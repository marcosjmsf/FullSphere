/**
 * 
 */
package Consumer;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.Endereco;
import Control.EnderecoControl;

/**
 * @author marcos
 *
 */

@Path("/endereco")
public class ConsumerEndereco {
	
	EnderecoControl enderecoControl;
	
	@GET
	@Path("/consultaCep/{cep}")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public List <Endereco> consultaCep(@PathParam("cep")String cep){

		return enderecoControl.consultaEnderecoCep(cep);

	}
	
	
	@POST
	@Path("/cadastroLogradouro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Endereco cadastroLogradouro(Endereco endereco){

		return enderecoControl.cadastroLogradouro(endereco);

	}
	

	public EnderecoControl getEnderecoControl() {
		return enderecoControl;
	}

	public void setEnderecoControl(EnderecoControl enderecoControl) {
		this.enderecoControl = enderecoControl;
	}
	
	
	
	
	

}
