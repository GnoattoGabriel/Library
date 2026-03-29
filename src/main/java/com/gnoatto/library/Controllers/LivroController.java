package com.gnoatto.library.Controllers;


import com.gnoatto.library.Models.LivroModel;
import com.gnoatto.library.Services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroNovo){
        LivroModel livro = livroService.criarLivro(livroNovo);
        return ResponseEntity.status(201).body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> buscarTodosLivros(){
        return ResponseEntity.ok(livroService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id,@RequestBody LivroModel livroNovo){
        LivroModel livro = livroService.atualizarLivro(id, livroNovo);
        return ResponseEntity.ok(livro);
    }



}
