package br.iss.ecommerce.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Grupo;

public class GrupoDaoTest {

	@Test
	//@Ignore
	public void save()	{
		
		GradeDAO gradeDAO = new GradeDAO();
		Set<Grade> grades = new HashSet<Grade>(gradeDAO.list());		
		
		GrupoDAO grupoDAO = new GrupoDAO();
		
		Grupo grupo = new Grupo();
		grupo.setNome("Geral");
		grupo.setGrades(grades);
		
		grupoDAO.save(grupo);
	}
	
}
