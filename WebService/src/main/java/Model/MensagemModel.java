/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.MensagemAmizade;
import Bean.Resultado;
import DAO.MensagemDao;

/**
 * @author marcos
 *
 */
public class MensagemModel {


	private MensagemDao mensagemDao;


	public Resultado cadastroMensagemAmizade(MensagemAmizade mensagemAmizade){
		
		Resultado resultado = new Resultado();
		
		resultado = mensagemDao.cadastroMensagemAmizade(mensagemAmizade);
		
		return resultado;

	}
	
	public List <MensagemAmizade> consultaConversaAmizade(int idAmizade){
		
		 List <MensagemAmizade> listaMensagem = new ArrayList<MensagemAmizade>();
		 
		 listaMensagem = mensagemDao.consultaConversaAmizade(idAmizade);
		 
		 return listaMensagem;
		
	}

	public List <MensagemAmizade> consultaConversaAmizadeLista(int idUsuario){
		
		List <MensagemAmizade> listaMensagem = new ArrayList<MensagemAmizade>();
		 
		listaMensagem = mensagemDao.consultaConversaAmizadeLista(idUsuario);
		 
		return listaMensagem;
		
	}



	public MensagemDao getMensagemDao() {
		return mensagemDao;
	}

	public void setMensagemDao(MensagemDao mensagemDao) {
		this.mensagemDao = mensagemDao;
	}


}
