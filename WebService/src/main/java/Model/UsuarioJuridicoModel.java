package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.ConfiguracaoPlano;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaJuridica;
import DAO.UsuarioJuridicoDao;
import Util.Guid;

/**
 * @author marcos
 *
 */
public class UsuarioJuridicoModel {
	
	private UsuarioJuridicoDao usuarioJuridicoDao; 

	public Resultado cadastroUsuarioJuridico(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		usuarioPessoaJuridica.setGuidUsuario(Guid.generateGuid());

		resultado = usuarioJuridicoDao.cadastroUsuarioJuridico(usuarioPessoaJuridica);
		
		return resultado;

	}
	
	public UsuarioPessoaJuridica consultaUsuarioJuridicoId (UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		usuarioPessoaJuridica = usuarioJuridicoDao.consultaUsuarioJuridicoId(usuarioPessoaJuridica);
		
		return usuarioPessoaJuridica;
		
	}
	
	public List <UsuarioPessoaJuridica> consultaUsuarioJuridicoNome(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		List<UsuarioPessoaJuridica> listUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listUsuario = usuarioJuridicoDao.consultaUsuarioJuridicoNome(usuarioPessoaJuridica);
		
		return listUsuario;
		
	}
	
	public ConfiguracaoPlano consultaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		ConfiguracaoPlano configuracaoPlano = new ConfiguracaoPlano();
		
		configuracaoPlano = usuarioJuridicoDao.consultaConfiguracaoPlano(usuarioPessoaJuridica);
		
		return configuracaoPlano;
	}
	
	public Resultado updateUsuarioJuridico(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioJuridicoDao.updateUsuarioJuridico(usuarioPessoaJuridica);
		
		return resultado;

	}
	
	public Resultado atualizaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioJuridicoDao.atualizaConfiguracaoPlano(usuarioPessoaJuridica);
		
		return resultado;
		
	}
	
	public UsuarioPessoaJuridica consultaUsuarioJuridicoGuid(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		usuarioPessoaJuridica = usuarioJuridicoDao.consultaUsuarioJuridicoGuid(usuarioPessoaJuridica);
		
		return usuarioPessoaJuridica;
		
	}
	
	
	
	public List <UsuarioPessoaJuridica> consultaListaUsuarioJuridicoItemColecao(Pesquisa pesquisa){
		
		List<UsuarioPessoaJuridica> listaUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listaUsuario = usuarioJuridicoDao.consultaListaUsuarioJuridicoItemColecao(pesquisa);
		
		return listaUsuario;	
	}


	
	public List <UsuarioPessoaJuridica> consultaPageListaUsuarioJuridicoItemColecao(int idEdicaoAlbum){
		
		List<UsuarioPessoaJuridica> listaUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listaUsuario = usuarioJuridicoDao.consultaPageListaUsuarioJuridicoItemColecao(idEdicaoAlbum);
		
		return listaUsuario;		
	}

	public int consultaNumeroPaginaUsuarioJuridicoItemColecao(int idEdicaoAlbum){
		
		int numeroPaginas = usuarioJuridicoDao.consultaNumeroPaginaUsuarioJuridicoItemColecao(idEdicaoAlbum);
		
		return numeroPaginas;
	}


	public UsuarioJuridicoDao getUsuarioJuridicoDao() {
		return usuarioJuridicoDao;
	}

	public void setUsuarioJuridicoDao(UsuarioJuridicoDao usuarioJuridicoDao) {
		this.usuarioJuridicoDao = usuarioJuridicoDao;
	}
	
	
	
	
	
	
	
	
}
