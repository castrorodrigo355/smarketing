package utn.frba.proyecto.main;

import static spark.Spark.after;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import utn.frba.proyecto.controladores.CamaraController;
import utn.frba.proyecto.controladores.MarcaController;
import utn.frba.proyecto.controladores.PublicidadController;
import utn.frba.proyecto.controladores.UsuarioController;
import utn.frba.proyecto.servicios.CamaraService;
import utn.frba.proyecto.servicios.MarcaService;
import utn.frba.proyecto.servicios.PublicidadService;
import utn.frba.proyecto.servicios.UsuarioService;

public class Main {

	public static void main(String[] args) {

		staticFileLocation("/public");
		port(8080);

		new CamaraController(new CamaraService());
		new UsuarioController(new UsuarioService());
		new MarcaController(new MarcaService());
		new PublicidadController(new PublicidadService());

		after((request, response) -> {
			PerThreadEntityManagers.getEntityManager();
			PerThreadEntityManagers.closeEntityManager();
		});

	}

}
