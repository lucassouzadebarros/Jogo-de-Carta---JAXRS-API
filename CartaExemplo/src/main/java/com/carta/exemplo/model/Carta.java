package com.carta.exemplo.model;



import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.carta.exemplo.enuns.Classe;
import com.carta.exemplo.enuns.Tipo;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

public class Carta  {

	
	
	private Integer Id;          
	
	private String  Nome;      
	
	private int Ataque;   
		
	private int Defesa;  
	
		
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Classe classe;
	
	
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getAtaque() {
		return Ataque;
	}

	public void setAtaque(Integer ataque) {
		Ataque = ataque;
	}

	public Integer getDefesa() {
		return Defesa;
	}

	public void setDefesa(Integer defesa) {
		Defesa = defesa;
	}

	
	
	
	
	
}
