package utn.frba.proyecto.servicios;

import java.util.List;

import utn.frba.proyecto.entidades.Camara;
import utn.frba.proyecto.repositorios.RepositorioCamara;

public class CamaraService {

	public List<Camara> listarCamaras() {
		return RepositorioCamara.getInstance().listarCamaras();
	}

	public Camara agregarCamara(String ip) {
		Camara camara = new Camara(ip);
		RepositorioCamara.getInstance().agregarCamara(camara);
		return camara;
	}

	public void quitarCamara(Camara camara) {
		RepositorioCamara.getInstance().quitarCamara(camara);
	}

	public Camara modificarCamara(int id, String ip) {
		return RepositorioCamara.getInstance().modificarCamara(id, ip);
	}

	public Camara getCamaraById(int id) {
		return RepositorioCamara.getInstance().getCamara(id);
	}

}
