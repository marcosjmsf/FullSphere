/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.EstiloMusical;
import Bean.EstimaItem;
import Bean.Gravadora;
import Bean.Pais;
import Bean.TipoMidia;
import Model.UtilModel;

/**
 * @author marcos
 *
 */
public class UtilControl {
	
	private UtilModel utilModel;
	
	
	public List <Pais> consultaPais(){

		List<Pais> listaPais = new ArrayList<Pais>();
		
		listaPais = utilModel.consultaPais();
		
		return listaPais;

	}
	
	public List <EstiloMusical> consultaEstiloMusical(){
		
		List <EstiloMusical> listaEstiloMusical = new ArrayList<EstiloMusical>();
		
		listaEstiloMusical = utilModel.consultaEstiloMusical();
		
		return listaEstiloMusical;
		
	}
	
	public List <TipoMidia> consultaTipoMidia(){
		
		List<TipoMidia> listaTipoMidia = new ArrayList<TipoMidia>();
		
		listaTipoMidia = utilModel.consultaTipoMidia();
		
		return listaTipoMidia;
		
	}

	
	public List<Gravadora> consultaGravadora(String gravadoraNome){
		
		
		List<Gravadora> listaGravadora = new ArrayList<Gravadora>();
		
		listaGravadora = utilModel.consultaGravadora(gravadoraNome);
		
		return listaGravadora;
		
	}

	public Gravadora cadastroGravadora(Gravadora gravadora){
		
		gravadora = utilModel.cadastroGravadora(gravadora);
		
		return gravadora;
		
	}
	
	public List<EstimaItem> consultaEstimaItem(){
		
		List<EstimaItem> listaEstimaItem =  new ArrayList<EstimaItem>();
		
		listaEstimaItem = utilModel.consultaEstimaItem();
		
		return listaEstimaItem;

	}
	

	public UtilModel getUtilModel() {
		return utilModel;
	}


	public void setUtilModel(UtilModel utilModel) {
		this.utilModel = utilModel;
	}
	
	
	

}
