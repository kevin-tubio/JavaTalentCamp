package com.github.sanchezih.jersey.service;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.sanchezih.jersey.entity.Usuario;

@Path("/users")
public class UsuarioService {

	private static final Map<String, Usuario> USUARIOS = new HashMap<>();

	public UsuarioService() {
		USUARIOS.put("mperez", new Usuario("mperez", "Mariela"));
		USUARIOS.put("jlopez", new Usuario("jlopez", "Juan"));
		USUARIOS.put("savila", new Usuario("savila", "Sol"));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(new ArrayList<>(USUARIOS.values())).build();
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByUsername(@PathParam("username") String username) {
		if (USUARIOS.get(username) == null) {
			return Response.status(Status.BAD_REQUEST).entity("Usuario no encontrado").build();
		}

		return Response.ok(USUARIOS.get(username)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Usuario userRequest) {
		if (USUARIOS.get(userRequest.getUsername()) != null)
			return Response.status(Status.BAD_REQUEST).entity("Ya existe un usuario con ese username").build();

		USUARIOS.put(userRequest.getUsername(), userRequest);
		return Response.ok(new ArrayList<>(USUARIOS.values())).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(Usuario usuario) {
		Usuario found = USUARIOS.get(usuario.getUsername());
		if (found == null) {
			return Response.status(Status.BAD_REQUEST).entity("Usuario no encontrado").build();
		}

		found.setName(usuario.getName());
		return Response.ok(found).build();
	}

	@DELETE
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("username") String username) {
		Usuario found = USUARIOS.get(username);
		if (found == null) {
			return Response.status(Status.BAD_REQUEST).entity("Usuario no encontrado").build();
		}

		USUARIOS.remove(username);
		return Response.ok(new ArrayList<>(USUARIOS.values())).build();
	}

}
