/**
 * 
 */
package com.co.nexos.prueba.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.co.nexos.prueba.Excepciones.NexosExcepcion;
import com.co.nexos.prueba.Model.Mercancia;
import com.co.nexos.prueba.Service.MercanciaService;
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
@RequestMapping("/api/v1/mercancia")
@CrossOrigin(origins = "*")
public class MercanciaController {

	@Autowired
	@Qualifier("mercanciaServiceConfiguration")
	protected MercanciaService mercanciaService;

	protected ObjectMapper mapper;

	@PostMapping("/nuevo")
	public restResponse save(@RequestBody String mercanciaJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();
		Mercancia mercancia = this.mapper.readValue(mercanciaJson, Mercancia.class);
		this.validator(mercancia);
		if (!this.validate(mercancia)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		if (mercanciaService.existeId(mercancia.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "El Producto ya existe");
		}

		this.mercanciaService.save(mercancia);
		return new restResponse(HttpStatus.OK.value(), "Producto guardado con exito");
	}

	// Actualizar
	@PostMapping("/actualizar")
	public restResponse update(@RequestBody String mercanciaJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();

		Mercancia mercancia = this.mapper.readValue(mercanciaJson, Mercancia.class);
		this.validator(mercancia);
		if (!mercanciaService.existeId(mercancia.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el Producto en la base de datos");
		}

		if (!this.validate(mercancia)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo requerido sin diligenciar");
		}
		this.mercanciaService.update(mercancia);
		return new restResponse(HttpStatus.OK.value(), "Producto actualizo con exito");
	}

	// Listar todos
	@GetMapping("/lista")
	public List<Mercancia> getProductos() {
		return this.mercanciaService.findAll();

	}

	// Eliminar
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.PATCH)
	public String deleteProducto(@PathVariable Long id) {
		return mercanciaService.delete(id);
	}

	// Detalles
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public Optional<Mercancia> detail(@PathVariable Long id) {

		return mercanciaService.detail(id);
	}

	private boolean validate(Mercancia mercancia) {
		boolean isValid = true;

		if (mercancia.getNombre_producto() == null || mercancia.getNombre_producto() == "") {
			isValid = false;
		}
		return isValid;
	}
	
	public void validator(Mercancia mercancia) throws NexosExcepcion {
		java.util.Date fecha = new Date();
		if(mercancia.getFecha_ingreso().after(fecha)) {
			message("La fecha de ingreso debe ser menor o igual a la fecha actual");
		}
		
	}
    private void message(String mensaje) throws NexosExcepcion {
    	throw new NexosExcepcion(mensaje);
    }
}
