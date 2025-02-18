package edu.kyndryl.msalumnosprofe.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//JAVA BEAN: CLASE BÁSICA CON SUS ATRIBUTOS Y MÉTODOS DE ACCESO //RECORDS LOMBOK

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremento en MYSQL
	private Long id;
	
	private String nombre;
	private String apellido;
	private int edad;
	private String email;
	
	@Column(name = "creado_en")//para especificar un nombre distinto en la BD
	private LocalDateTime creadoEn;
	
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	public Alumno(Long id, String nombre, String apellido, int edad, String email, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.creadoEn = creadoEn;
	}
	
	@PrePersist//este método, se ejecutará justo antes de que se inserte un alumno en BD
	private void generarFechaCreacion ()
	{
		this.creadoEn = LocalDateTime.now();//obtenemos la fecha actual
	}
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	
	

}
