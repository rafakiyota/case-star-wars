package br.com.desafio.star.wars.client;

import java.net.URI;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.star.wars.exception.AppNotFoundException;
import br.com.desafio.star.wars.model.client.film.SearchFilmDTO;
import br.com.desafio.star.wars.model.client.people.SearchPeopleDTO;
import br.com.desafio.star.wars.model.client.planet.SearchPlanetDTO;
import br.com.desafio.star.wars.model.client.specie.SearchSpecieDTO;
import br.com.desafio.star.wars.model.client.starship.SearchStarShipDTO;
import br.com.desafio.star.wars.model.client.vehicle.SearchVehicleDTO;

@Component
public class StarWarsApiClient {
	
	@Value("${aplicacao.cliente.star-wars-api.url}")
	private String apiUrl;

	@Value("${aplicacao.cliente.star-wars-api.recurso-people}")
	private String recursoPeople;
	
	@Value("${aplicacao.cliente.star-wars-api.recurso-films}")
	private String recursoFilms;
		
	@Value("${aplicacao.cliente.star-wars-api.recurso-planets}")
	private String recursoPlanets;
	
	@Value("${aplicacao.cliente.star-wars-api.recurso-starships}")
	private String recursoStarships;
	
	@Value("${aplicacao.cliente.star-wars-api.recurso-species}")
	private String recursoSpecies;
	
	@Value("${aplicacao.cliente.star-wars-api.recurso-vehicles}")
	private String recursoVehicles;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public SearchPeopleDTO findPeople(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoPeople, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchPeopleDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPeopleDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
	
	public SearchFilmDTO findFilm(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoFilms, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchFilmDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchFilmDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
	
	public SearchPlanetDTO findPlanet(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoPlanets, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchPlanetDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPlanetDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
	
	public SearchStarShipDTO findStarShip(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoStarships, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchStarShipDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchStarShipDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
	
	public SearchSpecieDTO findSpecie(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoSpecies, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchSpecieDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchSpecieDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
	
	public SearchVehicleDTO findVehicle(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", apiUrl, recursoVehicles, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<SearchVehicleDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchVehicleDTO.class);
			return response.getBody();			
		} catch (HttpClientErrorException e) {
			throw new AppNotFoundException(String.format("client error: %s", ExceptionUtils.getRootCauseMessage(e)));
		}
	}
}
