package br.edu.ufal.estudo.carros.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ufal.estudo.carros.domain.Carro;
import br.edu.ufal.estudo.carros.domain.CarroService;
import br.edu.ufal.estudo.carros.domain.dto.CarroDTO;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

	@Autowired
	private CarroService service;
	
	@GetMapping()
	public ResponseEntity<List<CarroDTO>> getAll(){
		return ResponseEntity.ok(service.getCarros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> getById(@PathVariable Long id) {
		CarroDTO carro = service.getById(id);
		
		return ResponseEntity.ok(carro);
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CarroDTO>> getByTipo(@PathVariable String tipo){
		
		List<CarroDTO> carros = service.getByTipo(tipo);
		
		return carros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carros); 
	}
	
	@PostMapping
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<CarroDTO> post(@RequestBody Carro carro) {//requestBody converte o json para objeto
		CarroDTO carrodto = service.save(carro);
		
		URI location = getUri(carrodto.getId());
		
		return ResponseEntity.created(location).build();
		
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarroDTO> put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		
		CarroDTO c = service.update(id, carro);
		
		return c!= null? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
