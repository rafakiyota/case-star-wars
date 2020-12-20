package br.com.desafio.star.wars.model.termo;

import br.com.desafio.star.wars.repository.entity.Busca;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaDTO {
	
    private String dominio;
    private String termo;
	private Long quantidade;
	
	public BuscaDTO() {}

	public BuscaDTO(Busca busca) {
		this.dominio = busca.getDominio();
		this.termo = busca.getTermo();
		this.quantidade = busca.getQuantidade();
	}
}
