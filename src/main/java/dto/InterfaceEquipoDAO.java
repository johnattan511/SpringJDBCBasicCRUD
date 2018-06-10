package dto;

import java.util.List;

import javax.sql.DataSource;

public interface InterfaceEquipoDAO {
        
	 public void setDataSource(DataSource ds);
	 
	 public void createEquipo(String nombre, String estrellas);
	 
	 public void updateEquipo(int id, String estrellas);
	 
	 public void deleteEquipo(int id);
	 
	 public EquipoDTO obtenerEquipo(int id);
	 
	 public List<EquipoDTO> listaEquipos();
}
