package utn.frba.proyecto.servicios;

import java.util.List;

import utn.frba.proyecto.entidades.Marca;
import utn.frba.proyecto.repositorios.RepositorioMarca;

public class MarcaService {

	public List<Marca> listarMarcas() {
		return RepositorioMarca.getInstance().listarMarcas();
	}

	public Marca agregarMarca(String nombre, String descripcion) {
		Marca marca = new Marca(nombre, descripcion);
		RepositorioMarca.getInstance().agregarMarca(marca);
		return marca;
	}

	public void quitarMarca(Marca marca) {
		RepositorioMarca.getInstance().quitarMarca(marca);
	}

	public Marca modificarMarca(int id, String nombre, String descripcion) {
		return RepositorioMarca.getInstance().modificarMarca(id, nombre, descripcion);
	}

	public Marca getMarcaById(int id) {
		return RepositorioMarca.getInstance().getMarca(id);
	}

}
