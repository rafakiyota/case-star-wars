package br.com.desafio.star.wars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.star.wars.model.termo.TermoPaginaDTO;
import br.com.desafio.star.wars.service.TermoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/termo")
@Api(tags = "API Termo", description = "API de termos mais consultados")
public class TermoController {

	@Autowired
	private TermoServices service;
	
	@GetMapping
	@ApiOperation(value = "Recupera os termos mais consultados para todos os domínios")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> all(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.all(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/personagem")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio personagem")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosPersonagens(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosPersonagens(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/filme")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio filme")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosFilmes(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosFilmes(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/planeta")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio planeta")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosPlanetas(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosPlanetas(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/nave")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio nave")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosNaves(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosNaves(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/especie")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio espécie")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosEspecies(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosEspecies(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/veiculo")
	@ApiOperation(value = "Recupera os termos mais consultados para o domínio veículo")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "retorna os termos"),
	    @ApiResponse(code = 500, message = "Ocorreu um erro inesperado no servidor"),
	})
	public ResponseEntity<TermoPaginaDTO> findTermosVeiculos(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosVeiculos(pagina);
		return ResponseEntity.ok(response);
	}
}
