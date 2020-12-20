package br.com.desafio.star.wars.service;

import br.com.desafio.star.wars.model.termo.TermoPaginaDTO;

public interface TermoServices {

	TermoPaginaDTO all(Integer pagina);
	TermoPaginaDTO findTermosPersonagens(Integer pagina);
	TermoPaginaDTO findTermosFilmes(Integer pagina);
	TermoPaginaDTO findTermosPlanetas(Integer pagina);
	TermoPaginaDTO findTermosNaves(Integer pagina);
	TermoPaginaDTO findTermosEspecies(Integer pagina);
	TermoPaginaDTO findTermosVeiculos(Integer pagina);
}
