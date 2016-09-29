/**
 * 
 */
package Consumer;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.MensagemAmizade;
import Bean.Resultado;
import Control.MensagemControl;

/**
 * @author marcos
 *
 */
@Path("/mensagem")
public class ConsumerMensagem {
	
	private MensagemControl mensagemControl;
	@POST
	@Path("/cadastroAmizade")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado cadastroMensagemAmizade(MensagemAmizade mensagemAmizade){

		return mensagemControl.cadastroMensagemAmizade(mensagemAmizade);

	}
	
	
	//Operacao responsavel por retornar as mensagens de uma conversa de forma paginada
	//Parametro principal sera o id da amizade
	@GET
	@Path("/consultaConversaAmizade/{idAmizade}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <MensagemAmizade> consultaConversaAmizade(@PathParam("idAmizade")int idAmizade){
		
		return mensagemControl.consultaConversaAmizade(idAmizade);
	}
	
	
	@GET
	@Path("/consultaConversaAmizadeLista/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <MensagemAmizade> consultaConversaAmizadeLista(@PathParam("idUsuario")int idUsuario){
				 
		return mensagemControl.consultaConversaAmizadeLista(idUsuario);
		 		
	}
	
	
	public MensagemControl getMensagemControl() {
		return mensagemControl;
	}

	public void setMensagemControl(MensagemControl mensagemControl) {
		this.mensagemControl = mensagemControl;
	}
	
	
	
	
	
	
	

}
