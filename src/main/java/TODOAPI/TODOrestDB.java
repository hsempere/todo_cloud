package TODOAPI;

import java.util.Collection;
import java.util.List;

import kong.unirest.GenericType;
import kong.unirest.Unirest;

public class TODOrestDB {
	private String REST_URL = "https://todos-9407.restdb.io/rest/tasks";
	private String REST_APIKEY = "a0a9de622d50e7b70776fda4793fbf5facb14";
	
	public Collection<TODO> getAll() {
		List<TODO> todos = Unirest.get(REST_URL)
				.header("x-apikey", REST_APIKEY)
				.asObject(new GenericType<List<TODO>>(){})
				.getBody();
		return todos;
	}
	
	public Collection<TODOSoloTitle> getSearchAll(String text) {
		
//		String search = "{\"title\":\""+text+"\"}";
		
		String search = "{\"title\": \""+text+"\"}";
		String fields = "{\"$fields\": {\"title\": 1, \"_mock\": 1}}";
		
		List<TODOSoloTitle> todos = Unirest.get(REST_URL)
				.header("x-apikey", REST_APIKEY)
				.header("Content-Type", "application/json")
				.queryString("q", search)
				.queryString("h", fields)
				.asObject(new GenericType<List<TODOSoloTitle>>(){})
				.getBody();
		return todos;
	}
	
//	public TODO getTODO(String id) {
//		TODO todo = Unirest.get(REST_URL+"/{id}")
//				.routeParam("id", id)
//				.header("x-apikey", REST_APIKEY)
//				.header("Content-Type", "application/json")
//				.asObject(TODO.class)
//				.getBody();
//			return todo;
//	}
//	
//	public TODO insertTODO(String title) {
//		TODO t = new TODO(title);
//
//		TODO nuevo = Unirest.post(REST_URL)
//				.header("x-apikey", REST_APIKEY)
//				.header("Content-type", "application/json")
//				.body(t)
//				.asObject(TODO.class)
//				.getBody();
//		return nuevo;
//	}
//	
//	public TODO modifyTODO(int id, String title) {
//		String idTxt = Integer.toString(id); 
//		TODO t = getTODO(idTxt);
//		if (t == null) return null;
//		
//		t = new TODO(title);
//		TODO nuevo = Unirest.put(REST_URL+"/{id}")
//			.routeParam("id", idTxt)
//			.header("x-apikey", REST_APIKEY)
//			.header("Content-Type", "application/json")
//			.body(t)
//			.asObject(TODO.class)
//			.getBody();
//		return nuevo;
//	}
//	
//	public TODO deleteTODO(int id) {
//		String idTxt = Integer.toString(id); 
//		TODO t = getTODO(idTxt);
//		if (t == null) return null;
//		Unirest.delete(REST_URL+"/{id}")
//			.routeParam("id", idTxt)
//			.header("x-apikey", REST_APIKEY)
//			.header("Content-Type", "application/json")
//			.asObject(TODO.class)
//			.getBody();
//		return t;
//	}
}
