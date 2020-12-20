package br.com.desafio.star.wars.service;

import br.com.desafio.star.wars.model.especie.BuscaEspecieDTO;
import br.com.desafio.star.wars.model.filme.BuscaFilmeDTO;
import br.com.desafio.star.wars.model.nave.BuscaNaveDTO;
import br.com.desafio.star.wars.model.personagem.BuscaPersonagemDTO;
import br.com.desafio.star.wars.model.planeta.BuscaPlanetaDTO;
import br.com.desafio.star.wars.model.veiculo.BuscaVeiculoDTO;

public interface BuscarServices {

	BuscaPersonagemDTO getPersonagens(String personagem, Long pagina);
	BuscaFilmeDTO getFilmes(String filme, Long pagina);
	BuscaPlanetaDTO getPlanetas(String planeta, Long pagina);
	BuscaNaveDTO getNaves(String nave, Long pagina);
	BuscaEspecieDTO getEspecies(String especie, Long pagina);
	BuscaVeiculoDTO getVeiculos(String veiculo, Long pagina);
}
