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

import Bean.AlbumAuxiliar;
import Bean.EdicaoAlbum;
import Control.EdicaoAlbumControl;

/**
 * @author marcos
 *
 */
@Path("/edicaoAlbum")
public class ConsumerEdicaoAlbum {
	
	private EdicaoAlbumControl edicaoAlbumControl;
	
	@POST
	@Path("/cadastro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public EdicaoAlbum cadastroEdicaoAlbum(EdicaoAlbum edicaoAlbum){
		
		return edicaoAlbumControl.cadastroEdicaoAlbum(edicaoAlbum);
		
	}
	
	
	//Metodo que faz uma busca por edicao de albuns de acordo com o id do album, para exibir no fluxo de cadastro de item
	@GET
	@Path("/consultaListaIdAlbum/{idAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <EdicaoAlbum> consultaEdicaoAlbumListaIdAlbum(@PathParam("idAlbum")int idAlbum){

		return edicaoAlbumControl.consultaEdicaoAlbumListaIdAlbum(idAlbum);

	}
	
	//Metodo que faz uma busca por edicao de albuns de acordo com o id do album, para exibir as edições na pagina do album.
	//O id do usuario sera usado para exibir algumas atividades do usuario no sistema.
	@POST
	@Path("/consultaIdAlbum")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List<EdicaoAlbum> consultaEdicaoAlbumIdAlbum(AlbumAuxiliar albumAuxiliar){
		
		return edicaoAlbumControl.consultaEdicaoAlbumIdAlbum(albumAuxiliar);
	}
	
	
	

	public EdicaoAlbumControl getEdicaoAlbumControl() {
		return edicaoAlbumControl;
	}

	public void setEdicaoAlbumControl(EdicaoAlbumControl edicaoAlbumControl) {
		this.edicaoAlbumControl = edicaoAlbumControl;
	}

	

}
