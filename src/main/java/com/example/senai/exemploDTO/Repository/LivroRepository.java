package com.example.senai.exemploDTO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.senai.exemploDTO.entities.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>{

	
}
