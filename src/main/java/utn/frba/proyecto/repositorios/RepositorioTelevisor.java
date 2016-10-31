package utn.frba.proyecto.repositorios;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entidades.Televisor;

public class RepositorioTelevisor implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioTelevisor instance = new RepositorioTelevisor();

	public static RepositorioTelevisor getInstance() {
		return instance;
	}

	public void agregarTelevisor(Televisor televisor) {
		withTransaction(() -> {
			entityManager().persist(televisor);
		});
	}

}
