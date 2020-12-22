package com.example.demo.testes_unitarios.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.URI;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.star.wars.client.StarWarsApiClient;
import br.com.desafio.star.wars.model.client.film.FilmDTO;
import br.com.desafio.star.wars.model.client.film.SearchFilmDTO;
import br.com.desafio.star.wars.model.client.people.PeopleDTO;
import br.com.desafio.star.wars.model.client.people.SearchPeopleDTO;
import br.com.desafio.star.wars.model.client.planet.PlanetDTO;
import br.com.desafio.star.wars.model.client.planet.SearchPlanetDTO;
import br.com.desafio.star.wars.model.client.specie.SearchSpecieDTO;
import br.com.desafio.star.wars.model.client.specie.SpecieDTO;
import br.com.desafio.star.wars.model.client.starship.SearchStarShipDTO;
import br.com.desafio.star.wars.model.client.starship.StarShipDTO;
import br.com.desafio.star.wars.model.client.vehicle.SearchVehicleDTO;
import br.com.desafio.star.wars.model.client.vehicle.VehicleDTO;

@ExtendWith(MockitoExtension.class)
public class StarWarsApiClientTest {

	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private StarWarsApiClient instance;
	
	@BeforeEach
	void setup() {
		ReflectionTestUtils.setField(instance, "apiUrl", "apiUrl");
		ReflectionTestUtils.setField(instance, "recursoPeople", "recursoPeople");
		ReflectionTestUtils.setField(instance, "recursoFilms", "recursoFilms");
		ReflectionTestUtils.setField(instance, "recursoPlanets", "recursoPlanets");
		ReflectionTestUtils.setField(instance, "recursoStarships", "recursoStarships");
		ReflectionTestUtils.setField(instance, "recursoSpecies", "recursoSpecies");
		ReflectionTestUtils.setField(instance, "recursoVehicles", "recursoVehicles");
	}
	
	@Test
	void testfindPeople() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoPeople", "luke", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		PeopleDTO p01 = new PeopleDTO();
		p01.setName("Luke Skywalker");
		p01.setHeight("172");
		p01.setMass("77");
		p01.setHair_color("blond");
		p01.setSkin_color("fair");
		p01.setBirth_year("19BBY");
		p01.setGender("male");
		
		SearchPeopleDTO searchPeopleDTO = new SearchPeopleDTO();
		searchPeopleDTO.setCount(1L);
		searchPeopleDTO.setResults(Arrays.asList(p01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPeopleDTO.class)).thenReturn(ResponseEntity.ok(searchPeopleDTO));
		
		SearchPeopleDTO response = instance.findPeople("luke", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("Luke Skywalker", response.getResults().get(0).getName());
		assertEquals("blond", response.getResults().get(0).getHair_color());
		assertEquals("male", response.getResults().get(0).getGender());
		
	}
	
	@Test
	void testfindFilm() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoFilms", "hope", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		FilmDTO f01 = new FilmDTO();
		f01.setTitle("A New Hope");
		f01.setEpisode_id(4L);
		f01.setOpening_crawl("It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....");
		f01.setDirector("George Lucas");
		f01.setProducer("Gary Kurtz, Rick McCallum");
		f01.setRelease_date("1977-05-25");
		
		SearchFilmDTO searchDTO = new SearchFilmDTO();
		searchDTO.setCount(1L);
		searchDTO.setResults(Arrays.asList(f01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchFilmDTO.class)).thenReturn(ResponseEntity.ok(searchDTO));
		
		SearchFilmDTO response = instance.findFilm("hope", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("A New Hope", response.getResults().get(0).getTitle());
		assertEquals("George Lucas", response.getResults().get(0).getDirector());
		assertEquals("Gary Kurtz, Rick McCallum", response.getResults().get(0).getProducer());
		
	}
	
	@Test
	void testfindPlanet() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoPlanets", "tato", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		PlanetDTO var01 = new PlanetDTO();
		var01.setName("Tatooine");
		var01.setRotation_period("23");
		var01.setOrbital_period("304");
		var01.setDiameter("10465");
		var01.setClimate("arid");
		var01.setGravity("1 standard");
		var01.setTerrain("desert");
		var01.setSurface_water("1");
		var01.setPopulation("200000");
		
		SearchPlanetDTO searchDTO = new SearchPlanetDTO();
		searchDTO.setCount(1L);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchPlanetDTO.class)).thenReturn(ResponseEntity.ok(searchDTO));
		
		SearchPlanetDTO response = instance.findPlanet("tato", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("Tatooine", response.getResults().get(0).getName());
		assertEquals("304", response.getResults().get(0).getOrbital_period());
		assertEquals("200000", response.getResults().get(0).getPopulation());
		
	}
	
	@Test
	void testfindStarShip() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoStarships", "corvette", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		StarShipDTO var01 = new StarShipDTO();
		var01.setName("CR90 corvette");
		var01.setModel("CR90 corvette");
		var01.setManufacturer("Corellian Engineering Corporation");
		var01.setCost_in_credits("3500000");
		var01.setLength("150");
		var01.setMax_atmosphering_speed("950");
		var01.setCrew("30-165");
		var01.setPassengers("600");
		var01.setCargo_capacity("3000000");
		var01.setConsumables("1 year");
		var01.setHyperdrive_rating("2.0");
		var01.setStarship_class("corvette");
		var01.setMGLT(null);
		
		SearchStarShipDTO searchDTO = new SearchStarShipDTO();
		searchDTO.setCount(1L);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchStarShipDTO.class)).thenReturn(ResponseEntity.ok(searchDTO));
		
		SearchStarShipDTO response = instance.findStarShip("corvette", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("CR90 corvette", response.getResults().get(0).getName());
		assertEquals("CR90 corvette", response.getResults().get(0).getModel());
		assertEquals("corvette", response.getResults().get(0).getStarship_class());
		
	}
	
	@Test
	void testfindSpecie() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoSpecies", "human", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		SpecieDTO var01 = new SpecieDTO();
		var01.setName("Human");
		var01.setClassification("mammal");
		var01.setDesignation("sentient");
		var01.setAverage_height("180");
		var01.setSkin_colors("caucasian, black, asian, hispanic");
		var01.setHair_colors("blonde, brown, black, red");
		var01.setEye_colors("brown, blue, green, hazel, grey, amber");
		var01.setAverage_lifespan("120");
		var01.setLanguage("Galactic Basic");
		
		SearchSpecieDTO searchDTO = new SearchSpecieDTO();
		searchDTO.setCount(1L);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchSpecieDTO.class)).thenReturn(ResponseEntity.ok(searchDTO));
		
		SearchSpecieDTO response = instance.findSpecie("human", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("Human", response.getResults().get(0).getName());
		assertEquals("mammal", response.getResults().get(0).getClassification());
		assertEquals("Galactic Basic", response.getResults().get(0).getLanguage());
		
	}
	
	@Test
	void testfindVehicle() {
		
		String url = String.format("%s%s/?search=%s&page=%s", "apiUrl", "recursoVehicles", "crawler", 1);
		URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		VehicleDTO var01 = new VehicleDTO();
		var01.setName("Sand Crawler");
		var01.setModel("Digger Crawler");
		var01.setManufacturer("Corellia Mining Corporation");
		var01.setCost_in_credits("150000");
		var01.setLength("36.8 ");
		var01.setMax_atmosphering_speed("30");
		var01.setCrew("46");
		var01.setPassengers("30");
		var01.setCargo_capacity("50000");
		var01.setConsumables("2 months");
		var01.setVehicle_class("wheeled");
		
		SearchVehicleDTO searchDTO = new SearchVehicleDTO();
		searchDTO.setCount(1L);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, entity, SearchVehicleDTO.class)).thenReturn(ResponseEntity.ok(searchDTO));
		
		SearchVehicleDTO response = instance.findVehicle("crawler", 1L);
		
		assertNotNull(response);
		assertNull(response.getNext());
		assertNull(response.getPrevious());
		assertEquals(1L, response.getCount());
		assertEquals("Sand Crawler", response.getResults().get(0).getName());
		assertEquals("Corellia Mining Corporation", response.getResults().get(0).getManufacturer());
		assertEquals("wheeled", response.getResults().get(0).getVehicle_class());
		
	}
}
