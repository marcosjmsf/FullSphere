package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.AlbumAuxiliar;
import Bean.EdicaoAlbum;
import Model.EdicaoAlbumModel;

/**
 * @author marcos
 *
 */
public class EdicaoAlbumControl {

	
	private EdicaoAlbumModel edicaoAlbumModel; 
	
	
	public EdicaoAlbum cadastroEdicaoAlbum(EdicaoAlbum edicaoAlbum){
		
		
		edicaoAlbum = edicaoAlbumModel.cadastroEdicaoAlbum(edicaoAlbum);
		
		
		return edicaoAlbum;
		
		
	}
	
	public List<EdicaoAlbum> consultaEdicaoAlbumListaIdAlbum(int idAlbum){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		listaEdicaoAlbum = edicaoAlbumModel.consultaEdicaoAlbumListaIdAlbum(idAlbum);
		
		return listaEdicaoAlbum;
		
	}
	
	public List<EdicaoAlbum> consultaEdicaoAlbumIdAlbum(AlbumAuxiliar albumAuxiliar){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		listaEdicaoAlbum = edicaoAlbumModel.consultaEdicaoAlbumIdAlbum(albumAuxiliar);
		
		return listaEdicaoAlbum;
		
		
	}



	public EdicaoAlbumModel getEdicaoAlbumModel() {
		return edicaoAlbumModel;
	}


	public void setEdicaoAlbumModel(EdicaoAlbumModel edicaoAlbumModel) {
		this.edicaoAlbumModel = edicaoAlbumModel;
	}
	
	
}
