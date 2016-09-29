/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.EstiloMusical;
import Bean.EstimaItem;
import Bean.Gravadora;
import Bean.Pais;
import Bean.TipoMidia;
import DAO.UtilDao;

/**
 * @author marcos
 *
 */
public class UtilModel {
	
	private UtilDao utilDao;
	
	public List <Pais> consultaPais(){

		List<Pais> listaPais = new ArrayList<Pais>();
		
		listaPais = utilDao.consultaPais();
		
		return listaPais;

	}
	
	public List <EstiloMusical> consultaEstiloMusical(){
		
		List <EstiloMusical> listaEstiloMusical = new ArrayList<EstiloMusical>();
		
		listaEstiloMusical = utilDao.consultaEstiloMusical();
		
		return listaEstiloMusical;
		
	}
	
	public List <TipoMidia> consultaTipoMidia(){
		
		List<TipoMidia> listaTipoMidia = new ArrayList<TipoMidia>();
		
		listaTipoMidia = utilDao.consultaTipoMidia();
		
		return listaTipoMidia;
		
	}

	public List<Gravadora> consultaGravadora(String gravadoraNome){
		
		
		List<Gravadora> listaGravadora = new ArrayList<Gravadora>();
		
		listaGravadora = utilDao.consultaGravadora(gravadoraNome);
		
		return listaGravadora;
		
	}

	public Gravadora cadastroGravadora(Gravadora gravadora){
		
		gravadora = utilDao.cadastroGravadora(gravadora);
		
		return gravadora;
		
	}


	public List<EstimaItem> consultaEstimaItem(){
			
		List<EstimaItem> listaEstimaItem =  new ArrayList<EstimaItem>();
		
		listaEstimaItem = utilDao.consultaEstimaItem();
		
		return listaEstimaItem;

	}
	

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	
	
	

}
