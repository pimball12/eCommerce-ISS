package br.iss.ecommerce.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.util.HibernateUtil;

public class GradeDaoTest {

	@Test
	@Ignore
	public void save()	{
		
		GradeDAO gradeDAO = new GradeDAO();
		
		Grade 		grade;
		ItemGrade 	itemGrade;
		Set<ItemGrade> itensGrade;
		
		// Cor
		grade = new Grade();
		grade.setNome("Cor");
		
		itensGrade = new HashSet<ItemGrade>();
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("Preto");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("Branco");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("Azul");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("Vermelho");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
			
		grade.setItensGrade(itensGrade);
		
		gradeDAO.save(grade);
		
		// Tamanho
		grade = new Grade();
		grade.setNome("Tamanho");
		
		itensGrade = new HashSet<ItemGrade>();
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("PP");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("P");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("M");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("G");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);
		
		itemGrade = new ItemGrade();
		itemGrade.setValor("GG");
		itemGrade.setGrade(grade);
		itensGrade.add(itemGrade);		
		
		grade.setItensGrade(itensGrade);
		
		gradeDAO.save(grade);		
		
	}
	
	@Test
	@Ignore
	public void list()	{
		
		GradeDAO gradeDAO = new GradeDAO();
		
		List<Grade> grades = gradeDAO.list();
		
		for (Grade grade : grades) {
			
			System.out.println(grade);
			
			for (ItemGrade itemGrade : grade.getItensGrade()) {
				
				System.out.println("   " + itemGrade);
			}
		}
		
		HibernateUtil.getSession().close();
	}
	
}
