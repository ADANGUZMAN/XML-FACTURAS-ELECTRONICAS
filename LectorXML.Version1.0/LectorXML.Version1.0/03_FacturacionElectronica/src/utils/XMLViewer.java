package utils;
import java.io.*;
import java.util.*;
import java.nio.file.*;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.beans.property.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLViewer extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
  Label label;
  TreeTableView<org.w3c.dom.Node> treeTableView;

  @Override
  public void start(Stage stage) {
    List<String> p = getParameters().getRaw();
    File file = new File("./xmls/prueba2.xml");
    /*File file;
    if (!p.isEmpty()) {
      file = new File(p.get(0));
      if (!file.isFile()) throw new RuntimeException(file.getName() + " file not found");
    } else {
      file = new File("sample.xml");
      if (!file.exists()) createDemo(file);
    }*/
    label = new Label();
    treeTableView = createTreeTableView(file);
    BorderPane layout = new BorderPane();
    layout.setCenter(treeTableView);
    layout.setBottom(label);
    stage.setScene(new Scene(layout, 600, 400));
    stage.show();
  }

  TreeTableView<org.w3c.dom.Node> createTreeTableView(File file) {
    TreeTableView<org.w3c.dom.Node> treeTableView = new TreeTableView<>(createTreeItems(file));
    treeTableView.setShowRoot(true);
    treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
    TreeTableColumn<org.w3c.dom.Node, TreeItem<org.w3c.dom.Node>> nameColumn = new TreeTableColumn<>("Name");

    nameColumn.setCellValueFactory(
      (TreeTableColumn.CellDataFeatures<org.w3c.dom.Node, TreeItem<org.w3c.dom.Node>> cellData) ->
        new ReadOnlyObjectWrapper<TreeItem<org.w3c.dom.Node>>(cellData.getValue())
    );

    Image[] images = new Image[tagNames.length];
    try {
      Image image = new Image(getClass().getResourceAsStream("image.png"));
      for(int i = 0; i < images.length; i++) {
        images[i] = new WritableImage(image.getPixelReader(), i * 16, 0, 16, 16);
      }
    } catch (Exception e) {}

    nameColumn.setCellFactory(column -> {
      TreeTableCell<org.w3c.dom.Node, TreeItem<org.w3c.dom.Node>> cell = new TreeTableCell<org.w3c.dom.Node, TreeItem<org.w3c.dom.Node>>() {
        ImageView[] imageView = new ImageView[images.length];
        { for(int i = 0; i < imageView.length; i++) imageView[i] = new ImageView(images[i]); }

        @Override
        protected void updateItem(TreeItem<org.w3c.dom.Node> item, boolean empty) {
          super.updateItem(item, empty);
          if (item != null && !empty) {
            org.w3c.dom.Node node = item.getValue();
            if (item.getValue() != null) {
              String s = node.getNodeName();
              setText(s == null ? "" : s.trim());
              setGraphic(imageView[typeIndex(node.getNodeType())]);
              return;
            }
          }
          setText(null);
          setGraphic(null);
        }
      };
      return cell;
    });

    nameColumn.setPrefWidth(300);
    nameColumn.setSortable(false);
    treeTableView.getColumns().add(nameColumn);

    TreeTableColumn<org.w3c.dom.Node, String> valueColumn = new TreeTableColumn<>("Value");
    valueColumn.setCellValueFactory(cellData -> {
      TreeItem<org.w3c.dom.Node> item = cellData.getValue();
      org.w3c.dom.Node childNode = item.getValue();
      if (childNode != null) {
        String s = childNode.getNodeType() == org.w3c.dom.Node.DOCUMENT_TYPE_NODE ?
          ((DocumentType)childNode).getInternalSubset() : childNode.getNodeValue();
        if (s != null) {
          return new ReadOnlyObjectWrapper<String>(s.trim());
          //return new ReadOnlyObjectWrapper<String>(s.trim().replaceAll("\\s+", " "));
        }
      }
      return null;
    });

    valueColumn.setPrefWidth(100);
    valueColumn.setSortable(false);
    treeTableView.getColumns().add(valueColumn);

    treeTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        org.w3c.dom.Node node = newValue.getValue();
        if (node != null) {
          label.setText(tagNames[typeIndex(node.getNodeType())]);
          return;
        }
      }
      label.setText("");
    });
    treeTableView.getSelectionModel().selectFirst();
    return treeTableView;
  }

  TreeItem<org.w3c.dom.Node> createTreeItems(File file) {
    TreeItem<org.w3c.dom.Node> root = null;
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(file);
      doc.getDocumentElement().normalize();
      root = new TreeItem<>(doc);
      root.setExpanded(true);
      addChildrenItem(root);
    } catch (Exception e) { e.printStackTrace(); }
    return root;
  }

  void addChildrenItem(TreeItem<org.w3c.dom.Node> root) {
    org.w3c.dom.Node node = root.getValue();
    if (node.hasAttributes()) {
      NamedNodeMap attrs = node.getAttributes();  
      for(int i = 0; i < attrs.getLength(); i++) {
        root.getChildren().add(new TreeItem<org.w3c.dom.Node>(attrs.item(i)));
      }
    }
    NodeList list = node.getChildNodes(); 
    for (int i = 0; i < list.getLength(); i++) { 
      org.w3c.dom.Node childNode = list.item(i);
      if (childNode != null && (childNode.getNodeType() != org.w3c.dom.Node.TEXT_NODE ||
        (childNode.getNodeValue() != null && childNode.getNodeValue().trim().length() > 0))) {
        TreeItem<org.w3c.dom.Node> treeItem = new TreeItem<>(childNode);
        treeItem.setExpanded(true);
        root.getChildren().add(treeItem);
        addChildrenItem(treeItem);
      }
    } 
  } 

  final String tagNames[] = {"Not considered", "Element", "Attribute",
    "Text", "CDATA section", "Processing Instruction",
    "Comment", "Document", "Document Type"};

  int typeIndex(int t) {
    switch (t) {
      case org.w3c.dom.Node.ELEMENT_NODE:                return 1;
      case org.w3c.dom.Node.ATTRIBUTE_NODE:              return 2;
      case org.w3c.dom.Node.TEXT_NODE:                   return 3;
      case org.w3c.dom.Node.CDATA_SECTION_NODE:          return 4;
      case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE: return 5;
      case org.w3c.dom.Node.COMMENT_NODE:                return 6;
      case org.w3c.dom.Node.DOCUMENT_NODE:               return 7;
      case org.w3c.dom.Node.DOCUMENT_TYPE_NODE:          return 8;
    }
    return 0;
  }

  void createDemo(File file) {
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\"?>\n");
    sb.append(" <!DOCTYPE DocType [<!ENTITY name \"Value\">]>\n");
    sb.append(" <?Target Instruction?>\n");
    sb.append(" <!--Comment-->\n");
    sb.append("<Element Attribute=\"Attribute\">\n");
    sb.append(" <Element>\n");
    sb.append("  Text &name;\n");
    sb.append(" </Element>\n");
    sb.append(" <![CDATA[CDATA Section]]>\n");
    sb.append(" <EmptyElement/>\n");
    sb.append("</Element>\n");
    try {
      Files.write(file.toPath(), sb.toString().getBytes());
    } catch (Exception e) { }
  }
}
