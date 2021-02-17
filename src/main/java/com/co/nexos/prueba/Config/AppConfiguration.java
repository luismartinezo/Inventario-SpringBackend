/**
 * 
 */
package com.co.nexos.prueba.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.nexos.prueba.Service.CargoService;
import com.co.nexos.prueba.Service.CargoServiceImp;
import com.co.nexos.prueba.Service.MercanciaService;
import com.co.nexos.prueba.Service.MercanciaServiceImp;
import com.co.nexos.prueba.Service.UsuarioService;
import com.co.nexos.prueba.Service.UsuarioServiceImp;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */

@Configuration
public class AppConfiguration {
	@Bean
	@Qualifier("usuarioServiceConfiguration")
	public UsuarioService usuarioServiceConfiguration() {
		return new UsuarioServiceImp();
	}

	@Bean
	@Qualifier("mercanciaServiceConfiguration")
	public MercanciaService mercanciaServiceConfiguration() {
		return new MercanciaServiceImp();
	}

	@Bean
	@Qualifier("cargoServiceConfiguration")
	public CargoService cargoServiceConfiguration() {
		return new CargoServiceImp();
	}
}
