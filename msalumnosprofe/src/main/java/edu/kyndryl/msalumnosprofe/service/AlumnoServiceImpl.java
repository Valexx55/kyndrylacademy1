package edu.kyndryl.msalumnosprofe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kyndryl.msalumnosprofe.model.Alumno;
import edu.kyndryl.msalumnosprofe.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;

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
	@Transactional
	public Optional<Alumno> modificar(Alumno alumno, Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
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

}
