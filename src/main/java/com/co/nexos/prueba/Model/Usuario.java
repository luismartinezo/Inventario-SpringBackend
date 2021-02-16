/**
 * 
 */
package com.co.nexos.prueba.Model;

import java.util.Date;

import javax.persistence.*;
/**
 * @author luis.martinez
 * @since 16/02/2021
 * @version 1.0
 */

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    
    @Column
    private String edad;
    
    @Column
    private int cargo_id;
    
    @Column
    private Date fecha_ingreso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public int getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(int cargo_id) {
		this.cargo_id = cargo_id;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
    
    
}
