/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Bean.ItemColecao;
import Bean.Pesquisa;
import Bean.Resultado;
import DAO.ItemColecaoDao;

/**
 * @author marcos
 *
 */
public class ItemColecaoModel {
	
	private ItemColecaoDao itemColecaoDao;  
	
	
	public ItemColecao cadastroItemColecao (ItemColecao itemColecao){
		
		itemColecao = itemColecaoDao.cadastroItemColecao(itemColecao);
		
		return itemColecao;
		
		
	}
	
	public Resultado cadastroItemListaDesejo (ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoDao.cadastroItemListaDesejo(itemColecao);
		
		return resultado;

	}

	
	public Resultado atualizaItemColecao(ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoDao.atualizaItemColecao(itemColecao);
		
		return resultado;
		
	}
	
	public Resultado deleteItemColecao(ItemColecao itemColecao){

		Resultado resultado = new Resultado();
		
		resultado = itemColecaoDao.deleteItemColecao(itemColecao);
		
		return resultado;
		
	}
	
	public Resultado deleteItemListaDesejo(ItemColecao itemColecao){
		
		Resultado resultado = new Resultado();
		
		resultado = itemColecaoDao.deleteItemListaDesejo(itemColecao);
		
		return resultado;
		
		
	}
	
	public ItemColecao consultaItemColecaoId(int idItemColecao){
		
		ItemColecao itemColecao = new ItemColecao();
		
		itemColecao = itemColecaoDao.consultaItemColecaoId(idItemColecao);
		
		return itemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoListaIdUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemColecaoListaIdUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemListaDesejoIdUsuario(Pesquisa pesquisa){

		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemListaDesejoIdUsuario(pesquisa);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemListaDesejoGuidUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemListaDesejoGuidUsuario(pesquisa);
		
		return listaItemColecao;
		
	}

	
	public List<ItemColecao> consultaItemColecaoHomeIdUsuario(int idUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemColecaoHomeIdUsuario(idUsuario);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoHomeGuidUsuario(String guidUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemColecaoHomeGuidUsuario(guidUsuario);
		
		return listaItemColecao;
		
	}
	
	public List<ItemColecao> consultaItemColecaoListaGuidUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemColecaoListaGuidUsuario(pesquisa);
		
		return listaItemColecao;
		
	}

	
	public int consultaNumeroPaginaListaDesejoItemIdUsuario(int idUsuario){
		
		int resultado = itemColecaoDao.consultaNumeroPaginaListaDesejoItemIdUsuario(idUsuario);
		
		return resultado;
	}
	
	public int consultaNumeroPaginaListaDesejoItemGuidUsuario(String guidUsuario){
		
		int resultado = itemColecaoDao.consultaNumeroPaginaListaDesejoItemGuidUsuario(guidUsuario);
		
		return resultado;

	}
	
	
	public int consultaNumeroPaginaItemColecaoIdUsuario(int idUsuario){
		
		int resultado = itemColecaoDao.consultaNumeroPaginaItemColecaoIdUsuario(idUsuario);
		
		return resultado;

	}
	
	public int consultaNumeroPaginaItemColecaoGuidUsuario(String guidUsuario){
		
		int resultado = itemColecaoDao.consultaNumeroPaginaItemColecaoGuidUsuario(guidUsuario);
		
		return resultado;
	}
	
	public List<ItemColecao> consultaItemListaDesejoHomeIdUsuario(int idUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		listaItemColecao = itemColecaoDao.consultaItemListaDesejoHomeIdUsuario(idUsuario);
		
		return listaItemColecao;		
	}

	




	public ItemColecaoDao getItemColecaoDao() {
		return itemColecaoDao;
	}


	public void setItemColecaoDao(ItemColecaoDao itemColecaoDao) {
		this.itemColecaoDao = itemColecaoDao;
	}

}
