/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.core.util.Base64;

import Bean.AlbumAuxiliar;
import Bean.EdicaoAlbum;
import Bean.Ftp;
import DAO.EdicaoAlbumDao;
import Util.Guid;
import Util.Utility;

/**
 * @author marcos
 *
 */
public class EdicaoAlbumModel {
	
	
	private EdicaoAlbumDao edicaoAlbumDao;
	private Ftp ftp;
	private String diretorio;
	
	public EdicaoAlbum cadastroEdicaoAlbum(EdicaoAlbum edicaoAlbum){
		
		Utility utility = new Utility();
		boolean validacao = false;
				
		edicaoAlbum.getImagem().setNome(Guid.generateGuid());
		edicaoAlbum.getImagem().setDiretorio(diretorio);
		edicaoAlbum.getImagem().setImagem(Base64.decode(edicaoAlbum.getImagem().getValue()));
		
		validacao = utility.transferenciaImagem(ftp, edicaoAlbum.getImagem());
		
		if(validacao){
			
			edicaoAlbum = edicaoAlbumDao.cadastroEdicaoAlbum(edicaoAlbum);

		}else{
			
			edicaoAlbum.getResultado().setCode("-2");
			edicaoAlbum.getResultado().setMensagem("Erro ao realizar o cadastro.");
			
		}

	
		
		
		return edicaoAlbum;
		
		
	}
	
	public List<EdicaoAlbum> consultaEdicaoAlbumListaIdAlbum(int idAlbum){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		listaEdicaoAlbum = edicaoAlbumDao.consultaEdicaoAlbumListaIdAlbum(idAlbum);
		
		return listaEdicaoAlbum;
		
	}
	
	public List<EdicaoAlbum> consultaEdicaoAlbumIdAlbum(AlbumAuxiliar albumAuxiliar){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		listaEdicaoAlbum = edicaoAlbumDao.consultaEdicaoAlbumIdAlbum(albumAuxiliar);
		
		return listaEdicaoAlbum;
		
		
	}




	public EdicaoAlbumDao getEdicaoAlbumDao() {
		return edicaoAlbumDao;
	}


	public void setEdicaoAlbumDao(EdicaoAlbumDao edicaoAlbumDao) {
		this.edicaoAlbumDao = edicaoAlbumDao;
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
