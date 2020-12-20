package com.example.demo.testes_unitarios.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.repository.entity.Busca;
import br.com.desafio.star.wars.service.impl.SugestaoServicesImpl;

@ExtendWith(MockitoExtension.class)
public class SugestaoServicesImplTest {

	@Mock
	private BuscaRepo buscaRepo;
	
	@InjectMocks
	private SugestaoServicesImpl instance;
	
	@Test
	void testsugestaoPorDominioTermo() {
		
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
		Page<Busca> page01 = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByDominioLikeTermo(Mockito.anyString(), Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page01);
		
		Busca b03 = new Busca();
		b03.setId(1L);
		b03.setDominio("people");
		b03.setTermo("vader");
		b03.setQuantidade(1000L);
		
		Busca b04 = new Busca();
		b04.setId(1L);
		b04.setDominio("species");
		b04.setTermo("yoda");
		b04.setQuantidade(900L);		
		Page<Busca> page02 = new PageImpl<>(Arrays.asList(b03, b04));
		
		Mockito.when(buscaRepo.findByDominio(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page02);
		List<String> response = instance.sugestaoPorDominioTermo("people", "anakin");
		
		assertNotNull(response);
		assertEquals("anakin", response.get(0));
		assertEquals("luke", response.get(1));
		assertEquals("vader", response.get(2));
		assertEquals("yoda", response.get(3));
	}
	
	@Test
	void testsugestaoPorTermo() {
		
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
		Page<Busca> page01 = new PageImpl<>(Arrays.asList(b01, b02));
		
		Mockito.when(buscaRepo.findByTermo(Mockito.anyString(), Mockito.any(PageRequest.class))).thenReturn(page01);
		
		Busca b03 = new Busca();
		b03.setId(1L);
		b03.setDominio("people");
		b03.setTermo("vader");
		b03.setQuantidade(1000L);
		
		Busca b04 = new Busca();
		b04.setId(1L);
		b04.setDominio("species");
		b04.setTermo("yoda");
		b04.setQuantidade(900L);		
		Page<Busca> page02 = new PageImpl<>(Arrays.asList(b03, b04));
		
		Mockito.when(buscaRepo.findAll(Mockito.any(PageRequest.class))).thenReturn(page02);
		List<String> response = instance.sugestaoPorTermo("yoda");

		assertNotNull(response);
		assertEquals("anakin", response.get(0));
		assertEquals("jedi", response.get(1));
		assertEquals("vader", response.get(2));
		assertEquals("yoda", response.get(3));
	}
}
