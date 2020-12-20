package br.com.desafio.star.wars.model.termo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.desafio.star.wars.repository.entity.Busca;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TermoPaginaDTO {

	private Integer totalPages;
	private Integer currentPage;
	private Boolean lastPage;
	private Boolean firstPage;
	private List<BuscaDTO> content = new ArrayList<>();
	
	public TermoPaginaDTO() {}
	
	public TermoPaginaDTO(Page<Busca> buscaPaginada) {
		this.totalPages = buscaPaginada.getTotalPages();
		this.currentPage = buscaPaginada.getNumber();
		this.lastPage = buscaPaginada.isLast();
		this.firstPage = buscaPaginada.isFirst();
		for (Busca busca : buscaPaginada) {
			addBusca(busca);
		}
	}
	
	public void addBusca(Busca busca) {
		this.content.add(new BuscaDTO(busca));
	}
}
