package mongoDB.M101J;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldFreeMarkerCombineStyle {
	
	public static void main(String[] args) {
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(HelloWorldFreeMarkerCombineStyle.class, "/");
		
		Spark.get("/", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplete = config.getTemplate("hello.ftl");
					Map<String,Object> helloMap = new HashMap<String, Object>();
					helloMap.put("name", "FreeMarker");
					helloTemplete.process(helloMap, writer);
					System.out.println(writer);	
				} catch (Exception e) {
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
