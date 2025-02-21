package edu.kyndryl.mscursosprofe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //en ocasiones, el Curso se dividiría en 2 clases: DAO Data Access Object = (Entity, el curso -tabla- en su relación con la base de datos) y otro el BEAN DTO (DATA TRANSFER OBJECT), es el Curso "puro"
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoinc
	private Long id;
	
	private String nombre;

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

	public Curso(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

}
