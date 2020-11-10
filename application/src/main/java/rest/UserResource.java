package rest;

import DTOs.UserDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errorhandling.DatabaseException;
import errorhandling.UserCreationException;
import facades.UserFacade;
import entities.User;
import errorhandling.UserNotFound;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author Mathias Nielsen
 */
@Path("info")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("User")
    public Response getFromUser() {
        String thisUser = securityContext.getUserPrincipal().getName();
        return Response.ok("{\"msg\": \"Hello to User: " + thisUser + "\"}").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("Admin")
    public Response getFromAdmin() {
        String thisUser = securityContext.getUserPrincipal().getName();
        return Response.ok("{\"msg\": \"Hello to (admin) User: " + thisUser + "\"}").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allUsers")
    @RolesAllowed("admin")
    public Response getAllUsers(){
        List<UserDTO> users = FACADE.getAllUsers();
        return Response.ok(users).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUser")
    @RolesAllowed("User")
    public Response getUser(User user) throws UserNotFound{
        UserDTO userDTO = FACADE.getUserByUserName(user.getUserName());
        return Response.ok(userDTO).build();
    }

    
}
