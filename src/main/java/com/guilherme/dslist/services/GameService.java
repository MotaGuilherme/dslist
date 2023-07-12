package com.guilherme.dslist.services;

import com.guilherme.dslist.dto.GameDTO;
import com.guilherme.dslist.dto.GameMinDTO;
import com.guilherme.dslist.entities.Game;
import com.guilherme.dslist.entities.GameList;
import com.guilherme.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
         List<Game> result = gameRepository.findAll();
         return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

}
