/**
 * 
 */
package DAO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.ConfiguracaoPaginaUsuario;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaFisica;
import RowMapper.UsuarioFisicoHomeIdRowMapper;
import RowMapper.UsuarioPessoaFisicaListaRowMapper;
import RowMapper.UsuarioPessoaFisicaPageRowMapper;
import RowMapper.UsuarioPessoaFisicaPaginadoRowMapper;
import RowMapper.UsuarioPessoaFisicaRowMapper;


/**
 * @author marcos
 *
 */
public class UsuarioFisicoDao {

	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroUsuarioPessoaFisica;
	private StoredProcedure procedureUpdateUsuarioPessoaFisica;
	private StoredProcedure procedureConfiguracaoPaginaUsuario;

	//Metodo que retorna uma lista de usuarios pessoa fisica, esse metodo sera chamado pela barra de pesquisa na pagina inicial do sistema.
	//O metodo so retorna as informações para exibição na tela de resultado da pesquisa.
	public List <UsuarioPessoaFisica> consultaUsuarioFisicoNome(UsuarioPessoaFisica usuarioPessoaFisica){


		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario,"
				+  "fm.nm_funcao_moderacao," 
				+  "ci.nome_cidade,"
				+  "es.sigla_estado, es.nm_estado"

				+  " from Usuario_PF pf, Usuario us, Funcao_Moderacao fm, logradouro lo, bairro ba, cidade ci, estado es"	

				+ " where us.nome_exibicao LIKE ?"
				+ " and pf.id_usuario = us.id_usuario"
				+ " and pf.id_funcao_moderacao_fk = fm.id_funcao_moderacao"
				+ "	and lo.id_logradouro = us.id_logradouro_fk"
				+ "	and ba.id_bairro = lo.id_bairro"
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado";

		Object [] parametros = {"%"+usuarioPessoaFisica.getNomeUser()+"%"};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaListaRowMapper());

		return listaUsuario;
	}


	//Esse metodo é utilizado para carregar os dados do usuario na home.
	public UsuarioPessoaFisica consultaUsuarioFisicoId(UsuarioPessoaFisica usuarioPessoaFisica){


		String sql ="SELECT us.id_usuario, us.e_mail_usuario, us.telefone_principal, us.telefone_secundario, us.nome_exibicao,"
				+  "us.id_logradouro_fk, us.numero_endereco, us.complemento_endereco,us.foto_usuario,"
				+  "pf.nome, pf.dt_nasc, pf.cpf, pf.sexo, pf.id_funcao_moderacao_fk, " 
				+  "fm.nm_funcao_moderacao, "  
				+  "lo.nome_logradouro, lo.cep_logradouro, " 
				+  "ba.nome_bairro, "
				+  "ci.nome_cidade, "
				+  "es.sigla_estado, es.nm_estado "

				+  " from Usuario_PF pf, Usuario us, Funcao_Moderacao fm, logradouro lo, bairro ba, cidade ci, estado es "	


				+ " where us.id_usuario = ?"
				+ " and pf.id_usuario = us.id_usuario"
				+ " and pf.id_funcao_moderacao_fk = fm.id_funcao_moderacao"
				+ "	and lo.id_logradouro = us.id_logradouro_fk"
				+ "	and ba.id_bairro = lo.id_bairro"
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado";

		Object [] parametros = {usuarioPessoaFisica.getIdUsuario()};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaRowMapper());		

		if(listaUsuario.size()>0){

			return listaUsuario.get(0);
		}else{

			return new UsuarioPessoaFisica();
		}	

	}



	//Esse metodo é utilizado para carregar os dados de uma pagina de usuario visitado, como parametro e utilizado guid.
	public UsuarioPessoaFisica consultaUsuarioFisicoGuid(UsuarioPessoaFisica usuarioPessoaFisica){


		String sql ="SELECT us.id_usuario, us.e_mail_usuario, us.telefone_principal, us.telefone_secundario, us.nome_exibicao,"
				+  "us.id_logradouro_fk, us.numero_endereco, us.complemento_endereco,us.foto_usuario,"
				+  "pf.nome, pf.dt_nasc, pf.cpf, pf.sexo, pf.id_funcao_moderacao_fk, " 
				+  "fm.nm_funcao_moderacao, "  
				+  "lo.nome_logradouro, lo.cep_logradouro, " 
				+  "ba.nome_bairro, "
				+  "ci.nome_cidade, "
				+  "es.sigla_estado, es.nm_estado "

				+  " from Usuario_PF pf, Usuario us, Funcao_Moderacao fm, logradouro lo, bairro ba, cidade ci, estado es "	


				+ " where us.guid_usuario = ?"
				+ " and pf.id_usuario = us.id_usuario"
				+ " and pf.id_funcao_moderacao_fk = fm.id_funcao_moderacao"
				+ "	and lo.id_logradouro = us.id_logradouro_fk"
				+ "	and ba.id_bairro = lo.id_bairro"
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado";

		Object [] parametros = {usuarioPessoaFisica.getGuidUsuario()};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaRowMapper());		

		if(listaUsuario.size()>0){

			return listaUsuario.get(0);
		}else{

			return new UsuarioPessoaFisica();
		}

	}

	public UsuarioPessoaFisica cadastroUsuarioFisico(final UsuarioPessoaFisica usuarioPessoaFisica){

		UsuarioPessoaFisica usuarioPessoaFisicaResposta = new UsuarioPessoaFisica();

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		

		parametros.put("prc_e_mail_usuario", usuarioPessoaFisica.getEmailUsuario());
		parametros.put("prc_senha_usuario", usuarioPessoaFisica.getSenhaUsuario());
		parametros.put("prc_telefone_principal", usuarioPessoaFisica.getTelefonePrincipal());
		parametros.put("prc_telefone_secundario", usuarioPessoaFisica.getTelefoneSecundario());
		parametros.put("prc_id_logradouro_fk", usuarioPessoaFisica.getEndereco().getIdLogradouro());
		parametros.put("prc_numero_endereco", usuarioPessoaFisica.getNumeroEndereco());
		parametros.put("prc_complemento_endereco", usuarioPessoaFisica.getComplementoEndereco());
		parametros.put("prc_nome", usuarioPessoaFisica.getNome());
		parametros.put("prc_dt_nasc", usuarioPessoaFisica.getDtNasc());
		parametros.put("prc_cpf", usuarioPessoaFisica.getCpf());
		parametros.put("prc_sexo", usuarioPessoaFisica.getSexo());
		parametros.put("prc_nome_user", usuarioPessoaFisica.getNomeUser());
		parametros.put("prc_id_funcao_moderacao_fk",1);
		parametros.put("prc_guid_usuario",usuarioPessoaFisica.getGuidUsuario());


		parametrosOut = procedureCadastroUsuarioPessoaFisica.execute(parametros);

		usuarioPessoaFisicaResposta.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
		usuarioPessoaFisicaResposta.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		if(usuarioPessoaFisicaResposta.getResultado().getCode().equals("0")){
			usuarioPessoaFisicaResposta.setIdUsuario((int)parametrosOut.get("prc_id_usuario"));
		}

		return usuarioPessoaFisicaResposta;		
	}

	public Resultado updateUsuarioFisico(final UsuarioPessoaFisica usuarioPessoaFisica){

		Resultado resultado = new Resultado();

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();

		parametros.put("prc_id_usuario", usuarioPessoaFisica.getIdUsuario());
		parametros.put("prc_telefone_principal", usuarioPessoaFisica.getTelefonePrincipal());
		parametros.put("prc_telefone_secundario", usuarioPessoaFisica.getTelefoneSecundario());
		parametros.put("prc_id_logradouro_fk", usuarioPessoaFisica.getEndereco().getIdLogradouro());
		parametros.put("prc_numero_endereco", usuarioPessoaFisica.getNumeroEndereco());
		parametros.put("prc_complemento_endereco", usuarioPessoaFisica.getComplementoEndereco());
		parametros.put("prc_nome", usuarioPessoaFisica.getNome());
		parametros.put("prc_dt_nasc", usuarioPessoaFisica.getDtNasc());
		parametros.put("prc_sexo", usuarioPessoaFisica.getSexo());
		parametros.put("prc_nome_user", usuarioPessoaFisica.getNomeUser());

		parametrosOut = procedureUpdateUsuarioPessoaFisica.execute(parametros);

		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));


		return resultado;
	}

	public ConfiguracaoPaginaUsuario consultaConfiguracaoPaginaUsuario(final UsuarioPessoaFisica usuarioPessoaFisica){

		ConfiguracaoPaginaUsuario configuracaoPaginaUsuario = new ConfiguracaoPaginaUsuario();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();

		parametros.put("prc_id_usuario", usuarioPessoaFisica.getIdUsuario());
		parametros.put("prc_guid_pesquisa", usuarioPessoaFisica.getGuidPesquisa());
		
		parametrosOut = procedureConfiguracaoPaginaUsuario.execute(parametros);

		configuracaoPaginaUsuario.setIdEstadoAmizade((int)parametrosOut.get("prc_id_estado_amizade"));
		configuracaoPaginaUsuario.setAmizade((boolean)parametrosOut.get("prc_amizade"));
		configuracaoPaginaUsuario.setSolicitante((boolean)parametrosOut.get("prc_solicitante"));
		configuracaoPaginaUsuario.setDtNascimentoPrivacidade((boolean)parametrosOut.get("prc_data_nascimento_privacidade"));
		configuracaoPaginaUsuario.setSexoPrivacidade((boolean)parametrosOut.get("prc_sexo_privacidade"));
		configuracaoPaginaUsuario.setEmailPrivacidade((boolean)parametrosOut.get("prc_email_privacidade"));
		configuracaoPaginaUsuario.setTelefonePrivacidade((boolean)parametrosOut.get("prc_telefone_privacidade"));
		configuracaoPaginaUsuario.setLocalizacaoPrivacidade((boolean)parametrosOut.get("prc_localizacao_privacidade"));
		configuracaoPaginaUsuario.setColecaoPrivacidade((boolean)parametrosOut.get("prc_colecao_privacidade"));
		configuracaoPaginaUsuario.setArtistaFavoritoPrivacidade((boolean)parametrosOut.get("prc_artista_favorito_privacidade"));
		configuracaoPaginaUsuario.setIdAmizade((int)parametrosOut.get("prc_id_amizade"));

		
		
		return configuracaoPaginaUsuario;
	}
	
	
	//Metodo responsavel por retornar uma lista de usuarios que possuam em sua colecao uma determinada edicao
	//Essa edicao sera determinada pelo id da edicao do album
	//Esse metodo retorna os dados para serem exibidos na pagina da edicao
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoItemColecao(int idEdicaoAlbum){


		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario from Usuario us, item_colecao ic"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk"
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pf where id_usuario = us.id_usuario)"
				+ " limit 10";

		Object [] parametros = {idEdicaoAlbum};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaPageRowMapper());

		return listaUsuario;
	}
	
	//Metodo responsavel por retornar uma lista de usuarios que possuam em sua colecao uma determinada edicao
	//Essa edicao sera determinada pelo id da edicao do album
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoItemColecao(Pesquisa pesquisa){
		
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;

		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario, "
				+ " ci.nome_cidade, "
				+ " es.sigla_estado, es.nm_estado"
				+ " from Usuario us, item_colecao ic, Logradouro lo, Bairro ba, Cidade ci, Estado es"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk"
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pf where id_usuario = us.id_usuario)"
				+ " and lo.id_logradouro = us.id_logradouro_fk "
				+ " and ba.id_bairro = lo.id_bairro "
				+ " and ci.id_cidade = ba.id_cidade "
				+ " and es.id_estado = ci.id_estado"
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdPesquisa(),limiteInicial,limiteFinal};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaPaginadoRowMapper());

		return listaUsuario;
	}

	//Esse metodo verificara quantas paginas serao necessarias 
	//para exibir todos os usuarios que possuem uma determinada edicao de album
	public int consultaNumeroPaginaUsuarioFisicoItemColecao(int idEdicaoAlbum){
		
		String sql = "SELECT COUNT(*) from Usuario us, item_colecao ic"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk "
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pf where id_usuario = us.id_usuario)";
		
		Object [] parametros = {idEdicaoAlbum};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		double auxiliar = numeroFavorito/10.0;
		
		int numeroPaginas = (int) Math.ceil(auxiliar);
		
		return numeroPaginas;
	}
	
	
	//Metodo responsavel por retornar uma lista de usuarios que favoritaram um determinado artista em comum
	//Esse artista sera determinada pelo id do mesmo
	//Esse metodo retorna os dados para serem exibidos na pagina do artista
	public List <UsuarioPessoaFisica> consultaPageListaUsuarioFisicoFavorito(int idArtista){


		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario "
				+ " from Usuario us, favoritos fa "
				+ " where fa.id_artista_pk = ?"
				+ " and us.id_usuario = fa.id_usuario_pf_pk"
				+ " limit 4";

		Object [] parametros = {idArtista};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaPageRowMapper());

		return listaUsuario;
	}
	
	//Metodo responsavel por retornar uma lista de usuarios que tenham favoritado um mesmo artista
	//Esse artista sera determinado pelo id do artista
	public List <UsuarioPessoaFisica> consultaListaUsuarioFisicoFavorito(Pesquisa pesquisa){
		
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;

		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario, "
				+ "ci.nome_cidade, "
				+ "es.sigla_estado, es.nm_estado "
				+ " from Usuario us, favoritos fa, Logradouro lo, Bairro ba, Cidade ci, Estado es"
				+ " where fa.id_artista_pk = ? "
				+ "	and us.id_usuario = fa.id_usuario_pf_pk "
				+ "	and lo.id_logradouro = us.id_logradouro_fk "
				+ "	and ba.id_bairro = lo.id_bairro "
				+ "	and ci.id_cidade = ba.id_cidade "
				+ "	and es.id_estado = ci.id_estado"
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdPesquisa(),limiteInicial,limiteFinal};

		List <UsuarioPessoaFisica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaFisicaPaginadoRowMapper());

		return listaUsuario;
	}
	
	//Esse metodo verificara quantas paginas serao necessarias 
	//para exibir todos os usuarios que favoritaram um determinado artista
	public int consultaNumeroPaginaUsuarioFisicoFavorito(int idArtista){
		
		String sql = "SELECT COUNT(*) "
				+ "	from Usuario us, favoritos fa "
				+ "	where fa.id_artista_pk = ? "
				+ " and us.id_usuario = fa.id_usuario_pf_pk";
		
		Object [] parametros = {idArtista};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		double auxiliar = numeroFavorito/10.0;
		
		int numeroPaginas = (int) Math.ceil(auxiliar);
		
		return numeroPaginas;
	}
	
	
	public Resultado atualizaPrivacidadeUsuarioFisico (ConfiguracaoPaginaUsuario configuracaoPaginaUsuario){

		Resultado resultado = new Resultado();
		
		String sql = "UPDATE preferencia_privacidade set "
				+ " dt_nasc_privacidade = ?, "
				+ " sexo_privacidade = ?, "
				+ " email_privacidade = ?, "
				+ " telefone_privacidade = ?,"
				+ " localizacao_privacidade = ?, "
				+ " colecao_privacidade = ?, "
				+ " artista_favorito_privacidade = ? "
				+ " where id_usuario_pf_pk = ?";
		
		Object [] parametros = {configuracaoPaginaUsuario.isDtNascimentoPrivacidade(),
				configuracaoPaginaUsuario.isSexoPrivacidade(),
				configuracaoPaginaUsuario.isEmailPrivacidade(),
				configuracaoPaginaUsuario.isTelefonePrivacidade(),
				configuracaoPaginaUsuario.isLocalizacaoPrivacidade(),
				configuracaoPaginaUsuario.isColecaoPrivacidade(),
				configuracaoPaginaUsuario.isArtistaFavoritoPrivacidade(),
				configuracaoPaginaUsuario.getIdUsuario()};

		int  result = jdbcTemplate.update(sql,parametros);
		
		
		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Preferencia atualizada com sucesso.");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Erro ao atualizar preferencia.");
			
		}
		
		
		return resultado;

	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	

	//Metodo utilizado para preencher os dados de usuario na home
	public UsuarioPessoaFisica consultaUsuarioFisicoHomeId(int idUsuarioPessoaFisica){


		String sql ="SELECT us.nome_exibicao, us.foto_usuario, us.e_mail_usuario,"
				+ "pf.nome,"
				+  "fm.nm_funcao_moderacao," 
				+  "es.sigla_estado"

				+  " from Usuario_PF pf, Usuario us, Funcao_Moderacao fm, logradouro lo, bairro ba, cidade ci, estado es"	

				+ " where us.id_usuario = ?"
				+ " and pf.id_usuario = us.id_usuario"
				+ " and pf.id_funcao_moderacao_fk = fm.id_funcao_moderacao"
				+ "	and lo.id_logradouro = us.id_logradouro_fk"
				+ "	and ba.id_bairro = lo.id_bairro"
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado";

		Object [] parametros = {idUsuarioPessoaFisica};

		List <UsuarioPessoaFisica> usuario = jdbcTemplate.query(sql, parametros, new UsuarioFisicoHomeIdRowMapper());

		return usuario.get(0);
	}
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StoredProcedure getProcedureCadastroUsuarioPessoaFisica() {
		return procedureCadastroUsuarioPessoaFisica;
	}

	public void setProcedureCadastroUsuarioPessoaFisica(StoredProcedure procedureCadastroUsuarioPessoaFisica) {
		this.procedureCadastroUsuarioPessoaFisica = procedureCadastroUsuarioPessoaFisica;
	}

	public StoredProcedure getProcedureUpdateUsuarioPessoaFisica() {
		return procedureUpdateUsuarioPessoaFisica;
	}

	public void setProcedureUpdateUsuarioPessoaFisica(StoredProcedure procedureUpdateUsuarioPessoaFisica) {
		this.procedureUpdateUsuarioPessoaFisica = procedureUpdateUsuarioPessoaFisica;
	}


	public StoredProcedure getProcedureConfiguracaoPaginaUsuario() {
		return procedureConfiguracaoPaginaUsuario;
	}


	public void setProcedureConfiguracaoPaginaUsuario(StoredProcedure procedureConfiguracaoPaginaUsuario) {
		this.procedureConfiguracaoPaginaUsuario = procedureConfiguracaoPaginaUsuario;
	}

	
	

}
