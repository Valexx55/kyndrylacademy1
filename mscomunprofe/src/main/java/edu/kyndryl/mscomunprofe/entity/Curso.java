package edu.kyndryl.mscomunprofe.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //en ocasiones, el Curso se dividiría en 2 clases: DAO Data Access Object = (Entity, el curso -tabla- en su relación con la base de datos) y otro el BEAN DTO (DATA TRANSFER OBJECT), es el Curso "puro"
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoinc
	private Long id;
	
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY)//es que cuando lea un curso, no cargue los alumnos, hasta que no se necesiten
	List<Alumno> alumnos;

	
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
	
	public void addAlumno (Alumno alumno)
	{
		this.alumnos.add(alumno);
	}
	
	public void borrarAlumno (Alumno alumno)
	{
		this.alumnos.remove(alumno);
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
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
