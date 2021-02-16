/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.co.nexos.prueba.Model.Cargo;
import com.co.nexos.prueba.Repository.CargoRepository;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */
public class CargoServiceImp implements CargoService{

	@Autowired
    protected CargoRepository cargoRepository;

	@Override
	public Cargo save(Cargo cargo) {
		return this.cargoRepository.save(cargo);
	}

	@Override
	public List<Cargo> findAll() {
		return this.cargoRepository.findAll();
	}

	@Override
	public Cargo update(Cargo cargo) {
		return this.cargoRepository.save(cargo);
	}

	@Override
	public String delete(Long id) {
		if (cargoRepository.findById(id).isPresent()) {
			cargoRepository.deleteById(id);
            return "cargo eliminado correctamente.";
        }
        return "Error! El cargo no existe";
	}

	@Override
	public boolean existeId(Long id) {
		return this.cargoRepository.existsById(id);
	}

	@Override
	public Optional<Cargo> detail(Long id) {
		Optional<Cargo> cargo = cargoRepository.findById(id);
        return cargo;
	}

}
