package br.com.ctsm.avoo;

import br.com.ctsm.avoo.model.DadosSerie;
import br.com.ctsm.avoo.service.ConsumoApi;
import br.com.ctsm.avoo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvooApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		/*System.out.printf(json);

		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");*/
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);


	}

	public static void main(String[] args) {
		SpringApplication.run(AvooApplication.class, args);
	}

}
