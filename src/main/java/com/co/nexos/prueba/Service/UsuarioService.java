/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.*;

import com.co.nexos.prueba.Model.Usuario;

/**
 * @author luis.martinez
 *
 */
public interface UsuarioService {

	Usuario save(Usuario usuario);

    List<Usuario> findAll();
    Usuario update(Usuario usuario);

    String delete(Long id);

    boolean existeId(Long id);

    Optional<Usuario> detail(Long id);
}
