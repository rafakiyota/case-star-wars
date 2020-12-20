package com.example.demo.testes_unitarios.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.desafio.star.wars.model.termo.TermoPaginaDTO;
import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.repository.entity.Busca;
import br.com.desafio.star.wars.service.impl.TermoServicesImpl;

@ExtendWith(MockitoExtension.class)
public class TermoServicesImplTest {

	@Mock
	private BuscaRepo buscaRepo;
	
	@InjectMocks
	private TermoServicesImpl instance;
	
	@Test
	void testAll() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("people");
		b01.setTermo("anakin");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("films");
		b02.setTermo("jedi");
		b02.setQuantidade(80L);
		
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findAll(Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.all(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("people", response.getContent().get(0).getDominio());
		assertEquals("anakin", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("films", response.getContent().get(1).getDominio());
		assertEquals("jedi", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosPersonagens() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("people");
		b01.setTermo("anakin");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("people");
		b02.setTermo("luke");
		b02.setQuantidade(80L);
		
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosPersonagens(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("people", response.getContent().get(0).getDominio());
		assertEquals("anakin", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("people", response.getContent().get(1).getDominio());
		assertEquals("luke", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosFilmes() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("films");
		b01.setTermo("hope");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("films");
		b02.setTermo("jedi");
		b02.setQuantidade(80L);
		
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosFilmes(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("films", response.getContent().get(0).getDominio());
		assertEquals("hope", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("films", response.getContent().get(1).getDominio());
		assertEquals("jedi", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosPlanetas() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("planets");
		b01.setTermo("tato");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("planets");
		b02.setTermo("yavin");
		b02.setQuantidade(80L);
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosPlanetas(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("planets", response.getContent().get(0).getDominio());
		assertEquals("tato", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("planets", response.getContent().get(1).getDominio());
		assertEquals("yavin", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosNaves() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("starships");
		b01.setTermo("death star");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("starships");
		b02.setTermo("star");
		b02.setQuantidade(80L);
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosNaves(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("starships", response.getContent().get(0).getDominio());
		assertEquals("death star", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("starships", response.getContent().get(1).getDominio());
		assertEquals("star", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosEspecies() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("species");
		b01.setTermo("yoda");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("species");
		b02.setTermo("human");
		b02.setQuantidade(80L);
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosEspecies(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("species", response.getContent().get(0).getDominio());
		assertEquals("yoda", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("species", response.getContent().get(1).getDominio());
		assertEquals("human", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
	
	@Test
	void testfindTermosVeiculos() {
		
		Busca b01 = new Busca();
		b01.setId(1L);
		b01.setDominio("vehicles");
		b01.setTermo("crawler");
		b01.setQuantidade(100L);
		
		Busca b02 = new Busca();
		b02.setId(1L);
		b02.setDominio("vehicles");
		b02.setTermo("skyhopper");
		b02.setQuantidade(80L);
		Page<Busca> page = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page);
		TermoPaginaDTO response = instance.findTermosVeiculos(0);
		
		assertNotNull(response);
		assertEquals(1, response.getTotalPages());
		assertEquals(0, response.getCurrentPage());
		assertEquals(true, response.getLastPage());
		assertEquals(true, response.getFirstPage());
		assertTrue(response.getContent().size() == 2);
		assertEquals("vehicles", response.getContent().get(0).getDominio());
		assertEquals("crawler", response.getContent().get(0).getTermo());
		assertEquals(100, response.getContent().get(0).getQuantidade());
		assertEquals("vehicles", response.getContent().get(1).getDominio());
		assertEquals("skyhopper", response.getContent().get(1).getTermo());
		assertEquals(80, response.getContent().get(1).getQuantidade());
	}
}
