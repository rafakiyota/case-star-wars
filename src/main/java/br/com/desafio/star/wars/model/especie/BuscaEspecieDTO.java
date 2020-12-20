package br.com.desafio.star.wars.model.especie;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.specie.SearchSpecieDTO;
import br.com.desafio.star.wars.model.client.specie.SpecieDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaEspecieDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<SpecieDTO> species = new ArrayList<>();
	
	public BuscaEspecieDTO() {}
	
	public BuscaEspecieDTO(SearchSpecieDTO searchSpecieDTO, Long pagina, List<String> suggestions) {
		if (searchSpecieDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchSpecieDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		species = searchSpecieDTO.getResults();
	}
}
