package com.carta.exemplo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import com.carta.exemplo.enuns.Classe;
import com.carta.exemplo.enuns.Tipo;
import com.carta.exemplo.model.Carta;
import com.carta.exemplo.validation.CartaValidation;

public class CartaRepository {


	 private final static HashMap<Integer, Carta> cartas = new HashMap<>();
	 
	 public List<Carta> GetAll(){
		 
	        return new ArrayList<Carta>(cartas.values());
	    }

	 
	 /*Consulta de cartas por ID */
	    public Carta Get(Integer id) {
	        return cartas.get(id);
	    }
	    
	    /* Consulta de cartas por Nome */    
	    public Carta BuscaNome( String Nome) {
	    	
	    ArrayList<Carta> cartabyname = new ArrayList<>();
	                     cartabyname = new ArrayList<Carta>(cartas.values());
	    	
	    		    	
	    	for (Carta carta  : cartabyname) {
	    		 	    		
	    	        if(carta.getNome().equalsIgnoreCase(Nome)) {
	    	    	   	          
	    	             return carta;
	    	        }
			}
			return null;
	    	
	    	
	    }

	    public List<Carta> BuscaClasse(String Classe) {
	    	
		      ArrayList<Carta> cartabyclasse = new ArrayList<Carta>(cartas.values());
		      ArrayList<Carta> ClasseRetorno = new ArrayList<>();
		      
		    	for (Carta  carta  : cartabyclasse) {
		    		 Classe classe = carta.getClasse();
		    		     if(classe.name().equalsIgnoreCase(Classe)) {
		    		    	 ClasseRetorno.add(carta);
		    	        }
				}
				return ClasseRetorno;
		    	
		    	
		    }
	    
	    public List<Carta> BuscaTipo(String Tipo) {
	    	
		      ArrayList<Carta> cartabytipo = new ArrayList<Carta>(cartas.values());
		      ArrayList<Carta> ClasseRetorno = new ArrayList<>();
		    	for (Carta  carta  : cartabytipo) {
		    		 Tipo tipo = carta.getTipo();
		    		     if(tipo.name().equalsIgnoreCase(Tipo)) {
		    		    	 ClasseRetorno.add(carta);
		    	        }
				}
				return ClasseRetorno;
		    	
		    	
		    }

	    
	    
	    
	    public Response Add(Carta carta) {
	    	
	    	CartaValidation cartavalidation = new CartaValidation();
			
	    	
	    if(cartavalidation.Validacao(carta.getAtaque()) == true & cartavalidation.Validacao(carta.getDefesa()) == true) {
	    	try {
	    		
	    		 carta.setId(generateId(cartas.size() + 1));
		    	 cartas.put(carta.getId(), carta);
		    	 return Response.status(Response.Status.CREATED).entity(carta).build();
		    	 
			}
	    	
	    	catch (Exception e) {
				 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
	    } else
	    	
	    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Exception.class).build();
	    
	    		    	
	    	 
	         
	       
	    }

	    public Response Editar(Carta carta) {
	    	
	    	try {
	    			    		
	    		cartas.remove(carta.getId());
		    	cartas.put(carta.getId(), carta);
		    	return Response.status(Response.Status.CREATED).entity(carta).build();
		    	
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
	    	
	    }

	    public void Delete( Integer id) {
	    	cartas.remove(id);
	    }

	    private int generateId(Integer possible)
	    {
	        if(cartas.containsKey(possible))
	            return generateId(possible + 1);
	        return possible;
	    }

}
