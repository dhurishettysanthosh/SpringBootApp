package factory.software.santhosh.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import factory.software.santhosh.model.Employee;

public class RestClient {
	private static final String GET_ALL_EMPLOYEES_API = "http://localhost:8080/api/v1/Employee/all";
	private static final String GET_EMPLOYEES_BY_ID_API = "http://localhost:8080/api/v1/Employee/employee/id";
	private static final String CREATE_EMPLOYEES_API = "http://localhost:8080/api/v1/Employee/save";
	private static final String UPDATE_EMPLOYEES_API = "http://localhost:8080/api/v1/Employee/modify/id";
	private static final String DELETE_EMPLOYEES_API = "http://localhost:8080/api/v1/Employee/delete/id";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		callGetAllEmployee();
	//	callGetuserById();
		callCreateEmployeeAPI();
		callUpdateEmployeeAPI();
		callDeleteAPI();
	}

	private static void callGetAllEmployee() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parametres", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity,
				String.class);
		System.out.println(result);
		System.out.println("=================================");

	}
	
	private static void callGetuserById() {
		Map<String,Integer> ids=new  HashMap<>();
		ids.put("id", 10);
		Employee em= restTemplate.getForObject(GET_EMPLOYEES_BY_ID_API, Employee.class, ids);
	System.out.println(em.getAge()+"/t"+em.getDesignation()+"/t"+em.getQualification()+"/t"+em.getName());
	System.out.println("=================================");
	}
	private static void callCreateEmployeeAPI() {
		Employee e=new Employee();
		e.setId(15);
		e.setAge(30);
		e.setDesignation("bowler");
		e.setQualification("inter");
		e.setName("bhuvneswar");
		ResponseEntity<Employee> entity = restTemplate.postForEntity(CREATE_EMPLOYEES_API, e, Employee.class);
		System.out.println(entity.getBody());
		
		System.out.println("=================================");
		
	}
	
	private static void callUpdateEmployeeAPI() {
		Map<String,Integer> ids=new  HashMap<>();
		ids.put("id", 10);
		Employee e=new Employee();
		e.setId(15);
		e.setAge(30);
		e.setDesignation("fastbowler");
		e.setQualification("inter");
		e.setName("bhuvneswar kumar");
		restTemplate.put(UPDATE_EMPLOYEES_API, e, ids);
		System.out.println("=================================");
	}
	
	private static void callDeleteAPI() {
		Map<String,Integer> ids=new  HashMap<>();
		ids.put("id", 10);
restTemplate.delete(DELETE_EMPLOYEES_API, ids);
System.out.println("=================================");
	}
	
	

}
