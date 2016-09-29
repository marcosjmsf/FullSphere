/**
 * 
 */
package Model;

import java.io.IOException;
import java.util.List;

import com.sun.jersey.core.util.Base64;

import Bean.Artista;
import Bean.ArtistaAuxiliar;
import Bean.Ftp;
import Bean.Pesquisa;
import Bean.Resultado;
import DAO.ArtistaDao;
import Util.Guid;
import Util.Utility;

/**
 * @author marcos
 *
 */
public class ArtistaModel {

	private ArtistaDao artistaDao;
	private Ftp ftp;
	private String diretorio;	
	
	public Artista cadastroArtista(Artista artista) throws IOException{

		Utility utility = new Utility();
		boolean validacao = false;
				
		artista.getImagem().setNome(Guid.generateGuid());
		artista.getImagem().setDiretorio(diretorio);
		artista.getImagem().setImagem(Base64.decode(artista.getImagem().getValue()));
		
		validacao = utility.transferenciaImagem(ftp, artista.getImagem());

		if(validacao){
		
			artista = artistaDao.cadastroArtista(artista);
		}else{
			
			artista.getResultado().setCode("-2");
			artista.getResultado().setMensagem("Erro ao realizar o cadastro.");
			
		}
		return artista;
	}


	/*public List <Artista> consultaArtistaNome(Artista artista){

		List <Artista> listaArtista = artistaDao.consultaArtistaNome(artista);

		return listaArtista;
	}*/


	public Artista consultaArtistaId(ArtistaAuxiliar artistaAuxiliar){

		Artista artista = new Artista();
		
		artista = artistaDao.consultaArtistaId(artistaAuxiliar);

		return artista;
	}
	
	public List <Artista> consultaArtistaNomeLista(Artista artista){
		
		List <Artista> listaArtista = artistaDao.consultaArtistaNomeLista(artista);

		return listaArtista;
		
	}

	public Artista consultaArtistaIdSimples(int idArtista){
		
		Artista artista = artistaDao.consultaArtistaIdSimples(idArtista);

		return artista;
		
	}
	
	
	public Resultado favoritarArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaDao.favoritarArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	public Resultado darNotaArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaDao.darNotaArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	
	public List <Artista> consultaArtistaFavoritoHomeGuid(String guidUsuario){
		
		List <Artista> listaArtista = artistaDao.consultaArtistaFavoritoHomeGuid(guidUsuario);

		return listaArtista;
		
	}
	
	public List <Artista> consultaArtistaFavoritoHomeId(int idUsuario){
		
		List <Artista> listaArtista = artistaDao.consultaArtistaFavoritoHomeId(idUsuario);

		return listaArtista;
		
	}
	

	public List <Artista> consultaArtistaFavoritoIdLista(Pesquisa pesquisa){
		
		List <Artista> listaArtista = artistaDao.consultaArtistaFavoritoIdLista(pesquisa);

		return listaArtista;
		
	}
	
	public List <Artista> consultaArtistaFavoritoGuidLista(Pesquisa pesquisa){
		
		List <Artista> listaArtista = artistaDao.consultaArtistaFavoritoGuidLista(pesquisa);

		return listaArtista;
		
	}


	public int consultaNumeroPaginaFavoritoIdUsuario(int idUsuario){
		
		int numeroPagina = artistaDao.consultaNumeroPaginaFavoritoIdUsuario(idUsuario);
		
		return numeroPagina;
		
	}
	
	public int consultaNumeroPaginaFavoritoGuidUsuario(String guidUsuario){
		
		int numeroPagina = artistaDao.consultaNumeroPaginaFavoritoGuidUsuario(guidUsuario);
		
		return numeroPagina;
		
	}

	public Resultado desfavoritarArtista (ArtistaAuxiliar artistaAuxiliar){
		
		Resultado resultado = new Resultado();
		
		resultado = artistaDao.desfavoritarArtista(artistaAuxiliar);
		
		return resultado;
		
	}
	
	public Artista atualizaDadosNotaArtista(int idArtista){
		
		Artista artista = new Artista();
	
		artista = artistaDao.atualizaDadosNotaArtista(idArtista);	
		
		return artista;
	
	}

	

	public ArtistaDao getArtistaDao() {
		return artistaDao;
	}

	public void setArtistaDao(ArtistaDao artistaDao) {
		this.artistaDao = artistaDao;
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
