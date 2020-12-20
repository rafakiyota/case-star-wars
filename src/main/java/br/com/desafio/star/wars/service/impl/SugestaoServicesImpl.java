package br.com.desafio.star.wars.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafio.star.wars.repository.BuscaRepo;
import br.com.desafio.star.wars.service.SugestaoServices;

@Service
public class SugestaoServicesImpl implements SugestaoServices {
	
	@Autowired
	private BuscaRepo buscaRepo;

	@Override
	public List<String> sugestaoPorDominioTermo(String dominio, String termo) {
		
		if (StringUtils.isBlank(termo)) {
			termo = new String("");
		}
		
		Pageable pageable = PageRequest.of(0, 4, Sort.by("quantidade").descending());
		List<String> sugestoes01 = buscaRepo.findByDominioLikeTermo(dominio, termo.toLowerCase(), pageable)
				.stream().map(b -> b.getTermo()).collect(Collectors.toList());
		
		List<String> sugestoes02 = buscaRepo.findByDominio(dominio, pageable)
				.stream().map(b -> b.getTermo()).collect(Collectors.toList());
		
		List<String> sugestoesBusca = new ArrayList<>();
		for (String s : sugestoes01) {
			if (!sugestoesBusca.contains(s)) {
				sugestoesBusca.add(s);
			}
		}
		for (String s : sugestoes02) {
			if (!sugestoesBusca.contains(s)) {
				sugestoesBusca.add(s);
			}
		}
		
		return sugestoesBusca;
	}

	@Override
	public List<String> sugestaoPorTermo(String termo) {
		
		if (StringUtils.isBlank(termo)) {
			termo = new String("");
		}
		
		Pageable pageable = PageRequest.of(0, 4, Sort.by("quantidade").descending());
		List<String> sugestoes01 = buscaRepo.findByTermo(termo.toLowerCase(), pageable)
				.stream().map(b -> b.getTermo()).collect(Collectors.toList());
		
		List<String> sugestoes02 = buscaRepo.findAll(pageable)
				.stream().map(b -> b.getTermo()).collect(Collectors.toList());
		
		List<String> sugestoesBusca = new ArrayList<>();
		for (String s : sugestoes01) {
			if (!sugestoesBusca.contains(s)) {
				sugestoesBusca.add(s);
			}
		}
		for (String s : sugestoes02) {
			if (!sugestoesBusca.contains(s)) {
				sugestoesBusca.add(s);
			}
		}
		
		return sugestoesBusca;
	}
}
