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

import dao.impl.CommentDaoImpl;
import model.CommentBean;
import model.entity.Comment;

@Path("/comment")
public class CommentService {

	
	@SuppressWarnings("unchecked")
	@GET
	@Produces("application/json")
	public List<Comment> getComments() {
		CommentDaoImpl dao = new CommentDaoImpl();
		@SuppressWarnings("rawtypes")
		List comments = dao.getComments();
		return comments;
		}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response addComment(CommentBean comment){
		CommentDaoImpl dao = new CommentDaoImpl();
		dao.createComment(comment);
		return Response.ok().build();
		}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteComment(@PathParam("id") long id){
		CommentDaoImpl dao = new CommentDaoImpl();
		int count = dao.deleteComment(id);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
			}
		return Response.ok().build();
		}
}
