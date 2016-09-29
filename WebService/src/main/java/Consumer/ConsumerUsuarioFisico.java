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

import Bean.ConfiguracaoPaginaUsuario;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaFisica;
import Control.UsuarioFisicoControl;


/**
 * @author marcos
 *
 */

@Path("/usuarioPessoaFisico")
public class ConsumerUsuarioFisico {

	UsuarioFisicoControl usuarioFisicoControl ; 
	
	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioPessoaFisica cadastroUsuarioPessoaFisica(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.cadastroUsuarioFisico(usuarioPessoaFisica);
	}
	
	
	@POST
	@Path("/consultaNome")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List<UsuarioPessoaFisica> consultaUsuarioPessoaFisicaNome(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.consultaUsuarioFisicoNome(usuarioPessoaFisica);

	}
	
	@POST
	@Path("/consultaId")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public UsuarioPessoaFisica consultaUsuarioPessoaFisicaId(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.consultaUsuarioFisicoId(usuarioPessoaFisica);

	}
	
	@POST
	@Path("/consultaGuid")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public UsuarioPessoaFisica consultaUsuarioPessoaFisicaGuid(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.consultaUsuarioFisicoGuid(usuarioPessoaFisica);

	}
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Resultado updateUsuarioPessoaFisica(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.updateUsuarioFisico(usuarioPessoaFisica);
	}

	
	@POST
	@Path("/consultaConfiguracaoPagina")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConfiguracaoPaginaUsuario consultaConfiguracaoPaginaUsuario(UsuarioPessoaFisica usuarioPessoaFisica){

		return usuarioFisicoControl.consultaConfiguracaoPaginaUsuario(usuarioPessoaFisica);
	}


	//Essa opercao e responsavel por retornar 10 usuarios que possuam um determinado item
	//Os 10 usuarios a serem retornados serao definidos pelo numero da pagina passado
	//O parametro de entrada sera o id de uma edicao de album
	@POST
	@Path("/consultaListaItemColecao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoItemColecao(Pesquisa pesquisa){
		
		
		return usuarioFisicoControl.consultaListaUsuarioFisicoItemColecao(pesquisa);
		
	}


	//Essa operacao retornara 10 usuario que possuam um determinado item
	//Essa opercao sera utilizada para exibir os usuarios que possuem uma certa edicao do album quando a pagina dessa edicao for acessada
	@GET
	@Path("/consultaPageListaItemColecao/{idEdicaoAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoItemColecao(@PathParam("idEdicaoAlbum")int idEdicaoAlbum){
		
		
		return usuarioFisicoControl.consultaPageListaUsuarioFisicoItemColecao(idEdicaoAlbum);
		
	}

	//Essa opercao retorna o numero de paginas necessarias para serem exibidos todos os usuarios que possuem um determinado item
	@GET
	@Path("/consultaNumeroPaginaItemColecao/{idEdicaoAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaUsuarioFisicoItemColecao(@PathParam("idEdicaoAlbum")int idEdicaoAlbum){
		
		return usuarioFisicoControl.consultaNumeroPaginaUsuarioFisicoItemColecao(idEdicaoAlbum);	
	}
	
	
	
	//Essa opercao sera responsavel por trazer 10 usuarios que favoritaram um mesmo artista
	//Essa opercao devera ser usada para preencher uma parte da pagina do artista
	@GET
	@Path("/consultaPageListaFavorito/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoFavorito(@PathParam("idArtista")int idArtista){
				
		return usuarioFisicoControl.consultaPageListaUsuarioFisicoFavorito(idArtista);
			
	}

	
	//Essa operacao retornara uma lista de 10 usuarios que favoritaram um determinado artista
	//Essa opercao funciona de forma paginada, de acordo com o numero da pagina enviada serao determinados quais usuarios seram retornados
	@POST
	@Path("/consultaListaFavorito")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoFavorito(Pesquisa pesquisa){
			
		return usuarioFisicoControl.consultaListaUsuarioFisicoFavorito(pesquisa);
		
	}

	//Essa opercao retornara o numero de paginas necessarias para exibir todos os usarios que favoritaram um determinado artista
	@GET
	@Path("/consultaNumeroPaginaFavorito/{idArtista}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaUsuarioFisicoFavorito(@PathParam("idArtista")int idArtista){
		
		return usuarioFisicoControl.consultaNumeroPaginaUsuarioFisicoItemColecao(idArtista);
				
	}
	
	//Essa operacao permite que o usuario atualize suas configuracoes de privacidade
	@POST
	@Path("/atualizaConfiguracoaPrivacidade")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Resultado atualizaPrivacidadeUsuarioFisico (ConfiguracaoPaginaUsuario configuracaoPaginaUsuario){
			
		return usuarioFisicoControl.atualizaPrivacidadeUsuarioFisico(configuracaoPaginaUsuario);
		
		
		
	}
	
	
	//Metodo utilizado para preencher as informaçoes proprias do usuario na pagina de home, apos o login
	@GET
	@Path("/consultaHomeId/{idUsuarioPessoaFisica}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public UsuarioPessoaFisica consultaUsuarioFisicoHomeId(@PathParam("idUsuarioPessoaFisica")int idUsuarioPessoaFisica){
	
		return usuarioFisicoControl.consultaUsuarioFisicoHomeId(idUsuarioPessoaFisica);

	}
	
	
	
	public UsuarioFisicoControl getUsuarioFisicoControl() {
		return usuarioFisicoControl;
	}


	public void setUsuarioFisicoControl(UsuarioFisicoControl usuarioFisicoControl) {
		this.usuarioFisicoControl = usuarioFisicoControl;
	}
	
	
	
	
	
}
