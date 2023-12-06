package br.com.vnw;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private String nomeUsuario; // para trazer o nome do usuário
    private List<Produto> produtosNoCarrinho;

    // Construtor para referenciar a variável com o nome informado pelo usuário na Classe Principal
    public Carrinho(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.produtosNoCarrinho = new ArrayList<>();
    }
    
    // Adiciona um produto ao carrinho com base na quantidade especificada
    public boolean adicionarProduto(Produto produto, int quantidade) {
        if (produto != null && quantidade > 0) {
            for (Produto p : produtosNoCarrinho) {
                if (p.idProduto == produto.idProduto) {
                    p.quantidade += quantidade; // Atualiza a quantidade do produto existente no carrinho
                    System.out.println("\nProduto adicionado ao carrinho com sucesso!");
                    return true; // Produto adicionado com sucesso
                }
            }

            // Se o produto não estiver no carrinho, adiciona-o
            Produto copiaProduto = new Produto(
                    produto.idProduto,
                    produto.nome,
                    produto.valor,
                    quantidade);
            produtosNoCarrinho.add(copiaProduto);
            System.out.println("\nProduto adicionado ao carrinho com sucesso!");
            return true; // Produto adicionado com sucesso
        } else {
            System.out.println("Não foi possível adicionar o produto ao carrinho.");
            return false; // Produto não pôde ser adicionado
        }
    }


    // Exibe os itens presentes no carrinho ou informa se está vazio
    public void exibirItensNoCarrinho() {
        if (produtosNoCarrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println(nomeUsuario + ", estes são os produtos atualmente no carrinho:");
            for (Produto produto : produtosNoCarrinho) {
                double valorTotalItem = produto.valor * produto.quantidade;
                String valorTotalFormatado = String.format("%.2f", valorTotalItem);
                System.out.println("- " + produto.nome + " | Quantidade: " + produto.quantidade + " | Valor Total: " + valorTotalFormatado);
            }
        }
    }


    // Calcula o valor total dos itens presentes no carrinho
	/* usa um loop para olhar cada produto que está no carrinho. Para cada produto,
	 * ele pega o valor do produto e multiplica pela quantidade desse produto no
	 * carrinho. Em seguida, soma isso ao valor total. Dessa forma, ao final do
	 * loop, o total vai ser o custo de todos os itens no carrinho juntos. */
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtosNoCarrinho) {
            total += produto.valor * produto.quantidade;
        }
        return total;
    }

    // Limpa o carrinho removendo todos os produtos
    public void limparCarrinho() {
        produtosNoCarrinho.clear();
        System.out.println("\nCarrinho limpo. Todos os produtos foram removidos.");
    }

    // Retorna a lista de produtos no carrinho
    public List<Produto> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }
}