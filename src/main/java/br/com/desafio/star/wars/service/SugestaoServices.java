package br.com.desafio.star.wars.service;

import java.util.List;

public interface SugestaoServices {

	List<String> sugestaoPorDominioTermo(String dominio, String termo);
	List<String> sugestaoPorTermo(String termo);
}
