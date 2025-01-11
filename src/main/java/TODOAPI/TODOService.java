package TODOAPI;

import spark.Request;
import spark.Response;

public class TODOService {
	
	//private static TODOmemoDB TODODB = new TODOmemoDB();
	private static TODOrestDB TODODB = new TODOrestDB();
	//private static TODOfileDB TODODB = new TODOfileDB();

	public static Object get(Request request, Response response) {
		response.type("application/json");
		return TODODB.getAll();
	}
	
	public static Object search(Request request, Response response) {
		String title = request.queryParamOrDefault("title", "");

		Object t = null;
		t = TODODB.getSearchAll(title);
		response.type("application/json");
		response.status(200);
		return t;
	}
		
//	public static Object post(Request request, Response response) {
//		String title = request.queryParamOrDefault("title", "");
//
//		Object t = null;
//		if (!title.equals("")) {
//			t = TODODB.insertTODO(title);
//		} else {
//			response.status(400); //Bad request
//			return "Missing title";
//		}
//		if (t!=null) {
//			response.type("application/json");
//			response.status(201);
//			return t;
//		} else {
//			response.status(400); //Bad request
//			return "POST DB Error";
//		}
//	}
//	
//	public static Object put(Request request, Response response) {
//		String id = request.params("id");
//		int numId = Integer.parseInt(id);
//		
//		String title = request.queryParamOrDefault("title", "");
//		Object t = null;
//		
//		if (!title.equals("")) {
//			t = TODODB.modifyTODO(numId, title);
//			if (t==null) {
//				response.status(404);
//				return "TODO Not found";
//			}
//		} else {
//			response.status(400);
//			return "Missing title";
//		}
//		response.type("application/json");
//		response.status(200);
//		return t;
//	}
//	
//	public static Object deleteId(Request request, Response response) {
//		String id = request.params("id");
//		int numId = Integer.parseInt(id);
//		Object t = null;
//
//		t = TODODB.deleteTODO(numId);
//		if (t==null) {
//			response.status(404); 
//			return "TODO Not found";
//		}
//		
//		response.type("application/json");
//		response.status(200);
//		return t;
//	}

}
