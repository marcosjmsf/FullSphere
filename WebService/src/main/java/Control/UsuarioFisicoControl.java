/**


 * 
 */
package Control;

import java.util.ArrayList;

import java.util.List;

import Bean.ConfiguracaoPaginaUsuario;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaFisica;
import Model.UsuarioFisicoModel;

/**
 * @author marcos
 *
 */


public class UsuarioFisicoControl {
	
	private UsuarioFisicoModel usuarioFisicoModel; 

	
	public List<UsuarioPessoaFisica> consultaUsuarioFisicoNome(UsuarioPessoaFisica usuarioPessoaFisica){

		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoModel.consultaUsuarioFisicoNome(usuarioPessoaFisica);
		
		return listaUsuario;
	}
	
	public UsuarioPessoaFisica consultaUsuarioFisicoId(UsuarioPessoaFisica usuarioPessoaFisica){
		
		usuarioPessoaFisica = usuarioFisicoModel.consultaUsuarioFisicoId(usuarioPessoaFisica);
		
		return usuarioPessoaFisica;

	}
	
	
	
	
	public UsuarioPessoaFisica cadastroUsuarioFisico(UsuarioPessoaFisica usuarioPessoaFisica){
		
		UsuarioPessoaFisica usuarioPessoaFisicaResposta = new UsuarioPessoaFisica();
		
		usuarioPessoaFisicaResposta = usuarioFisicoModel.cadastroUsuarioFisico(usuarioPessoaFisica);
		
		return usuarioPessoaFisicaResposta;
		
		
	}
	
	public Resultado updateUsuarioFisico(UsuarioPessoaFisica usuarioPessoaFisica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioFisicoModel.updateUsuarioFisico(usuarioPessoaFisica);
		
		return resultado;
		
		
	}
	
	public UsuarioPessoaFisica consultaUsuarioFisicoGuid(UsuarioPessoaFisica usuarioPessoaFisica){
		
		usuarioPessoaFisica = usuarioFisicoModel.consultaUsuarioFisicoGuid(usuarioPessoaFisica);
		
		return usuarioPessoaFisica;
		
	}
	
	public ConfiguracaoPaginaUsuario consultaConfiguracaoPaginaUsuario(final UsuarioPessoaFisica usuarioPessoaFisica){
		
		ConfiguracaoPaginaUsuario configuracaoPaginaUsuario = new ConfiguracaoPaginaUsuario();
		
		configuracaoPaginaUsuario = usuarioFisicoModel.consultaConfiguracaoPaginaUsuario(usuarioPessoaFisica);
		
		return configuracaoPaginaUsuario;
		
	}
	
	
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoItemColecao(Pesquisa pesquisa){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoModel.consultaListaUsuarioFisicoItemColecao(pesquisa);
		
		return listaUsuario;	
	}


	
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoItemColecao(int idEdicaoAlbum){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoModel.consultaPageListaUsuarioFisicoItemColecao(idEdicaoAlbum);
		
		return listaUsuario;		
	}

	public int consultaNumeroPaginaUsuarioFisicoItemColecao(int idEdicaoAlbum){
		
		int numeroPaginas = usuarioFisicoModel.consultaNumeroPaginaUsuarioFisicoItemColecao(idEdicaoAlbum);
		
		return numeroPaginas;
	}
	
	
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoFavorito(int idArtista){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoModel.consultaPageListaUsuarioFisicoFavorito(idArtista);
		
		return listaUsuario;	
		
	}

	
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoFavorito(Pesquisa pesquisa){
	
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoModel.consultaListaUsuarioFisicoFavorito(pesquisa);
		
		return listaUsuario;
		
	}

	public int consultaNumeroPaginaUsuarioFisicoFavorito(int idArtista){
		
		int numeroPaginas = usuarioFisicoModel.consultaNumeroPaginaUsuarioFisicoItemColecao(idArtista);
		
		return numeroPaginas;
		
	}
	
	
	public Resultado atualizaPrivacidadeUsuarioFisico (ConfiguracaoPaginaUsuario configuracaoPaginaUsuario){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioFisicoModel.atualizaPrivacidadeUsuarioFisico(configuracaoPaginaUsuario);
		
		return resultado;
		
	}
	
	
	public UsuarioPessoaFisica consultaUsuarioFisicoHomeId(int idUsuarioPessoaFisica){

		UsuarioPessoaFisica usuario = new UsuarioPessoaFisica(); 
	
		usuario = usuarioFisicoModel.consultaUsuarioFisicoHomeId(idUsuarioPessoaFisica);

		return usuario;
	}
	
	
	public UsuarioFisicoModel getUsuarioFisicoModel() {
		return usuarioFisicoModel;
	}

	public void setUsuarioFisicoModel(UsuarioFisicoModel usuarioFisicoModel) {
		this.usuarioFisicoModel = usuarioFisicoModel;
	}
	
	

}
