package com.gabrielbezerra.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielbezerra.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	
	
}
