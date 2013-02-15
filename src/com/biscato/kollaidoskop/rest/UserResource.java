package com.biscato.kollaidoskop.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.biscato.kollaidoskop.model.User;
import com.biscato.kollaidoskop.persistence.UserDAO;

@Path("/users")
public class UserResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		UserDAO userDAO = new UserDAO();
 		return userDAO.getAllEntities();
	}

	@GET
	@Path("{id}")
	public User getUserForId(@PathParam("id") long id) {
		UserDAO userDAO = new UserDAO();
		//TODO: Error handling: a) wrong id b) no id (e.g. character instead of int) c) other error
		return userDAO.getEntityForId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(User user){
		//TODO: Error handling
		UserDAO usr = new UserDAO();
		return usr.createEntity(user);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	//TODO: return boolean for success or failure
	public void deleteAllUsers(){
		UserDAO usr = new UserDAO();
		usr.deleteAllEntities();
	}
}
