package br.iss.ecommerce.dao;

import org.junit.Ignore;
import org.junit.Test;
import br.iss.ecommerce.domain.Parametro;

public class ParametroDaoTest {

	@Test
	@Ignore
	public void save()	{
		
		ParametroDAO parametroDAO = new ParametroDAO();
		Parametro parametro = new Parametro();
		
		parametro.setEmail("luizjunior_2005@hotmail.com");
		parametro.setRemetente(null);
		
		parametroDAO.save(parametro);
	}
}
