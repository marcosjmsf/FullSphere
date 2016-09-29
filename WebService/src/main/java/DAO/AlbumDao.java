/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.Album;
import Bean.AlbumAuxiliar;
import Bean.Artista;
import Bean.EstiloMusical;
import Bean.Resultado;
import RowMapper.AlbumDiscografiaArtistaRowMapper;
import RowMapper.AlbumListaRowMapper;
import RowMapper.AlbumPaginaRowMapper;
import RowMapper.AlbumRowMapper;
import RowMapper.EstiloMusicalRowMapper;

/**
 * @author marcos
 *
 */
public class AlbumDao {
	
	
	private JdbcTemplate jdbcTemplate;
	private StoredProcedure procedureCadastroAlbum;
	private StoredProcedure procedureCadastroEstiloMusicalAlbum;
	
	
	public Album cadastroAlbum(Album album){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		
		parametros.put("prc_nm_album", album.getNomeAlbum());
		parametros.put("prc_foto_album", album.getImagem().getNome()+album.getImagem().getExtensao());
		parametros.put("prc_desc_album", album.getDescricaoAlbum());
		parametros.put("prc_ano_lancamento", album.getAnoLancamento());
		parametros.put("prc_membros_album", album.getMembrosAlbum());
		parametros.put("prc_setList_album", album.getSetListAlbum());
		parametros.put("prc_id_artista_fk", album.getArtista().getIdArtista());

		parametrosOut = procedureCadastroAlbum.execute(parametros);
		
		album.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
		album.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
		album.setIdAlbum((int)parametrosOut.get("prc_id_album"));
		
		
		if("0".equals(album.getResultado().getCode())){
	
			if(album.getListaEstiloMusical().size()>0){

				Map<String, Object> parametrosEstilo = new HashMap<String, Object>();
				
				for (EstiloMusical estiloMusical : album.getListaEstiloMusical()) {

					parametrosEstilo.clear();
					parametrosEstilo.put("prc_id_album", album.getIdAlbum());
					parametrosEstilo.put("prc_id_estilo_musical", estiloMusical.getIdEstiloMusical());
					
					procedureCadastroEstiloMusicalAlbum.execute(parametrosEstilo);
					
				}

			}
			
		}
		
		return album;
	}
	
	//Essa opercacao vai ser utilizada quando o usuario fizer uma busca pela bara de pesquisa principal
	public List <Album> consultaAlbumNome(Album album){

		String sql ="  Select al.id_album, al.nm_album, al.foto_album, al.desc_album, al.ano_lancamento, al.membros_album, al.setList_album, al.id_artista_fk, "
				+ " ar.nm_artista "
				+ " from album al, artista ar"
				+ " where al.nm_album like ? "
				+ " and al.id_artista_fk = ar.id_artista"
				+ " limit 10";

		Object [] parametros = {"%"+album.getNomeAlbum()+"%"};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumRowMapper());

		if(listaAlbum.size() > 0){

			for (Album album2 : listaAlbum) {

				String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
						+ " from Estilo_Musical es, Estilo_Musical_Album ea"
						+ " where ea.id_album_fk = ?"
						+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
						+ " order by es.nm_estilo_musical";

				Object [] parametrosEstiloMusical = {album2.getIdAlbum()};


				List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
				album2.setListaEstiloMusical(listaEstiloMusical);

			}


		}



		return listaAlbum;
	}
	
	//Essa opercao retorna um album para ser exibido na pagina de album
	public Album consultaAlbumId(AlbumAuxiliar albumAuxiliar){

		String sql =" Select al.id_album, al.nm_album, al.foto_album, al.desc_album, al.ano_lancamento, al.membros_album, al.setList_album, al.id_artista_fk,"
				+ " ar.nm_artista,"
				+ " (Select AVG(Nota_Album) from Nota_Album where id_album_fk = al.id_album)as nota_Album,"
				+ " (Select COUNT(Nota_Album) from Nota_Album where id_album_fk = al.id_album)as quantidade_nota,"
				+ " (Select Nota_Album from Nota_Album where id_album_fk = al.id_album and id_usuario_pf_pk = ?) as nota_propria "
				+ " from album al, artista ar"
				+ " where al.id_album = ?"
				+ " and al.id_artista_fk = ar.id_artista";

		Object [] parametros = {albumAuxiliar.getUsuario().getIdUsuario(), albumAuxiliar.getAlbum().getIdAlbum()};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumPaginaRowMapper());

		if(listaAlbum.size() > 0){

			for (Album album2 : listaAlbum) {

				String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
						+ " from Estilo_Musical es, Estilo_Musical_Album ea"
						+ " where ea.id_album_fk = ?"
						+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
						+ " order by es.nm_estilo_musical";

				Object [] parametrosEstiloMusical = {album2.getIdAlbum()};


				List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
				album2.setListaEstiloMusical(listaEstiloMusical);

			}


		}
		
		if(listaAlbum.size()>0){
			
			return listaAlbum.get(0); 
		}else{
			
			return new Album();
		}
		
	}
	
	
	//Operacao utilizada no fluxo completo de cadastro de um item para a colecao 
	public List <Album> consultaAlbumNomeLista(Album album){

		String sql ="  Select al.id_album, al.nm_album, al.foto_album, al.ano_lancamento,"
				+ " ar.nm_artista"
				+ " from album al, artista ar"
				+ " where al.nm_album like ? "
				+ " and al.id_artista_fk = ar.id_artista";

		Object [] parametros = {"%"+album.getNomeAlbum()+"%"};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumListaRowMapper());

		return listaAlbum;
	}

	public List <Album> consultaAlbumIdLista(int idArtista){

		String sql ="  Select al.id_album, al.nm_album, al.foto_album, al.ano_lancamento,"
				+ " ar.nm_artista"
				+ " from album al, artista ar"
				+ " where al.id_artista_fk = ?"
				+ " and al.id_artista_fk = ar.id_artista";
		Object [] parametros = {idArtista};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumListaRowMapper());

		return listaAlbum;
	}
	
	public Resultado darNotaAlbum (AlbumAuxiliar albumAuxiliar){

		Resultado resultado = new Resultado();

		String sqlUpdate = "Update Nota_Album set nota_album = ? where id_usuario_pf_pk = ? and id_album_fk = ?";

		Object [] parametros = {albumAuxiliar.getAlbum().getNotaAlbum(), albumAuxiliar.getUsuario().getIdUsuario(), albumAuxiliar.getAlbum().getIdAlbum()};

		try{

			int result = jdbcTemplate.update(sqlUpdate, parametros);

			if(result >0){

				resultado.setCode("0");
				resultado.setMensagem("Nota dada com sucesso");
			}else{

				String sqlInsert = "Insert into Nota_Album (nota_album, id_usuario_pf_pk, id_album_fk) values (?, ?, ?)";
				try{
					result = jdbcTemplate.update(sqlInsert, parametros);

					if(result > 0){
						resultado.setCode("0");
						resultado.setMensagem("Nota dada com sucesso");
					}else{

						resultado.setCode("-1");
						resultado.setMensagem("Erro ao dar nota");

					}
				}catch(Exception e){
					resultado.setCode("-1");
					resultado.setMensagem("Erro ao dar nota");
				}

			}

		}catch(Exception e){

			resultado.setCode("-1");
			resultado.setMensagem("Erro ao dar nota");

		}
		return resultado;

	}

	
	//Essa opercao retorna a discografia de um determinado artista para ser exibida na pagina do artista
	public List<Album> consultaAlbumIdArtistaDiscografia(int idArtista){

		String sql =" Select al.id_album, al.nm_album, al.foto_album, al.ano_lancamento,"
				+ " (Select AVG(Nota_Album) from Nota_Album where id_album_fk = al.id_album)as nota_Album,"
				+ " (Select COUNT(Nota_Album) from Nota_Album where id_album_fk = al.id_album)as quantidade_nota"
				+ " from album al, artista ar"
				+ " where al.id_artista_fk = ?"
				+ " and al.id_artista_fk = ar.id_artista";
		
		
		Object [] parametros = {idArtista};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumDiscografiaArtistaRowMapper());

		
		return listaAlbum;
	}
	
	
	//Esse metodo é utilizado para atualizar as informaçoes de nota na pagina do album quando o usuario da uma nota ao album
	//As informaçoes que serao atualizadas serao a media geral de notas e tambem a quantidade de notas
	public Album atualizaDadosNotaAlbum(int idAlbum){
		
		Album album = new Album();
		
		String queryCount = "Select COUNT(nota_album) from nota_album where id_album_fk = ?";
		
		String queryAVG = "Select AVG(nota_album) as nota_album from nota_album where id_album_fk = ? ";
		
		Object [] parametros = {idAlbum};
	
		int  quantidadeNota = jdbcTemplate.queryForInt(queryCount,parametros);
		
		double  notaAlbum = jdbcTemplate.queryForObject(queryAVG,parametros,Double.class);
	
		album.setQuantidadeNota(quantidadeNota);
		album.setNotaAlbum(notaAlbum);
		
		return album;
	
	}
	
	//Operacao utilizada para consultar album de um determinado artista pelo nome
	public List <Album> consultaAlbumNomeIdLista(Album album){

		String sql ="  Select al.id_album, al.nm_album, al.foto_album, al.ano_lancamento,"
				+ " ar.nm_artista"
				+ " from album al, artista ar"
				+ " where al.nm_album like ? "
				+ " and al.id_artista_fk = ? "
				+ " and al.id_artista_fk = ar.id_artista";

		Object [] parametros = {"%"+album.getNomeAlbum()+"%",album.getArtista().getIdArtista()};

		List <Album> listaAlbum = jdbcTemplate.query(sql, parametros, new AlbumListaRowMapper());

		return listaAlbum;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public StoredProcedure getProcedureCadastroAlbum() {
		return procedureCadastroAlbum;
	}


	public void setProcedureCadastroAlbum(StoredProcedure procedureCadastroAlbum) {
		this.procedureCadastroAlbum = procedureCadastroAlbum;
	}


	public StoredProcedure getProcedureCadastroEstiloMusicalAlbum() {
		return procedureCadastroEstiloMusicalAlbum;
	}


	public void setProcedureCadastroEstiloMusicalAlbum(StoredProcedure procedureCadastroEstiloMusicalAlbum) {
		this.procedureCadastroEstiloMusicalAlbum = procedureCadastroEstiloMusicalAlbum;
	}


	
	
	
	

}
