package com.carta.exemplo.validation;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CartaValidation {
	
	
	private int numeros;
	
	
	

	public int getNumero() {
		return numeros;
	}

	public void setNumero(int numero) {
		this.numeros = numero;
	}
	
	
	public Boolean Validacao(Integer numero) {
		
		
		
		
			if (numero >= 0 & numero <= 10) {
				
				return true;
			} 
			else		
		        return false;
		
		
	}
	
	
	

}
