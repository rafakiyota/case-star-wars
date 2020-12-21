package com.example.demo.testes_unitarios_serverup.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.desafio.star.wars.CaseStarWarsApplication;

@SpringBootTest(classes = CaseStarWarsApplication.class)
@AutoConfigureMockMvc
public class TermoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_v1_termo() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(6)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(false)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("people")))
			.andExpect(jsonPath("$.content[0].termo", is("vader")));
	}
	
	@Test
	void test_v1_termo_personagem() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/personagem")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(2)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(false)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("people")))
			.andExpect(jsonPath("$.content[0].termo", is("vader")));
	}
	
	@Test
	void test_v1_termo_filme() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/filme")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(1)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(true)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("films")))
			.andExpect(jsonPath("$.content[0].termo", is("jedi")));
	}
	
	@Test
	void test_v1_termo_planeta() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/planeta")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(1)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(true)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("planets")))
			.andExpect(jsonPath("$.content[0].termo", is("tato")));
	}
	
	@Test
	void test_v1_termo_nave() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/nave")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(1)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(true)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("starships")))
			.andExpect(jsonPath("$.content[0].termo", is("death star")));
	}
	
	@Test
	void test_v1_termo_especie() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/especie")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(1)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(true)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("species")))
			.andExpect(jsonPath("$.content[0].termo", is("yoda")));
	}
	
	@Test
	void test_v1_termo_veiculo() throws Exception {
		this.mockMvc
			.perform(get("/v1/termo/veiculo")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalPages", is(1)))
			.andExpect(jsonPath("$.currentPage", is(0)))
			.andExpect(jsonPath("$.lastPage", is(true)))
			.andExpect(jsonPath("$.firstPage", is(true)))
			.andExpect(jsonPath("$.content[0].dominio", is("vehicles")))
			.andExpect(jsonPath("$.content[0].termo", is("crawler")));
	}
}
