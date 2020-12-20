package br.com.desafio.star.wars.model.client.specie;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchSpecieDTO {
	
    private Long count;
	private String next;
	private String previous;
	private List<SpecieDTO> results;
}
