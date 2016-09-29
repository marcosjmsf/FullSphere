
package Consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.Album;
import Bean.AlbumAuxiliar;
import Bean.ArtistaAuxiliar;
import Bean.Resultado;
import Control.AlbumControl;

/**
 * @author marcos
 *
 */


@Path("/album")
public class ConsumerAlbum {
	
	private AlbumControl albumControl;

	@POST
	@Path("/cadastro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Album cadastroAlbum(Album album) throws IOException{
		
		return albumControl.cadastroAlbum(album);
		
	}
	
	@POST
	@Path("/consultaNome")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Album> consultaNomeAlbum(Album album){
		
		return albumControl.consultaAlbumNome(album);
		
	}
	
	@POST
	@Path("/consultaId")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Album consultaId(AlbumAuxiliar albumAuxiliar){
		
		return albumControl.consultaAlbumId(albumAuxiliar);
		
	}
	
	@POST
	@Path("/consultaNomeLista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Album> consultaNomeLista(Album album){
		
		return albumControl.consultaAlbumNomeLista(album);
		
	}
	
	
	
	//Operacao que retorna os albuns de um artista, esse metodo nao retorna todos os dados do album pois os dados dessa operacao serao utilizados apenas para exibicao
	@GET
	@Path("/consultaIdArtistaLista/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Album> consultaIdLista(@PathParam("idArtista")int idArtista){

		return albumControl.consultaAlbumIdLista(idArtista);

	}
	
	@GET
	@Path("/consultaIdArtistaDiscografia/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List<Album> consultaAlbumIdArtistaDiscografia(@PathParam("idArtista")int idArtista){

		return albumControl.consultaAlbumIdArtistaDiscografia(idArtista);
		
	}
	
	
	//Opercao que permitira ao usuario dar nota um determinado album, 
	//os parametros que serao utilizados serao id do Usuario, id do album e nota
	@POST
	@Path("/darNota")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado darNotaAlbum(AlbumAuxiliar albumAuxiliar){
		
		return albumControl.darNotaAlbum(albumAuxiliar);
		
	}
	
	//Esse metodo é utilizado para atualizar os dados referente a notas na pagina do album
	//retorna os dados de media de notas de album e tambem quantidade de usuario que deram notas
	@GET
	@Path("/atualizaDadosNota/{idAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Album atualizaDadosNotaAlbum(@PathParam("idAlbum")int idAlbum){
		
		return albumControl.atualizaDadosNotaAlbum(idAlbum);
		
	}
	

	public AlbumControl getAlbumControl() {
		return albumControl;
	}

	public void setAlbumControl(AlbumControl albumControl) {
		this.albumControl = albumControl;
	}
	

}
