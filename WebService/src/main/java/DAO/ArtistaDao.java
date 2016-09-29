/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.Artista;
import Bean.ArtistaAuxiliar;
import Bean.EstiloMusical;
import Bean.Pesquisa;
import Bean.Resultado;
import RowMapper.ArtistaFavoritoHomeRowMapper;
import RowMapper.ArtistaFavoritoListaRowMapper;
import RowMapper.ArtistaListaRowMapper;
import RowMapper.ArtistaRowMapper;
import RowMapper.EstiloMusicalRowMapper;
import Util.Utility;

/**
 * @author marcos
 *
 */
public class ArtistaDao {

	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroArtista;
	private StoredProcedure procedureCadastroEstiloMusical;



	public Artista cadastroArtista(Artista artista){



		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();


		parametros.put("prc_nm_artista", artista.getNomeArtista());
		parametros.put("prc_desc_artista", artista.getDescricaoArtista());
		parametros.put("prc_foto_artista", artista.getImagem().getNome()+artista.getImagem().getExtensao());
		parametros.put("prc_membros_artista", artista.getMembrosArtista());
		parametros.put("prc_id_pais_fk", artista.getPais().getIdPais());

		try{
			parametrosOut = procedureCadastroArtista.execute(parametros);

			artista.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
			artista.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
			artista.setIdArtista((int)parametrosOut.get("prc_id_artista"));

			if("0".equals(artista.getResultado().getCode())){

				if(artista.getListaEstiloMusical().size()>0){

					Map<String, Object> parametrosEstilo = new HashMap<String, Object>();


					for (EstiloMusical estiloMusical : artista.getListaEstiloMusical()) {

						parametrosEstilo.clear();
						parametrosEstilo.put("prc_id_artista", artista.getIdArtista());
						parametrosEstilo.put("prc_id_estilo_musical", estiloMusical.getIdEstiloMusical());

						try{

							procedureCadastroEstiloMusical.execute(parametrosEstilo);

						}catch(Exception e ){

							artista.getResultado().setCode("-1");
							artista.getResultado().setMensagem("Erro ao realizar o cadastro.");


						}

					}

				}

			}else{

				artista.getResultado().setCode("-1");
				artista.getResultado().setMensagem("Erro ao realizar o cadastro.");


			}

		}catch(Exception e){

			artista.getResultado().setCode("-1");
			artista.getResultado().setMensagem("Erro ao realizar o cadastro.");

		}

		return artista;

	}

	//metodo que retorna uma lista de no maximo 10 artista de acordo com o parametro de entrada que sera o nome ou um termo parecido com o nome
	//esse metodo sera utilizado pela barra de pesquisa principal
	/*public List <Artista> consultaArtistaNome(Artista artista){

		String sql ="Select  ar.id_artista, ar.nm_artista, ar.desc_artista, ar.foto_artista, ar.membros_artista,"
				+ " pa.nm_pais, pa.bandeira_pais"
				+ " from artista ar, Pais pa"
				+ " where  ar.nm_artista LIKE ?"
				+ " and pa.id_pais = ar.id_pais_fk"
				+ " limit 10";

		Object [] parametros = {"%"+artista.getNomeArtista()+"%"};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaRowMapper());

		if(listaArtista.size() > 0){

			for (Artista artista2 : listaArtista) {

				String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
						+ " from Estilo_Musical es, Estilo_Musical_Artista ea"
						+ " where ea.id_artista_fk = ?"
						+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
						+ " order by es.nm_estilo_musical";

				Object [] parametrosEstiloMusical = {artista2.getIdArtista()};


				List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
				artista2.setListaEstiloMusical(listaEstiloMusical);

			}


		}



		return listaArtista;
	}*/

	//Opercao que retorna o artista para o preenchimento da pagina do mesmo
	public Artista consultaArtistaId(ArtistaAuxiliar artistaAuxiliar){

			String sql ="Select  ar.id_artista, ar.nm_artista, ar.desc_artista, ar.foto_artista, ar.membros_artista, "
					+ "pa.nm_pais, pa.bandeira_pais, "
					+ "(Select AVG(nota_artista) from nota_artista where id_artista_fk = ar.id_artista)as nota_artista, "
					+ "(Select COUNT(nota_artista) from nota_artista where id_artista_fk = ar.id_artista)as quantidade_nota, "
					+ "(Select nota_artista from nota_artista where id_artista_fk = ar.id_artista and id_usuario_fk = ?)as nota_propria, "
					+ "(Select COUNT(*) from Favoritos where id_artista_pk = ar.id_artista)as quantidade_favorito, "
					+ "(Select IF(COUNT(*), true, false) tag from favoritos where id_usuario_pf_pk = ? and id_artista_pk = ar.id_artista)as flag_favorito "
					+ "from artista ar, Pais pa where  ar.id_artista = ? "
					+ "and pa.id_pais = ar.id_pais_fk "
					+ "limit 10";

		Object [] parametros = {artistaAuxiliar.getUsuario().getIdUsuario(),artistaAuxiliar.getUsuario().getIdUsuario(),artistaAuxiliar.getArtista().getIdArtista()};


		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaRowMapper());

		if(listaArtista.size() > 0){


			String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
					+ " from Estilo_Musical es, Estilo_Musical_Artista ea"
					+ " where ea.id_artista_fk = ?"
					+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
					+ " order by es.nm_estilo_musical";

			Object [] parametrosEstiloMusical = {listaArtista.get(0).getIdArtista()};


			List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
			listaArtista.get(0).setListaEstiloMusical(listaEstiloMusical);
		}

		if(listaArtista.size() > 0){
			
			return listaArtista.get(0);
		}else{
			
			return new Artista();
		}
		


		
	}

	//Essa operacao sera utilizada no fluxo de cadastro de item completo
	public List <Artista> consultaArtistaNomeLista(Artista artista){

		String sql ="Select  ar.id_artista, ar.nm_artista, ar.foto_artista,"
				+ " pa.nm_pais, pa.bandeira_pais"
				+ " from artista ar, Pais pa"
				+ " where  ar.nm_artista LIKE ?"
				+ " and pa.id_pais = ar.id_pais_fk"
				+ " limit 10";

		Object [] parametros = {"%"+artista.getNomeArtista()+"%"};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaListaRowMapper());

		if(listaArtista.size() > 0){

			for (Artista artista2 : listaArtista) {

				String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
						+ " from Estilo_Musical es, Estilo_Musical_Artista ea"
						+ " where ea.id_artista_fk = ?"
						+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
						+ " order by es.nm_estilo_musical";

				Object [] parametrosEstiloMusical = {artista2.getIdArtista()};


				List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
				artista2.setListaEstiloMusical(listaEstiloMusical);

			}


		}



		return listaArtista;
	}

	//Essa operacao sera utilizada passando como parametro o id do artista
	public Artista consultaArtistaIdSimples(int idArtista){

		String sql ="Select  ar.id_artista, ar.nm_artista, ar.foto_artista,"
				+ " pa.nm_pais, pa.bandeira_pais"
				+ " from artista ar, Pais pa"
				+ " where  ar.id_artista = ?"
				+ " and pa.id_pais = ar.id_pais_fk"
				+ " limit 10";

		Object [] parametros = {idArtista};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaListaRowMapper());

		if(listaArtista.size() > 0){

			for (Artista artista2 : listaArtista) {

				String sqlEstiloMusical = "Select es.nm_estilo_musical, es.id_estilo_musical"
						+ " from Estilo_Musical es, Estilo_Musical_Artista ea"
						+ " where ea.id_artista_fk = ?"
						+ " and ea.id_estilo_musical_fk = es.id_estilo_musical"
						+ " order by es.nm_estilo_musical";

				Object [] parametrosEstiloMusical = {artista2.getIdArtista()};


				List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sqlEstiloMusical, parametrosEstiloMusical, new EstiloMusicalRowMapper());
				artista2.setListaEstiloMusical(listaEstiloMusical);

			}

			return listaArtista.get(0);
		}



		return new Artista();
	}
	
	//Metodo que insere um artista na lista de favoritos de um determinado usuario
	public Resultado desfavoritarArtista (ArtistaAuxiliar artistaAuxiliar){

		Resultado resultado = new Resultado();
		
		int result = 1;
		
		String query = "select  COUNT(*) from favoritos where id_usuario_pf_pk = ? and id_artista_pk = ? ";
		
		String sql = "DELETE FROM favoritos where id_usuario_pf_pk = ? and id_artista_pk = ? ";

		Object [] parametros = {artistaAuxiliar.getUsuario().getIdUsuario(), artistaAuxiliar.getArtista().getIdArtista()};

		int validaFavorito = jdbcTemplate.queryForInt(query, parametros);
		
		
		if(validaFavorito > 0){
		
			 result = jdbcTemplate.update(sql, parametros);
		}
		
		if(result >0){

			resultado.setCode("0");
			resultado.setMensagem("Artista favoritado com sucesso");
		}else{

			resultado.setCode("-1");
			resultado.setMensagem("Erro ao favoritar o artista");

		}

		return resultado;

	}
	
	

	//Metodo que insere um artista na lista de favoritos de um determinado usuario
	public Resultado favoritarArtista (ArtistaAuxiliar artistaAuxiliar){

		Resultado resultado = new Resultado();
		
		int result = 1;
		
		String query = "select  COUNT(*) from favoritos where id_usuario_pf_pk = ? and id_artista_pk = ? ";
		
		String sql = "Insert into favoritos (id_usuario_pf_pk, id_artista_pk, dt_adicao) values (?, ?, CURDATE())";

		Object [] parametros = {artistaAuxiliar.getUsuario().getIdUsuario(), artistaAuxiliar.getArtista().getIdArtista()};

		int validaFavorito = jdbcTemplate.queryForInt(query, parametros);
		
		
		if(validaFavorito == 0){
		
			 result = jdbcTemplate.update(sql, parametros);
		}
		
		if(result >0){

			resultado.setCode("0");
			resultado.setMensagem("Artista favoritado com sucesso");
		}else{

			resultado.setCode("-1");
			resultado.setMensagem("Erro ao favoritar o artista");

		}

		return resultado;

	}
	

	//metodo que permite um usuario dar nota a um determinado artista
	public Resultado darNotaArtista (ArtistaAuxiliar artistaAuxiliar){

		Resultado resultado = new Resultado();

		String sqlUpdate = "Update Nota_Artista set nota_artista = ? where id_usuario_fk = ? and id_artista_fk = ?";

		Object [] parametros = {artistaAuxiliar.getArtista().getNotaArtista(), artistaAuxiliar.getUsuario().getIdUsuario(), artistaAuxiliar.getArtista().getIdArtista()};

		try{

			int result = jdbcTemplate.update(sqlUpdate, parametros);

			if(result >0){

				resultado.setCode("0");
				resultado.setMensagem("Nota dada com sucesso");
			}else{

				String sqlInsert = "Insert into nota_artista (nota_artista, id_usuario_fk, id_artista_fk) values (?, ?, ?)";
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
	
	public List <Artista> consultaArtistaFavoritoHomeGuid(String guidUsuario){

		String sql ="select ar.nm_artista, ar.foto_artista, ar.id_artista "
				+ "from artista ar, usuario us, favoritos fa "
				+ "where  us.guid_usuario = ? "
				+ "and fa.id_usuario_pf_pk = us.id_usuario "
				+ "and fa.id_artista_pk = ar.id_artista"
				+ " limit 10";

		Object [] parametros = {guidUsuario};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaFavoritoHomeRowMapper());

		return listaArtista;
	}
	

	public List <Artista> consultaArtistaFavoritoHomeId(int idUsuario){

		String sql ="select ar.nm_artista, ar.foto_artista, ar.id_artista "
				+ "from artista ar, usuario us, favoritos fa "
				+ "where  us.id_usuario = ? "
				+ "and fa.id_usuario_pf_pk = us.id_usuario "
				+ "and fa.id_artista_pk = ar.id_artista"
				+ " limit 10";

		Object [] parametros = {idUsuario};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaFavoritoHomeRowMapper());

		return listaArtista;
	}
	
	//Essa operacao retorna os artistas favoritados por um determinado usuario de forma paginada
	//Para identificar o usuario sera usada a seu id
	//Serao retornados sempre 10 artista os quais serao escolhidos de acordo com o numero da pagina enviado
	public List <Artista> consultaArtistaFavoritoIdLista(Pesquisa pesquisa){

		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		String sql ="select ar.id_artista, ar.nm_artista, ar.desc_artista, ar.foto_artista, ar.membros_artista, "
				+ " pa.nm_pais, pa.bandeira_pais "
				+ " from artista ar, usuario us, favoritos fa, pais pa "
				+ " where  us.id_usuario = ? "
				+ " and fa.id_usuario_pf_pk = us.id_usuario "
				+ " and fa.id_artista_pk = ar.id_artista "
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdUsuario(),limiteInicial,limiteFinal};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaFavoritoListaRowMapper());

		return listaArtista;
	}

	
	//Essa operacao retorna os artistas favoritados por um determinado usuario de forma paginada
	//Para identificar o usuario sera usada a sua guid
	//Serao retornados sempre 10 artista os quais serao escolhidos de acordo com o numero da pagina enviado
	public List <Artista> consultaArtistaFavoritoGuidLista(Pesquisa pesquisa){

		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		String sql ="select ar.id_artista, ar.nm_artista, ar.desc_artista, ar.foto_artista, ar.membros_artista, "
				+ " pa.nm_pais, pa.bandeira_pais "
				+ " from artista ar, usuario us, favoritos fa, pais pa "
				+ " where  us.guid_usuario = ? "
				+ " and fa.id_usuario_pf_pk = us.id_usuario "
				+ " and fa.id_artista_pk = ar.id_artista "
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getGuidUsuario(),limiteInicial,limiteFinal};

		List <Artista> listaArtista = jdbcTemplate.query(sql, parametros, new ArtistaFavoritoListaRowMapper());

		return listaArtista;
	}
	
	
	//Essa operacao sera responsavel por retornar a quantidade de paginas que serao necessarias para exibir todos os artistas favoritos
	//Sera utilizado com parametro de entrada o id do usuario
	public int consultaNumeroPaginaFavoritoIdUsuario(int idUsuario){
		
		String sql = "Select (select COUNT(*) from favoritos fa, usuario us "
				+ " where us.id_usuario = ? "
				+ " and fa.id_usuario_pf_pk = us.id_usuario) ";
		
		Object [] parametros = {idUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		double auxiliar = numeroFavorito/10.0;
		
		int numeroPaginas = (int) Math.ceil(auxiliar);
		
		return numeroPaginas;
	}
	
	
	//Essa operacao sera responsavel por retornar a quantidade de paginas que serao necessarias para exibir todos os artistas favoritos
	//Sera utilizado com parametro de entrada o guid do usuario
	public int consultaNumeroPaginaFavoritoGuidUsuario(String guidUsuario){
		
		String sql = "Select (select COUNT(*) from favoritos fa, usuario us "
				+ " where us.guid_usuario = ? "
				+ " and fa.id_usuario_pf_pk = us.id_usuario) ";
		
		Object [] parametros = {guidUsuario};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
	
		
		return Utility.calculoQuantidadePagina(numeroFavorito, 10.0);
	}

	
	
	//Esse metodo é utilizado para atualizar as informaçoes de nota na pagina do artista quando o usuario da uma nota ao artista
	//As informaçoes que serao atualizadas serao a media geral de notas e tambem a quantidade de notas
	public Artista atualizaDadosNotaArtista(int idArtista){
		
		Artista artista = new Artista();
		
		String queryCount = "Select COUNT(nota_artista) from nota_artista where id_artista_fk = ?";
		
		String queryAVG = "Select AVG(nota_artista) as nota_artista from nota_artista where id_artista_fk = ? ";
		
		Object [] parametros = {idArtista};
	
		int  quantidadeNota = jdbcTemplate.queryForInt(queryCount,parametros);
		
		double  notaArtista = jdbcTemplate.queryForObject(queryAVG,parametros,Double.class);
	
		artista.setQuantidadeNota(quantidadeNota);
		artista.setNotaArtista(notaArtista);
		
		return artista;
	
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public StoredProcedure getProcedureCadastroArtista() {
		return procedureCadastroArtista;
	}


	public void setProcedureCadastroArtista(StoredProcedure procedureCadastroArtista) {
		this.procedureCadastroArtista = procedureCadastroArtista;
	}


	public StoredProcedure getProcedureCadastroEstiloMusical() {
		return procedureCadastroEstiloMusical;
	}


	public void setProcedureCadastroEstiloMusical(StoredProcedure procedureCadastroEstiloMusical) {
		this.procedureCadastroEstiloMusical = procedureCadastroEstiloMusical;
	}	




}
