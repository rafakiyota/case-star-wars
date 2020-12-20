package br.com.desafio.star.wars.model.client.planet;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchPlanetDTO {
	
    private Long count;
	private String next;
	private String previous;
	private List<PlanetDTO> results;
}
