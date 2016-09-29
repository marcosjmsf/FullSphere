/**
 * 
 */
package Control;

import java.io.IOException;
import java.util.List;
import Bean.Artista;
import Bean.ArtistaAuxiliar;
import Bean.Pesquisa;
import Bean.Resultado;
import Model.ArtistaModel;

/**
 * @author marcos
 *
 */
public class ArtistaControl {
	
	ArtistaModel artistaModel;
	
	public Artista cadastroArtista(Artista artista) throws IOException{
		
		
		artista = artistaModel.cadastroArtista(artista);
		
		return artista;
	}
	
	/*public List <Artista> consultaArtistaNome(Artista artista){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaNome(artista);
		
		return listaArtista;
	}*/
	
	public Artista consultaArtistaId(ArtistaAuxiliar artistaAuxiliar){

		Artista artista = new Artista();
		
		artista = artistaModel.consultaArtistaId(artistaAuxiliar);

		return artista;
	}
	
	public List <Artista> consultaArtistaNomeLista(Artista artista){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaNomeLista(artista);

		return listaArtista;
		
	}
	
	public Artista consultaArtistaIdSimples(int idArtista){
		
		Artista artista = artistaModel.consultaArtistaIdSimples(idArtista);

		return artista;
		
	}
	
	public Resultado favoritarArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaModel.favoritarArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	
	public Resultado darNotaArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaModel.darNotaArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	public List <Artista> consultaArtistaFavoritoHomeGuid(String guidUsuario){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaFavoritoHomeGuid(guidUsuario);

		return listaArtista;
		
	}
	
	public List <Artista> consultaArtistaFavoritoHomeId(int idUsuario){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaFavoritoHomeId(idUsuario);

		return listaArtista;
		
	}
	
	public List <Artista> consultaArtistaFavoritoIdLista(Pesquisa pesquisa){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaFavoritoIdLista(pesquisa);

		return listaArtista;
		
	}
	
	public List <Artista> consultaArtistaFavoritoGuidLista(Pesquisa pesquisa){
		
		List <Artista> listaArtista = artistaModel.consultaArtistaFavoritoGuidLista(pesquisa);

		return listaArtista;
		
	}
	
	public int consultaNumeroPaginaFavoritoIdUsuario(int idUsuario){
		
		int numeroPagina = artistaModel.consultaNumeroPaginaFavoritoIdUsuario(idUsuario);
		
		return numeroPagina;
		
	}
	
	public int consultaNumeroPaginaFavoritoGuidUsuario(String guidUsuario){
		
		int numeroPagina = artistaModel.consultaNumeroPaginaFavoritoGuidUsuario(guidUsuario);
		
		return numeroPagina;
		
	}

	public Resultado desfavoritarArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaModel.desfavoritarArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	public Artista atualizaDadosNotaArtista(int idArtista){
		
		Artista artista = new Artista();
	
		artista = artistaModel.atualizaDadosNotaArtista(idArtista);	
		
		return artista;
	
	}
	

	public ArtistaModel getArtistaModel() {
		return artistaModel;
	}

	public void setArtistaModel(ArtistaModel artistaModel) {
		this.artistaModel = artistaModel;
	}
	
	
	

}
