package br.com.desafio.star.wars.model.veiculo;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.star.wars.model.client.vehicle.SearchVehicleDTO;
import br.com.desafio.star.wars.model.client.vehicle.VehicleDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuscaVeiculoDTO {
	
    private Long currentPage;
	private Long nextPage;
	private Long previousPage;
	private List<String> suggestions = new ArrayList<>();
	private List<VehicleDTO> vehicles = new ArrayList<>();
	
	public BuscaVeiculoDTO() {}
	
	public BuscaVeiculoDTO(SearchVehicleDTO searchVehicleDTO, Long pagina, List<String> suggestions) {
		if (searchVehicleDTO.getPrevious() == null || pagina < 2) {
			previousPage = null;
		} else {
			previousPage = pagina - 1;
		}
		
		if (searchVehicleDTO.getNext() == null) {
			nextPage = null;
		} else {
			nextPage = pagina + 1;
		}
		
		currentPage = pagina;
		this.suggestions = suggestions;
		vehicles = searchVehicleDTO.getResults();
	}
}
