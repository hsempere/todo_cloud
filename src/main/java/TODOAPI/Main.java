package TODOAPI;

import spark.Spark;

public class Main {

	public static void main(String[] args) {
		JsonTransformer jsonTransformer = new JsonTransformer();
		
		Spark.port(8080);
		
		Spark.options("/*", (request, response) -> {
			response.header("Access-Control-Allow-Headers", "*");
			response.header("Access-Control-Allow-Methods", "*");
			return "OK";
		});
		Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

		Spark.get("/TODO", TODOService::get, jsonTransformer);
		Spark.get("/TODO/search", TODOService::search, jsonTransformer);
		
//		Spark.post("/TODO", TODOService::post, jsonTransformer);
//		Spark.put("/TODO/:id", TODOService::put, jsonTransformer);
//		
//		Spark.delete("/TODO/:id", TODOService::deleteId, jsonTransformer);
		
		/*Spark.get("/todos", (req, res) -> {
			res.type("application/json");
			return auxTODO;
		}, new JsonTransformer());*/
	}

}
