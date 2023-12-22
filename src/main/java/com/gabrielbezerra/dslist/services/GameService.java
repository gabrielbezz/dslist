package com.gabrielbezerra.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielbezerra.dslist.DTO.GameDTO;
import com.gabrielbezerra.dslist.DTO.GameMinDTO;
import com.gabrielbezerra.dslist.entities.Game;
import com.gabrielbezerra.dslist.projections.GameMinProjection;
import com.gabrielbezerra.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
 		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
 		return dto;
	}

	public Game fromGameDTO(GameDTO gameDto) {
		return new Game(gameDto.getId(), 
				gameDto.getTitle(), 
				gameDto.getYear(), 
				gameDto.getGenre(), 
				gameDto.getPlatforms(), 
				gameDto.getScore(), 
				gameDto.getImgUrl(), 
				gameDto.getShortDescription(), 
				gameDto.getLongDescription() 
		);
	}
	
	public Game insert(Game game) {
		
		return gameRepository.save(game);
		
	}
}
