package br.com.antonio.ecommerce.domain.produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ProdutoMostrarDto(

        UUID idProduto,
        String nome,
        BigDecimal preco,
        String descricao,
        TipoCategoria tipoCategoria,
        String marca,
        String imagemUrl,
        int estoque,
        LocalDate dataAdicao
) {
    public ProdutoMostrarDto (Produto produto){
        this (
                produto.getIdProduto(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getTipoCategoria(),
                produto.getMarca(),
                produto.getImagemUrl(),
                produto.getEstoque(),
                produto.getDataAdicao()
        );
    }
}
