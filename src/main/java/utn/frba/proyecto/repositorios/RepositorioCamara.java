package utn.frba.proyecto.repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entidades.Camara;

public class RepositorioCamara implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioCamara instance = new RepositorioCamara();

	public static RepositorioCamara getInstance() {
		return instance;
	}

	public void agregarCamara(Camara camara) {
		withTransaction(() -> {
			entityManager().persist(camara);
		});
	}

	public void quitarCamara(Camara camara) {
		withTransaction(() -> {
			entityManager().remove(camara);
		});
	}

	public Camara modificarCamara(int id, String ip) {
		return withTransaction(() -> {
			Camara camara = entityManager().find(Camara.class, id);
			camara.setIp(ip);
			return camara;
		});
	}

	public List<Camara> listarCamaras() {
		List<Camara> camaras = entityManager().createQuery("from Camara", Camara.class).getResultList();
		camaras.stream().forEach(camara -> entityManager().refresh(camara));
		return camaras;
	}

	public Camara getCamara(int id) {
		return entityManager().find(Camara.class, id);
	}

}
