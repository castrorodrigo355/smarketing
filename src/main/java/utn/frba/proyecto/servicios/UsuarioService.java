package utn.frba.proyecto.servicios;

import java.util.List;

import utn.frba.proyecto.entidades.Marca;
import utn.frba.proyecto.entidades.Usuario;
import utn.frba.proyecto.repositorios.RepositorioUsuario;

public class UsuarioService {

	public List<Usuario> listarUsuarios() {
		return RepositorioUsuario.getInstance().listarUsuarios();
	}

	public Usuario agregarUsuario(String nombre, String apellido, String password, String email, Marca marca) {
		Usuario usuario = new Usuario(nombre, apellido, password, email, marca);
		RepositorioUsuario.getInstance().agregarUsuario(usuario);
		return RepositorioUsuario.getInstance().getUsuarioByMail(email);
	}

	public void quitarUsuario(Usuario usuario) {
		RepositorioUsuario.getInstance().quitarUsuario(usuario);
	}

	public Usuario modificarUsuario(int id, String nombre, String apellido, String email, boolean admin) {
		return RepositorioUsuario.getInstance().modificarUsuario(id, nombre, apellido, email, admin);
	}

	public Usuario getUsuarioById(int id) {
		return RepositorioUsuario.getInstance().getUsuario(id);
	}

}
