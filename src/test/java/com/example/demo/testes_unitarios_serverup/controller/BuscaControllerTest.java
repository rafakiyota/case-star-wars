package com.example.demo.testes_unitarios_serverup.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.desafio.star.wars.CaseStarWarsApplication;

@SpringBootTest(classes = CaseStarWarsApplication.class)
@AutoConfigureMockMvc
public class BuscaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_v1_busca_personagem() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/personagem?termo=anakin")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("anakin")))
			.andExpect(jsonPath("$.suggestions[1]", is("vader")))
			.andExpect(jsonPath("$.suggestions[2]", is("yoda")))
			.andExpect(jsonPath("$.characters[0].name", is("Anakin Skywalker")))
			.andExpect(jsonPath("$.characters[0].hair_color", is("blond")))
			.andExpect(jsonPath("$.characters[0].skin_color", is("fair")))
			.andExpect(jsonPath("$.characters[0].gender", is("male")));
	}
	
	@Test
	void test_v1_busca_filme() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/filme?termo=jedi")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("jedi")))
			.andExpect(jsonPath("$.suggestions[1]", is("sith")))
			.andExpect(jsonPath("$.suggestions[2]", is("revenge")))
			.andExpect(jsonPath("$.films[0].title", is("Return of the Jedi")))
			.andExpect(jsonPath("$.films[0].episode_id", is(6)))
			.andExpect(jsonPath("$.films[0].producer", is("Howard G. Kazanjian, George Lucas, Rick McCallum")))
			.andExpect(jsonPath("$.films[0].director", is("Richard Marquand")));
	}
	
	@Test
	void test_v1_busca_planeta() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/planeta?termo=tato")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("tato")))
			.andExpect(jsonPath("$.suggestions[1]", is("yavin")))
			.andExpect(jsonPath("$.suggestions[2]", is("hoth")))
			.andExpect(jsonPath("$.planets[0].name", is("Tatooine")))
			.andExpect(jsonPath("$.planets[0].rotation_period", is("23")))
			.andExpect(jsonPath("$.planets[0].population", is("200000")))
			.andExpect(jsonPath("$.planets[0].terrain", is("desert")));
	}
	
	@Test
	void test_v1_busca_nave() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/nave?termo=star")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage", is(2)))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("death star")))
			.andExpect(jsonPath("$.suggestions[1]", is("star")))
			.andExpect(jsonPath("$.suggestions[2]", is("death")))
			.andExpect(jsonPath("$.starships[0].name", is("Star Destroyer")))
			.andExpect(jsonPath("$.starships[0].model", is("Imperial I-class Star Destroyer")))
			.andExpect(jsonPath("$.starships[0].manufacturer", is("Kuat Drive Yards")))
			.andExpect(jsonPath("$.starships[0].cost_in_credits", is("150000000")));
	}
	
	@Test
	void test_v1_busca_especie() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/especie?termo=human")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("human")))
			.andExpect(jsonPath("$.suggestions[1]", is("yoda")))
			.andExpect(jsonPath("$.suggestions[2]", is("droid")))
			.andExpect(jsonPath("$.species[0].name", is("Human")))
			.andExpect(jsonPath("$.species[0].classification", is("mammal")))
			.andExpect(jsonPath("$.species[0].designation", is("sentient")))
			.andExpect(jsonPath("$.species[0].skin_colors", is("caucasian, black, asian, hispanic")));
	}
	
	@Test
	void test_v1_busca_veiculo() throws Exception {
		this.mockMvc
			.perform(get("/v1/busca/veiculo?termo=crawler")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currentPage", is(1)))
			.andExpect(jsonPath("$.nextPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.previousPage").value(IsNull.nullValue()))
			.andExpect(jsonPath("$.suggestions[0]", is("crawler")))
			.andExpect(jsonPath("$.suggestions[1]", is("skyhopper")))
			.andExpect(jsonPath("$.suggestions[2]", is("landspeeder")))
			.andExpect(jsonPath("$.vehicles[0].name", is("Sand Crawler")))
			.andExpect(jsonPath("$.vehicles[0].model", is("Digger Crawler")))
			.andExpect(jsonPath("$.vehicles[0].passengers", is("30")))
			.andExpect(jsonPath("$.vehicles[0].cargo_capacity", is("50000")))
			.andExpect(jsonPath("$.vehicles[0].vehicle_class", is("wheeled")));
	}
}
