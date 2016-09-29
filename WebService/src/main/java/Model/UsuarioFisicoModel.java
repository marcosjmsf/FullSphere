/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.ConfiguracaoPaginaUsuario;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaFisica;
import DAO.UsuarioFisicoDao;
import RowMapper.UsuarioFisicoHomeIdRowMapper;
import Util.Guid;

/**
 * @author marcos
 *
 */

public class UsuarioFisicoModel {

	UsuarioFisicoDao usuarioFisicoDao; 
	
	public List<UsuarioPessoaFisica> consultaUsuarioFisicoNome(UsuarioPessoaFisica usuarioPessoaFisica){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoDao.consultaUsuarioFisicoNome(usuarioPessoaFisica);
		
		return listaUsuario;
	}
	
	public UsuarioPessoaFisica consultaUsuarioFisicoId(UsuarioPessoaFisica usuarioPessoaFisica){
		
		usuarioPessoaFisica = usuarioFisicoDao.consultaUsuarioFisicoId(usuarioPessoaFisica);
		
		return usuarioPessoaFisica;
		
		
	}
	
	
	public UsuarioPessoaFisica cadastroUsuarioFisico(UsuarioPessoaFisica usuarioPessoaFisica){
		
		UsuarioPessoaFisica usuarioPessoaFisicaResposta = new UsuarioPessoaFisica();
		
		usuarioPessoaFisica.setGuidUsuario(Guid.generateGuid());
		
		usuarioPessoaFisicaResposta = usuarioFisicoDao.cadastroUsuarioFisico(usuarioPessoaFisica);
				
		return usuarioPessoaFisicaResposta;
		
		
	}
	
	public Resultado updateUsuarioFisico(UsuarioPessoaFisica usuarioPessoaFisica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioFisicoDao.updateUsuarioFisico(usuarioPessoaFisica);
		
		return resultado;
		
		
	}
	
	public UsuarioPessoaFisica consultaUsuarioFisicoGuid(UsuarioPessoaFisica usuarioPessoaFisica){
		
		usuarioPessoaFisica = usuarioFisicoDao.consultaUsuarioFisicoGuid(usuarioPessoaFisica);
		
		return usuarioPessoaFisica;
		
	}
	
	public ConfiguracaoPaginaUsuario consultaConfiguracaoPaginaUsuario(final UsuarioPessoaFisica usuarioPessoaFisica){
		
		ConfiguracaoPaginaUsuario configuracaoPaginaUsuario = new ConfiguracaoPaginaUsuario();
		
		configuracaoPaginaUsuario = usuarioFisicoDao.consultaConfiguracaoPaginaUsuario(usuarioPessoaFisica);
		
		return configuracaoPaginaUsuario;
		
	}
	
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoItemColecao(Pesquisa pesquisa){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoDao.consultaListaUsuarioFisicoItemColecao(pesquisa);
		
		return listaUsuario;	
	}


	
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoItemColecao(int idEdicaoAlbum){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoDao.consultaPageListaUsuarioFisicoItemColecao(idEdicaoAlbum);
		
		return listaUsuario;		
	}

	public int consultaNumeroPaginaUsuarioFisicoItemColecao(int idEdicaoAlbum){
		
		int numeroPaginas = usuarioFisicoDao.consultaNumeroPaginaUsuarioFisicoItemColecao(idEdicaoAlbum);
		
		return numeroPaginas;
	}

	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoFavorito(int idArtista){
		
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoDao.consultaPageListaUsuarioFisicoFavorito(idArtista);
		
		return listaUsuario;	
		
	}

	
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoFavorito(Pesquisa pesquisa){
	
		List<UsuarioPessoaFisica> listaUsuario = new ArrayList<UsuarioPessoaFisica>();
		
		listaUsuario = usuarioFisicoDao.consultaListaUsuarioFisicoFavorito(pesquisa);
		
		return listaUsuario;
		
	}

	public int consultaNumeroPaginaUsuarioFisicoFavorito(int idArtista){
		
		int numeroPaginas = usuarioFisicoDao.consultaNumeroPaginaUsuarioFisicoItemColecao(idArtista);
		
		return numeroPaginas;
		
	}


	public Resultado atualizaPrivacidadeUsuarioFisico (ConfiguracaoPaginaUsuario configuracaoPaginaUsuario){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioFisicoDao.atualizaPrivacidadeUsuarioFisico(configuracaoPaginaUsuario);
		
		return resultado;
		
	}
	
	public UsuarioPessoaFisica consultaUsuarioFisicoHomeId(int idUsuarioPessoaFisica){

		UsuarioPessoaFisica usuario = new UsuarioPessoaFisica(); 
	
		usuario = usuarioFisicoDao.consultaUsuarioFisicoHomeId(idUsuarioPessoaFisica);

		return usuario;
	}

	
	

	public UsuarioFisicoDao getUsuarioFisicoDao() {
		return usuarioFisicoDao;
	}

	public void setUsuarioFisicoDao(UsuarioFisicoDao usuarioFisicoDao) {
		this.usuarioFisicoDao = usuarioFisicoDao;
	}
	
	
	
	
}
