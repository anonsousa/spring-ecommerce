package br.com.antonio.ecommerce.domain.produto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoCadastroDto(

        @NotBlank(message = "Nome não pode ser nulo!")
        @Size(min = 3, max = 95)
        String nome,

        @NotNull(message = "Preço não pode ser nulo!")
        @Positive(message = "Preço pode ser apenas positivo!")
        BigDecimal preco,

        @NotBlank(message = "Descrição do item é obrgatória!")
        @Size(min = 10, max = 1900)
        String descricao,

        @NotNull(message = "Categoria é obrigatória!")
        TipoCategoria tipoCategoria,

        @NotBlank(message = "Marca é obrigatória!")
        @Size(min = 2, max = 37)
        String marca,

        @NotBlank(message = "Imagem é obrigatória!")
        @Size(min = 10, max = 240)
        String imagemUrl,

        @Positive(message = "Estoque tem que ser positivo")
        @NotNull(message = "Estoque é obrigatorio!")
        int estoque

) { }
