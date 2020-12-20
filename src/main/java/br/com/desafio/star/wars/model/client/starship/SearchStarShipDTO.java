package br.com.desafio.star.wars.model.client.starship;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchStarShipDTO {
	
    private Long count;
	private String next;
	private String previous;
	private List<StarShipDTO> results;
}
