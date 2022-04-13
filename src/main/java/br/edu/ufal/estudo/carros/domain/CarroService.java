package br.edu.ufal.estudo.carros.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.edu.ufal.estudo.carros.domain.dto.CarroDTO;
import lombok.RequiredArgsConstructor;

@Service
public class CarroService {

	@Autowired(required = true)
	private CarroRepository repository;
	
	public List<CarroDTO> getCarros(){	
		return repository.findAll().stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
	}
	
	public Optional<CarroDTO> getById(Long id) {
		return repository.findById(id).map(c -> CarroDTO.create(c));
	}
	
	public List<CarroDTO> getByTipo(String tipo){
		return repository.findByTipo(tipo).stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
	}

	public CarroDTO save(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
		
		return CarroDTO.create(repository.save(carro));
	}

	public CarroDTO update(Long id, Carro carro) {
		
		Assert.notNull(id, "Não foi possível localizar o caro!");

		Carro c = repository.findById(id).orElse(null);
		System.out.println(c.getNome());
		if(c!=null) {
			c.setDescricao(carro.getDescricao());
			c.setLatitude(carro.getLatitude());
			c.setLongitude(carro.getLongitude());
			c.setNome(carro.getNome());
			c.setTipo(carro.getTipo());
			c.setUrl_foto(carro.getUrl_foto());
			c.setUrl_video(carro.getUrl_video());
			
			return CarroDTO.create(repository.save(c));
		}else {
			return null;
		}
	}

	public boolean delete(Long id) {
		
		if(getById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
