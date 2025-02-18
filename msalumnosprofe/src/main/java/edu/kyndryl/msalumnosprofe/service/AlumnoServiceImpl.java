package edu.kyndryl.msalumnosprofe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.kyndryl.msalumnosprofe.model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Override
	public Alumno alta(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bajaPorId(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Alumno> modificar(Alumno alumno, Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Alumno> consulta(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Alumno> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
