package utn.frba.proyecto.repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import utn.frba.proyecto.entidades.Usuario;

public class RepositorioUsuario implements WithGlobalEntityManager, TransactionalOps {

	private static RepositorioUsuario instance = new RepositorioUsuario();

	public static RepositorioUsuario getInstance() {
		return instance;
	}

	public void agregarUsuario(Usuario usuario) {
		withTransaction(() -> {
			entityManager().persist(usuario);
		});
	}

	public void quitarUsuario(Usuario usuario) {
		withTransaction(() -> {
			entityManager().remove(usuario);
		});
	}

	public Usuario modificarUsuario(int id, String nombre, String apellido, String email, boolean admin) {
		return withTransaction(() -> {
			Usuario usuario = entityManager().find(Usuario.class, id);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			usuario.setAdmin(admin);
			return usuario;
		});
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = entityManager().createQuery("from Usuario", Usuario.class).getResultList();
		usuarios.stream().forEach(usuario -> entityManager().refresh(usuario));
		return usuarios;
	}

	public Usuario getUsuario(int id) {
		return entityManager().find(Usuario.class, id);
	}

	public Usuario getUsuarioByMail(String email) {
		return entityManager().createQuery("from Usuario U where U.email = :email", Usuario.class)
				.setParameter("email", email).getSingleResult();
	}

}
