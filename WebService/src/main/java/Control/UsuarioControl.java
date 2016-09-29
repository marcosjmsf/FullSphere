/**
 * 
 */
package Control;

import java.io.IOException;

import Bean.Resultado;
import Bean.Usuario;
import Model.UsuarioModel;

/**
 * @author marcos
 *
 */
public class UsuarioControl {
	
	private UsuarioModel usuarioModel;
	
	
	public Usuario login(Usuario usuario){
		
		usuario = usuarioModel.login(usuario);
		
		return usuario;
		
		
	}
	
	public Resultado adicionarFotoUsuario(Usuario usuario) throws IOException{
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioModel.adicionarFotoUsuario(usuario);
		
		return resultado;

	}
	
	
	public Resultado trocaSenha(Usuario usuario){

		Resultado resultado = new Resultado();

		resultado = usuarioModel.trocaSenha(usuario);

		return resultado;

	}
	
	public Resultado updateEmailUsuario(Usuario usuario){
		
		Resultado resultado = new Resultado();

		resultado = usuarioModel.updateEmailUsuario(usuario);

		return resultado;
		
	}
	
	public Usuario convertIdToGuid(int idUsuario){
		
		Usuario usuario = new Usuario();
	
		usuario = usuarioModel.convertIdToGuid(idUsuario);
		
		return usuario;
	}



	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}


	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	
	
	

}
