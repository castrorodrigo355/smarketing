package utn.frba.proyecto.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import utn.frba.proyecto.enums.Sexo;

@Entity
@Table(name = "Publicidades")
public class Publicidad {

	@Id
	@GeneratedValue
	private int id;
	private Sexo sexo;
	private int edad_min;
	private int edad_max;
	private int horario_min;
	private int horario_max;
	private String descripcion;
	private String path;

	public Publicidad() {

	}

	public Publicidad(Sexo sexo, int edad_min, int edad_max, int horario_min, int horario_max, String descripcion,
			String path) {
		this.edad_max = edad_max;
		this.edad_min = edad_min;
		this.horario_max = horario_max;
		this.horario_min = horario_min;
		this.sexo = sexo;
		this.descripcion = descripcion;
		this.path = path;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad_min() {
		return edad_min;
	}

	public void setEdad_min(int edad_min) {
		this.edad_min = edad_min;
	}

	public int getEdad_max() {
		return edad_max;
	}

	public void setEdad_max(int edad_max) {
		this.edad_max = edad_max;
	}

	public int getHorario_min() {
		return horario_min;
	}

	public void setHorario_min(int horario_min) {
		this.horario_min = horario_min;
	}

	public int getHorario_max() {
		return horario_max;
	}

	public void setHorario_max(int horario_max) {
		this.horario_max = horario_max;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pub_id")
	private Oferta oferta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id")
	private Marca marca;

}
