package com.dickyis.games;

import com.dickyis.games.service.GamesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamesApplication {

	public static void main(String[] args) {

		SpringApplication.run(GamesApplication.class, args);


		GamesService gameService = new GamesService();
		gameService.startTicTacToe();
	}
}
