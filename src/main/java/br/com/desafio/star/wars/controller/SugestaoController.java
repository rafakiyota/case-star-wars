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

@RestController
@RequestMapping("/v1/sugestao")
public class SugestaoController {

	@Autowired
	private SugestaoServices service;
	
	@GetMapping
	public ResponseEntity<SugestaoDTO> sugestaoPorTermo(@RequestParam String termo) {		
		List<String> sugestoes = service.sugestaoPorTermo(termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/personagem")
	public ResponseEntity<SugestaoDTO> sugestaoPersonagens(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("people", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/filme")
	public ResponseEntity<SugestaoDTO> sugestaoFilmes(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("films", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/planeta")
	public ResponseEntity<SugestaoDTO> sugestaoPlanetas(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("planets", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/nave")
	public ResponseEntity<SugestaoDTO> sugestaoNaves(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("starships", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/especie")
	public ResponseEntity<SugestaoDTO> sugestaoEspecies(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("species", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
	
	@GetMapping("/veiculo")
	public ResponseEntity<SugestaoDTO> sugestaoVeiculos(@RequestParam String termo) {
		List<String> sugestoes = service.sugestaoPorDominioTermo("vehicles", termo);
		return ResponseEntity.ok(new SugestaoDTO(sugestoes));
	}
}
