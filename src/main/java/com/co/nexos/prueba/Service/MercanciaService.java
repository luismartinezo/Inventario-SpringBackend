/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import com.co.nexos.prueba.Model.Mercancia;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */
public interface MercanciaService {
	Mercancia save(Mercancia mercancia);

    List<Mercancia> findAll();
    Mercancia update(Mercancia mercancia);

    String delete(Long id);

    boolean existeId(Long id);

    Optional<Mercancia> detail(Long id);
}
