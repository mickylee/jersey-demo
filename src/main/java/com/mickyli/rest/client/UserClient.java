package com.mickyli.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mickyli.rest.bean.User;

public class UserClient {
	private static String serverUri = "http://localhost:8080/jersey/rest";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addUser();
		getAllUsers();
		updateUser();
		getUserById();
		getAllUsers();
		delUser();
		getAllUsers();

	}

	/**
	 * 添加用户
	 */
	private static void addUser() {
		System.out.println("****增加用户addUser****");
		User user = new User("006", "Susan", "21");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri + "/users");
		Response response = target.request()
				.buildPost(Entity.entity(user, MediaType.APPLICATION_XML))
				.invoke();
		response.close();
	}

	/**
	 * 删除用户
	 */
	private static void delUser() {
		System.out.println("****删除用户****");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri + "/users/006");
		Response response = target.request().delete();
		response.close();
	}

	/**
	 * 修改用户
	 */
	private static void updateUser() {
		System.out.println("****修改用户updateUser****");
		User user = new User("006", "Susan", "33");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri + "/users");
		Response response = target.request()
				.buildPut(Entity.entity(user, MediaType.APPLICATION_XML))
				.invoke();
		response.close();
	}

	/**
	 * 根据id查询用户
	 */
	private static void getUserById() {
		System.out.println("****根据id查询用户****");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri + "/users/006");
		Response response = target.request().get();
		User user = response.readEntity(User.class);
		System.out.println(user.getUserId() + user.getUserName()
				+ user.getAge());
		response.close();
	}

	/**
	 * 查询所有用户
	 */
	private static void getAllUsers() {  
         System.out.println("****查询所有getAllUsers****");  
           
         //Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);//注册json支持  
         Client client = ClientBuilder.newClient();
         //target.request(). 后面跟的是请求的方法:POST，GET，PUT或DELETE
         WebTarget target = client.target(serverUri + "/users");  
         Response response = target.request().get();  
         String value = response.readEntity(String.class);  
         System.out.println(value);  
         response.close();  //关闭连接  
	 }
}
