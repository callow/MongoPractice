package mongoDB.M101J.class1;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFormHandling {

	public static void main(String[] args) {
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(SparkFormHandling.class, "/");
		
		Spark.get("/", new Route() { // load all the fruits choices to the page
			
			public Object handle(Request request, Response response) throws Exception {
				Map<String,Object> fruitsMap = new HashMap<String, Object>();
				fruitsMap.put("fruits", Arrays.asList("apple","banana","orange","peach"));
				Template fruitTemplete = config.getTemplate("fruitPicker.ftl");
				
				StringWriter writer = new StringWriter();
				fruitTemplete.process(fruitsMap, writer);
				return writer;
			}
		});
		
	    Spark.post("/favorite_fruit", new Route() { // when user submit button, trigger a post request
			
			public Object handle(Request request, Response response) throws Exception {
				final String fruit = request.queryParams("fruit");
				if (fruit == null) {
					return "Why don't you pick one ?";
				} else {
					return "Your favourite fruit is " + fruit;
				}
			}
		});
	}
}
