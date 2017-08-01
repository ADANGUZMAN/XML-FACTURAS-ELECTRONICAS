package guis;

public class usuariosLogin {
public boolean ValidarUsuarios(String usuario,String contraseña){
	if(usuario.equals("admin")&& contraseña.equals("1234")){
		return true;
		}else
			return false;
}
}
