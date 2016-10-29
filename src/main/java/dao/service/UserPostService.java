package dao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dao.impl.UserPostDaoImpl;
import model.UserPostBean;
import model.entity.UserPost;

@Path("/userPost")
public class UserPostService {

	

	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<UserPost> getUserPosts() {
		UserPostDaoImpl dao = new UserPostDaoImpl();
		@SuppressWarnings("rawtypes")
		List userPosts = dao.getUserPosts();
		return userPosts;
		}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addUserPost(UserPostBean userPost){
		UserPostDaoImpl dao = new UserPostDaoImpl();
		dao.createUserPost(userPost);
		return Response.ok().build();
		}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteUserPost(@PathParam("id") long id){
		UserPostDaoImpl dao = new UserPostDaoImpl();
		int count = dao.deleteUserPost(id);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
		return Response.ok().build();
		}
}
