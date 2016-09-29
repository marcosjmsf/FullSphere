/**
 * 
 */
package Consumer;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.Artista;
import Bean.ArtistaAuxiliar;
import Bean.Pesquisa;
import Bean.Resultado;
import Control.ArtistaControl;

/**
 * @author marcos
 *
 */

@Path("/artista")
public class ConsumerArtista {
	
	private ArtistaControl artistaControl;
	
	//Opercao que fara todo o cadastro de um artista
	@POST
	@Path("/cadastro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Artista cadastroArtista(Artista artista) throws IOException{
		
		return artistaControl.cadastroArtista(artista);
		
	}

	//Essa operacao sera utilizada pela barra de pesquisa principal, ela retorna no maximo 10 artistas com o nome parecido ou proximo ao termo pesquisado na barra
	/*@POST
	@Path("/consultaNome")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaNome(Artista artista){
		
		return artistaControl.consultaArtistaNome(artista);
		
	}*/
	
	//Essa opercao devera ser utilizada quando for carregada a pagina de artista, 
	//Sera utilizado para identificar o artista o seu id
	//O id do usuario tambem devera ser enviado para que algumas informacoes que relacionam o artista ao usuario possam ser retornadas
	//Por exemplo: A nota que o usuario possa ter dado a esse artista, se o usuario favoritou esse artista,
	@POST
	@Path("/consultaId")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Artista consultaArtistaId(ArtistaAuxiliar artistaAuxiliar){
		
		return artistaControl.consultaArtistaId(artistaAuxiliar);
		
	}
	
	
	//Operacao para preencher lista no cadastro de album ou no fluxo completo de um cadastro de item na colecao
	@POST
	@Path("/consultaNomeLista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaNomeLista(Artista artista){
		
		return artistaControl.consultaArtistaNomeLista(artista);
		
	}

	//Essa operacao ira retorna apenas dados basicos para visualização de um artista,
	//Como parametro de entrada utiliza o id do artista
	@GET
	@Path("/consultaIdSimples/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Artista consultaArtistaIdSimples(@PathParam("idArtista")int idArtista){
		
		return artistaControl.consultaArtistaIdSimples(idArtista);
	}
	
	//Opercao que permitira ao usuario favoritar um determinado artista, 
	//os parametros que serao utilizados serao id do Usuario e id do artista
	@POST
	@Path("/favorito")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado favoritarArtista(ArtistaAuxiliar artistaAuxiliar){
		
		return artistaControl.favoritarArtista(artistaAuxiliar);
		
	}
	
	//Opercao que permitira ao usuario dar nota um determinado artista, 
	//os parametros que serao utilizados serao id do Usuario, id do artista e nota
	@POST
	@Path("/darNota")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado darNotaArtista(ArtistaAuxiliar artistaAuxiliar){
		
		return artistaControl.darNotaArtista(artistaAuxiliar);
		
	}
	
	
	
	//Essa operacao retornara ate 10 artistas presentes na lista de favoritos de um determinado usuario
	//sera utilizada para exibir uma simples visualizacao dos ultimos favoritados pelo usuario
	//isso sera exibido na pagina de perfil do usuario
	@GET
	@Path("/consultaFavoritoHomeGuid/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaFavoritoHomeGuid(@PathParam("guidUsuario")String guidUsuario){

		return artistaControl.consultaArtistaFavoritoHomeGuid(guidUsuario);
		
	}
	
	//Essa operacao retornara ate 10 artistas presentes na lista de favoritos de um determinado usuario
	//sera utilizada para exibir uma simples visualizacao dos ultimos favoritados pelo usuario
	//isso sera exibido na pagina de home do usuario
	@GET
	@Path("/consultaFavoritoHomeId/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaFavoritoHomeId(@PathParam("idUsuario")int idUsuario){
		
		return artistaControl.consultaArtistaFavoritoHomeId(idUsuario);		
	}
	
	
	
	//Essa sera uma opercao paginada ao solicitar essa opercao seram enviados os parametros idUsuario e numeroPagina
	//de acordo com o numero da pagina serao retornados ate 10 artistas
	@POST
	@Path("/consultaFavoritoIdLista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaFavoritoIdLista(Pesquisa pesquisa){
		
		return artistaControl.consultaArtistaFavoritoIdLista(pesquisa);
		
	}
	
	//Essa sera uma opercao paginada ao solicitar essa opercao seram enviados os parametros guidUsuario e numeroPagina
	//de acordo com o numero da pagina serao retornados ate 10 artistas
	@POST
	@Path("/consultaFavoritoGuidLista")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Artista> consultaArtistaFavoritoGuidLista(Pesquisa pesquisa){
		
		return artistaControl.consultaArtistaFavoritoGuidLista(pesquisa);
		
	}
	
	@GET
	@Path("/consultaNumeroPaginaFavoritoIdUsuario/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginasFavoritoIdUsuario(@PathParam("idUsuario")int idUsuario){
		
		return artistaControl.consultaNumeroPaginaFavoritoIdUsuario(idUsuario);		
	}
	
	@GET
	@Path("/consultaNumeroPaginaFavoritoGuidUsuario/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginasFavoritoGuidUsuario(@PathParam("guidUsuario")String guidUsuario){
		
		return artistaControl.consultaNumeroPaginaFavoritoGuidUsuario(guidUsuario);		
	}
	
	//Opercao que permitira ao usuario desfavoritar um determinado artista, 
	//os parametros que serao utilizados serao id do Usuario e id do artista
	@POST
	@Path("/desfavorito")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado desfavoritarArtista(ArtistaAuxiliar artistaAuxiliar){
		
		return artistaControl.desfavoritarArtista(artistaAuxiliar);
		
	}
	
	
	
	//Esse metodo é utilizado para atualizar os dados referente a notas na pagina do artista
	//retorna os dados de media de notas de artista e tambem quantidade de usuario que deram notas
	@GET
	@Path("/atualizaDadosNota/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Artista atualizaDadosNotaArtista(@PathParam("idArtista")int idArtista){
	
		return artistaControl.atualizaDadosNotaArtista(idArtista);	
		
	
	}
	
	
	public ArtistaControl getArtistaControl() {
		return artistaControl;
	}


	public void setArtistaControl(ArtistaControl artistaControl) {
		this.artistaControl = artistaControl;
	}
	
	

}
