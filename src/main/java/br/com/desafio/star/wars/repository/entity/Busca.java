package br.com.desafio.star.wars.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Busca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "dominio")
    private String dominio;
	
	@Column(name = "termo")
    private String termo;
	
	@Column(name = "quantidade")
	private Long quantidade;
	
}
