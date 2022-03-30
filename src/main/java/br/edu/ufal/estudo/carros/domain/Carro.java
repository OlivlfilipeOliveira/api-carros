package br.edu.ufal.estudo.carros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String url_foto;
	private String url_video;
	private String latitude;
	private String longitude;
	private String tipo;
	
	public Carro(String nome, String descricao, String url_foto, String url_video, String latitude, String longitude,
			String tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.url_foto = url_foto;
		this.url_video = url_video;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tipo = tipo;
	}

		
}
