package mongoDB.M101J.class1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {

	public static void main(String[] args) {
	Spark.get("/", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				return "Hello World ";
			}
		});
	
	Spark.get("/test", new Route() {
		
		public Object handle(Request arg0, Response arg1) throws Exception {
			return "Hello World Test";
		}
	});
	
	Spark.get("/echo/:thing", new Route() {
		
		public Object handle(Request request, Response response) throws Exception {
			return request.params(":thing"); // return the input from url
		}
	});
	}

}
