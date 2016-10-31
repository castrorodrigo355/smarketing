package utn.frba.proyecto.main;

import utn.frba.proyecto.entidades.Camara;
import utn.frba.proyecto.entidades.Marca;
import utn.frba.proyecto.entidades.Televisor;
import utn.frba.proyecto.entidades.Usuario;
import utn.frba.proyecto.repositorios.RepositorioCamara;
import utn.frba.proyecto.repositorios.RepositorioMarca;
import utn.frba.proyecto.repositorios.RepositorioTelevisor;
import utn.frba.proyecto.repositorios.RepositorioUsuario;
import utn.frba.proyecto.utils.PasswordUtil;

public class Bootstrap {

	public static void main(String[] args) {

		Bootstrap bootstrap = new Bootstrap();
		bootstrap.run();

		System.exit(0);
	}

	public void run() {

		Usuario usuario1 = new Usuario("Rodrigo", "Castro", PasswordUtil.hashPassword("admin"),
				"rodrigo.castro@gmail.com", true);

		Usuario usuario2 = new Usuario("Federico", "Alva", PasswordUtil.hashPassword("admin"), "fede.alva@gmail.com",
				false);
		Usuario usuario3 = new Usuario("Federico", "Cze", PasswordUtil.hashPassword("admin"), "fede.cze@gmail.com",
				false);
		Usuario usuario4 = new Usuario("Ezequiel", "Ogando", PasswordUtil.hashPassword("admin"), "eze.ogando@gmail.com",
				false);
		Usuario usuario5 = new Usuario("Ana", "Sosa", PasswordUtil.hashPassword("admin"), "ana.sosa@gmail.com", false);

		RepositorioUsuario.getInstance().agregarUsuario(usuario1);
		RepositorioUsuario.getInstance().agregarUsuario(usuario2);
		RepositorioUsuario.getInstance().agregarUsuario(usuario3);
		RepositorioUsuario.getInstance().agregarUsuario(usuario4);
		RepositorioUsuario.getInstance().agregarUsuario(usuario5);

		Camara camara1 = new Camara("10.24.192.151");
		Camara camara2 = new Camara("10.24.192.152");
		Camara camara3 = new Camara("10.24.192.153");
		Camara camara4 = new Camara("10.24.192.154");
		Camara camara5 = new Camara("10.24.192.155");
		Camara camara6 = new Camara("10.24.192.156");

		Televisor televisor1 = new Televisor("10.24.192.141");
		Televisor televisor2 = new Televisor("10.24.192.142");
		Televisor televisor3 = new Televisor("10.24.192.143");
		Televisor televisor4 = new Televisor("10.24.192.144");
		Televisor televisor5 = new Televisor("10.24.192.145");
		Televisor televisor6 = new Televisor("10.24.192.146");
		Televisor televisor7 = new Televisor("10.24.192.147");
		Televisor televisor8 = new Televisor("10.24.192.148");

		camara1.agregarTelevisor(televisor1);
		camara2.agregarTelevisor(televisor2);
		camara3.agregarTelevisor(televisor3);
		camara4.agregarTelevisor(televisor4);
		camara5.agregarTelevisor(televisor5);
		camara6.agregarTelevisor(televisor6);
		camara1.agregarTelevisor(televisor7);
		camara2.agregarTelevisor(televisor8);

		RepositorioTelevisor.getInstance().agregarTelevisor(televisor1);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor2);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor3);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor4);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor5);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor6);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor7);
		RepositorioTelevisor.getInstance().agregarTelevisor(televisor8);

		RepositorioCamara.getInstance().agregarCamara(camara1);
		RepositorioCamara.getInstance().agregarCamara(camara2);
		RepositorioCamara.getInstance().agregarCamara(camara3);
		RepositorioCamara.getInstance().agregarCamara(camara4);
		RepositorioCamara.getInstance().agregarCamara(camara5);
		RepositorioCamara.getInstance().agregarCamara(camara6);

		Marca marca1 = new Marca("Adidas", "Imposible is nothing");
		Marca marca2 = new Marca("Nike", "Just do it");
		Marca marca3 = new Marca("Salomon", "Montaña, vino y partuza");
		Marca marca4 = new Marca("Topper", "No me compra nadie");

		RepositorioMarca.getInstance().agregarMarca(marca1);
		RepositorioMarca.getInstance().agregarMarca(marca2);
		RepositorioMarca.getInstance().agregarMarca(marca3);
		RepositorioMarca.getInstance().agregarMarca(marca4);

	}

}
