package com.mickyli.rest.resources;

import java.util.ArrayList;
import java.util.List;

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
import com.mickyli.rest.dao.impl.UserDaoImpl;

@Path("/users")  
public class UserResource {  
    private UserDaoImpl userDaoImpl = new UserDaoImpl();  
    /** 
     * 增加 
     * @param user 
     */  
    @POST  
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    public void createUser(User user)  
    {  
        userDaoImpl.createUser(user);  
    }  
      
    /** 
     * 删除 
     * @param id 
     */  
    @DELETE  
    @Path("{id}")  
    public void deleteUser(@PathParam("id")String id){  
        userDaoImpl.deleteUserById(id);  
    }  
      
    /** 
     * 修改 
     * @param user 
     */  
    @PUT  
    @Consumes(MediaType.APPLICATION_XML)  
    public void updateUser(User user){  
        userDaoImpl.updateUser(user);  
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
        User u = userDaoImpl.getUserById(id);  
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
        users = userDaoImpl.getAllUsers();  
        return users;  
    }  
}