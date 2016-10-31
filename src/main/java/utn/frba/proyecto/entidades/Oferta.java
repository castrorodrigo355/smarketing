package utn.frba.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ofertas")
public class Oferta {

	@Id
	@GeneratedValue
	private int id;
	private String descripcion;

}
