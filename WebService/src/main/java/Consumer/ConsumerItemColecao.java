/**
 * 
 */
package Consumer;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Bean.ItemColecao;
import Bean.Pesquisa;
import Bean.Resultado;
import Control.ItemColecaoControl;


/**
 * @author marcos
 *
 */

@Path("/itemColecao")
public class ConsumerItemColecao {
	
	private ItemColecaoControl itemColecaoControl;
	
	
	@POST
	@Path("/cadastro")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public ItemColecao cadastroItemColecao(ItemColecao itemColecao){
		
		return itemColecaoControl.cadastroItemColecao(itemColecao);
		
	}
	
	@POST
	@Path("/cadastroListaDesejo")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado cadastroItemListaDesejo (ItemColecao itemColecao){
		
		return itemColecaoControl.cadastroItemListaDesejo(itemColecao);
	}


	@POST
	@Path("/atualiza")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado atualizaItemColecao(ItemColecao itemColecao){
		
		return itemColecaoControl.atualizaItemColecao(itemColecao);
		
	}

	@POST
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado deleteItemColecao(ItemColecao itemColecao){
		
		return itemColecaoControl.deleteItemColecao(itemColecao);
		
	}
	
	
	@POST
	@Path("/deleteListaDesejo")
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	public Resultado deleteItemListaDesejo(ItemColecao itemColecao){
				
		return itemColecaoControl.deleteItemListaDesejo(itemColecao);
		
	}
	
	@GET
	@Path("/consultaId/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public ItemColecao consultaItemColecaoId(@PathParam("id")int idItemColecao){
		
		return itemColecaoControl.consultaItemColecaoId(idItemColecao);
		
	}
	
	//Opercao sera utilizada de forma paginada, sera passado como parametros o numero da pagina e id do usuario que se deseja consultar
	//A operacao sempre retornara 10 itens da colecao do usuario informado de acordo com o numero da pagina
	@POST
	@Path("/consultaListaIdUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemColecaoListaIdUsuario(Pesquisa pesquisa){
		
		return itemColecaoControl.consultaItemColecaoListaIdUsuario(pesquisa);
		
	}
	
	
	
	//Essa operacao retornara uma lista de 10 itens da lista de desejo do usuario, esses itens ira mudar de acordo com o numero da pagina
	//usara como parametro o id do usuario
	@POST
	@Path("/consultaItemListaDesejoIdUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemListaDesejoIdUsuario(Pesquisa pesquisa){
		
		return itemColecaoControl.consultaItemListaDesejoIdUsuario(pesquisa);
		
	}
	
	//Essa operacao retornara uma lista de 10 itens da lista de desejo do usuario, esses itens ira mudar de acordo com o numero da pagina
	//usara como parametro o guid do usuario
	@POST
	@Path("/consultaItemListaDesejoGuidUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemListaDesejoGuidUsuario(Pesquisa pesquisa){
		
		return itemColecaoControl.consultaItemListaDesejoGuidUsuario(pesquisa);
		
	}

	//Essa operacao sera utilizada para exibir uma previa da colecao do usuario na pagina inicial, "HOME"
	//Ela retornara 10 itens da colecao do usuario informado atravez do id. 
	//Sera retornado apenas o nome da edicao, a foto da edicao, o id da edicao e o tipo de midia daquela edicao
	@GET
	@Path("/consultaHomeIdUsuario/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemColecaoHomeIdUsuario(@PathParam("idUsuario")int idUsuario){
		
		return itemColecaoControl.consultaItemColecaoHomeIdUsuario(idUsuario);
	}
	
	
	
	//Essa operacao sera utilizada para exibir uma previa da colecao do usuario na pagina de exibicao
	//Ela retornara 10 itens da colecao do usuario informado atravez da guid. 
	//Sera retornado apenas o nome da edicao, a foto da edicao, o id da edicao e o tipo de midia daquela edicao
	@GET
	@Path("/consultaHomeGuidUsuario/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemColecaoHomeGuidUsuario(@PathParam("guidUsuario")String guidUsuario){
		
		return itemColecaoControl.consultaItemColecaoHomeGuidUsuario(guidUsuario);
	}
	
	
	//Opercao sera utilizada de forma paginada, sera passado como parametros o numero da pagina e a guid do usuario que se deseja consultar
	//A operacao sempre retornara 10 itens da colecao do usuario informado de acordo com o numero da pagina
	@POST
	@Path("/consultaListaGuidUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemColecaoListaGuidUsuario(Pesquisa pesquisa){
		
		return itemColecaoControl.consultaItemColecaoListaGuidUsuario(pesquisa);
		
	}
	
	
	//Essa operacao e excluisiva para retornar o numero de paginas que uma lista de desejo deve possuir,
	//Baseado nesse numero que o front end vai exibir o numero de paginas para o usuario
	//o parametro de entrada dessa opercao sera a guid do usuario
	@GET
	@Path("/consultaNumeroPaginaListaDesejoGuidUsuario/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaListaDesejoItemGuidUsuario(@PathParam("guidUsuario")String guidUsuario){
		
		return itemColecaoControl.consultaNumeroPaginaListaDesejoItemGuidUsuario(guidUsuario);
	}

	
	//Essa operacao e excluisiva para retornar o numero de paginas que uma lista de desejo deve possuir,
	//Baseado nesse numero que o front end vai exibir o numero de paginas para o usuario
	//o parametro de entrada dessa opercao sera o id do usuario
	@GET
	@Path("/consultaNumeroPaginaListaDesejoIdUsuario/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaListaDesejoItemIdUsuario(@PathParam("idUsuario")int guidUsuario){
		
		return itemColecaoControl.consultaNumeroPaginaListaDesejoItemIdUsuario(guidUsuario);
	}

	
	//Essa operacao e excluisiva para retornar o numero de paginas que uma colecao deve possuir,
	//Baseado nesse numero que o front end vai exibir o numero de paginas para o usuario
	//o parametro de entrada dessa opercao sera a guid do usuario
	@GET
	@Path("/consultaNumeroPaginaGuidUsuario/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaItemColecaoGuidUsuario(@PathParam("guidUsuario")String guidUsuario){
		
		return itemColecaoControl.consultaNumeroPaginaItemColecaoGuidUsuario(guidUsuario);
	}

	
	
	//Essa operacao e excluisiva para retornar o numero de paginas que uma colecao deve possuir,
	//Baseado nesse numero que o front end vai exibir o numero de paginas para o usuario
	//o parametro de entrada dessa opercao sera o id do usuario
	@GET
	@Path("/consultaNumeroPaginaIdUsuario/{guidUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public int consultaNumeroPaginaItemColecaoIdUsuario(@PathParam("guidUsuario")int guidUsuario){
		
		return itemColecaoControl.consultaNumeroPaginaItemColecaoIdUsuario(guidUsuario);
	}

	
	//Essa operacao e excluisiva para retornar os itens da lista de desejo que apareceram na home do usuario
	@GET
	@Path("/consultaListaDesejoHomeIdUsuario/{idUsuario}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public List<ItemColecao> consultaItemListaDesejoHomeIdUsuario(@PathParam("idUsuario")int idUsuario){
			
		return itemColecaoControl.consultaItemListaDesejoHomeIdUsuario(idUsuario);
		
	}
	
	
	
	public ItemColecaoControl getItemColecaoControl() {
		return itemColecaoControl;
	}


	public void setItemColecaoControl(ItemColecaoControl itemColecaoControl) {
		this.itemColecaoControl = itemColecaoControl;
	}
	
	
	
	
	

}
