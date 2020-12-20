package br.com.desafio.star.wars.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.star.wars.model.sugestao.SugestaoDTO;
import br.com.desafio.star.wars.service.SugestaoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/sugestao")
@Api(tags = "API Sugestão", description = "API de sugestões por termo e domínio")
public class SugestaoController {

	@Autowired
	private SugestaoServices service;
	
	@GetMapping
	@ApiOperation(value = "Sugestão de termos para todos os domínios")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoPorTermo(@RequestParam String termo) {		
		List<String> sugestoes = service.sugestaoPorTermo(termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/personagem")
	@ApiOperation(value = "Sugestão de termos para o domínio personagem")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoPersonagens(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("people", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/filme")
	@ApiOperation(value = "Sugestão de termos para o domínio filme")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoFilmes(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("films", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/planeta")
	@ApiOperation(value = "Sugestão de termos para o domínio planeta")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoPlanetas(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("planets", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/nave")
	@ApiOperation(value = "Sugestão de termos para o domínio nave")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoNaves(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("starships", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/especie")
	@ApiOperation(value = "Sugestão de termos para o domínio espécie")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoEspecies(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("species", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/veiculo")
	@ApiOperation(value = "Sugestão de termos para o domínio veículo")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna sugestões de termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<SugestaoDTO> sugestaoVeiculos(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("vehicles", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
}
