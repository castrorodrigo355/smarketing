package utn.frba.proyecto.controladores;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static utn.frba.proyecto.utils.JSONUtils.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utn.frba.proyecto.entidades.Marca;
import utn.frba.proyecto.entidades.Usuario;
import utn.frba.proyecto.servicios.MarcaService;
import utn.frba.proyecto.servicios.UsuarioService;

public class UsuarioController {

	public UsuarioController(final UsuarioService usuarioService) {

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		MarcaService marcaService = new MarcaService();

		get("/usuarios", (request, response) -> {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Usuario> usuarios = usuarioService.listarUsuarios();
			List<Marca> marcas = marcaService.listarMarcas();
			map.put("usuarios", usuarios);
			map.put("marcas", marcas);
			return new ModelAndView(map, "usuarios.hbs");
		}, engine);

		get("/usuarios/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			return usuarioService.getUsuarioById(id);
		}, json());

		put("/usuarios/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			String nombre = req.queryParams("nombre");
			String apellido = req.queryParams("apellido");
			String password = req.queryParams("password");
			String email = req.queryParams("email");
			boolean admin = Boolean.parseBoolean(req.queryParams("admin"));
			return usuarioService.modificarUsuario(id, nombre, apellido, email, admin);

		}, json());

		delete("/usuarios/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			Usuario usuario = usuarioService.getUsuarioById(id);
			usuarioService.quitarUsuario(usuario);
			return null;

		}, json());

		post("/usuarios", (req, res) -> {
			String nombre = req.queryParams("nombre");
			String apellido = req.queryParams("apellido");
			String password = req.queryParams("password");
			String email = req.queryParams("email");
			int marca_id = Integer.parseInt(req.queryParams("marca"));

			Marca marca = marcaService.getMarcaById(marca_id);

			return usuarioService.agregarUsuario(nombre, apellido, password, email, marca);

			// MarcaService marcaService = new MarcaService();
			// Marcas marca = marcaService.getMarca(marca_id);
			// Usuarios usuario = usuarioService.crearUsuario(nombre, apellido,
			// password, email, marca);
			// marca.agregarUsuario(usuario);
			// marcaService.modificarMarca(marca);
			// usuario.setMarca(marca);
			// res.redirect("/usuarios");
		}, json());
	}

}
