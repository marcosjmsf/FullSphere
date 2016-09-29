/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.ConfiguracaoPlano;
import Bean.Pesquisa;
import Bean.Resultado;
import Bean.UsuarioPessoaJuridica;
import RowMapper.ConfiguracaoPlanoRowMapper;
import RowMapper.UsuarioPessoaJuridicaListaRowMapper;
import RowMapper.UsuarioPessoaJuridicaPageRowMapper;
import RowMapper.UsuarioPessoaJuridicaPaginadoRowMapper;
import RowMapper.UsuarioPessoaJuridicaRowMapper;

/**
 * @author marcos
 *
 */
public class UsuarioJuridicoDao {
	
	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroUsuarioPessoaJuridica;
	private StoredProcedure procedureUpdateUsuarioPessoaJuridica;

	
	public Resultado cadastroUsuarioJuridico(final UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();

		
		parametros.put("prc_e_mail_usuario", usuarioPessoaJuridica.getEmailUsuario());
		parametros.put("prc_senha_usuario", usuarioPessoaJuridica.getSenhaUsuario());
		parametros.put("prc_telefone_principal", usuarioPessoaJuridica.getTelefonePrincipal());
		parametros.put("prc_telefone_secundario", usuarioPessoaJuridica.getTelefoneSecundario());
		parametros.put("prc_id_logradouro_fk", usuarioPessoaJuridica.getEndereco().getIdLogradouro());
		parametros.put("prc_numero_endereco", usuarioPessoaJuridica.getNumeroEndereco());
		parametros.put("prc_complemento_endereco", usuarioPessoaJuridica.getComplementoEndereco());
		
		parametros.put("prc_razao_social", usuarioPessoaJuridica.getRazaoSocial());
		parametros.put("prc_nm_fantasia", usuarioPessoaJuridica.getNomeFantasia());
		parametros.put("prc_cnpj", usuarioPessoaJuridica.getCnpj());
		parametros.put("prc_insc_estadual", usuarioPessoaJuridica.getInscricaoEstadual());
		parametros.put("prc_id_plano", usuarioPessoaJuridica.getConfiguracaoPlano().getIdPlano());
		parametros.put("prc_id_Forma_Pagamento", usuarioPessoaJuridica.getConfiguracaoPlano().getIdFormaPagamento());
		parametros.put("prc_dt_pgto", usuarioPessoaJuridica.getConfiguracaoPlano().getDataPagamento());
		parametros.put("prc_guid_usuario",usuarioPessoaJuridica.getGuidUsuario());

		
		
		parametrosOut = procedureCadastroUsuarioPessoaJuridica.execute(parametros);
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));

		
		return resultado;		
	}
	
	
	//Metodo que sera utilizado para preencher a pagina do usuario
	public UsuarioPessoaJuridica consultaUsuarioJuridicoId(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		
		String sql = "SELECT us.id_usuario, us.e_mail_usuario, us.telefone_principal, us.telefone_secundario, us.nome_exibicao,"
				+ " us.id_logradouro_fk, us.numero_endereco, us.complemento_endereco,us.foto_usuario, us.guid_usuario,"
				+ " pj.razao_social, pj.cnpj, pj.insc_estadual,"
				+ " lo.nome_logradouro, lo.cep_logradouro,"
				+ " ba.nome_bairro,"
				+ " ci.nome_cidade,"
				+ " es.sigla_estado, es.nm_estado"
				+ " from Usuario_PJ pj, Usuario us, logradouro lo, bairro ba, cidade ci, estado es "
				+ " where us.id_usuario = ? "
				+ " and pj.id_usuario = us.id_usuario"
				+ " and lo.id_logradouro = us.id_logradouro_fk "
				+ " and ba.id_bairro = lo.id_bairro "
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado;";
		
		Object [] parametros = {usuarioPessoaJuridica.getIdUsuario()};
		
		List <UsuarioPessoaJuridica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaJuridicaRowMapper());
		
		if(listaUsuario.size()>0){

			return listaUsuario.get(0);
		}else{

			return new UsuarioPessoaJuridica();
		}		
	
	}
	
	
	//Metodo utilizado para trazer uma lista de usuarios pelo nome, esse metodo deve ser usado quando o usuario faz uma pesquisa pela barra de pesquisa do sistema
	public List <UsuarioPessoaJuridica> consultaUsuarioJuridicoNome(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		
		String sql = "SELECT us.foto_usuario,us.guid_usuario, us.nome_exibicao,"
				+ " ci.nome_cidade,"
				+ " es.sigla_estado, es.nm_estado"
				+ " from Usuario_PJ pj, Usuario us, logradouro lo, bairro ba, cidade ci, estado es "
				+ " where us.nome_exibicao like ?"
				+ " and pj.id_usuario = us.id_usuario"
				+ " and lo.id_logradouro = us.id_logradouro_fk "
				+ " and ba.id_bairro = lo.id_bairro "
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado;";
		
		Object [] parametros = {usuarioPessoaJuridica.getNomeFantasia()+"%"};
		
		List <UsuarioPessoaJuridica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaJuridicaListaRowMapper());
		
		return listaUsuario;
	}

	public ConfiguracaoPlano consultaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		
		String sql = "Select  cp.data_contratacao, cp.dt_pgto, "
				+ " pl.nm_plano, pl.ds_plano, pl.vl_plano, pl.tempo_plano_meses, pl.disponbilidade,"
				+ " fp.nm_forma_pagamento,"
				+ " ep.nm_estado_plano"
				+ " from  Config_Plano cp, Estado_Plano ep, Forma_Pagamento fp, Plano pl "
				+ " where cp.id_usuario_pj_fk = ? "
				+ " and cp.id_plano_fk = pl.id_plano "
				+ " and cp.id_forma_pagamento_fk = fp.id_Forma_Pagamento "
				+ " and cp.Id_estado_plano_fk = ep.id_estado_plano";
		
		Object [] parametros = {usuarioPessoaJuridica.getIdUsuario()};
		
		List <ConfiguracaoPlano> ListConfiguracaoPlano = jdbcTemplate.query(sql, parametros, new ConfiguracaoPlanoRowMapper());
		
		return ListConfiguracaoPlano.get(0);
	}

	public Resultado updateUsuarioJuridico(final UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		Resultado resultado = new Resultado();

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();

		
		parametros.put("prc_telefone_principal", usuarioPessoaJuridica.getTelefonePrincipal());
		parametros.put("prc_telefone_secundario", usuarioPessoaJuridica.getTelefoneSecundario());
		parametros.put("prc_id_logradouro_fk", usuarioPessoaJuridica.getEndereco().getIdLogradouro());
		parametros.put("prc_numero_endereco", usuarioPessoaJuridica.getNumeroEndereco());
		parametros.put("prc_complemento_endereco", usuarioPessoaJuridica.getComplementoEndereco());
		parametros.put("prc_nm_fantasia", usuarioPessoaJuridica.getNomeFantasia());
		
		
		parametrosOut = procedureUpdateUsuarioPessoaJuridica.execute(parametros);
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));

		
		return resultado;		
	}
	
	public Resultado atualizaConfiguracaoPlano(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		String sql = "UPDATE Config_Plano SET data_contratacao = CURDATE(), id_forma_pagamento_fk = ?,  dt_pgto = ?, Id_estado_plano_fk = ?,  id_plano_fk = ?"
				+ " where id_usuario_pj_fk = ?";
		
		Object [] parametros = {usuarioPessoaJuridica.getConfiguracaoPlano().getIdFormaPagamento(),
				usuarioPessoaJuridica.getConfiguracaoPlano().getDataPagamento(),
				usuarioPessoaJuridica.getConfiguracaoPlano().getIdEstadoPlano(),
				usuarioPessoaJuridica.getConfiguracaoPlano().getIdPlano(),
				usuarioPessoaJuridica.getIdUsuario()};

		
		int result = jdbcTemplate.update(sql, parametros);
		
		Resultado resultado =  new Resultado();
		
		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Plano atualizado com sucesso");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Não foi possivel atualizar o plano");
			
		}
		
		return resultado;
		
		
	}

	//Metodo que sera utilizado para preencher a pagina do usuario, utilizando como parametro guid
	public UsuarioPessoaJuridica consultaUsuarioJuridicoGuid(UsuarioPessoaJuridica usuarioPessoaJuridica){
		
		
		String sql = "SELECT us.id_usuario, us.e_mail_usuario, us.telefone_principal, us.telefone_secundario, us.nome_exibicao,"
				+ " us.id_logradouro_fk, us.numero_endereco, us.complemento_endereco,us.foto_usuario, us.guid_usuario,"
				+ " pj.razao_social, pj.cnpj, pj.insc_estadual,"
				+ " lo.nome_logradouro, lo.cep_logradouro,"
				+ " ba.nome_bairro,"
				+ " ci.nome_cidade,"
				+ " es.sigla_estado, es.nm_estado"
				+ " from Usuario_PJ pj, Usuario us, logradouro lo, bairro ba, cidade ci, estado es "
				+ " where us.guid_usuario = ? "
				+ " and pj.id_usuario = us.id_usuario"
				+ " and lo.id_logradouro = us.id_logradouro_fk "
				+ " and ba.id_bairro = lo.id_bairro "
				+ " and ci.id_cidade = ba.id_cidade"
				+ " and es.id_estado = ci.id_estado;";
		
		Object [] parametros = {usuarioPessoaJuridica.getGuidUsuario()};
		
		List <UsuarioPessoaJuridica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaJuridicaRowMapper());
		
		if(listaUsuario.size()>0){

			return listaUsuario.get(0);
		}else{

			return new UsuarioPessoaJuridica();
		}
		
	}
	
	
	//Metodo responsavel por retornar uma lista de usuarios que possuam em sua colecao uma determinada edicao
	//Essa edicao sera determinada pelo id da edicao do album
	//Esse metodo retorna os dados para serem exibidos na pagina da edicao
	public List <UsuarioPessoaJuridica> consultaPageListaUsuarioJuridicoItemColecao(int idEdicaoAlbum){


		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario from Usuario us, item_colecao ic"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk"
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pj where id_usuario = us.id_usuario)"
				+ " limit 10";

		Object [] parametros = {idEdicaoAlbum};

		List <UsuarioPessoaJuridica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaJuridicaPageRowMapper());

		return listaUsuario;
	}
	
	//Metodo responsavel por retornar uma lista de usuarios que possuam em sua colecao uma determinada edicao
	//Essa edicao sera determinada pelo id da edicao do album
	public List <UsuarioPessoaJuridica> consultaListaUsuarioJuridicoItemColecao(Pesquisa pesquisa){
		
		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;

		String sql ="SELECT us.guid_usuario, us.nome_exibicao, us.foto_usuario, "
				+ " ci.nome_cidade, "
				+ " es.sigla_estado, es.nm_estado"
				+ " from Usuario us, item_colecao ic, Logradouro lo, Bairro ba, Cidade ci, Estado es"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk"
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pj where id_usuario = us.id_usuario)"
				+ " and lo.id_logradouro = us.id_logradouro_fk "
				+ " and ba.id_bairro = lo.id_bairro "
				+ " and ci.id_cidade = ba.id_cidade "
				+ " and es.id_estado = ci.id_estado"
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdPesquisa(),limiteInicial,limiteFinal};

		List <UsuarioPessoaJuridica> listaUsuario = jdbcTemplate.query(sql, parametros, new UsuarioPessoaJuridicaPaginadoRowMapper());

		return listaUsuario;
	}

	//Esse metodo verificara quantas paginas serao necessarias 
	//para exibir todos os usuarios que possuem uma determinada edicao de album
	public int consultaNumeroPaginaUsuarioJuridicoItemColecao(int idEdicaoAlbum){
		
		String sql = "SELECT COUNT(*) from Usuario us, item_colecao ic"
				+ " where ic.id_edicao_album_fk = ? "
				+ " and us.id_usuario = ic.id_usuario_pk "
				+ " and (Select IF(COUNT(*), true, false) tag from usuario_pj where id_usuario = us.id_usuario)";
		
		Object [] parametros = {idEdicaoAlbum};
		
		int  numeroFavorito = jdbcTemplate.queryForInt(sql,parametros);
		
		double auxiliar = numeroFavorito/10.0;
		
		int numeroPaginas = (int) Math.ceil(auxiliar);
		
		return numeroPaginas;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StoredProcedure getProcedureCadastroUsuarioPessoaJuridica() {
		return procedureCadastroUsuarioPessoaJuridica;
	}

	public void setProcedureCadastroUsuarioPessoaJuridica(StoredProcedure procedureCadastroUsuarioPessoaJuridica) {
		this.procedureCadastroUsuarioPessoaJuridica = procedureCadastroUsuarioPessoaJuridica;
	}



	public StoredProcedure getProcedureUpdateUsuarioPessoaJuridica() {
		return procedureUpdateUsuarioPessoaJuridica;
	}



	public void setProcedureUpdateUsuarioPessoaJuridica(StoredProcedure procedureUpdateUsuarioPessoaJuridica) {
		this.procedureUpdateUsuarioPessoaJuridica = procedureUpdateUsuarioPessoaJuridica;
	}

	
	
	
	
	
}
