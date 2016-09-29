/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.ArtistaItemLista;
import Bean.ListaArtista;

/**
 * @author marcos
 *
 */
public class ListaArtistaDao {
	
	private JdbcTemplate jdbcTemplate;
	private StoredProcedure procedureCadastroListaArtista;
	
	//Vai ser necessario criar um insert para cadastrar os dados referente a lista
	//Necessario que esse primeiro insert ocorra via proc, sera necessario o id da lista
	//E tambem um loop para cadastrar todos os itens da lista utilizando o id retornado pela proc anterior
	
	public ListaArtista cadastroListaArtista(ListaArtista listaArtista){
		
		ListaArtista listaArtistaResposta = new ListaArtista();
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		String sql = "INSERT into item_lista_artista (ordem_item_lista_artista,desc_lista_artista,id_artista_fk,id_lista_artista_fk)"
				+ "VALUES(?,?,?,?)";

		
		parametros.put("prc_titulo_lista_artista", listaArtista.getNomeLista());
		parametros.put("prc_desc_lista_artista", listaArtista.getDescricaoListaArtista());
		parametros.put("prc_lista_artista_ordenada", listaArtista.getFlagOrdenacao());
		parametros.put("prc_id_usuario_fk", listaArtista.getDataCriacaoLista());
		
		parametrosOut = procedureCadastroListaArtista.execute(parametros);
		
		listaArtistaResposta.setIdListaArtista((int)parametrosOut.get("prc_id_lista"));
		
		for (ArtistaItemLista itemArtista : listaArtista.getListaArtista()) {
		
			Object [] parametrosItem = {itemArtista.getOrdenacao(),itemArtista.getDescricaoItemLista(),itemArtista.getArtista().getIdArtista(),
					listaArtistaResposta.getIdListaArtista()};
			
			int result = jdbcTemplate.update(sql, parametrosItem);
		}

		
		return listaArtista;
	}
	
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	public StoredProcedure getProcedureCadastroListaArtista() {
		return procedureCadastroListaArtista;
	}




	public void setProcedureCadastroListaArtista(StoredProcedure procedureCadastroListaArtista) {
		this.procedureCadastroListaArtista = procedureCadastroListaArtista;
	}

	
	

}
