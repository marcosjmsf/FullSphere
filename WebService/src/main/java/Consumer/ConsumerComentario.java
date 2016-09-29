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

import Bean.ComentarioAlbum;
import Bean.ComentarioArtista;
import Bean.Pesquisa;
import Bean.Resultado;
import Control.ComentarioControl;

/**
 * @author marcos
 *
 */

@Path("/comentario")
public class ConsumerComentario {

	private ComentarioControl comentarioControl;
	
	
	@POST
	@Path("/cadastroArtista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public ComentarioArtista cadastroComentarioArtista(ComentarioArtista comentarioArtista){

		return comentarioControl.cadastroComentarioArtista(comentarioArtista);
		
		
	}

	
	@POST
	@Path("/cadastroAlbum")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public ComentarioAlbum cadastroComentarioAlbum(ComentarioAlbum comentarioAlbum){

		return comentarioControl.cadastroComentarioAlbum(comentarioAlbum);
		
		
	}
	
	@POST
	@Path("/deleteAlbum")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado deleteComentarioAlbum(ComentarioAlbum comentarioAlbum){

		return comentarioControl.deleteComentarioAlbum(comentarioAlbum);
		
		
	}
	
	@POST
	@Path("/deleteArtista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado deleteComentarioArtista(ComentarioArtista comentarioArtista){

		return comentarioControl.deleteComentarioArtista(comentarioArtista);
		
		
	}
	
	@POST
	@Path("/consultaListaArtista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <ComentarioArtista> consultaListaComentarioArtista(Pesquisa pesquisa){

		return comentarioControl.consultaListaComentarioArtista(pesquisa);

	}
	
	@POST
	@Path("/consultaListaAlbum")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <ComentarioAlbum> consultaListaComentarioAlbum(Pesquisa pesquisa){

		return comentarioControl.consultaListaComentarioAlbum(pesquisa);

	}

	public ComentarioControl getComentarioControl() {
		return comentarioControl;
	}


	public void setComentarioControl(ComentarioControl comentarioControl) {
		this.comentarioControl = comentarioControl;
	}
	
	
	
	
	
}















