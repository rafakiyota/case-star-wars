package br.com.desafio.star.wars.model.personagem;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.people.PeopleDTO;
import br.com.desafio.star.wars.model.client.people.SearchPeopleDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaPersonagemDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<PeopleDTO> characters = new ArrayList<>();
	
	public BuscaPersonagemDTO() {}
	
	public BuscaPersonagemDTO(SearchPeopleDTO searchPeopleDTO, Long pagina, List<String> suggestions) {
		if (searchPeopleDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchPeopleDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		characters = searchPeopleDTO.getResults();
	}
}
