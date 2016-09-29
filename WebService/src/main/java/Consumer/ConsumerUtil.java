 	/**
 * 
 */
package Consumer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.EstiloMusical;
import Bean.EstimaItem;
import Bean.Gravadora;
import Bean.Pais;
import Bean.TipoMidia;
import Control.UtilControl;

/**
 * @author marcos
 *
 */


@Path("/util")
public class ConsumerUtil {
	
	
	private UtilControl utilControl;
	
	@GET
	@Path("/consultaPais")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pais> consultaPais(){

		return utilControl.consultaPais();
	}

	
	@GET
	@Path("/consultaEstiloMusical")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstiloMusical> consultaEstiloMusical(){

		return utilControl.consultaEstiloMusical();
	}
	
	@GET
	@Path("/consultaTipoMidia")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoMidia> consultaTipoMidia(){

		return utilControl.consultaTipoMidia();
	}
	
	@POST
	@Path("/cadastroGravadora")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Gravadora cadastroGravadora(Gravadora gravadora){
		
		return utilControl.cadastroGravadora(gravadora);
		
	}
	
	@GET
	@Path("/consultaGravadora/{nomeGravadora}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gravadora> consultaGravadora(@PathParam("nomeGravadora")String nomeGravadora){

		return utilControl.consultaGravadora(nomeGravadora);
	}
	
	
	@GET
	@Path("/consultaEstimaItem")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstimaItem> consultaEstimaItem(){

		return utilControl.consultaEstimaItem();
	}	
	
	
	public UtilControl getUtilControl() {
		return utilControl;
	}

	public void setUtilControl(UtilControl utilControl) {
		this.utilControl = utilControl;
	}
	
	

}
