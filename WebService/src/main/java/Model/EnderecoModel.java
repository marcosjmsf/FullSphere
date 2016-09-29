/**
 * 
 */
package Model;



import java.util.List;

import Bean.Endereco;
import DAO.EnderecoDao;

/**
 * @author marcos
 *
 */
public class EnderecoModel {

	EnderecoDao enderecoDao;
	
	public List <Endereco> consultaEnderecoCep(String cep){

		List <Endereco> endereco = enderecoDao.consultaEnderecoCep(cep);
		
		return endereco;
	}
	
	public Endereco cadastroLogradouro (Endereco endereco){
		
		
		endereco = enderecoDao.cadastroLogradouro(endereco);
		
		return endereco;
		
	}

	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}
	
	


}
