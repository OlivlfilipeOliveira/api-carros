package br.edu.ufa.estudo.carros;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ufal.estudo.carros.domain.Carro;
import br.edu.ufal.estudo.carros.domain.CarroService;
import br.edu.ufal.estudo.carros.domain.dto.CarroDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration
//@SpringBootTest(classes = Carro.class)
class CarrosApplicationTests {
	
	@Autowired
	private CarroService carroService;// = new CarroService();
	
	@Test
	public void test1() {
		Carro carro = new Carro();
		carro.setNome("Teste");
		carro.setTipo("Esportivo");
		
		CarroDTO c = this.carroService.save(carro);
		
		assertNotNull(c);
		
		Optional<CarroDTO> op = this.carroService.getById(c.getId());
		
		assertTrue(op.isPresent());
		
		c = op.get();
		
		assertEquals("Teste", c.getNome());
		assertEquals("Esportivo", c.getTipo());
		
		this.carroService.delete(c.getId());
		
		assertFalse(this.carroService.getById(c.getId()).isPresent());
	}
	

}
