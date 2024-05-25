package br.com.antonio.ecommerce.domain.produto;

import br.com.antonio.ecommerce.infra.ProductNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public ProdutoMostrarDto save(ProdutoCadastroDto produtoCadastroDto){
        var produtoModel = new Produto();
        BeanUtils.copyProperties(produtoCadastroDto, produtoModel);
        produtoModel.setDataAdicao(LocalDate.now());
        return new ProdutoMostrarDto(produtoRepository.save(produtoModel));
    }

    public ProdutoMostrarDto findOneProduct(UUID uuid){
        var productOp = produtoRepository.findById(uuid);
        if (productOp.isPresent()){
            return new ProdutoMostrarDto(productOp.get());
        } else {
            throw new ProductNotFound("Produto não encontrado!");
        }
    }

    public Page<ProdutoMostrarDto> findAllProducts(Pageable pageable){
        return produtoRepository.findAll(pageable).map(ProdutoMostrarDto::new);
    }

    @Transactional
    public ProdutoMostrarDto updateProduct(ProdutoAtualizarDto produtoAtualizarDto){
        var productOp = produtoRepository.findById(produtoAtualizarDto.idProduto());
        if (productOp.isPresent()){
            var produto = new Produto();
            BeanUtils.copyProperties(produtoAtualizarDto, produto);
            return new ProdutoMostrarDto(produtoRepository.save(produto));
        }
        throw new ProductNotFound("Produto não encontrado!");
    }

    @Transactional
    public void deleteById(UUID uuid){
        var productOp = produtoRepository.findById(uuid);
        if (productOp.isPresent()){
            produtoRepository.deleteById(uuid);
        }
        throw new ProductNotFound("Produto não encontrado:!");
    }















}
