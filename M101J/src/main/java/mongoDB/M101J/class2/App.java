package mongoDB.M101J.class2;

import org.bson.Document;

public class App {

	public static void main(String[] args) {
		Document document = new Document().append("str", "Hello Mongo");
		document.getString("str");
	}

}
