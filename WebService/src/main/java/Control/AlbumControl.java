/**
 * 
 */
package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Bean.Album;
import Bean.AlbumAuxiliar;
import Bean.Resultado;
import Model.AlbumModel;

/**
 * @author marcos
 *
 */
public class AlbumControl {
	
	private AlbumModel albumModel;
	
	
	public Album cadastroAlbum(Album album) throws IOException{
		

		
		album = albumModel.cadastroAlbum(album);
		
		return album;
		
	}
	
	public List <Album> consultaAlbumNome(Album album){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumModel.consultaAlbumNome(album);
		
		return listAlbum;
	}
	
	public Album consultaAlbumId(AlbumAuxiliar albumAuxiliar){

		Album album = new Album();
		
		album = albumModel.consultaAlbumId(albumAuxiliar);
		
		return album;
	}

	public List <Album> consultaAlbumNomeLista(Album album){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumModel.consultaAlbumNomeLista(album);
		
		return listAlbum;
	}
	
	public List <Album> consultaAlbumIdLista(int idArtista){
		
		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumModel.consultaAlbumIdLista(idArtista);
		
		return listAlbum;
		
	}
	
	public List<Album> consultaAlbumIdArtistaDiscografia(int idArtista){

		List <Album> listAlbum = new ArrayList<Album>();
		
		listAlbum = albumModel.consultaAlbumIdArtistaDiscografia(idArtista);
		
		return listAlbum;
	}
	
	
	public Resultado darNotaAlbum (AlbumAuxiliar albumAuxiliar){

		Resultado resultado = new Resultado();
		
		resultado = albumModel.darNotaAlbum(albumAuxiliar);
		
		return resultado;
	}	
	
	
	
	public Album atualizaDadosNotaAlbum(int idAlbum){
		
		Album album = new Album();
		
		album = albumModel.atualizaDadosNotaAlbum(idAlbum);
		
		return album;
	
	}	

	

	public AlbumModel getAlbumModel() {
		return albumModel;
	}


	public void setAlbumModel(AlbumModel albumModel) {
		this.albumModel = albumModel;
	}
	
	

}
