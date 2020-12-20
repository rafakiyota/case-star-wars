package br.com.desafio.star.wars.model.filme;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.film.FilmDTO;
import br.com.desafio.star.wars.model.client.film.SearchFilmDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaFilmeDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<FilmDTO> films = new ArrayList<>();
	
	public BuscaFilmeDTO() {}
	
	public BuscaFilmeDTO(SearchFilmDTO searchFilmDTO, Long pagina, List<String> suggestions) {
		if (searchFilmDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchFilmDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		films = searchFilmDTO.getResults();
	}
}
