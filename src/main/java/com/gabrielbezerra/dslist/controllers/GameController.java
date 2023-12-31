package com.gabrielbezerra.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielbezerra.dslist.DTO.GameDTO;
import com.gabrielbezerra.dslist.DTO.GameMinDTO;
import com.gabrielbezerra.dslist.entities.Game;
import com.gabrielbezerra.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@PostMapping
	public void insertGame(@RequestBody GameDTO gameDto) {
		Game obj = gameService.fromGameDTO(gameDto);
		gameService.insert(obj);
		
	}
}
