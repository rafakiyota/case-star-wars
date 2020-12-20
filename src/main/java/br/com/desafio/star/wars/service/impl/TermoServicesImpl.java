package br.com.desafio.star.wars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafio.star.wars.model.termo.TermoPaginaDTO;
import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.repository.entity.Busca;
import br.com.desafio.star.wars.service.TermoServices;

@Service
public class TermoServicesImpl implements TermoServices {
	
	@Autowired
	private BuscaRepo buscaRepo;

	@Override
	public TermoPaginaDTO all(Integer pagina) {
		
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findAll(pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosPersonagens(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("people", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosFilmes(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("films", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosPlanetas(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("planets", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosNaves(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("starships", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosEspecies(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("species", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}

	@Override
	public TermoPaginaDTO findTermosVeiculos(Integer pagina) {
		Pageable pageable = PageRequest.of(pagina, 10, Sort.by("quantidade").descending());
		Page<Busca> buscaPaginada = buscaRepo.findByDominio("vehicles", pageable);
		return new TermoPaginaDTO(buscaPaginada);
	}
}
