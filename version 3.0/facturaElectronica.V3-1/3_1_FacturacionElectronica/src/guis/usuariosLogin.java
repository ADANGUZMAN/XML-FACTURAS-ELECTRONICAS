package guis;

public class usuariosLogin {
public boolean ValidarUsuarios(String usuario,String contrase�a){
	if(usuario.equals("admin")&& contrase�a.equals("1234")){
		return true;
		}else
			return false;
}
}
