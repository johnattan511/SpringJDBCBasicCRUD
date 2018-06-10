package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EquipoMapper implements RowMapper<EquipoDTO>{

	@Override
	public EquipoDTO mapRow(ResultSet rs, int arg) throws SQLException {
		EquipoDTO equipo = new EquipoDTO();
		equipo.setId(rs.getInt(1));
		equipo.setNombre(rs.getString(2));
		equipo.setEstrellas(rs.getString(3));
		return equipo;
	}

}
