package com.gnoatto.library.Services;

import com.gnoatto.library.Models.LivroModel;
import com.gnoatto.library.Repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroModel criarLivro(LivroModel livro){
        return livroRepository.save(livro);
    }

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    public Optional<LivroModel> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public LivroModel atualizarLivro(Long id, LivroModel livroNovo){
        Optional<LivroModel> livroNobanco = livroRepository.findById(id);

        if (livroNobanco.isPresent()){
            LivroModel livroEditar = livroNobanco.get();

            livroEditar.setTitulo(livroNovo.getTitulo());
            livroEditar.setAutor(livroNovo.getAutor());
            livroEditar.setAnoPublicacao(livroNovo.getAnoPublicacao());

            return livroRepository.save(livroEditar);
        } else return  null;
    }


}
