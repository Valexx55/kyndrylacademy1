package edu.kyndryl.msalumnosprofe.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.kyndryl.msalumnosprofe.model.Alumno;
import edu.kyndryl.msalumnosprofe.model.FraseChiquito;
import edu.kyndryl.msalumnosprofe.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	private static final String URL_CHIQUITO_FRASE = "https://chiquitadas.es/api/quotes/avoleorrr";

	@Override
	@Transactional
	public Alumno alta(Alumno alumno) {

		return this.alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void bajaPorId(Long id) {
		this.alumnoRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = false)
	public Optional<Alumno> modificar(Alumno alumno, Long id) {
		
		Optional<Alumno> oa= Optional.empty();
		
		//1 LEER POR ID EL REGISTRO QUE QUIERO MODIFICAR
			oa = this.alumnoRepository.findById(id);
			if (oa.isPresent())
			{
				Alumno alumnoLeido = oa.get();//EL OBJETO ESTÁ EN PERSISTENT - si modifico un atributo, estoy modificando la columna asociada de la bd
				alumnoLeido.setApellido(alumno.getApellido());
				alumnoLeido.setNombre(alumno.getNombre());
				alumnoLeido.setEdad(alumno.getEdad());
				alumnoLeido.setEmail(alumno.getEmail());
				//alumno.getNombre().charAt(10);
				BeanUtils.copyProperties(alumno, alumnoLeido, "id", "creadoEn");
				//this.alumnoRepository.save(alumnoLeido);
				
			}
		//1.2 MODIFICAR LOS ATRIBUTOS
		//2 SALVAR LOS CAMBIOS
		return oa;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> consulta(Long id) {
		return this.alumnoRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> consultarTodos() {

		return this.alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> consultarAlumnosEntreEdad(int edadmin, int edadmax) {

		return this.alumnoRepository.findByEdadBetween(edadmin, edadmax);
	}

	@Override
	public Optional<FraseChiquito> obtenerFraseChiquitoAleatoria() {
		Optional<FraseChiquito> optionalFrase = Optional.empty();
		RestTemplate restTemplate = null;
		FraseChiquito fraseChiquito = null;
		
			restTemplate = new RestTemplate();
			fraseChiquito = restTemplate.getForObject(URL_CHIQUITO_FRASE, FraseChiquito.class);
			optionalFrase = Optional.of(fraseChiquito);
		
		return optionalFrase;
	}

}
