package br.com.desafio.star.wars.model.sugestao;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SugestaoDTO {

	private List<String> suggestions = new ArrayList<>();
	
	public SugestaoDTO() {}
	
	public SugestaoDTO(List<String> suggestions) {
		this.suggestions = suggestions;
	}
}
