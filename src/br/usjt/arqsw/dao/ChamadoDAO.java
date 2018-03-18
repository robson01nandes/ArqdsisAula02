package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoDAO {

	public ArrayList<Chamado> ListarChamados(Fila fila) throws IOException, SQLException {
		String query = "SELECT * FROM chamado WHERE id_fila = ?";
		ArrayList<Chamado> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {
				pst.setInt(1, fila.getId());
		
				try(ResultSet rs = pst.executeQuery();){
				
			while(rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setId_chamado(rs.getInt("id_chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				chamado.setDataAbertura(rs.getDate("dt_abertura"));
				fila.setNome(rs.getString("nm_fila"));
				chamado.setFila(fila);
				lista.add(chamado);
				
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}
}
