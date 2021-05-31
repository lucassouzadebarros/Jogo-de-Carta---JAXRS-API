package com.carta.validation;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CartaValidation {
	
	
	private int numero;
	
	
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public Boolean Validacao(Integer numero) {
		
		
		
		
			if (numero >= 0 & numero <= 10) {
				
				return true;
			} 
			else		
		        return false;
		
		
	}
	
	
	

}
