package edu.kyndryl.mscursosprofe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kyndryl.mscomunprofe.entity.Alumno;
import edu.kyndryl.mscomunprofe.entity.Curso;
import edu.kyndryl.mscursosprofe.repository.CursoRepository;

@Service
@Transactional // si definimos arriba esta anotación, aplica la transaccionalidad a todos los
				// métodos de la clase service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository cursoRepository;

	@Override
	public Iterable<Curso> findAll() {

		return this.cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> findById(Long id) {

		return this.cursoRepository.findById(id);
	}

	@Override
	public Curso save(Curso curso) {

		return this.cursoRepository.save(curso);
	}

	@Override
	public void deleteById(Long id) {
		this.cursoRepository.deleteById(id);
	}

	@Override
	public Optional<Curso> update(Curso curso, Long id) {
		Optional<Curso> oc = Optional.empty();

		oc = this.cursoRepository.findById(id);
		if (oc.isPresent()) {
			Curso cursoleido = oc.get();
			cursoleido.setNombre(curso.getNombre());
		}

		return oc;
	}

	@Override
	public Optional<Curso> matricularAlumnos(List<Alumno> lAlumnos, Long id) {
		Optional<Curso> oc = Optional.empty();

		oc = this.cursoRepository.findById(id);
		if (oc.isPresent()) {
			Curso cursoLeido = oc.get();
			lAlumnos.forEach(alumno -> cursoLeido.addAlumno(alumno));
			oc = Optional.of(cursoLeido);
		}

		return oc;
	}

	@Override
	public Optional<Curso> desmatricularAlumno(Alumno alumno, Long id) {
		Optional<Curso> oc = Optional.empty();

		oc = this.cursoRepository.findById(id);
		if (oc.isPresent()) {
			Curso cursoLeido = oc.get();
			cursoLeido.borrarAlumno(alumno);
			oc = Optional.of(cursoLeido);
		}

		return oc;
	}

}
