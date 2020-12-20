package br.com.desafio.star.wars.model.nave;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.starship.SearchStarShipDTO;
import br.com.desafio.star.wars.model.client.starship.StarShipDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaNaveDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<StarShipDTO> starships = new ArrayList<>();
	
	public BuscaNaveDTO() {}
	
	public BuscaNaveDTO(SearchStarShipDTO searchStarShipDTO, Long pagina, List<String> suggestions) {
		if (searchStarShipDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchStarShipDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		starships = searchStarShipDTO.getResults();
	}
}
