package com.example.senai.exemploDTO.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senai.exemploDTO.DTO.LivroDTO;
import com.example.senai.exemploDTO.Repository.LivroRepository;
import com.example.senai.exemploDTO.entities.Livro;


@Service
public class LivroService{

private final LivroRepository livroRepository;

@Autowired
public LivroService(LivroRepository livroRepository) {
	this.livroRepository = livroRepository;
	
}

public LivroDTO salvar(Livro livro) {
	Livro salvarLivro = livroRepository.save(livro);
	return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
}

public LivroDTO atualizar(Long id, Livro livro) {
	Livro existeLivro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	existeLivro.setTitulo(livro.getTitulo());
	existeLivro.setAutor(livro.getAutor());
	Livro updateLivro = livroRepository.save(existeLivro);
	return new LivroDTO(updateLivro.getId(), updateLivro.getTitulo(), updateLivro.getAutor());
}

public boolean deletar(Long id) {
	Optional<Livro> existeCliente = livroRepository.findById(id);
	if (existeCliente.isPresent()) {
		livroRepository.deleteById(id);
		return true;
	}
	return false;
}



public List<Livro> buscarTodos(){
		return livroRepository.findAll();
}

public Livro buscarPorId(Long id) {
	Optional <Livro> Livro = livroRepository.findById(id);
	return Livro.orElse(null);
}
}
