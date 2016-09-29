/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.ConfiguracaoPlano;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaJuridica;
import Model.UsuarioJuridicoModel;

/**
 * @author marcos
 *
 */
public class UsuarioJuridicoControl {
	
	
	private UsuarioJuridicoModel usuarioJuridicoModel;

	public Resultado cadastroUsuarioJuridico(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioJuridicoModel.cadastroUsuarioJuridico(usuarioPessoaJuridica);
		
		return resultado;
		
		
	}
	
	public UsuarioPessoaJuridica consultaUsuarioJuridicoId (UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		usuarioPessoaJuridica = usuarioJuridicoModel.consultaUsuarioJuridicoId(usuarioPessoaJuridica);
		
		return usuarioPessoaJuridica;
		
	}
	
	public List <UsuarioPessoaJuridica> consultaUsuarioJuridicoNome(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		List<UsuarioPessoaJuridica> listUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listUsuario = usuarioJuridicoModel.consultaUsuarioJuridicoNome(usuarioPessoaJuridica);
		
		return listUsuario;
		
	}
	
	public ConfiguracaoPlano consultaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		ConfiguracaoPlano configuracaoPlano = new ConfiguracaoPlano();
		
		configuracaoPlano = usuarioJuridicoModel.consultaConfiguracaoPlano(usuarioPessoaJuridica);
		
		return configuracaoPlano;
	}

	
	public Resultado updateUsuarioJuridico(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioJuridicoModel.updateUsuarioJuridico(usuarioPessoaJuridica);
		
		return resultado;

	}
	
	public Resultado atualizaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();
		
		resultado = usuarioJuridicoModel.atualizaConfiguracaoPlano(usuarioPessoaJuridica);
		
		return resultado;
		
	}
	
	public UsuarioPessoaJuridica consultaUsuarioJuridicoGuid(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		usuarioPessoaJuridica = usuarioJuridicoModel.consultaUsuarioJuridicoGuid(usuarioPessoaJuridica);
		
		return usuarioPessoaJuridica;
		
	}

	public List <UsuarioPessoaJuridica> consultaListaUsuarioJuridicoItemColecao(Pesquisa pesquisa){
		
		List<UsuarioPessoaJuridica> listaUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listaUsuario = usuarioJuridicoModel.consultaListaUsuarioJuridicoItemColecao(pesquisa);
		
		return listaUsuario;	
	}


	
	public List <UsuarioPessoaJuridica> consultaPageListaUsuarioJuridicoItemColecao(int idEdicaoAlbum){
		
		List<UsuarioPessoaJuridica> listaUsuario = new ArrayList<UsuarioPessoaJuridica>();
		
		listaUsuario = usuarioJuridicoModel.consultaPageListaUsuarioJuridicoItemColecao(idEdicaoAlbum);
		
		return listaUsuario;		
	}

	public int consultaNumeroPaginaUsuarioJuridicoItemColecao(int idEdicaoAlbum){
		
		int numeroPaginas = usuarioJuridicoModel.consultaNumeroPaginaUsuarioJuridicoItemColecao(idEdicaoAlbum);
		
		return numeroPaginas;
	}

	
	
	

	public UsuarioJuridicoModel getUsuarioJuridicoModel() {
		return usuarioJuridicoModel;
	}

	public void setUsuarioJuridicoModel(UsuarioJuridicoModel usuarioJuridicoModel) {
		this.usuarioJuridicoModel = usuarioJuridicoModel;
	}
	
	
	
}
