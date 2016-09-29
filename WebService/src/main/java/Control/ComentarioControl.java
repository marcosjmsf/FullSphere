/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.ComentarioAlbum;
import Bean.ComentarioArtista;
import Bean.Pesquisa;
import Bean.Resultado;
import Model.ComentarioModel;

/**
 * @author marcos
 *
 */
public class ComentarioControl {

	
	private ComentarioModel comentarioModel;
	
	public ComentarioArtista cadastroComentarioArtista (ComentarioArtista comentarioArtista){
		
		ComentarioArtista resultado = new ComentarioArtista();
		
		resultado =	comentarioModel.cadastroComentarioArtista(comentarioArtista);
		
		return resultado;
		
	}
	
	public ComentarioAlbum cadastroComentarioAlbum (ComentarioAlbum comentarioAlbum){
		
		ComentarioAlbum resultado = new ComentarioAlbum();
		
		resultado =	comentarioModel.cadastroComentarioAlbum(comentarioAlbum);
		
		return resultado;
		
	}
	
	public Resultado deleteComentarioAlbum (ComentarioAlbum comentarioAlbum){
		
		Resultado resultado = new Resultado();
		
		resultado =	comentarioModel.deleteComentarioAlbum(comentarioAlbum);
		
		return resultado;
		
	}
	
	public Resultado deleteComentarioArtista (ComentarioArtista comentarioArtista){
		
		Resultado resultado = new Resultado();
		
		resultado =	comentarioModel.deleteComentarioArtista(comentarioArtista);
		
		return resultado;
		
	}
	
	public List<ComentarioArtista> consultaListaComentarioArtista (Pesquisa pesquisa){
		
		List<ComentarioArtista> listaComentarioArtista = new ArrayList<ComentarioArtista>();
		
		listaComentarioArtista = comentarioModel.consultaListaComentarioArtista(pesquisa);
		
		return listaComentarioArtista;
		
	}
	
	public List<ComentarioAlbum> consultaListaComentarioAlbum (Pesquisa pesquisa){
		
		List<ComentarioAlbum> listaComentarioAlbum = new ArrayList<ComentarioAlbum>();
		
		listaComentarioAlbum = comentarioModel.consultaListaComentarioAlbum(pesquisa);
		
		return listaComentarioAlbum;
		
	}

	public ComentarioModel getComentarioModel() {
		return comentarioModel;
	}

	public void setComentarioModel(ComentarioModel comentarioModel) {
		this.comentarioModel = comentarioModel;
	}
	
	
	
	
	
	
}
