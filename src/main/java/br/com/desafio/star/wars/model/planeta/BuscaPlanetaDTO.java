package br.com.desafio.star.wars.model.planeta;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.planet.PlanetDTO;
import br.com.desafio.star.wars.model.client.planet.SearchPlanetDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaPlanetaDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<PlanetDTO> planets = new ArrayList<>();
	
	public BuscaPlanetaDTO() {}
	
	public BuscaPlanetaDTO(SearchPlanetDTO searchPlanetDTO, Long pagina, List<String> suggestions) {
		if (searchPlanetDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchPlanetDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		planets = searchPlanetDTO.getResults();
	}
}
