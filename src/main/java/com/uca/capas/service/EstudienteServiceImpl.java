package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudienteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.findAll();
	}

	@Override
	public void insert(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.insert(estudiante);
		
	}

	@Override
	public void delete(Integer CodigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.delete(CodigoEstudiante);
		
	}
	

}
