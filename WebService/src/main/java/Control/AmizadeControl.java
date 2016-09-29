/**
 * 
 */
package Control;

import Bean.Amizade;
import Bean.Resultado;
import Model.AmizadeModel;

/**
 * @author marcos
 *
 */
public class AmizadeControl {
	
	private AmizadeModel amizadeModel;

	public Resultado cadastroAmizade (Amizade amizade){
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeModel.cadastroAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado aceitarAmizade (Amizade amizade){
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeModel.aceitarAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado bloquearAmizade (Amizade amizade){
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeModel.bloquearAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado deleteAmizade(Amizade amizade){
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeModel.deleteAmizade(amizade);
		
		return resultado;
	}
	
	
	
	public AmizadeModel getAmizadeModel() {
		return amizadeModel;
	}

	public void setAmizadeModel(AmizadeModel amizadeModel) {
		this.amizadeModel = amizadeModel;
	}
	
	

}
