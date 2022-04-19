package br.edu.ufal.estudo.carros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.edu.ufal.estudo.carros.domain.Carro;
import br.edu.ufal.estudo.carros.domain.CarroRepository;
import br.edu.ufal.estudo.carros.domain.User;
import br.edu.ufal.estudo.carros.domain.UserRepository;

@Component
public class DataLoader implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

	
	@Autowired
	private CarroRepository repository;
	
	@Autowired
	private UserRepository userRespository;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Carregando dados de teste na inicialização...");

		this.loadCars();
		this.loadUsers();
		
		logger.info("Carros carregados: {}", repository.count());
		logger.info("Usuários carregados: {}", userRespository.count());
		logger.info("Finalizando teste na inicialização...");
	}
	
	private void loadUsers() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senha1 = encoder.encode("admin");
		User user1 = new User("Admin", "admin", "admin@gmail.com", senha1);
		
		String senha2 = encoder.encode("teste123");
		User user2 = new User("Filipe Oliveira", "fOliveira", "filipeo444@gmail.com", senha2);
		
		userRespository.save(user1);		
		userRespository.save(user2);
		
	}
	
	private void loadCars() {
		//Clássicos
		Carro c1 = new Carro("Tucker 1948","Descrição Tucker 1948","http://www.livroandroid.com.br/livro/carros/classicos/Tucker.png","http://www.livroandroid.com.br/livro/carros/classicos/tucker.mp4","-23.564224","-46.653156","classicos");
		Carro c2 = new Carro("Chevrolet Corvette","Descrição Chevrolet Corvette","http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_Corvette.png","http://www.livroandroid.com.br/livro/carros/classicos/corvette.mp4","-23.564224","-46.653156","classicos");
		Carro c3 = new Carro("Chevrolet Impala Coupe","Descrição Chevrolet Impala Coupe","http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_Impala_Coupe.png","http://www.livroandroid.com.br/livro/carros/classicos/chevrolet_impala.mp4","-23.564224","-46.653156","classicos");
		Carro c4 = new Carro("Cadillac Deville Convertible","Descrição Cadillac Deville Convertible","http://www.livroandroid.com.br/livro/carros/classicos/Cadillac_Deville_Convertible.png","http://www.livroandroid.com.br/livro/carros/classicos/cadillac_deville.mp4","-23.564224","-46.653156","classicos");
		Carro c5 = new Carro("Chevrolet Bel-Air","Descrição Chevrolet Bel-Air","http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_BelAir.png","http://www.livroandroid.com.br/livro/carros/classicos/chevrolet_bel_air.mp4","-23.564224","-46.653156","classicos");
		Carro c6 = new Carro("Cadillac Eldorado","Descrição Cadillac Eldorado","http://www.livroandroid.com.br/livro/carros/classicos/Cadillac_Eldorado.png","http://www.livroandroid.com.br/livro/carros/classicos/cadillac_eldorado.mp4","-23.564224","-46.653156","classicos");
		Carro c7 = new Carro("Ferrari 250 GTO","Descrição Ferrari 250 GTO","http://www.livroandroid.com.br/livro/carros/classicos/Ferrari_250_GTO.png","http://www.livroandroid.com.br/livro/carros/classicos/ferrari_gto.mp4","-23.564224","-46.653156","classicos");
		Carro c8 = new Carro("Dodge Challenger","Descrição Dodge Challenger","http://www.livroandroid.com.br/livro/carros/classicos/Dodge_Challenger.png","http://www.livroandroid.com.br/livro/carros/classicos/dodge_challenger.mp4","","","classicos");
		Carro c9 = new Carro("Camaro SS 1969","Descrição Camaro SS 1969","http://www.livroandroid.com.br/livro/carros/classicos/Camaro_SS.png","http://www.livroandroid.com.br/livro/carros/classicos/camaro_ss.mp4","-23.564224","-46.653156","classicos");
		Carro c10 = new Carro("Ford Mustang 1976","Descrição Ford Mustang 1976","http://www.livroandroid.com.br/livro/carros/classicos/Ford_Mustang.png","http://www.livroandroid.com.br/livro/carros/classicos/ford_mustang.mp4","-23.564224","-46.653156","classicos");

		//Esportivos
		Carro c11 = new Carro("Ferrari FF","Descrição Ferrari FF","http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png","http://www.livroandroid.com.br/livro/carros/esportivos/ferrari_ff.mp4","44.532218","10.864019","esportivos");
		Carro c12 = new Carro("AUDI GT Spyder","Descrição AUDI GT Spyder","http://www.livroandroid.com.br/livro/carros/esportivos/Audi_Spyder.png","http://www.livroandroid.com.br/livro/carros/esportivos/audi_gt.mp4","-23.564224","-46.653156","esportivos");
		Carro c13 = new Carro("Porsche Panamera","Descrição Porsche Panamera","http://www.livroandroid.com.br/livro/carros/esportivos/Porsche_Panamera.png","http://www.livroandroid.com.br/livro/carros/esportivos/porsche_panamera.mp4","-23.564224","-46.653156","esportivos");
		Carro c14 = new Carro("Lamborghini Aventador","Descrição Lamborghini Aventador","http://www.livroandroid.com.br/livro/carros/esportivos/Lamborghini_Aventador.png","http://www.livroandroid.com.br/livro/carros/esportivos/lamborghini_aventador.mp4","-23.564224","-46.653156","esportivos");
		Carro c15 = new Carro("Chevrolet Corvette Z06","Descrição Chevrolet Corvette Z06","http://www.livroandroid.com.br/livro/carros/esportivos/Chevrolet_Corvette_Z06.png","http://www.livroandroid.com.br/livro/carros/esportivos/chevrolet_corvette.mp4","-23.564224","-46.653156","esportivos");
		Carro c16 = new Carro("BMW M5","Descrição BMW M5","http://www.livroandroid.com.br/livro/carros/esportivos/BMW.png","http://www.livroandroid.com.br/livro/carros/esportivos/bmw-m5.mp4","-23.564224","-46.653156","esportivos");
		Carro c17 = new Carro("Renault Megane RS Trophy","Descrição Renault Megane RS Trophy","http://www.livroandroid.com.br/livro/carros/esportivos/Renault_Megane_Trophy.png","http://www.livroandroid.com.br/livro/carros/esportivos/renault_megane.mp4","-23.564224","-46.653156","esportivos");
		Carro c18 = new Carro("Maserati Grancabrio Sport","Descrição Maserati Grancabrio Sport","http://www.livroandroid.com.br/livro/carros/esportivos/Maserati_Grancabrio_Sport.png","http://www.livroandroid.com.br/livro/carros/esportivos/renault_megane.mp4","-23.564224","-46.653156","esportivos");
		Carro c19 = new Carro("McLAREN MP4-12C","Descrição McLAREN MP4-12C","http://www.livroandroid.com.br/livro/carros/esportivos/McLAREN.png","http://www.livroandroid.com.br/livro/carros/esportivos/mcLaren.mp4","-23.564224","-46.653156","esportivos");
		Carro c20 = new Carro("MERCEDES-BENZ C63 AMG","Descrição MERCEDES-BENZ C63 AMG","http://www.livroandroid.com.br/livro/carros/esportivos/MERCEDES_BENZ_AMG.png","http://www.livroandroid.com.br/livro/carros/esportivos/mercedes.mp4","-23.564224","-46.653156","esportivos");

		//Luxo
		Carro c21 = new Carro("Bugatti Veyron","Descrição Bugatti Veyron","http://www.livroandroid.com.br/livro/carros/luxo/Bugatti_Veyron.png","http://www.livroandroid.com.br/livro/carros/luxo/bugatti_veyron.mp4","-23.564224","-46.653156","luxo");
		Carro c22 = new Carro("Ferrari Enzo","Descrição Ferrari Enzo","http://www.livroandroid.com.br/livro/carros/luxo/Ferrari_Enzo.png","http://www.livroandroid.com.br/livro/carros/luxo/ferrari_enzo.mp4","-23.564224","-46.653156","luxo");
		Carro c23 = new Carro("Lamborghini Reventon","Descrição Lamborghini Reventon","http://www.livroandroid.com.br/livro/carros/luxo/Lamborghini_Reventon.png","http://www.livroandroid.com.br/livro/carros/luxo/lamborghini _reventon.mp4","-23.564224","-46.653156","luxo");
		Carro c24 = new Carro("Leblanc Mirabeau","Descrição Leblanc Mirabeau","http://www.livroandroid.com.br/livro/carros/luxo/Leblanc_Mirabeau.png","http://www.livroandroid.com.br/livro/carros/luxo/leblanc_mirabeau.mp4","-23.564224","-46.653156","luxo");
		Carro c25 = new Carro("Shelby Supercars Ultimate","Descrição Shelby Supercars Ultimate","http://www.livroandroid.com.br/livro/carros/luxo/Shelby_Supercars_Ultimate.png","http://www.livroandroid.com.br/livro/carros/luxo/shelby.mp4","-23.564224","-46.653156","luxo");
		Carro c26 = new Carro("Pagani Zonda","Descrição Pagani Zonda","http://www.livroandroid.com.br/livro/carros/luxo/Pagani_Zonda.png","http://www.livroandroid.com.br/livro/carros/luxo/pagani_zonda.mp4","-23.564224","-46.653156","luxo");
		Carro c27 = new Carro("Koenigsegg CCX","Descrição Koenigsegg CCX","http://www.livroandroid.com.br/livro/carros/luxo/Koenigsegg_CCX.png","http://www.livroandroid.com.br/livro/carros/luxo/koenigsegg.mp4","-23.564224","-46.653156","luxo");
		Carro c28 = new Carro("Mercedes SLR McLaren","Descrição Mercedes SLR McLaren","http://www.livroandroid.com.br/livro/carros/luxo/Mercedes_McLaren.png","http://www.livroandroid.com.br/livro/carros/luxo/mclaren_slr.mp4","-23.564224","-46.653156","luxo");
		Carro c29 = new Carro("Rolls Royce Phantom","Descrição Rolls Royce Phantom","http://www.livroandroid.com.br/livro/carros/luxo/Rolls_Royce_Phantom.png","http://www.livroandroid.com.br/livro/carros/luxo/rolls_royce.mp4","-23.564224","-46.653156","luxo");
		Carro c30 = new Carro("Lexus LFA","Descrição Lexus LFA","http://www.livroandroid.com.br/livro/carros/luxo/Lexus_LFA.png","http://www.livroandroid.com.br/livro/carros/luxo/lexus.mp4","-23.564224","-46.653156","luxo");

		
		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		repository.save(c4);
		repository.save(c5);
		repository.save(c6);
		repository.save(c7);
		repository.save(c8);
		repository.save(c9);
		repository.save(c10);
		repository.save(c11);
		repository.save(c12);
		repository.save(c13);
		repository.save(c14);
		repository.save(c15);
		repository.save(c16);
		repository.save(c17);
		repository.save(c18);
		repository.save(c19);
		repository.save(c20);
		repository.save(c21);
		repository.save(c22);
		repository.save(c23);
		repository.save(c24);
		repository.save(c25);
		repository.save(c26);
		repository.save(c27);
		repository.save(c28);
		repository.save(c29);
		repository.save(c30);
		
	}

}
