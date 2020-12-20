package br.com.desafio.star.wars.model.client.vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VehicleDTO {

	private String name;
	private String model;
	private String manufacturer;
	private String cost_in_credits;
	private String length;
	private String max_atmosphering_speed;
	private String crew;
	private String passengers;
	private String cargo_capacity;
	private String consumables;
	private String vehicle_class;
	
}
