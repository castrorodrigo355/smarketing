package utn.frba.proyecto.servicios;

import java.util.List;

import utn.frba.proyecto.entidades.Publicidad;
import utn.frba.proyecto.enums.Sexo;
import utn.frba.proyecto.repositorios.RepositorioPublicidad;

public class PublicidadService {

	public List<Publicidad> listarPublicidades() {
		return RepositorioPublicidad.getInstance().listarPublicidades();

	}

	public Publicidad agregarPublicidad(Sexo sexo, int edadMin, int edadMax, int horarioMin, int horarioMax,
			String descripcion, String path) {
		Publicidad publicidad = new Publicidad(sexo, edadMin, edadMax, horarioMin, horarioMax, descripcion, path);
		RepositorioPublicidad.getInstance().agregarPublicidad(publicidad);
		return publicidad;
	}

}
