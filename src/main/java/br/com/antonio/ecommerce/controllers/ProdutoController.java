package br.com.antonio.ecommerce.controllers;


import br.com.antonio.ecommerce.domain.produto.ProdutoCadastroDto;
import br.com.antonio.ecommerce.domain.produto.ProdutoMostrarDto;
import br.com.antonio.ecommerce.domain.produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<ProdutoMostrarDto> save(@RequestBody @Valid ProdutoCadastroDto produtoCadastroDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoCadastroDto));
    }

    @GetMapping("/produto/{uuid}")
    public ResponseEntity<ProdutoMostrarDto> findOneProduct(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findOneProduct(uuid));
    }


}
