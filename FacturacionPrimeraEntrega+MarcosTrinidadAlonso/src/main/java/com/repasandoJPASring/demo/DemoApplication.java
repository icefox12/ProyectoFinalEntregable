package com.repasandoJPASring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.repasandoJPASring.demo.model.Sucursal;
import com.repasandoJPASring.demo.initializer.JuegoInitializer;
import com.repasandoJPASring.demo.initializer.EmpleadoInitializer;
import com.repasandoJPASring.demo.initializer.SucursalInitializer;
import com.repasandoJPASring.demo.initializer.StockInitializer;
import com.repasandoJPASring.demo.initializer.CategoriaInitializer;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private SucursalInitializer sucursalInitializer;

	@Autowired
	private JuegoInitializer juegoInitializer;

	@Autowired
	private EmpleadoInitializer empleadoInitializer;

	@Autowired
	private StockInitializer stockInitializer;

	@Autowired
	private CategoriaInitializer categoriaInitializer;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Iniciando la carga de datos...");

		 // CATEGORIAS :
        categoriaInitializer.initialize();

		// SUCURSALES :
		Sucursal sucursalUno = sucursalInitializer.initializeSucursalUno();
		Sucursal sucursalDos = sucursalInitializer.initializeSucursalDos();
		Sucursal sucursalTres = sucursalInitializer.initializeSucursalTres();

		// VIDEOJUEGOS :
		juegoInitializer.initialize();

		// EMPLEADOS :
		empleadoInitializer.initialize(sucursalUno, sucursalDos, sucursalTres);

		// STOCK :
		stockInitializer.initialize(sucursalUno, sucursalDos, sucursalTres);
	}
}

// ESTRUCTURA JSON PARA CREAR UN JUEGO

// http://localhost:8080/juegos (EJEMPLO)

// {
  //"nombre": "Nuevo Juego TEST",
  //"fechaCreacion": "2025-03-03",
  //"precio": 99.99,
  //"categorias": ["Acción", "Simulacion"]
//}

// ESTRUCTURA JSON PARA ACTUALIZAR UN JUEGO

//http://localhost:8080/juegos/modificar/1 (EJEMPLO)

// {
  //"id": 1,
  //"nombre": "HADES",
  //"fechaCreacion": "2025-03-03",
  //"precio": 99.99,
  //"categorias": ["Acción", "Simulacion"]
//}

// ESTRUCTURA JSON PARA ELIMINAR UN JUEGO

// http://localhost:8080/juegos/1 (EJEMPLO)

// {
  //"id": 1
//}