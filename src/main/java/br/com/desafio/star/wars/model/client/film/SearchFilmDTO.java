package br.com.desafio.star.wars.model.client.film;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchFilmDTO {
	
    private Long count;
	private String next;
	private String previous;
	private List<FilmDTO> results;
}
