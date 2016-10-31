package utn.frba.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Camaras")
public class Camara {

	@Id
	@GeneratedValue
	private int id;
	private String ip;

	@OneToMany
	@JoinColumn(name = "cam_id")
	private List<Televisor> televisores = new ArrayList<Televisor>();

	public Camara() {

	}

	public Camara(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<Televisor> getTelevisores() {
		return televisores;
	}

	public void setTelevisores(List<Televisor> televisores) {
		this.televisores = televisores;
	}

	public void agregarTelevisor(Televisor televisor) {
		this.televisores.add(televisor);
	}

	public void quitarTelevisor(Televisor televisor) {
		this.televisores.remove(televisor);
	}

}
