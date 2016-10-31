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

@Entity
@Table(name = "Publicidades")
public class Publicidad {

	@GeneratedValue
	@Id
	private int id;
	private String sexo;
	private int edad_min;
	private int edad_max;
	private int horario_min;
	private int horario_max;
	private String descripcion;
	private String path;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pub_id")
	private Oferta oferta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id")
	private Marca marca;

}
