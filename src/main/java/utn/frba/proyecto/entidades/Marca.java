package utn.frba.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Marcas")
public class Marca {

	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String descripcion;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_id")
	private List<Publicidad> publicidades = new ArrayList<Publicidad>();

	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "marca_id")
	// private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Marca() {

	}

	public Marca(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Publicidad> getPublicidades() {
		return publicidades;
	}

	public void setPublicidades(List<Publicidad> publicidades) {
		this.publicidades = publicidades;
	}

	// public List<Usuario> getUsuarios() {
	// return usuarios;
	// }
	//
	// public void setUsuarios(List<Usuario> usuarios) {
	// this.usuarios = usuarios;
	// }

}
