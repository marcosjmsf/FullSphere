/**
 * 
 */
package Control;

import java.util.List;

import Bean.Endereco;
import Model.EnderecoModel;

/**
 * @author marcos
 *
 */
public class EnderecoControl {
	
	EnderecoModel enderecoModel;
	
	public List <Endereco> consultaEnderecoCep(String cep){

		List <Endereco> endereco = enderecoModel.consultaEnderecoCep(cep);
		
		return endereco;
	}

	public Endereco cadastroLogradouro (Endereco endereco){
		
		endereco = enderecoModel.cadastroLogradouro(endereco);
		
		return endereco;
		
	}
	
	
	public EnderecoModel getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(EnderecoModel enderecoModel) {
		this.enderecoModel = enderecoModel;
	}
	

}
