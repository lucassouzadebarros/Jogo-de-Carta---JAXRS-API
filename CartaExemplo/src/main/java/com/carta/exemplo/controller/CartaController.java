package com.carta.exemplo.controller;

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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.carta.exemplo.model.Carta;
import com.carta.exemplo.repository.CartaRepository;

@Path("carta")
public class CartaController {
	
	
	CartaRepository cartarepositorio = new CartaRepository();
	
	    @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response post(Carta carta)
	    	    
	    {
	        return	cartarepositorio.Add(carta);
	                
	    }


	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carta> GetAll() {
		
		return cartarepositorio.GetAll();
	}
	
	@GET
	@Path(value = "nome/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carta GetByName(@PathParam(value = "nome") String nome) {
		
		return cartarepositorio.BuscaNome(nome);
	}
	
	@GET
	@Path(value = "tipo/{tipo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carta> GetByType(@PathParam(value = "tipo") String tipo) {
		
		return cartarepositorio.BuscaTipo(tipo);
	}
	
	@GET
	@Path(value = "classe/{classe}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carta> GetByClass(@PathParam(value = "classe") String classe) {
		
		return cartarepositorio.BuscaClasse(classe);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Update(Carta carta) {
		
		return cartarepositorio.Editar(carta);
	}
	
	
	@DELETE
	@Path(value = "/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void Delete(int id) {
		
		cartarepositorio.Delete(id);
	}
	
	


}
