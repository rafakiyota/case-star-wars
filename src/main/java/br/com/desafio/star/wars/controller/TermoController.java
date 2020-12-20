package br.com.desafio.star.wars.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.star.wars.model.termo.TermoPaginaDTO;
import br.com.desafio.star.wars.service.TermoServices;

@RestController
@RequestMapping("/v1/termo")
public class TermoController {

	@Autowired
	private TermoServices service;
	
	@GetMapping
	public ResponseEntity<TermoPaginaDTO> all(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.all(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/personagem")
	public ResponseEntity<TermoPaginaDTO> findTermosPersonagens(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosPersonagens(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/filme")
	public ResponseEntity<TermoPaginaDTO> findTermosFilmes(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosFilmes(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/planeta")
	public ResponseEntity<TermoPaginaDTO> findTermosPlanetas(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosPlanetas(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/nave")
	public ResponseEntity<TermoPaginaDTO> findTermosNaves(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosNaves(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/especie")
	public ResponseEntity<TermoPaginaDTO> findTermosEspecies(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosEspecies(pagina);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/veiculo")
	public ResponseEntity<TermoPaginaDTO> findTermosVeiculos(
			@RequestParam(required=false, defaultValue="0") Integer pagina) {
		
		TermoPaginaDTO response = service.findTermosVeiculos(pagina);
		return ResponseEntity.ok(response);
	}
}
