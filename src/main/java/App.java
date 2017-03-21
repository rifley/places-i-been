import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("places", request.session().attribute("places"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/input", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Travel> places = request.session().attribute("places");
      if (places == null) {
        places = new ArrayList<Travel>();
        request.session().attribute("places", places);
      }

      String place = request.queryParams("destination");
      Travel newTravel = new Travel(place);
      places.add(newTravel);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
