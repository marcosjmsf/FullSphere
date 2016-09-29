/**
 * 
 */
package Consumer;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.Resultado;
import Bean.Usuario;
import Control.UsuarioControl;

/**
 * @author marcos
 *
 */

@Path("/usuario")
public class ConsumerUsuario {
	
	private UsuarioControl usuarioControl;
	
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Usuario login(Usuario usuario){
		
		return usuarioControl.login(usuario);
		
	}
	
	@POST
	@Path("/adicionarFoto")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado adicionarFotoUsuario(Usuario usuario) throws IOException{
		
		return usuarioControl.adicionarFotoUsuario(usuario);
		
	}
	
	
	@POST
	@Path("/trocaSenha")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado trocaSenha(Usuario usuario){

		return usuarioControl.trocaSenha(usuario);

		

	}

	@POST
	@Path("/updateEmail")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado updateEmailUsuario(Usuario usuario){

		return usuarioControl.updateEmailUsuario(usuario);

		

	}
	
	@GET
	@Path("/convertIdToGuid/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Usuario convertIdToGuid(@PathParam("idUsuario")int idUsuario){
		
		return usuarioControl.convertIdToGuid(idUsuario);
	}
	
	

	public UsuarioControl getUsuarioControl() {
		return usuarioControl;
	}


	public void setUsuarioControl(UsuarioControl usuarioControl) {
		this.usuarioControl = usuarioControl;
	}

	
	
	
	
}
