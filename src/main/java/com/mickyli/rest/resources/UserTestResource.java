package com.mickyli.rest.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mickyli.rest.bean.User;

@Path("/userstest")
public class UserTestResource {
	private static Map<String, User> userMap = new HashMap<String, User>();// 存储用户

	@GET
	@Path("/getUserXml")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserXml() {
		User user = new User();
		user.setAge("21");
		user.setUserId("004");
		user.setUserName("Amand");
		return user;
	}
	@GET    
	@Path("/getUserJson")    
	@Produces(MediaType.APPLICATION_JSON)    
	public User getUserJson() {    
	 User user  = new User();    
	 user.setAge("27");    
	 user.setUserId("005");    
	 user.setUserName("Fmand");    
	 return user;    
	}
	
	/** 
     * 增加 
     * @param user 
     */  
    @POST  
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    public void createStudent(User user)  
    {  
        userMap.put(user.getUserId(), user );  
    }  
      
    /** 
     * 删除 
     * @param id 
     */  
    @DELETE  
    @Path("{id}")  
    public void deleteStudent(@PathParam("id")String id){  
        userMap.remove(id);  
    }  
      
    /** 
     * 修改 
     * @param user 
     */  
    @PUT  
    @Consumes(MediaType.APPLICATION_XML)  
    public void updateStudent(User user){  
        userMap.put(user.getUserId(), user );  
    }  
   
    /** 
     * 根据id查询 
     * @param id 
     * @return 
     */  
    @GET  
    @Path("{id}")  
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    public User getUserById(@PathParam("id") String id){  
        User u = userMap.get(id);  
        return u;  
    }  
     
    /** 
     * 查询所有 
     * @return 
     */  
    @GET  
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    public List<User> getAllUsers(){       
        List<User> users = new ArrayList<User>();     
        users.addAll( userMap.values() );    
        return users;  
    }
}
