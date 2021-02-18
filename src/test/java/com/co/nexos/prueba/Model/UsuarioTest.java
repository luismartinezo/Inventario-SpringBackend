package com.co.nexos.prueba.Model;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Usuario usuario;
	Date fecha = new Date();
	@BeforeEach
	protected void setUp() throws Exception {
		// Se comenta ya que el constructor del Modelo crea error
//		usuario = new Usuario((long) 0, "Luis", "Martinez",30, fecha);
		usuario = new Usuario();
	}

	
	@Test
	public void testGetNombre() throws Exception {
		//given

		//when

		//then
		Assert.assertTrue(usuario.getNombre().equals("Luis"));
	}

}


