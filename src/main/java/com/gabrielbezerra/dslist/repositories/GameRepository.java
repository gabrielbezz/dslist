package com.gabrielbezerra.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielbezerra.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	
	
}
