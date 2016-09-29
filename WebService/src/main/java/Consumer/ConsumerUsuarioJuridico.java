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

import Bean.ConfiguracaoPlano;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaFisica;
import Bean.UsuarioPessoaJuridica;
import Control.UsuarioJuridicoControl;

/**
 * @author marcos
 *
 */

@Path("/usuarioPessoaJuridico")
public class ConsumerUsuarioJuridico {
	
	 UsuarioJuridicoControl usuarioJuridicoControl;
								   	
	@POST
	@Path("/cadastro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Resultado cadastroUsuarioPessoaFisica(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.cadastroUsuarioJuridico(usuarioPessoaJuridica);
	}
	

	@POST
	@Path("/consultaId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioPessoaJuridica consultaUsuarioJuridicoId(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.consultaUsuarioJuridicoId(usuarioPessoaJuridica);
	}
	

	@POST
	@Path("/consultaNome")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <UsuarioPessoaJuridica> consultaUsuarioJuridicoNome(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.consultaUsuarioJuridicoNome(usuarioPessoaJuridica);
	}
	
	@POST
	@Path("/consultaConfiguracaoPlano")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConfiguracaoPlano consultaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.consultaConfiguracaoPlano(usuarioPessoaJuridica);
	}	

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Resultado updateUsuarioPessoaFisica(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.updateUsuarioJuridico(usuarioPessoaJuridica);
	}

	@POST
	@Path("/atualizaConfiguracaoPlano")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Resultado atualizaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.updateUsuarioJuridico(usuarioPessoaJuridica);
	}
	
	@POST
	@Path("/consultaGuid")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioPessoaJuridica consultaUsuarioJuridicoGuid(UsuarioPessoaJuridica usuarioPessoaJuridica){

		return usuarioJuridicoControl.consultaUsuarioJuridicoGuid(usuarioPessoaJuridica);
	}
	
	//Essa opercao e responsavel por retornar 10 usuarios que possuam um determinado item
	//Os 10 usuarios a serem retornados serao definidos pelo numero da pagina passado
	//O parametro de entrada sera o id de uma edicao de album
	@POST
	@Path("/consultaListaItemColecao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <UsuarioPessoaJuridica> consultaListaUsuarioJuridicoItemColecao(Pesquisa pesquisa){
		
		
		return usuarioJuridicoControl.consultaListaUsuarioJuridicoItemColecao(pesquisa);
		
	}


	//Essa operacao retornara 10 usuario que possuam um determinado item
	//Essa opercao sera utilizada para exibir os usuarios que possuem uma certa edicao do album quando a pagina dessa edicao for acessada
	@GET
	@Path("/consultaPageListaItemColecao/{idEdicaoAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <UsuarioPessoaJuridica> consultaPageListaUsuarioJuridicoItemColecao(@PathParam("idEdicaoAlbum")int idEdicaoAlbum){
		
		
		return usuarioJuridicoControl.consultaPageListaUsuarioJuridicoItemColecao(idEdicaoAlbum);
		
	}

	//Essa opercao retorna o numero de paginas necessarias para serem exibidos todos os usuarios que possuem um determinado item
	@GET
	@Path("/consultaNumeroPaginaItemColecao/{idEdicaoAlbum}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaUsuarioJuridicoItemColecao(@PathParam("idEdicaoAlbum")int idEdicaoAlbum){
		
		return usuarioJuridicoControl.consultaNumeroPaginaUsuarioJuridicoItemColecao(idEdicaoAlbum);	
	}
	
	
	
	public UsuarioJuridicoControl getUsuarioJuridicoControl() {
		return usuarioJuridicoControl;
	}

	public void setUsuarioJuridicoControl(UsuarioJuridicoControl usuarioJuridicoControl) {
		this.usuarioJuridicoControl = usuarioJuridicoControl;
	}
	

}
