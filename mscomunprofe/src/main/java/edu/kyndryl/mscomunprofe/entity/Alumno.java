package edu.kyndryl.mscomunprofe.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//JAVA BEAN: CLASE BÁSICA CON SUS ATRIBUTOS Y MÉTODOS DE ACCESO //RECORDS LOMBOK

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremento en MYSQL
	private Long id;
	
	@Size(min = 3, max = 20)
	private String nombre;

	@NotEmpty
	private String apellido;
	
	@Max(120)
	@Min(10)
	private int edad;
	
	@Email
	//@JsonIgnore //con esta anotación evitamos que la propiedad se serialice a JSON
	private String email;
	
	@Column(name = "creado_en")//para especificar un nombre distinto en la BD
	private LocalDateTime creadoEn;
	
	@Lob
	@JsonIgnore //evitamos que se serialice en la respuesta
	private byte[] foto;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	//este atributo hashcode nos indica si el registro
	//tiene foto asociada o no
	public Integer getFotoHashCode ()
	{
		Integer codeDev = null;
		
		if (this.foto != null)
		{
			codeDev = this.foto.hashCode();
		}
			
		
		return codeDev;
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
	
	
	
	public byte[] getFoto() {
		return foto;
	}



	public void setFoto(byte[] foto) {
		this.foto = foto;
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
	
	@Override
	public boolean equals(Object obj) //sobreescribimos equals porque al borrar un ALumno de la lista del curso, se usará 
	{
		boolean iguales = false;
		
			if (this ==obj)
			{
				iguales = true;
			} else if (obj instanceof Alumno a) {
				
				iguales =  Objects.equals(this.id, a.id);//para mi, dos alumnos son iguales, si tienen el mismo id
			}
		
		
		return iguales;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", email="
				+ email + ", creadoEn=" + creadoEn + "]";
	}
	
	
	

}
