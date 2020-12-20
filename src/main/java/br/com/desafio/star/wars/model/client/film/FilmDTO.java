package br.com.desafio.star.wars.model.client.film;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FilmDTO {

	private String title;
	private Long episode_id;
	private String opening_crawl;
	private String director;
	private String producer;
	private String release_date;
}
