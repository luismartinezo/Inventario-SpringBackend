/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.co.nexos.prueba.Model.Mercancia;
import com.co.nexos.prueba.Repository.MercanciaRepository;


/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */
public class MercanciaServiceImp implements MercanciaService{

	@Autowired
    protected MercanciaRepository mercanciaRepository;

	@Override
	public Mercancia save(Mercancia mercancia) {
		return this.mercanciaRepository.save(mercancia);
	}

	@Override
	public List<Mercancia> findAll() {
		return this.mercanciaRepository.findAll();
	}

	@Override
	public Mercancia update(Mercancia mercancia) {
		return this.mercanciaRepository.save(mercancia);
	}

	@Override
	public String delete(Long id) {
		if (mercanciaRepository.findById(id).isPresent()) {
			mercanciaRepository.deleteById(id);
            return "producto eliminado correctamente.";
        }
        return "Error! El producto no existe";
	}

	@Override
	public boolean existeId(Long id) {
		return this.mercanciaRepository.existsById(id);
	}

	@Override
	public Optional<Mercancia> detail(Long id) {
		Optional<Mercancia> mercancia = mercanciaRepository.findById(id);
        return mercancia;
	}

}
