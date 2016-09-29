package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.ConfiguracaoPlano;

/**
 * @author marcos
 *
 */
public class ConfiguracaoPlanoRowMapper implements RowMapper<ConfiguracaoPlano> {

	@Override
	public ConfiguracaoPlano mapRow(ResultSet rs, int arg1) throws SQLException {
		
		ConfiguracaoPlano configuracaoPlano = new ConfiguracaoPlano();
		
		configuracaoPlano.setDataContratacao(rs.getDate("data_contratacao"));
		configuracaoPlano.setDataPagamento(rs.getDate("dt_pgto"));
		configuracaoPlano.setNomePlano(rs.getString("nm_plano"));
		configuracaoPlano.setDescricaoPlano(rs.getString("ds_plano"));
		configuracaoPlano.setValorPlano(rs.getDouble("vl_plano"));
		configuracaoPlano.setTempoPlanoMeses(rs.getInt("tempo_plano_meses"));
		configuracaoPlano.setDisponibilidade(rs.getInt("disponbilidade"));
		configuracaoPlano.setNomeFormaPagamento(rs.getString("nm_forma_pagamento"));
		configuracaoPlano.setNomeEstadoPlano(rs.getString("nm_estado_plano"));
		
		
		
		return configuracaoPlano;
	}
	
}
