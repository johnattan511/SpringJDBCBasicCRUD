package com.johnattan.SpringJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.EquipoDTO;
import dto.InterfaceEquipoDAO;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringJdbcApplication.class, args);
		AbstractApplicationContext ap = new ClassPathXmlApplicationContext("Bean.xml");
		
		InterfaceEquipoDAO inte = (InterfaceEquipoDAO) ap.getBean("EquipoDTO");
		
		// CREAR EQUIPO
		inte.createEquipo("Millonarios", "15");
		inte.createEquipo("Santafe", "9");
		inte.createEquipo("Nacional", "16");
		inte.createEquipo("Junior", "7");
		inte.createEquipo("Tolima", "2");
		
		// ACTUALIZAR EQUIPO
		inte.updateEquipo(1, "16");
		
		// ELIMINAR EQUIPO
		inte.deleteEquipo(2);
		
		// OBTENER EQUIPO
		EquipoDTO equipo = inte.obtenerEquipo(4);
		
		System.out.println("El equipo es : " + equipo.getNombre() + " y sus estrellas son: " + equipo.getEstrellas());
		
		
		// OBTENER LISTAS DE EQUIPOS
		List<EquipoDTO> listaEquipos = inte.listaEquipos();
		
		for(EquipoDTO e : listaEquipos){
			System.out.println("El equipo es : " + e.getNombre() + " y sus estrellas son: " + e.getEstrellas());
		}
		
		
	}
}
