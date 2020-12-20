package br.com.desafio.star.wars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.star.wars.model.especie.BuscaEspecieDTO;
import br.com.desafio.star.wars.model.filme.BuscaFilmeDTO;
import br.com.desafio.star.wars.model.nave.BuscaNaveDTO;
import br.com.desafio.star.wars.model.personagem.BuscaPersonagemDTO;
import br.com.desafio.star.wars.model.planeta.BuscaPlanetaDTO;
import br.com.desafio.star.wars.model.veiculo.BuscaVeiculoDTO;
import br.com.desafio.star.wars.service.BuscarServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/busca")
@Api(tags = "API Busca", description = "API de consulta do mundo Star Wars")
public class BuscaController {

	@Autowired
	private BuscarServices service;
	
	@GetMapping("/personagem")
	@ApiOperation(value = "Consulta personagens")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna personagens"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaPersonagemDTO> findPersonagem(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaPersonagemDTO buscaPersonagemDTO = service.getPersonagens(termo, pagina);
		return ResponseEntity.ok(buscaPersonagemDTO);
	}
	
	@GetMapping("/filme")
	@ApiOperation(value = "Consulta filmes")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna filmes"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaFilmeDTO> findFilme(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaFilmeDTO buscaFilmeDTO = service.getFilmes(termo, pagina);
		return ResponseEntity.ok(buscaFilmeDTO);
	}
	
	@GetMapping("/planeta")
	@ApiOperation(value = "Consulta planetas")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna planetas"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaPlanetaDTO> getPlanetas(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaPlanetaDTO buscaPlanetDTO = service.getPlanetas(termo, pagina);
		return ResponseEntity.ok(buscaPlanetDTO);
	}
	
	@GetMapping("/nave")
	@ApiOperation(value = "Consulta naves")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna naves"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaNaveDTO> getNaves(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaNaveDTO buscaNaveDTO = service.getNaves(termo, pagina);
		return ResponseEntity.ok(buscaNaveDTO);
	}
	
	@GetMapping("/especie")
	@ApiOperation(value = "Consulta espécies")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna espécies"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaEspecieDTO> getEspecies(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaEspecieDTO buscaEspecieDTO = service.getEspecies(termo, pagina);
		return ResponseEntity.ok(buscaEspecieDTO);
	}
	
	@GetMapping("/veiculo")
	@ApiOperation(value = "Consulta veículos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna veículos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<BuscaVeiculoDTO> getVeiculos(
			@RequestParam(required=false, defaultValue="") String termo, 
			@RequestParam(required=false, defaultValue="1") Long pagina) {
		
		BuscaVeiculoDTO buscaVeiculoDTO = service.getVeiculos(termo, pagina);
		return ResponseEntity.ok(buscaVeiculoDTO);
	}
}
