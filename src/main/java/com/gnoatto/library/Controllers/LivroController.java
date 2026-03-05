package com.gnoatto.library.Controllers;


import com.gnoatto.library.Models.LivroModel;
import com.gnoatto.library.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroModel criarLivro(@RequestBody LivroModel livroNovo){
        return livroService.criarLivro(livroNovo);
    }

    @GetMapping
    public List<LivroModel> buscarTodosLivros(){
        return livroService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public LivroModel atualizarLivro(@PathVariable Long id,@RequestBody LivroModel livroNovo){
        return livroService.atualizarLivro(id, livroNovo);
    }
}
