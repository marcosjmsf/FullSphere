/**
 * 
 */
package Control;

import java.util.ArrayList;
import java.util.List;

import Bean.ItemColecao;
import Bean.Pesquisa;
import Bean.Resultado;
import Model.ItemColecaoModel;

/**
 * @author marcos
 *
 */
public class ItemColecaoControl {
	
	private ItemColecaoModel itemColecaoModel;
	
	
	public ItemColecao cadastroItemColecao (ItemColecao itemColecao){
		
		itemColecao = itemColecaoModel.cadastroItemColecao(itemColecao);
		
		return itemColecao;
		
	}
	
	public Resultado cadastroItemListaDesejo (ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoModel.cadastroItemListaDesejo(itemColecao);
		
		return resultado;

	}
	
	public Resultado atualizaItemColecao(ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoModel.atualizaItemColecao(itemColecao);
		
		return resultado;
		
	}
	
	public Resultado deleteItemColecao(ItemColecao itemColecao){

		Resultado resultado = new Resultado();
		
		resultado = itemColecaoModel.deleteItemColecao(itemColecao);
		
		return resultado;
		
	}
	
	public Resultado deleteItemListaDesejo(ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoModel.deleteItemListaDesejo(itemColecao);
		
		return resultado;
		
		
	}
	
	public ItemColecao consultaItemColecaoId(int idItemColecao){
		
		ItemColecao itemColecao = new ItemColecao();
		
		itemColecao = itemColecaoModel.consultaItemColecaoId(idItemColecao);
		
		return itemColecao;
		
	}
	
	
	public List<ItemColecao> consultaItemColecaoListaIdUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemColecaoListaIdUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemListaDesejoIdUsuario(Pesquisa pesquisa){

		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemListaDesejoIdUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemListaDesejoGuidUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemListaDesejoGuidUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoHomeIdUsuario(int idUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemColecaoHomeIdUsuario(idUsuario);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoHomeGuidUsuario(String guidUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemColecaoHomeGuidUsuario(guidUsuario);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoListaGuidUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemColecaoListaGuidUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	
	
	
	
	public int consultaNumeroPaginaListaDesejoItemIdUsuario(int idUsuario){
		
		int resultado = itemColecaoModel.consultaNumeroPaginaListaDesejoItemIdUsuario(idUsuario);
		
		return resultado;
	}
	
	public int consultaNumeroPaginaListaDesejoItemGuidUsuario(String guidUsuario){
		
		int resultado = itemColecaoModel.consultaNumeroPaginaListaDesejoItemGuidUsuario(guidUsuario);
		
		return resultado;

	}
	
	
	public int consultaNumeroPaginaItemColecaoIdUsuario(int idUsuario){
		
		int resultado = itemColecaoModel.consultaNumeroPaginaItemColecaoIdUsuario(idUsuario);
		
		return resultado;

	}
	
	public int consultaNumeroPaginaItemColecaoGuidUsuario(String guidUsuario){
		
		int resultado = itemColecaoModel.consultaNumeroPaginaItemColecaoGuidUsuario(guidUsuario);
		
		return resultado;
	}
	
	public List<ItemColecao> consultaItemListaDesejoHomeIdUsuario(int idUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoModel.consultaItemListaDesejoHomeIdUsuario(idUsuario);
		
		return listaItemColecao;		
	}



	public ItemColecaoModel getItemColecaoModel() {
		return itemColecaoModel;
	}


	public void setItemColecaoModel(ItemColecaoModel itemColecaoModel) {
		this.itemColecaoModel = itemColecaoModel;
	}


}
