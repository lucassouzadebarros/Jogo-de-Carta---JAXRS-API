package com.carta.exemplo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.carta.exemplo.controller.CartaController;

@Component
@ApplicationPath(value = "api")
public class CartaAppConfig extends ResourceConfig{

	public CartaAppConfig() {
		
		register(CartaController.class);
		packages("com.frugalis.JersayExemplo.resources");
	}
	
}
