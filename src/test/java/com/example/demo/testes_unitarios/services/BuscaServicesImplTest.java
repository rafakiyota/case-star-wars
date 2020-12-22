package com.example.demo.testes_unitarios.services;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
import br.com.desafio.star.wars.model.especie.BuscaEspecieDTO;
import br.com.desafio.star.wars.model.filme.BuscaFilmeDTO;
import br.com.desafio.star.wars.model.nave.BuscaNaveDTO;
import br.com.desafio.star.wars.model.personagem.BuscaPersonagemDTO;
import br.com.desafio.star.wars.model.planeta.BuscaPlanetaDTO;
import br.com.desafio.star.wars.model.veiculo.BuscaVeiculoDTO;
import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.repository.entity.Busca;
import br.com.desafio.star.wars.service.SugestaoServices;
import br.com.desafio.star.wars.service.impl.BuscaServicesImpl;

@ExtendWith(MockitoExtension.class)
public class BuscaServicesImplTest {

	@Mock
	private StarWarsApiClient starWarsClient;
	
	@Mock
	private BuscaRepo buscaRepo;
	
	@Mock
	private SugestaoServices sugestaoServices;
	
	@InjectMocks
	private BuscaServicesImpl instance;
	
	@Test
	void testgetPersonagens() {
		
		PeopleDTO p01 = new PeopleDTO();
		p01.setName("Luke Skywalker");
		p01.setHeight("172");
		p01.setMass("77");
		p01.setHair_color("blond");
		p01.setSkin_color("fair");
		p01.setBirth_year("19BBY");
		p01.setGender("male");
		
		PeopleDTO p02 = new PeopleDTO();
		p02.setName("C-3PO");
		p02.setHeight("167");
		p02.setMass("75");
		p02.setHair_color("n/a");
		p02.setSkin_color("gold");
		p02.setBirth_year("112BBY");
		p02.setGender("n/a");
		
		SearchPeopleDTO searchPeopleDTO = new SearchPeopleDTO();
		searchPeopleDTO.setCount(2L);
		searchPeopleDTO.setNext(null);
		searchPeopleDTO.setPrevious(null);
		searchPeopleDTO.setResults(Arrays.asList(p01, p02));
		
		Mockito.when(starWarsClient.findPeople(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchPeopleDTO);
		
		List<String> sugestoes = Arrays.asList("anakin", "jedi", "vader", "yoda");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("people");
		b01.setTermo("anakin");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaPersonagemDTO response = instance.getPersonagens("anakin", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("anakin", response.getSuggestions().get(0));
		assertEquals("jedi", response.getSuggestions().get(1));
		assertEquals("vader", response.getSuggestions().get(2));
		assertEquals("yoda", response.getSuggestions().get(3));
		assertTrue(response.getCharacters().size() == 2);
		assertEquals("Luke Skywalker", response.getCharacters().get(0).getName());
		assertEquals("172", response.getCharacters().get(0).getHeight());
		assertEquals("77", response.getCharacters().get(0).getMass());
		assertEquals("male", response.getCharacters().get(0).getGender());
	}
	
	@Test
	void testgetFilmes() {
		
		FilmDTO f01 = new FilmDTO();
		f01.setTitle("A New Hope");
		f01.setEpisode_id(4L);
		f01.setOpening_crawl("It is a period of civil war.\\r\\nRebel spaceships, striking\\r\\nfrom a hidden base, have won\\r\\ntheir first victory against\\r\\nthe evil Galactic Empire.\\r\\n\\r\\nDuring the battle, Rebel\\r\\nspies managed to steal secret\\r\\nplans to the Empire's\\r\\nultimate weapon, the DEATH\\r\\nSTAR, an armored space\\r\\nstation with enough power\\r\\nto destroy an entire planet.\\r\\n\\r\\nPursued by the Empire's\\r\\nsinister agents, Princess\\r\\nLeia races home aboard her\\r\\nstarship, custodian of the\\r\\nstolen plans that can save her\\r\\npeople and restore\\r\\nfreedom to the galaxy....");
		f01.setDirector("George Lucas");
		f01.setProducer("Gary Kurtz, Rick McCallum");
		f01.setRelease_date("1977-05-25");
		
		SearchFilmDTO searchDTO = new SearchFilmDTO();
		searchDTO.setCount(1L);
		searchDTO.setNext(null);
		searchDTO.setPrevious(null);
		searchDTO.setResults(Arrays.asList(f01));
		
		Mockito.when(starWarsClient.findFilm(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchDTO);
		
		List<String> sugestoes = Arrays.asList("hope", "jedi", "revenge", "new");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("films");
		b01.setTermo("hope");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaFilmeDTO response = instance.getFilmes("hope", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("hope", response.getSuggestions().get(0));
		assertEquals("jedi", response.getSuggestions().get(1));
		assertEquals("revenge", response.getSuggestions().get(2));
		assertEquals("new", response.getSuggestions().get(3));
		assertTrue(response.getFilms().size() == 1);
		assertEquals("A New Hope", response.getFilms().get(0).getTitle());
	}
	
	@Test
	void testgetPlanetas() {
		
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
		searchDTO.setNext(null);
		searchDTO.setPrevious(null);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(starWarsClient.findPlanet(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchDTO);
		
		List<String> sugestoes = Arrays.asList("tato", "alde", "hoth", "dago");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("planets");
		b01.setTermo("tato");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaPlanetaDTO response = instance.getPlanetas("hope", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("tato", response.getSuggestions().get(0));
		assertEquals("alde", response.getSuggestions().get(1));
		assertEquals("hoth", response.getSuggestions().get(2));
		assertEquals("dago", response.getSuggestions().get(3));
		assertTrue(response.getPlanets().size() == 1);
		assertEquals("Tatooine", response.getPlanets().get(0).getName());
		assertEquals("200000", response.getPlanets().get(0).getPopulation());
		assertEquals("1 standard", response.getPlanets().get(0).getGravity());
	}
	
	@Test
	void testgetNaves() {
		
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
		searchDTO.setNext(null);
		searchDTO.setPrevious(null);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(starWarsClient.findStarShip(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchDTO);
		
		List<String> sugestoes = Arrays.asList("corvette", "destroyer", "craft", "falcon");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("starships");
		b01.setTermo("corvette");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaNaveDTO response = instance.getNaves("hope", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("corvette", response.getSuggestions().get(0));
		assertEquals("destroyer", response.getSuggestions().get(1));
		assertEquals("craft", response.getSuggestions().get(2));
		assertEquals("falcon", response.getSuggestions().get(3));
		assertTrue(response.getStarships().size() == 1);
		assertEquals("CR90 corvette", response.getStarships().get(0).getName());
		assertEquals("Corellian Engineering Corporation", response.getStarships().get(0).getManufacturer());
		assertEquals("corvette", response.getStarships().get(0).getStarship_class());
	}
	
	@Test
	void testgetEspecies() {
		
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
		searchDTO.setNext(null);
		searchDTO.setPrevious(null);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(starWarsClient.findSpecie(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchDTO);
		
		List<String> sugestoes = Arrays.asList("yoda", "human", "droid", "wookie");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("species");
		b01.setTermo("yoda");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaEspecieDTO response = instance.getEspecies("yoda", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("yoda", response.getSuggestions().get(0));
		assertEquals("human", response.getSuggestions().get(1));
		assertEquals("droid", response.getSuggestions().get(2));
		assertEquals("wookie", response.getSuggestions().get(3));
		assertTrue(response.getSpecies().size() == 1);
		assertEquals("Human", response.getSpecies().get(0).getName());
		assertEquals("mammal", response.getSpecies().get(0).getClassification());
		assertEquals("sentient", response.getSpecies().get(0).getDesignation());
	}
	
	@Test
	void testgetVeiculos() {
		
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
		searchDTO.setNext(null);
		searchDTO.setPrevious(null);
		searchDTO.setResults(Arrays.asList(var01));
		
		Mockito.when(starWarsClient.findVehicle(Mockito.anyString(), Mockito.anyLong())).thenReturn(searchDTO);
		
		List<String> sugestoes = Arrays.asList("crawler", "skyhopper", "starfighter", "bomber");
		Mockito.when(sugestaoServices.sugestaoPorDominioTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(sugestoes);
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("vehicles");
		b01.setTermo("starfighter");
		b01.setQuantidade(100L);
		
		Optional<Busca> busca = Optional.ofNullable(b01);
		Mockito.when(buscaRepo.findByDominioAndTermo(Mockito.anyString(), Mockito.anyString())).thenReturn(busca);
		
		BuscaVeiculoDTO response = instance.getVeiculos("car", 1L);
		
		assertNotNull(response);
		assertEquals(1L, response.getCurrentPage());
		assertNull(response.getNextPage());
		assertNull(response.getPreviousPage());
		assertEquals("crawler", response.getSuggestions().get(0));
		assertEquals("skyhopper", response.getSuggestions().get(1));
		assertEquals("starfighter", response.getSuggestions().get(2));
		assertEquals("bomber", response.getSuggestions().get(3));
		assertTrue(response.getVehicles().size() == 1);
		assertEquals("Sand Crawler", response.getVehicles().get(0).getName());
		assertEquals("Digger Crawler", response.getVehicles().get(0).getModel());
		assertEquals("wheeled", response.getVehicles().get(0).getVehicle_class());
	}
}
