/**
 * 
 */
package com.co.nexos.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.nexos.prueba.Model.Cargo;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */
@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
