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
@Table(name = "mercancia")
public class Mercancia {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    private String nombre_producto;
	
	@Column
    private int cantidad;
	
	@Column
    private Date fecha_ingreso;
	
	@Column
    private int usuario_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	
}
