package utn.frba.proyecto.repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entidades.Publicidad;

public class RepositorioPublicidad implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioPublicidad instance = new RepositorioPublicidad();

	public static RepositorioPublicidad getInstance() {
		return instance;
	}

	public void agregarPublicidad(Publicidad publicidad) {
		withTransaction(() -> {
			entityManager().persist(publicidad);
		});
	}

	public void quitarPublicidad(Publicidad publicidad) {
		withTransaction(() -> {
			entityManager().remove(publicidad);
		});
	}

	public Publicidad modificarPublicidad(int id, String ip) {
		return withTransaction(() -> {
			Publicidad publicidad = entityManager().find(Publicidad.class, id);
			return publicidad;
		});
	}

	public List<Publicidad> listarPublicidades() {
		List<Publicidad> publicidades = entityManager().createQuery("from Publicidad", Publicidad.class).getResultList();
		publicidades.stream().forEach(publicidad -> entityManager().refresh(publicidad));
		return publicidades;
	}

	public Publicidad getPublicidad(int id) {
		return entityManager().find(Publicidad.class, id);
	}

}
