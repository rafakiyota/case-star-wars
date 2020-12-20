package br.com.desafio.star.wars.model.client.people;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PeopleDTO {

	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String birth_year;
	private String gender;
}
