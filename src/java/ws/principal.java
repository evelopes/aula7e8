/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ws;

import DAO.Funcionario;
import DAO.FuncionarioDao;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author eveli
 */
@Path("rest")
public class principal {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of principal
     */
    public principal() {
    }

    /**
     * Retrieves representation of an instance of ws.principal
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
       return "teste";
    }
    
       
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public String getFuncionarios() {
         FuncionarioDao dao = new FuncionarioDao();
        ArrayList<Funcionario> listaFuncionarios = dao.getLista();
        Gson gson = new Gson();
        return gson.toJson(listaFuncionarios);
    }
    
           
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("funcionarios/{numat}")
    public String getFuncionarioNumat(@PathParam("numat") int numat) {
         FuncionarioDao dao = new FuncionarioDao();
         Funcionario funcionario = dao.consulta(numat);
        Gson gson = new Gson();
        return gson.toJson(funcionario);
    }
    
    
        @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("supervisores")
    public String getSupervisores() {
         FuncionarioDao dao = new FuncionarioDao();
        ArrayList<Funcionario> listaSupervisores = dao.getSupervisores();
        Gson gson = new Gson();
        return gson.toJson(listaSupervisores);
    }
    
    
        
        @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("funcionarios/{numat}")
    public Response delFuncionario(@PathParam("numat") int numat) {
         FuncionarioDao dao = new FuncionarioDao();
        if(dao.remove(numat)){
            return Response.status(Response.Status.OK).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
         
    }
    
          
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public Response addFuncionario(String content) {
        Gson gson = new Gson();
        Funcionario funcionario = (Funcionario) gson.fromJson(content, Funcionario.class);
        FuncionarioDao dao =  new FuncionarioDao();
        
        try{
            dao.adiciona(funcionario);
        }catch(RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
        return Response.status(Response.Status.OK).build();
   
         
    }
    
    
    
    
    
    
    /**
     * PUT method for updating or creating an instance of principal
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public Response setFuncionario(String content) {
        Gson gson = new Gson();
        Funcionario funcionario = (Funcionario) gson.fromJson(content, Funcionario.class);
        FuncionarioDao dao =  new FuncionarioDao();
        
        try{
            if(dao.atualiza(funcionario)){
            return Response.status(Response.Status.OK).build();
            }else{
            return Response.status(Response.Status.NOT_FOUND).build();
            }
        }catch(RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
        
         
        
    }
}
