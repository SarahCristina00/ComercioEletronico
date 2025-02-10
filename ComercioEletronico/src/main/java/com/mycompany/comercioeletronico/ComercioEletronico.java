
package com.mycompany.comercioeletronico;

import java.util.ArrayList;
import java.util.List;


public class ComercioEletronico {
    
     private static Venda vender(Produto... produtos) {
        Venda venda = new Venda();
        for (Produto produto : produtos) {
            venda.adicionarProduto(produto);
        }
        return venda;
    }
     
     private static void gerarVenda(Venda venda, Cupom cupom) {
    if (cupom != null) {
        try {
            venda.aplicarCupom(cupom);
        } catch (CupomInvalidoException e) {
            System.out.println("Erro ao aplicar o cupom: " + e.getMessage());
        }
    }
    venda.getVenda(); 
}

    public static void main(String[] args) {
        // produtos
        List<Produto> produtos = List.of(
                new Eletronico("Smartphone Samsung Galaxy A52", 1500.00f, 12),
                new Eletronico("Ventilador Britania Turbo", 350.20f, 12),
                new Eletronico("Microondas Brastemp", 500.00f, 24),
                new Roupa("Uniforme Laranja Corinthians", 360.00f, 40, "Laranja e preto"),
                new Roupa("Tenis Nike Court", 125.00f, 36, "Azul e bege"),
                new Roupa("Moletom GOT - Brutall Kill", 159.98f, 42, "Preto"),
                new Alimento("Bolo de chocolate com cereja - Mamae eu quero",68.90f, "05/11/2025"),
                new Alimento("Lasanha a Bolonhesa Amabile & Kim", 24.90f, "15/06/2025"),
                new Alimento("Agua", 0.0f, "10/12/2025")
        );

        // cupons
        List<Cupom> cupons = List.of(
                new ValorMinimo(20, 100),
                new CupomLimitado(10, 5),
                new ValorMinimo(50, 500),
                new CupomLimitado(15, 2)
        );

//lista de compras
        List<Venda> vendas = new ArrayList<>();
        vendas.add(vender(produtos.get(1), produtos.get(5))); 
        vendas.add(vender(produtos.get(0), produtos.get(2), produtos.get(3)));
        vendas.add(vender(produtos.get(4), produtos.get(7), produtos.get(8))); 
        vendas.add(vender(produtos.get(6), produtos.get(6)));
        vendas.add(vender(produtos.get(1), produtos.get(7)));

   //adicions os cupons    
        gerarVenda(vendas.get(0), cupons.get(0)); 
        gerarVenda(vendas.get(1), null); 
        gerarVenda(vendas.get(2), null); 
        gerarVenda(vendas.get(3), cupons.get(2)); 
        gerarVenda(vendas.get(4), cupons.get(3));

     GerenciaVendas gestorVendas = new GerenciaVendas(vendas, cupons);


gestorVendas.gerarResumoVendas();  
gestorVendas.gerarResumoCupons(); 
    }
}