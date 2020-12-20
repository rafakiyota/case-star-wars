package br.com.desafio.star.wars.model.client.people;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchPeopleDTO {
	
    private Long count;
	private String next;
	private String previous;
	private List<PeopleDTO> results;
}
