/**
 * 
 */
package com.co.nexos.prueba.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.co.nexos.prueba.Excepciones.NexosExcepcion;
import com.co.nexos.prueba.Model.Usuario;
import com.co.nexos.prueba.Service.UsuarioService;
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
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioServiceConfiguration")
	protected UsuarioService usuarioService;

	protected ObjectMapper mapper;

	@PostMapping("/nuevo")
	public restResponse save(@RequestBody String usuarioJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		this.validator(usuario);
		if (!this.validate(usuario)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
		}
		if (usuarioService.existeId(usuario.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "El usuario ya existe");
		}

		this.usuarioService.save(usuario);
		return new restResponse(HttpStatus.OK.value(), "usuario guardado con exito");
	}

	// Actualizar
	@PostMapping("/actualizar")
	public restResponse update(@RequestBody String usuarioJson)
			throws JsonMappingException, JsonProcessingException, NexosExcepcion {
		this.mapper = new ObjectMapper();
		
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		this.validator(usuario);
		if (!usuarioService.existeId(usuario.getId())) {
			return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el usuario en la base de datos");
		}

		if (!this.validate(usuario)) {
			return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo requerido sin diligenciar");
		}
		this.usuarioService.update(usuario);
		return new restResponse(HttpStatus.OK.value(), "usuario actualizo con exito");
	}

	// Listar todos
	@GetMapping("/lista")
	public List<Usuario> getUsuarios() {
		return this.usuarioService.findAll();

	}

	// Eliminar
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.PATCH)
	public String deleteUsuario(@PathVariable Long id) {
		return usuarioService.delete(id);
	}

	// Detalles
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public Optional<Usuario> detail(@PathVariable Long id) {

		return usuarioService.detail(id);
	}

	private boolean validate(Usuario usuario) {
		boolean isValid = true;

		if (usuario.getNombre() == null || usuario.getNombre() == "") {
			isValid = false;
		}
		return isValid;
	}
	
	public void validator(Usuario usuario) throws NexosExcepcion {
		java.util.Date fecha = new Date();
		if(usuario.getFecha_ingreso().after(fecha)) {
			message("La fecha de ingreso debe ser menor o igual a la fecha actual");
		}
		
	}
    private void message(String mensaje) throws NexosExcepcion {
    	throw new NexosExcepcion(mensaje);
    }

}
