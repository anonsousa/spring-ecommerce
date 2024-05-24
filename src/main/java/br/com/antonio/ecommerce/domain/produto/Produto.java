package br.com.antonio.ecommerce.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_produto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

    @Column(name = "id_produto")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProduto;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false, length = 2000)
    private String descricao;
    @Column(name = "tipo_categoria", length = 50)
    private TipoCategoria tipoCategoria;
    @Column(length = 40)
    private String marca;
    @Column(name = "imagem_url")
    private String imagemUrl;
    @Column(nullable = false)
    private int estoque;
    @Column(name = "data_adicao")
    private LocalDate dataAdicao;


    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public LocalDate getDataAdicao() {
        return dataAdicao;
    }

    public void setDataAdicao(LocalDate dataAdicao) {
        this.dataAdicao = dataAdicao;
    }
}
