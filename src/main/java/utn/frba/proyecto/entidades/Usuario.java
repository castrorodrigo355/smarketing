package utn.frba.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private boolean admin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id")
	private Marca marca;

	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Usuario(String nombre, String apellido, String password, String email, boolean admin) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public Usuario(String nombre, String apellido, String password, String email, Marca marca) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.marca = marca;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
