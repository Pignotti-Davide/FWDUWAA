package com.dao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.impl.UserDaoImpl;
import com.model.UserBean;
import com.model.entity.User;

@Path("/user")
public class UserService {

	

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<User> getUsers() {
		UserDaoImpl dao = new UserDaoImpl();
		@SuppressWarnings("rawtypes")
		List users = dao.getUsers();
		return users;
		}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addUser(UserBean user){
		UserDaoImpl dao = new UserDaoImpl();
		dao.createUser(user);
		return Response.ok().build();
		}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("id") long id){
		UserDaoImpl dao = new UserDaoImpl();
		int count = dao.deleteUser(id);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
		return Response.ok().build();
		}
}
