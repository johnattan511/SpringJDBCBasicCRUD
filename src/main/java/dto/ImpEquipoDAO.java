package dto;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;

public class ImpEquipoDAO implements InterfaceEquipoDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Required
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createEquipo(String nombre, String estrellas) {
		String consulta ="INSERT INTO equipo (nombre, estrellas) VALUES(?,?)";
		jdbcTemplate.update(consulta, nombre, estrellas);
		System.out.println("CREADO EQUIPO EXITOSAMENTE");
		
	}

	@Override
	public void updateEquipo(int id, String estrellas) {
	  String consulta ="update equipo set estrellas = ? where id = ?";
	  jdbcTemplate.update(consulta, estrellas, id);
	  System.out.println("ACTUALIZADO EQUIPO EXITOSAMENTE");
		
	}

	@Override
	public void deleteEquipo(int id) {
		String consulta = "delete from equipo where id = ?";
		jdbcTemplate.update(consulta, id);
		System.out.println("ELIMINADO EQUIPO EXITOSAMENTE");
	}

	@Override
	public EquipoDTO obtenerEquipo(int id) {
		String consulta = "select * from equipo where id = ?";
		EquipoDTO equipo = jdbcTemplate.queryForObject(consulta , new EquipoMapper(), id);
		return equipo;
	}

	@Override
	public List<EquipoDTO> listaEquipos() {
		String consulta = "select * from equipo";
		List<EquipoDTO> lista = jdbcTemplate.query(consulta, new EquipoMapper());
		return lista;
	}

}
