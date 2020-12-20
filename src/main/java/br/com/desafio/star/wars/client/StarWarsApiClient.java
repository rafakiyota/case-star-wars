package br.com.desafio.star.wars.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.star.wars.model.client.film.SearchFilmDTO;
import br.com.desafio.star.wars.model.client.people.SearchPeopleDTO;
import br.com.desafio.star.wars.model.client.planet.SearchPlanetDTO;
import br.com.desafio.star.wars.model.client.specie.SearchSpecieDTO;
import br.com.desafio.star.wars.model.client.starship.SearchStarShipDTO;
import br.com.desafio.star.wars.model.client.vehicle.SearchVehicleDTO;

@Component
public class StarWarsApiClient {

	private final String API_URL = "https://swapi.dev";
	private final String PEOPLE = "/api/people";
	private final String FILMS = "/api/films";
	private final String PLANETS = "/api/planets";
	private final String STARSHIPS = "/api/starships";
	private final String SPECIES = "/api/species";
	private final String VEHICLES = "/api/vehicles";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public SearchPeopleDTO findPeople(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, PEOPLE, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchPeopleDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPeopleDTO.class);
		return response.getBody();
	}
	
	public SearchFilmDTO findFilm(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, FILMS, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchFilmDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchFilmDTO.class);
		return response.getBody();
	}
	
	public SearchPlanetDTO findPlanet(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, PLANETS, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchPlanetDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPlanetDTO.class);
		return response.getBody();
	}
	
	public SearchStarShipDTO findStarShip(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, STARSHIPS, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchStarShipDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchStarShipDTO.class);
		return response.getBody();
	}
	
	public SearchSpecieDTO findSpecie(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, SPECIES, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchSpecieDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchSpecieDTO.class);
		return response.getBody();
	}
	
	public SearchVehicleDTO findVehicle(String finder, Long page) {
		
		String url = String.format("%s%s/?search=%s&page=%s", API_URL, VEHICLES, finder, page);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<SearchVehicleDTO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchVehicleDTO.class);
		return response.getBody();
	}
}
