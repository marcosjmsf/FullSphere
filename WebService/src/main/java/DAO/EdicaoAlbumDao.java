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

import Bean.AlbumAuxiliar;
import Bean.EdicaoAlbum;
import RowMapper.EdicaoAlbumListaRowMapper;
import RowMapper.EdicaoAlbumRowMapper;

/**
 * @author marcos
 *
 */
public class EdicaoAlbumDao {

	private JdbcTemplate jdbcTemplate;
	private StoredProcedure procedureCadastroEdicaoAlbum;

	public EdicaoAlbum cadastroEdicaoAlbum(EdicaoAlbum edicaoAlbum){


		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();


		parametros.put("prc_nm_edicao_album", edicaoAlbum.getNomeEdicaoAlbum());
		parametros.put("prc_data_lancamento_edicao_album", edicaoAlbum.getDataLancamentoEdicaoAlbum());
		parametros.put("prc_observacao_edicao_album", edicaoAlbum.getObservacaoEdicaoAlbum());
		parametros.put("prc_setList_edicao_album", edicaoAlbum.getSetListEdicaoAlbum());
		parametros.put("prc_capa_edicao_album", edicaoAlbum.getImagem().getNome()+edicaoAlbum.getImagem().getExtensao());
		parametros.put("prc_id_pais_fk", edicaoAlbum.getPais().getIdPais());
		parametros.put("prc_id_gravadora_fk", edicaoAlbum.getGravadora().getIdGravadora());
		parametros.put("prc_id_album_fk", edicaoAlbum.getAlbum().getIdAlbum());
		parametros.put("prc_id_tipo_midia_fk", edicaoAlbum.getTipoMidia().getIdTipoMidia());

		try{


			parametrosOut = procedureCadastroEdicaoAlbum.execute(parametros);

			edicaoAlbum.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
			edicaoAlbum.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
			edicaoAlbum.setIdEdicaoAlbum((int)parametrosOut.get("prc_id_edicao_album"));

		}catch(Exception e){

			edicaoAlbum.getResultado().setCode("-1");
			edicaoAlbum.getResultado().setMensagem("Erro ao cadastrar a Edição do album.");	
		}


		return edicaoAlbum;
	}

	
	public List<EdicaoAlbum> consultaEdicaoAlbumListaIdAlbum(int idAlbum){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		String sql = "Select ea.id_edicao_album, ea.data_lancamento_edicao_album, ea.nm_edicao_album, ea.capa_edicao_album, "
				+ " pa.nm_pais, pa.bandeira_pais, "
				+ " gr.nm_gravadora,"
				+ " tm.nm_tipo_midia"
				+ " from Edicao_Album ea, Pais pa, Gravadora gr, Tipo_Midia tm"
				+ " where ea.id_album_fk = ? "
				+ " and pa.id_pais = ea.id_pais_fk "
				+ " and gr.id_gravadora = ea.id_gravadora_fk "
				+ " and tm.id_tipo_midia = ea.id_tipo_midia_fk";
		
		Object [] parametros = {idAlbum};

		listaEdicaoAlbum = jdbcTemplate.query(sql, parametros, new EdicaoAlbumListaRowMapper());
		
		
		return listaEdicaoAlbum;
		
	}
	
	public List<EdicaoAlbum> consultaEdicaoAlbumIdAlbum(AlbumAuxiliar albumAuxiliar){
		
		List<EdicaoAlbum> listaEdicaoAlbum = new ArrayList<EdicaoAlbum>();
		
		String sql = "Select ea.id_edicao_album, ea.data_lancamento_edicao_album, ea.nm_edicao_album, ea.capa_edicao_album, "
				+ " pa.nm_pais, pa.bandeira_pais, "
				+ " gr.nm_gravadora,"
				+ " tm.nm_tipo_midia"
				+ "	(Select IF(COUNT(*), true, false) tag from Item_Colecao where id_edicao_album_fk = ea.id_edicao_album and id_usuario_pk = ?) as flag_possui,"
				+ "	(Select IF(COUNT(*), true, false) tag from Lista_Desejo_Item where id_edicao_album_fk = ea.id_edicao_album and id_usuario_pf_fk = ?) as flag_deseja"
				+ " from Edicao_Album ea, Pais pa, Gravadora gr, Tipo_Midia tm"
				+ " where ea.id_album_fk = ? "
				+ " and pa.id_pais = ea.id_pais_fk "
				+ " and gr.id_gravadora = ea.id_gravadora_fk "
				+ " and tm.id_tipo_midia = ea.id_tipo_midia_fk";
		
		Object [] parametros = {albumAuxiliar.getUsuario().getIdUsuario(), albumAuxiliar.getAlbum().getIdAlbum()};

		listaEdicaoAlbum = jdbcTemplate.query(sql, parametros, new EdicaoAlbumRowMapper());
		
		
		return listaEdicaoAlbum;
		
	}

	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public StoredProcedure getProcedureCadastroEdicaoAlbum() {
		return procedureCadastroEdicaoAlbum;
	}


	public void setProcedureCadastroEdicaoAlbum(StoredProcedure procedureCadastroEdicaoAlbum) {
		this.procedureCadastroEdicaoAlbum = procedureCadastroEdicaoAlbum;
	}


}
