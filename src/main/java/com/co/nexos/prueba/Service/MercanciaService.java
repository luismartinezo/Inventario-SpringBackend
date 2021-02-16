/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import com.co.nexos.prueba.Model.Mercancia;

/**
 * @author luis.martinez
 *
 */
public interface MercanciaService {
	Mercancia save(Mercancia mercancia);

    List<Mercancia> findAll();
    Mercancia update(Mercancia mercancia);

    String delete(Long id);

    boolean existeId(Long id);

    Optional<Mercancia> detail(Long id);
}
