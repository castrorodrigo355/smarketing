package utn.frba.proyecto.controladores;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utn.frba.proyecto.servicios.PublicidadService;

public class PublicidadController {

	public PublicidadController(final PublicidadService publicidadService) {

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

		get("/publicidades", (request, response) -> {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("publicidades", publicidadService.listarPublicidades());

			return new ModelAndView(map, "publicidades.hbs");
		}, engine);

		post("/publicidad", "multipart/form-data", (request, response) -> {
			MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
			request.raw().setAttribute("org.eclipse.multipartConfig", multipartConfigElement);

			try (InputStream is = request.raw().getPart("publicidad").getInputStream()) {

				byte[] data = new byte[1024];

				FileOutputStream fos = null;
				File f = null;

				f = new File(
						"src/main/resources/public/publicidades/" + getFileName(request.raw().getPart("publicidad")));
				fos = new FileOutputStream(f);

				int read = is.read(data);

				while (read != -1) {
					fos.write(data, 0, read);
					read = is.read(data);
				}

				fos.close();

				return "Se subio el archivo";

			} catch (IOException e) {
				throw new RuntimeException();
			}
		});

	}

	private static String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
