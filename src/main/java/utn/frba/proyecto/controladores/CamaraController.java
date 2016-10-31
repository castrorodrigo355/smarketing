package utn.frba.proyecto.controladores;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static utn.frba.proyecto.utils.JSONUtils.json;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utn.frba.proyecto.entidades.Camara;
import utn.frba.proyecto.servicios.CamaraService;

public class CamaraController {

	public CamaraController(final CamaraService camaraService) {

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		get("/camaras", (request, response) -> {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("camaras", camaraService.listarCamaras());
			return new ModelAndView(map, "camaras.hbs");
		}, engine);

		get("/camaras/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			return camaraService.getCamaraById(id);
		}, json());

		put("/camaras/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			String ip_dir = req.queryParams("ip_dir");
			return camaraService.modificarCamara(id, ip_dir);
		}, json());

		delete("/camaras/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			Camara camara = camaraService.getCamaraById(id);
			camaraService.quitarCamara(camara);
			return null;
		}, json());

		post("/camaras", (req, res) -> {
			String ip_dir = req.queryParams("ip_dir");
			return camaraService.agregarCamara(ip_dir);
		}, json());

	}

}
