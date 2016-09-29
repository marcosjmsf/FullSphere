/**
 * 
 */
package Model;



import Bean.Amizade;
import Bean.Resultado;
import DAO.AmizadeDao;

/**
 * @author marcos
 *
 */
public class AmizadeModel {
	
	private AmizadeDao amizadeDao;

	public Resultado cadastroAmizade (Amizade amizade){

		amizade.setIdEstadoAmizade(1);
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeDao.cadastroAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado aceitarAmizade (Amizade amizade){

		amizade.setIdEstadoAmizade(2);
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeDao.updateEstadoAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado bloquearAmizade (Amizade amizade){
		
		Resultado resultado = new Resultado();
		
		resultado = amizadeDao.bloqueioAmizade(amizade);
		
		return resultado;
	}
	
	public Resultado deleteAmizade (Amizade amizade){
				
		Resultado resultado = new Resultado();
		
		resultado = amizadeDao.deleteAmizade(amizade);
		
		return resultado;
	}
	

	
	public AmizadeDao getAmizadeDao() {
		return amizadeDao;
	}

	public void setAmizadeDao(AmizadeDao amizadeDao) {
		this.amizadeDao = amizadeDao;
	}

}
