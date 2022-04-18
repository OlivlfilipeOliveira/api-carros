package br.edu.ufa.estudo.carros;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ufal.estudo.carros.CarrosApplication;
import br.edu.ufal.estudo.carros.api.exception.ObjectNotFoundException;
import br.edu.ufal.estudo.carros.domain.Carro;
import br.edu.ufal.estudo.carros.domain.CarroService;
import br.edu.ufal.estudo.carros.domain.dto.CarroDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrosApplication.class)
class CarrosServiceTests {
	
	@Autowired(required = true)
	private CarroService carroService;// = new CarroService();
	
	
	@Test
	public void InsertAndDeletCarTest() {
		Carro carro = new Carro();
		carro.setNome("Teste");
		carro.setTipo("Esportivo");
		
		CarroDTO c = this.carroService.save(carro);
		
		assertNotNull(c);
		
		Long id = c.getId();
		assertNotNull(id);
		
		CarroDTO op = this.carroService.getById(c.getId());
		
		assertNotNull(op);
		
		
		assertEquals("Teste", c.getNome());
		assertEquals("Esportivo", c.getTipo());
		
		this.carroService.delete(c.getId());
		
		try {
			assertNull(this.carroService.getById(c.getId()));
			fail("O carro não foi excluído!");
		}catch (ObjectNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testeList(){
		List<CarroDTO> carros = carroService.getCarros();
		
		assertEquals(30, carros.size());
	}
	
	@Test
	public void testeListByType(){
		assertEquals(10, carroService.getByTipo("esportivos").size());
		assertEquals(10, carroService.getByTipo("luxo").size());
		assertEquals(10, carroService.getByTipo("classicos").size());
		
		assertEquals(0, carroService.getByTipo("x").size());

	}
	
	@Test
	public void testGet() {
		CarroDTO op = carroService.getById(1L);
		
		assertNotNull(op);
		
		
		assertEquals("Tucker 1948", op.getNome());
	}

}
