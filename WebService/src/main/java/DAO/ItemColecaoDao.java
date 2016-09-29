/**
 * 
 */
package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.ItemColecao;
import Bean.Pesquisa;
import Bean.Resultado;
import RowMapper.ItemColecaoHomeRowMapper;
import RowMapper.ItemColecaoListaRowMapper;
import RowMapper.ItemColecaoRowMapper;
import RowMapper.ItemListaDesejoRowMapper;
import Util.Utility;

/**
 * @author marcos
 *
 */
public class ItemColecaoDao {
	
	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroItemColecao;

	public ItemColecao cadastroItemColecao (ItemColecao itemColecao){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_obs_item", itemColecao.getObservacaoItem());
		parametros.put("prc_id_estima_item_fk", itemColecao.getEstimaItem().getIdEstimaItem());
		parametros.put("prc_id_edicao_album_fk", itemColecao.getEdicaoAlbum().getIdEdicaoAlbum());
		parametros.put("prc_id_usuario_pk", itemColecao.getUsuario().getIdUsuario());
		parametros.put("prc_dt_adicao_item", itemColecao.getDataAdicaoItem());
		parametros.put("prc_quantidade_item", itemColecao.getQuantidadeItem());
		parametros.put("prc_estado_item_caixa", itemColecao.getEstadoCaixa());
		parametros.put("prc_estado_item_midia", itemColecao.getEstadoMidia());
		parametros.put("prc_estado_item_encarte", itemColecao.getEstadoEncarte());
		
		parametrosOut = procedureCadastroItemColecao.execute(parametros);
		
		itemColecao = new ItemColecao();
		
		itemColecao.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
		itemColecao.setIdItemColecao((int)parametrosOut.get("prc_id_item_colecao"));
		itemColecao.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return itemColecao;
	}

	
	public Resultado cadastroItemListaDesejo (ItemColecao itemColecao){

		Resultado resultado =  new Resultado();
		String sql = "Insert into Lista_Desejo_Item (id_edicao_album_fk, id_usuario_pf_fk, dt_adicao) values (?,?,CURDATE())";
		
		Object [] parametros = {itemColecao.getEdicaoAlbum().getIdEdicaoAlbum(),itemColecao.getUsuario().getIdUsuario()};

		
		int result = jdbcTemplate.update(sql, parametros);
	
		if(result > 0){
			resultado.setCode("0");
			resultado.setMensagem("Item adicionado com sucesso");
			
		}else{
			
			resultado.setCode("0");
			resultado.setMensagem("Erro ao adicionar item");
			
		}
		
		return resultado;
			
			
	}
	

	public Resultado atualizaItemColecao(ItemColecao itemColecao){
		
		String sql = "UPDATE Item_Colecao SET obs_item = ?, id_estima_item_fk = ?,"
				+ " quantidade_item = ?, estado_item_caixa = ?, estado_item_midia = ?, estado_item_encarte = ?"
				+ " WHERE id_item_colecao = ?";
		
		Object [] parametros = {itemColecao.getObservacaoItem(),
				itemColecao.getEstimaItem().getIdEstimaItem(),
				itemColecao.getQuantidadeItem(),
				itemColecao.getEstadoCaixa(),
				itemColecao.getEstadoMidia(),
				itemColecao.getEstadoEncarte(),
				itemColecao.getIdItemColecao()};

		
		int result = jdbcTemplate.update(sql, parametros);
		
		Resultado resultado =  new Resultado();
		
		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Item atualizado com sucesso");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Não foi possivel atualizar o item");
			
		}
		
		return resultado;
		
		
	}
	
	public Resultado deleteItemColecao(ItemColecao itemColecao){
		
		String sql = "DELETE FROM Item_Colecao WHERE id_item_colecao = ?";
		
		Object [] parametros = {itemColecao.getIdItemColecao()};

		int result = jdbcTemplate.update(sql, parametros);
		
		Resultado resultado =  new Resultado();
		
		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Item deletado com sucesso");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Não foi possivel deletar o item");
			
		}
		
		return resultado;
		
		
	}
	
	public Resultado deleteItemListaDesejo(ItemColecao itemColecao){
		
		String sql = "delete from Lista_Desejo_Item where id_edicao_album_fk = ? and id_usuario_pf_fk = ?";
		
		Object [] parametros = {itemColecao.getEdicaoAlbum().getIdEdicaoAlbum(),itemColecao.getUsuario().getIdUsuario()};

		int result = jdbcTemplate.update(sql, parametros);
		
		Resultado resultado =  new Resultado();
		
		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Item deletado com sucesso");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Não foi possivel deletar o item");
			
		}
		
		return resultado;
		
		
	}
	

	//Exibira todos os dados de um item especifico, sera usado como parametro o id do item da colecao
	public ItemColecao consultaItemColecaoId(int idItemColecao){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		String sql ="Select ic.id_item_colecao, ic.obs_item, ic.quantidade_item, ic.estado_item_caixa, ic.estado_item_midia, ic.estado_item_encarte,"
				+ "ei.id_estima_item,ei.desc_estima_item,"
				+ "tm.nm_tipo_midia,"
				+ "ea.nm_edicao_album, ea.data_lancamento_edicao_album, ea.capa_edicao_album,"
				+ "pa.nm_pais, pa.bandeira_pais,"
				+ "gr.nm_gravadora,"
				+ "ar.nm_artista,"
				+ "al.nm_album"
				+ " from Item_Colecao ic, Estima_Item ei, Tipo_Midia tm, Edicao_Album ea, Pais pa,"
				+ " Gravadora gr, Artista ar, Album al"
				+ " where ic.id_item_colecao = ?"
				+ " and ic.id_estima_item_fk = ei.id_estima_item"
				+ " and ic.id_edicao_album_fk = ea.id_edicao_album"
				+ " and ea.id_pais_fk = pa.id_pais"
				+ " and ea.id_gravadora_fk = gr.id_gravadora"
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia"
				+ " and ea.id_album_fk = al.id_album"
				+ " and al.id_artista_fk = ar.id_artista" ;
		
		Object [] parametros = {idItemColecao};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoRowMapper());
		
		ItemColecao itemColecao =  new ItemColecao();
		
		if(listaItemColecao.size() > 0){
			
			itemColecao = listaItemColecao.get(0);
		}
		
		return itemColecao;
		
	}

	//Opercao paginada, esse metodo retornara os itens de uma colecao de usuario limitando seu retorno a 10 itens por chamada
	//Os 10 itens que serao retornados serao decididos de acordo com o numero da pagina enviada
	public List<ItemColecao> consultaItemColecaoListaIdUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		
		String sql ="Select ic.id_item_colecao,"
				+ "ei.desc_estima_item,"
				+ "tm.nm_tipo_midia,"
				+ "ea.nm_edicao_album, ea.data_lancamento_edicao_album, ea.capa_edicao_album,"
				+ "pa.nm_pais, pa.bandeira_pais,"
				+ "gr.nm_gravadora,"
				+ "ar.nm_artista,"
				+ "al.nm_album"
				+ " from Item_Colecao ic, Estima_Item ei, Tipo_Midia tm, Edicao_Album ea, Pais pa,"
				+ " Gravadora gr, Artista ar, Album al"
				+ " where ic.id_usuario_pk = ?"
				+ " and ic.id_estima_item_fk = ei.id_estima_item"
				+ " and ic.id_edicao_album_fk = ea.id_edicao_album"
				+ " and ea.id_pais_fk = pa.id_pais"
				+ " and ea.id_gravadora_fk = gr.id_gravadora"
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia"
				+ " and ea.id_album_fk = al.id_album"
				+ " and al.id_artista_fk = ar.id_artista"
				+ "	LIMIT ?,?" ;
		
		Object [] parametros = {pesquisa.getIdUsuario(),limiteInicial, limiteFinal};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoListaRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	//Opercao paginada, esse metodo retornara os itens de uma colecao de usuario limitando seu retorno a 10 itens por chamada
	//Os 10 itens que serao retornados serao decididos de acordo com o numero da pagina enviada
	public List<ItemColecao> consultaItemColecaoListaGuidUsuario(Pesquisa pesquisa){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		
		String sql ="Select ic.id_item_colecao,"
				+ "ei.desc_estima_item,"
				+ "tm.nm_tipo_midia,"
				+ "ea.nm_edicao_album, ea.data_lancamento_edicao_album, ea.capa_edicao_album,"
				+ "pa.nm_pais, pa.bandeira_pais,"
				+ "gr.nm_gravadora,"
				+ "ar.nm_artista,"
				+ "al.nm_album"
				+ " from Item_Colecao ic, Estima_Item ei, Tipo_Midia tm, Edicao_Album ea, Pais pa,"
				+ " Gravadora gr, Artista ar, Album al, Usuario us"
				+ " where us.guid_usuario = ? "
				+ "	and ic.id_usuario_pk = us.id_usuario "
				+ " and ic.id_estima_item_fk = ei.id_estima_item"
				+ " and ic.id_edicao_album_fk = ea.id_edicao_album"
				+ " and ea.id_pais_fk = pa.id_pais"
				+ " and ea.id_gravadora_fk = gr.id_gravadora"
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia"
				+ " and ea.id_album_fk = al.id_album"
				+ " and al.id_artista_fk = ar.id_artista"
				+ "	LIMIT ?,?" ;
		
		Object [] parametros = {pesquisa.getGuidUsuario(),limiteInicial, limiteFinal};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoListaRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	
	
	//Opercao paginada, esse metodo retornara os itens de uma lista de desejo de usuario limitando seu retorno a 10 itens por chamada
	//Os 10 itens que serao retornados serao decididos de acordo com o numero da pagina enviada	
	public List<ItemColecao> consultaItemListaDesejoIdUsuario(Pesquisa pesquisa){
	
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		String sql ="Select id.id_edicao_album_fk, id.dt_adicao,"
				+ "tm.nm_tipo_midia,"
				+ "ea.nm_edicao_album, ea.data_lancamento_edicao_album, ea.capa_edicao_album,"
				+ "pa.nm_pais, pa.bandeira_pais,"
				+ "gr.nm_gravadora,"
				+ "ar.nm_artista,"
				+ "al.nm_album"
				+ " from Lista_Desejo_Item id, Tipo_Midia tm, Edicao_Album ea, Pais pa,"
				+ " Gravadora gr, Artista ar, Album al "
				+ " where id.id_usuario_pf_fk = ? "
				+ " and id.id_edicao_album_fk = ea.id_edicao_album "
				+ " and ea.id_pais_fk = pa.id_pais "
				+ " and ea.id_gravadora_fk = gr.id_gravadora "
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia "
				+ " and ea.id_album_fk = al.id_album "
				+ " and al.id_artista_fk = ar.id_artista"
				+ " limit ?,?" ;
		
		Object [] parametros = {pesquisa.getIdUsuario(),limiteInicial,limiteFinal};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemListaDesejoRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	//Opercao paginada, esse metodo retornara os itens de uma lista de desejo de usuario limitando seu retorno a 10 itens por chamada
	//Os 10 itens que serao retornados serao decididos de acordo com o numero da pagina enviada	
	public List<ItemColecao> consultaItemListaDesejoGuidUsuario(Pesquisa pesquisa){
	
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		String sql ="Select id.id_edicao_album_fk, id.dt_adicao,"
				+ "tm.nm_tipo_midia,"
				+ "ea.nm_edicao_album, ea.data_lancamento_edicao_album, ea.capa_edicao_album,"
				+ "pa.nm_pais, pa.bandeira_pais,"
				+ "gr.nm_gravadora,"
				+ "ar.nm_artista,"
				+ "al.nm_album"
				+ " from Lista_Desejo_Item id, Tipo_Midia tm, Edicao_Album ea, Pais pa,"
				+ " Gravadora gr, Artista ar, Album al, Usuario us"
				+ " where us.guid_usuario = ?"
				+ " and id.id_usuario_pf_fk = us.id_usuario "
				+ " and id.id_edicao_album_fk = ea.id_edicao_album "
				+ " and ea.id_pais_fk = pa.id_pais "
				+ " and ea.id_gravadora_fk = gr.id_gravadora "
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia "
				+ " and ea.id_album_fk = al.id_album "
				+ " and al.id_artista_fk = ar.id_artista"
				+ " limit ?,?" ;
		
		Object [] parametros = {pesquisa.getGuidUsuario(),limiteInicial,limiteFinal};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemListaDesejoRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	//Operacao para retornar os itens da colecao do usuario na pagina inicial ou de perfil usando como parametro a guid do usuario
	public List<ItemColecao> consultaItemColecaoHomeGuidUsuario(String guidUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		String sql ="select ea.id_edicao_album, ea.nm_edicao_album, ea.capa_edicao_album, "
				+ "tm.nm_tipo_midia, "
				+ "ar.nm_artista, "
				+ "al.nm_album "
				+ "from Edicao_Album ea, Item_Colecao ic, Usuario us, Tipo_Midia tm, "
				+ "Album al, Artista ar "
				+ "	where us.guid_usuario = ?"
				+ " and ic.id_usuario_pk = us.id_usuario "
				+ "and ic.id_edicao_album_fk = ea.id_edicao_album "
				+ "and ea.id_tipo_midia_fk = tm.id_tipo_midia "
				+ "and al.id_album = ea.id_album_fk "
				+ "and ar.id_artista = al.id_artista_fk "
				+ "limit 4" ;

		Object [] parametros = {guidUsuario};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoHomeRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	//Operacao para retornar os itens da colecao do usuario na pagina inicial ou de perfil usando como parametroo id do usuario
	public List<ItemColecao> consultaItemColecaoHomeIdUsuario(int idUsuario){
		
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		String sql ="select ea.id_edicao_album, ea.nm_edicao_album, ea.capa_edicao_album, "
				+ "tm.nm_tipo_midia, "
				+ "ar.nm_artista, "
				+ "al.nm_album "
				+ "from Edicao_Album ea, Item_Colecao ic, Usuario us, Tipo_Midia tm, "
				+ "Album al, Artista ar "
				+ "where us.id_usuario = ? "
				+ "and ic.id_usuario_pk = us.id_usuario "
				+ "and ic.id_edicao_album_fk = ea.id_edicao_album "
				+ "and ea.id_tipo_midia_fk = tm.id_tipo_midia "
				+ "and al.id_album = ea.id_album_fk "
				+ "and ar.id_artista = al.id_artista_fk "
				+ "limit 4" ;

		Object [] parametros = {idUsuario};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoHomeRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	//Essa opercao sera responsavel por retornar a quantidade de paginas na exibicao de todos os itens da lista de desejo
	//o parametro de entrada sera o id do usuario
	public int consultaNumeroPaginaListaDesejoItemIdUsuario(int idUsuario){
		
		String sql = "Select (select COUNT(*) from lista_desejo_item ld, usuario us"
				+ "	where us.id_usuario = ? "
				+ " and ld.id_usuario_pf_fk = us.id_usuario)";
		
		Object [] parametros = {idUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		
		return Utility.calculoQuantidadePagina(numeroFavorito, 10.0);
	}

	
	//Essa opercao sera responsavel por retornar a quantidade de paginas na exibicao de todos os itens da lista de desejo
	//o parametro de entrada sera a guid do usuario
	public int consultaNumeroPaginaListaDesejoItemGuidUsuario(String guidUsuario){
		
		String sql = "Select (select COUNT(*) from lista_desejo_item ld, usuario us"
				+ "	where us.guid_usuario = ? "
				+ " and ld.id_usuario_pf_fk = us.id_usuario)";
		
		Object [] parametros = {guidUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		
		return Utility.calculoQuantidadePagina(numeroFavorito, 10.0);
	}
	

	//Essa opercao sera responsavel por retornar a quantidade de paginas na exibicao de todos os itens da colecao
	//o parametro de entrada sera o id do usuario
	public int consultaNumeroPaginaItemColecaoIdUsuario(int idUsuario){
		
		String sql = "Select (select COUNT(*) from item_colecao ic, usuario us "
				+ " where us.id_usuario = ? "
				+ "and ic.id_usuario_pk = us.id_usuario)";
		
		Object [] parametros = {idUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		
		return Utility.calculoQuantidadePagina(numeroFavorito, 10.0);
	}
	
	//Essa opercao sera responsavel por retornar a quantidade de paginas na exibicao de todos os itens da colecao
	//o parametro de entrada sera a guid do usuario
	public int consultaNumeroPaginaItemColecaoGuidUsuario(String guidUsuario){
		
		String sql = "Select (select COUNT(*) from item_colecao ic, usuario us "
				+ " where us.guid_usuario = ? "
				+ "and ic.id_usuario_pk = us.id_usuario)";
		
		Object [] parametros = {guidUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		
		return Utility.calculoQuantidadePagina(numeroFavorito, 10.0);
	}
	
	
	//Opercao paginada, esse metodo retornara os itens de uma lista de desejo de usuario que apareceram na home
	public List<ItemColecao> consultaItemListaDesejoHomeIdUsuario(int idUsuario){
	
		List<ItemColecao> listaItemColecao = new ArrayList<ItemColecao>();
		
		String sql ="select ea.id_edicao_album,"
				+ "	tm.nm_tipo_midia, "
				+ " ea.nm_edicao_album, ea.capa_edicao_album, "
				+ " ar.nm_artista, "
				+ " al.nm_album "
				+ " from Lista_Desejo_Item id, Tipo_Midia tm, Edicao_Album ea, "
				+ " Artista ar, Album al, Usuario us "
				+ " where us.id_usuario = ? "
				+ " and id.id_usuario_pf_fk = us.id_usuario "
				+ " and id.id_edicao_album_fk = ea.id_edicao_album "
				+ " and ea.id_tipo_midia_fk = tm.id_tipo_midia "
				+ " and ea.id_album_fk = al.id_album "
				+ " and al.id_artista_fk = ar.id_artista "
				+ " limit 4 ;" ;
		
		Object [] parametros = {idUsuario};

		listaItemColecao = jdbcTemplate.query(sql, parametros, new ItemColecaoHomeRowMapper());
		
		
		return listaItemColecao;
		
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StoredProcedure getProcedureCadastroItemColecao() {
		return procedureCadastroItemColecao;
	}

	public void setProcedureCadastroItemColecao(StoredProcedure procedureCadastroItemColecao) {
		this.procedureCadastroItemColecao = procedureCadastroItemColecao;
	}
	
	
	
	
	
	
}
