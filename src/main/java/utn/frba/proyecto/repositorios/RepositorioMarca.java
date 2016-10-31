package utn.frba.proyecto.repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entidades.Marca;

public class RepositorioMarca implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioMarca instance = new RepositorioMarca();

	public static RepositorioMarca getInstance() {
		return instance;
	}

	public void agregarMarca(Marca marca) {
		withTransaction(() -> {
			entityManager().persist(marca);
		});
	}

	public void quitarMarca(Marca marca) {
		withTransaction(() -> {
			entityManager().remove(marca);
		});
	}

	public Marca modificarMarca(int id, String nombre, String descripcion) {
		return withTransaction(() -> {
			Marca marca = entityManager().find(Marca.class, id);
			marca.setNombre(nombre);
			marca.setDescripcion(descripcion);
			return marca;
		});
	}

	public List<Marca> listarMarcas() {
		List<Marca> marcas = entityManager().createQuery("from Marca", Marca.class).getResultList();
		marcas.stream().forEach(marca -> entityManager().refresh(marca));
		return marcas;
	}

	public Marca getMarca(int id) {
		return entityManager().find(Marca.class, id);
	}

}
