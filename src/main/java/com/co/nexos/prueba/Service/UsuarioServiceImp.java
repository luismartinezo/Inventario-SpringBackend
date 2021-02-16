/**
 * 
 */
package com.co.nexos.prueba.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.nexos.prueba.Model.Usuario;
import com.co.nexos.prueba.Repository.UsuarioRepository;

/**
 * @author luis.martinez
 *
 */

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
    protected UsuarioRepository usuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario update(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public String delete(Long id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
            return "usuario eliminado correctamente.";
        }
        return "Error! El usuario no existe";
	}

	@Override
	public boolean existeId(Long id) {
		return this.usuarioRepository.existsById(id);
	}

	@Override
	public Optional<Usuario> detail(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
	}

}
