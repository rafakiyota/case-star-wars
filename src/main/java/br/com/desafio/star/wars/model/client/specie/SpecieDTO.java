package br.com.desafio.star.wars.model.client.specie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SpecieDTO {

	private String name;
	private String classification;
	private String designation;
	private String average_height;
	private String skin_colors;
	private String hair_colors;
	private String eye_colors;
	private String average_lifespan;
	private String language;
	
}
