/**
 * 
 */
package com.co.nexos.prueba.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private String nombre_producto;
}
