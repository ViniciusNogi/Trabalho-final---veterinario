package com.veterinario;

import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.veterinario.config.DBConfig;
import com.veterinario.view.Menu;

@SpringBootApplication
public class VeterinarioApplication implements CommandLineRunner{

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(VeterinarioApplication.class, args);

		
	}

	@Override
	public void run(String... args) throws Exception {
		
		DBConfig.getConnection();
		DBConfig.TBCliente();
		DBConfig.TBAnimal();
		DBConfig.TBMedicamento();
		DBConfig.TBReceita();
		DBConfig.TBVeterinario();
		DBConfig.TBConsulta();

		Menu menu = new Menu();
		menu.menuPrincipal();
	}

}
