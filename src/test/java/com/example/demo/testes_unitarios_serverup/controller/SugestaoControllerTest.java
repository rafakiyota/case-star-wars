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
public class SugestaoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test_v1_sugestao() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao?termo=anakin"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("anakin")))
			.andExpect(jsonPath("$.suggestions[1]", is("vader")))
			.andExpect(jsonPath("$.suggestions[2]", is("yoda")))
			.andExpect(jsonPath("$.suggestions[3]", is("jedi")));
	}
	
	@Test
	void test_v1_sugestao_personagem() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/personagem?termo=anakin"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("anakin")))
			.andExpect(jsonPath("$.suggestions[1]", is("vader")))
			.andExpect(jsonPath("$.suggestions[2]", is("yoda")))
			.andExpect(jsonPath("$.suggestions[3]", is("darth")))
			.andExpect(jsonPath("$.suggestions[4]", is("darth vader")));
	}
	
	@Test
	void test_v1_sugestao_filme() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/filme?termo=hope"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("hope")))
			.andExpect(jsonPath("$.suggestions[1]", is("a new hope")))
			.andExpect(jsonPath("$.suggestions[2]", is("jedi")))
			.andExpect(jsonPath("$.suggestions[3]", is("sith")))
			.andExpect(jsonPath("$.suggestions[4]", is("revenge")))
			.andExpect(jsonPath("$.suggestions[5]", is("return")));
	}
	
	@Test
	void test_v1_sugestao_planeta() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/planeta?termo=tato"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("tato")))
			.andExpect(jsonPath("$.suggestions[1]", is("yavin")))
			.andExpect(jsonPath("$.suggestions[2]", is("hoth")))
			.andExpect(jsonPath("$.suggestions[3]", is("naboo")));
	}
	
	@Test
	void test_v1_sugestao_nave() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/nave?termo=star"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("death star")))
			.andExpect(jsonPath("$.suggestions[1]", is("star")))
			.andExpect(jsonPath("$.suggestions[2]", is("death")))
			.andExpect(jsonPath("$.suggestions[3]", is("corvette")));
	}
	
	@Test
	void test_v1_sugestao_especie() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/especie?termo=yoda"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("yoda")))
			.andExpect(jsonPath("$.suggestions[1]", is("human")))
			.andExpect(jsonPath("$.suggestions[2]", is("droid")))
			.andExpect(jsonPath("$.suggestions[3]", is("wookie")));	
	}
	
	@Test
	void test_v1_sugestao_veiculo() throws Exception {
		this.mockMvc
			.perform(get("/v1/sugestao/veiculo?termo=cra"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.suggestions[0]", is("crawler")))
			.andExpect(jsonPath("$.suggestions[1]", is("skyhopper")))
			.andExpect(jsonPath("$.suggestions[2]", is("landspeeder")))
			.andExpect(jsonPath("$.suggestions[3]", is("starfighter")));
	}
}
