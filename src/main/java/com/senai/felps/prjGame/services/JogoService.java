package com.senai.felps.prjGame.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.senai.felps.prjGame.entities.Jogo;
import com.senai.felps.prjGame.repository.JogoRepository;

@Service
public class JogoService {
private final JogoRepository jogoRepository;
	
	public JogoService (JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
		
	}
	
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public List<Jogo> getAllJogo(){
		return jogoRepository.findAll();
	}
	
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	public Jogo updateJogo(Long id, Jogo novoJogo) {
        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
        if (jogoOptional.isPresent()) {
        	Jogo jogoExistente = jogoOptional.get();
           	jogoExistente.setName(novoJogo.getName());
        	jogoExistente.setPlataforma(novoJogo.getPlataform());          
            return jogoRepository.save(jogoExistente); 
        } else {
            return null; 
        }
    }
}
