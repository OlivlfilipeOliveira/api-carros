package br.edu.ufal.estudo.carros.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	List<Carro> findByTipo(String tipo);
}
