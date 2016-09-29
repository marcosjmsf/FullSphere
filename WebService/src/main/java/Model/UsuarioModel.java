/**
 * 
 */
package Model;

import java.io.IOException;


import com.sun.jersey.core.util.Base64;

import Bean.Ftp;
import Bean.Resultado;
import Bean.Usuario;
import DAO.UsuarioDao;
import Util.Guid;

import Util.Utility;

/**
 * @author marcos
 *
 */
public class UsuarioModel {
	
	private UsuarioDao usuarioDao;
	private Ftp ftp;
	private String diretorio;	
	
	public Usuario login(Usuario usuario){
		
		usuario = usuarioDao.login(usuario);
		
		return usuario;
		
	}
	
	
	public Resultado adicionarFotoUsuario(Usuario usuario) throws IOException{

		boolean validacao = false;
		Utility utility = new Utility();
		Resultado resultado = new Resultado();


		String nomeAntigo = usuarioDao.existeFoto(usuario);

		if(!nomeAntigo.equals("") && nomeAntigo != null){

			utility.excluirImagemAntiga(ftp,nomeAntigo);
		}


		usuario.getImagem().setDiretorio(diretorio);
		usuario.getImagem().setImagem(Base64.decode(usuario.getImagem().getValue()));
		usuario.getImagem().setNome(Guid.generateGuid());

		validacao = utility.transferenciaImagem(ftp,usuario.getImagem());

		if(validacao){
			resultado = usuarioDao.adicionarFotoUsuario(usuario);
		}else{

			resultado.setCode("-3");
			resultado.setMensagem("Erro ao adicionar foto");

		}


		return resultado;

	}	
	
	public Resultado trocaSenha(Usuario usuario){

		Resultado resultado = new Resultado();

		resultado = usuarioDao.trocaSenha(usuario);

		return resultado;

	}

	public Resultado updateEmailUsuario(Usuario usuario){
		
		Resultado resultado = new Resultado();

		resultado = usuarioDao.updateEmailUsuario(usuario);

		return resultado;
		
	}

	public Usuario convertIdToGuid(int idUsuario){
		
		Usuario usuario = new Usuario();
	
		usuario = usuarioDao.convertIdToGuid(idUsuario);
		
		return usuario;
	}

	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public Ftp getFtp() {
		return ftp;
	}


	public void setFtp(Ftp ftp) {
		this.ftp = ftp;
	}


	public String getDiretorio() {
		return diretorio;
	}


	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	
	
	
	

}
