/**
 * 
 */
package Teste;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author marcos
 *
 */



@Path("/teste")
public class Consumer {
	
	
	MensagemUsuario mensagem ;
	
	@GET
	@Path("/primeiro")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioTeste teste (){
		
		UsuarioTeste user = new UsuarioTeste();
		
		user.nome = "José";
		user.nomeMae="Lucia";
		
		return user;
	}
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MensagemUsuario recebeUsuario(UsuarioTeste user){
		
		mensagem.setUser(user);
		mensagem.setTexo("Funcionou");
		
		return mensagem;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MensagemUsuario deleteUsuario(@PathParam("id") int id){
		

		mensagem.setTexo("Funcionou "+ id);
		
		
		return mensagem;
	}

	public MensagemUsuario getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemUsuario mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
	
}
