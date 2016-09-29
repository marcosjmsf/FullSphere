/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.MensagemAmizade;
import Bean.Resultado;
import Model.MensagemModel;

/**
 * @author marcos
 *
 */
public class MensagemControl {
	
	
	private MensagemModel mensagemModel;


	public Resultado cadastroMensagemAmizade(MensagemAmizade mensagemAmizade){
		
		Resultado resultado = new Resultado();
		
		resultado = mensagemModel.cadastroMensagemAmizade(mensagemAmizade);
		
		return resultado;

	}
	
	public List <MensagemAmizade> consultaConversaAmizade(int idAmizade){
		
		 List <MensagemAmizade> listaMensagem = new ArrayList<MensagemAmizade>();
		 
		 listaMensagem = mensagemModel.consultaConversaAmizade(idAmizade);
		 
		 return listaMensagem;
		
	}
	
	public List <MensagemAmizade> consultaConversaAmizadeLista(int idUsuario){
		
		List <MensagemAmizade> listaMensagem = new ArrayList<MensagemAmizade>();
		 
		listaMensagem = mensagemModel.consultaConversaAmizadeLista(idUsuario);
		 
		return listaMensagem;
		
	}
	
	
	public MensagemModel getMensagemModel() {
		return mensagemModel;
	}

	public void setMensagemModel(MensagemModel mensagemModel) {
		this.mensagemModel = mensagemModel;
	}

}
