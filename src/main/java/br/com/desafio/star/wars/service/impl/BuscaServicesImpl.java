package br.com.desafio.star.wars.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.star.wars.client.StarWarsApiClient;
import br.com.desafio.star.wars.model.client.film.SearchFilmDTO;
import br.com.desafio.star.wars.model.client.people.SearchPeopleDTO;
import br.com.desafio.star.wars.model.client.planet.SearchPlanetDTO;
import br.com.desafio.star.wars.model.client.specie.SearchSpecieDTO;
import br.com.desafio.star.wars.model.client.starship.SearchStarShipDTO;
import br.com.desafio.star.wars.model.client.vehicle.SearchVehicleDTO;
import br.com.desafio.star.wars.model.especie.BuscaEspecieDTO;
import br.com.desafio.star.wars.model.filme.BuscaFilmeDTO;
import br.com.desafio.star.wars.model.nave.BuscaNaveDTO;
import br.com.desafio.star.wars.model.personagem.BuscaPersonagemDTO;
import br.com.desafio.star.wars.model.planeta.BuscaPlanetaDTO;
import br.com.desafio.star.wars.model.veiculo.BuscaVeiculoDTO;
import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.repository.entity.Busca;
import br.com.desafio.star.wars.service.BuscarServices;
import br.com.desafio.star.wars.service.SugestaoServices;

@Service
public class BuscaServicesImpl implements BuscarServices {

	@Autowired
	private StarWarsApiClient starWarsClient;
	
	@Autowired
	private BuscaRepo buscaRepo;
	
	@Autowired
	private SugestaoServices sugestaoServices;
	
	@Override
	public BuscaPersonagemDTO getPersonagens(String personagem, Long pagina) {
		
		SearchPeopleDTO searchPeopleDTO = starWarsClient.findPeople(personagem, pagina);
		if (searchPeopleDTO.getResults().isEmpty()) {
			return new BuscaPersonagemDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("people", personagem);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("people", personagem.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("people");
			novaBusca.setTermo(personagem.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaPersonagemDTO(searchPeopleDTO, pagina, sugestoesBusca);
	}

	@Override
	public BuscaFilmeDTO getFilmes(String filme, Long pagina) {
		
		SearchFilmDTO searchFilmDTO = starWarsClient.findFilm(filme, pagina);
		if (searchFilmDTO.getResults().isEmpty()) {
			new BuscaFilmeDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("films", filme);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("films", filme.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("films");
			novaBusca.setTermo(filme.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaFilmeDTO(searchFilmDTO, pagina, sugestoesBusca);
	}

	@Override
	public BuscaPlanetaDTO getPlanetas(String planeta, Long pagina) {
		
		SearchPlanetDTO searchPlanetDTO = starWarsClient.findPlanet(planeta, pagina);
		if (searchPlanetDTO.getResults().isEmpty()) {
			new BuscaPlanetaDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("planets", planeta);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("planets", planeta.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("planets");
			novaBusca.setTermo(planeta.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaPlanetaDTO(searchPlanetDTO, pagina, sugestoesBusca);
	}

	@Override
	public BuscaNaveDTO getNaves(String nave, Long pagina) {
		
		SearchStarShipDTO searchStarShipDTO = starWarsClient.findStarShip(nave, pagina);
		if (searchStarShipDTO.getResults().isEmpty()) {
			new BuscaNaveDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("starships", nave);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("starships", nave.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("starships");
			novaBusca.setTermo(nave.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaNaveDTO(searchStarShipDTO, pagina, sugestoesBusca);
	}

	@Override
	public BuscaEspecieDTO getEspecies(String especie, Long pagina) {
		
		SearchSpecieDTO searchSpecieDTO = starWarsClient.findSpecie(especie, pagina);
		if (searchSpecieDTO.getResults().isEmpty()) {
			new BuscaEspecieDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("species", especie);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("species", especie.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("species");
			novaBusca.setTermo(especie.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaEspecieDTO(searchSpecieDTO, pagina, sugestoesBusca);
	}

	@Override
	public BuscaVeiculoDTO getVeiculos(String veiculo, Long pagina) {
		
		SearchVehicleDTO searchVehicleDTO = starWarsClient.findVehicle(veiculo, pagina);
		if (searchVehicleDTO.getResults().isEmpty()) {
			new BuscaVeiculoDTO();
		}
		
		List<String> sugestoesBusca = sugestaoServices.sugestaoPorDominioTermo("vehicles", veiculo);
		
		Optional<Busca> busca = buscaRepo.findByDominioAndTermo("vehicles", veiculo.toLowerCase());
		if (busca.isPresent()) {
			Long quantidade = busca.get().getQuantidade() + 1;
			busca.get().setQuantidade(quantidade);
			buscaRepo.save(busca.get());
		} else {
			Busca novaBusca = new Busca();
			novaBusca.setDominio("vehicles");
			novaBusca.setTermo(veiculo.toLowerCase());
			novaBusca.setQuantidade(1L);
			buscaRepo.save(novaBusca);
		}
		
		return new BuscaVeiculoDTO(searchVehicleDTO, pagina, sugestoesBusca);
	}

}
