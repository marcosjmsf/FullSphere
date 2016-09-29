/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.ComentarioAlbum;
import Bean.ComentarioArtista;
import Bean.Pesquisa;
import Bean.Resultado;
import DAO.ComentarioDao;

/**
 * @author marcos
 *
 */
public class ComentarioModel {
	
	private ComentarioDao comentarioDao;
	
	public ComentarioArtista cadastroComentarioArtista (ComentarioArtista comentarioArtista){
		
		ComentarioArtista resultado = new ComentarioArtista();
		
		resultado =	comentarioDao.cadastroComentarioArtista(comentarioArtista);
		
		return resultado;
		
	}
	
	public ComentarioAlbum cadastroComentarioAlbum (ComentarioAlbum comentarioAlbum){
		
		ComentarioAlbum resultado = new ComentarioAlbum();
		
		resultado =	comentarioDao.cadastroComentarioAlbum(comentarioAlbum);
		
		return resultado;
		
	}
	
	public Resultado deleteComentarioAlbum (ComentarioAlbum comentarioAlbum){
		
		Resultado resultado = new Resultado();
		
		resultado =	comentarioDao.deleteComentarioAlbum(comentarioAlbum);
		
		return resultado;
		
	}
	
	public Resultado deleteComentarioArtista (ComentarioArtista comentarioArtista){
		
		Resultado resultado = new Resultado();
		
		resultado =	comentarioDao.deleteComentarioArtista(comentarioArtista);
		
		return resultado;
		
	}
	
	public List<ComentarioArtista> consultaListaComentarioArtista (Pesquisa pesquisa){
		
		List<ComentarioArtista> listaComentarioArtista = new ArrayList<ComentarioArtista>();
		
		listaComentarioArtista = comentarioDao.consultaListaComentarioArtista(pesquisa);
		
		return listaComentarioArtista;
		
	}
	
	public List<ComentarioAlbum> consultaListaComentarioAlbum (Pesquisa pesquisa){
		
		List<ComentarioAlbum> listaComentarioAlbum = new ArrayList<ComentarioAlbum>();
		
		listaComentarioAlbum = comentarioDao.consultaListaComentarioAlbum(pesquisa);
		
		return listaComentarioAlbum;
		
	}


	public ComentarioDao getComentarioDao() {
		return comentarioDao;
	}

	public void setComentarioDao(ComentarioDao comentarioDao) {
		this.comentarioDao = comentarioDao;
	}
	
	
	

}
