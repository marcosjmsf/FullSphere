/**
 * 
 */
package Consumer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.Amizade;
import Bean.Resultado;
import Control.AmizadeControl;

/**
 * @author marcos
 *
 */

@Path("/amizade")
public class ConsumerAmizade {
	
	private AmizadeControl amizadeControl;
	
	
	@POST
	@Path("/cadastro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado cadastroAmizade(Amizade amizade){
		
		return amizadeControl.cadastroAmizade(amizade);
		
	}
	
	@POST
	@Path("/aceitar")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado aceitarAmizade(Amizade amizade){
		
		return amizadeControl.aceitarAmizade(amizade);
		
	}
	
	@POST
	@Path("/bloquear")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado bloquearAmizade(Amizade amizade){
		
		return amizadeControl.bloquearAmizade(amizade);
		
	}
	
	@POST
	@Path("/recusar")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado recusarAmizade(Amizade amizade){
		
		return amizadeControl.deleteAmizade(amizade);
		
	}


	public AmizadeControl getAmizadeControl() {
		return amizadeControl;
	}


	public void setAmizadeControl(AmizadeControl amizadeControl) {
		this.amizadeControl = amizadeControl;
	}
	
	
	
	

}
