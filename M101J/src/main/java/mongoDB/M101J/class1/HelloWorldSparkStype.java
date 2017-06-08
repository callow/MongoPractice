package mongoDB.M101J.class1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkStype {
	public static void main(String[] args) {
		Spark.get("/", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				return "Hello World ";
			}
		});
	}
}
