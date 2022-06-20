package sistema.integrador.oo2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.integrador.oo2.entities.Profesor;
import sistema.integrador.oo2.repositories.IProfesorRepositoryCRUD;
import sistema.integrador.oo2.services.*;

@Service("profesorService")
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	// @Qualifier("profesorRepository")
	private IProfesorRepositoryCRUD profesorRepository;

	@Override
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(Profesor profesor) {
		try {
			profesorRepository.save(profesor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Profesor findById(int id) {
		return profesorRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			profesorRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}