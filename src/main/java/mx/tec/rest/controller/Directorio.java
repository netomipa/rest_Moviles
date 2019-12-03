package mx.tec.rest.controller;

import mx.tec.rest.model.*;
import mx.tec.rest.service.*;

import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class Directorio {

    @GET
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new UsuarioService().findUsuarios();
        return usuarios;
    }

    @GET
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("id") int idUsuario) {
        Usuario usuario = new UsuarioService().findUsuarioById(idUsuario);
        return usuario;
    }

    @POST
    @Path("/validarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String validUsuario(@WebParam Usuario usuario) {
        return Boolean.toString(new UsuarioService().validarUsuario(usuario.getCorreo()));
    }

    @POST
    @Path("/validarSesion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario validSesion(@WebParam Usuario usuario) {
        Usuario result = new UsuarioService().validarSesion(usuario);
        return result;
    }

    @DELETE
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUsuario(@PathParam("id") int idUsuario) {
        return Boolean.toString(new UsuarioService().deleteUsuario(idUsuario));
    }

    @POST
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveUsuario(@WebParam Usuario usuario) {
        return Boolean.toString(new UsuarioService().createUsuario(usuario));
    }

    @PUT
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String editUsuario(@WebParam Usuario usuario) {
        return Boolean.toString(new UsuarioService().editUsuario(usuario));
    }

    @GET
    @Path("/cajon")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cajon> getCajones(){
        return new CajonService().findCajones();
    }

    @GET
    @Path("/cajon/{seccion}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cajon> getCajonesBySeccion(@PathParam("seccion")String seccion){
        return new CajonService().findCajonesBySeccion(seccion);
    }

    @GET
    @Path("/cajon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cajon getCajon(@PathParam("id") int idCajon) {
        return new CajonService().findCajonById(idCajon);
    }

    @DELETE
    @Path("/cajon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCajon(@PathParam("id") int idCajon) {
        return Boolean.toString(new CajonService().deleteCajon(idCajon));
    }

    @POST
    @Path("/cajon")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveCajon(@WebParam Cajon cajon) {
        return Boolean.toString(new CajonService().saveCajon(cajon));
    }

    @PUT
    @Path("/cajon")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String editCajon(@WebParam Cajon cajon) {
        return Boolean.toString(new CajonService().editCajon(cajon));
    }

    @PUT
    @Path("/cajon/cambiarEstado")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cambiarEstadoByIdUsuario(@WebParam Cajon cajon){
        return Boolean.toString(new CajonService().cambiarEstadoByIdUsuario(cajon));
    }

    @PUT
    @Path("/ocuparCajon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String ocuparCajon(@PathParam("id") int idCajon) {
        return Boolean.toString(new CajonService().ocuparCajon(idCajon));
    }

    @PUT
    @Path("/liberarCajon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String liberarCajon(@PathParam("id") int idCajon) {
        return Boolean.toString(new CajonService().liberarCajon(idCajon));
    }
}