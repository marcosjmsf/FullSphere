/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.core.util.Base64;

import Bean.Album;
import Bean.AlbumAuxiliar;
import Bean.Ftp;
import Bean.Resultado;
import DAO.AlbumDao;
import RowMapper.AlbumDiscografiaArtistaRowMapper;
import Util.Guid;
import Util.Utility;

/**
 * @author marcos
 *
 */
public class AlbumModel {
	
	private AlbumDao albumDao;
	private Ftp ftp;
	private String diretorio;	
	
	public Album cadastroAlbum(Album album){
		
		Utility utility = new Utility();
		boolean validacao = false;
				
		album.getImagem().setNome(Guid.generateGuid());
		album.getImagem().setDiretorio(diretorio);
		album.getImagem().setImagem(Base64.decode(album.getImagem().getValue()));
		
		validacao = utility.transferenciaImagem(ftp, album.getImagem());
		
		if(validacao){

			album = albumDao.cadastroAlbum(album);
		}else{
			
			album.getResultado().setCode("-2");
			album.getResultado().setMensagem("Erro ao realizar o cadastro.");
		}
		
		return album;
		
	}
	
	public List <Album> consultaAlbumNome(Album album){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumDao.consultaAlbumNome(album);
		
		return listAlbum;
	}
	
	public Album consultaAlbumId(AlbumAuxiliar albumAuxiliar){

		Album album = new Album();
		
		album = albumDao.consultaAlbumId(albumAuxiliar);
		
		return album;
	}
	
	public List <Album> consultaAlbumNomeLista(Album album){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumDao.consultaAlbumNomeLista(album);
		
		return listAlbum;
	}

	public List <Album> consultaAlbumIdLista(int idArtista){
		
		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumDao.consultaAlbumIdLista(idArtista);
		
		return listAlbum;
		
	}
	
	
	public List<Album> consultaAlbumIdArtistaDiscografia(int idArtista){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumDao.consultaAlbumIdArtistaDiscografia(idArtista);
		
		return listAlbum;
	}

	public Resultado darNotaAlbum (AlbumAuxiliar albumAuxiliar){

		Resultado resultado = new Resultado();
		
		resultado = albumDao.darNotaAlbum(albumAuxiliar);
		
		return resultado;
	}
	
	public Album atualizaDadosNotaAlbum(int idAlbum){
		
		Album album = new Album();
		
		album = albumDao.atualizaDadosNotaAlbum(idAlbum);
		
		return album;
	
	}	


	public AlbumDao getAlbumDao() {
		return albumDao;
	}


	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
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
