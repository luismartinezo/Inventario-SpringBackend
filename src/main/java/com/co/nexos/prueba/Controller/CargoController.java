/**
 * 
 */
package com.co.nexos.prueba.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.nexos.prueba.Excepciones.NexosExcepcion;
import com.co.nexos.prueba.Model.Cargo;
import com.co.nexos.prueba.Service.CargoService;
import com.co.nexos.prueba.Util.restResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/cargo")
@CrossOrigin(origins = "*")
public class CargoController {

	@Autowired
	@Qualifier("cargoServiceConfiguration")
	protected CargoService cargoService;

	protected ObjectMapper mapper;

	@PostMapping("/nuevo")
	public restResponse save(@RequestBody String cargoJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();
		Cargo cargo = this.mapper.readValue(cargoJson, Cargo.class);

		if (!this.validate(cargo)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		if (cargoService.existeId(cargo.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "El Cargo ya existe");
		}

		this.cargoService.save(cargo);
		return new restResponse(HttpStatus.OK.value(), "Cargo guardado con exito");
	}

	// Actualizar
	@PostMapping("/actualizar")
	public restResponse update(@RequestBody String cargoJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();

		Cargo cargo = this.mapper.readValue(cargoJson, Cargo.class);

		if (!cargoService.existeId(cargo.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el Cargo en la base de datos");
		}

		if (!this.validate(cargo)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo requerido sin diligenciar");
		}
		this.cargoService.update(cargo);
		return new restResponse(HttpStatus.OK.value(), "Cargo actualizo con exito");
	}

	// Listar todos
	@GetMapping("/lista")
	public List<Cargo> getCargos() {
		return this.cargoService.findAll();

	}

	// Eliminar
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.PATCH)
	public String deleteCargo(@PathVariable Long id) {
		return cargoService.delete(id);
	}

	// Detalles
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public Optional<Cargo> detail(@PathVariable Long id) {

		return cargoService.detail(id);
	}

	private boolean validate(Cargo cargo) {
		boolean isValid = true;

		if (cargo.getNombre() == null || cargo.getNombre() == "") {
			isValid = false;
		}
		return isValid;
	}
}
