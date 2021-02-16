/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import com.co.nexos.prueba.Model.Cargo;


/**
 * @author luis.martinez
 *
 */
public interface CargoService {
	Cargo save(Cargo cargo);

    List<Cargo> findAll();
    Cargo update(Cargo cargo);

    String delete(Long id);

    boolean existeId(Long id);

    Optional<Cargo> detail(Long id);
}
