package com.mycompany.comercioeletronico;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Testes {
    private Produto produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9;
    private Venda venda1, venda2, venda3;
    private List<Venda> vendas = new ArrayList<>();
    private List<Cupom> cupons = new ArrayList<>();
    private ValorMinimo cupomValorMinimo;
    private CupomLimitado cupomQuantidadeLimitada;
    
        @BeforeEach
    void setUp() {
      
        produto1 = new Eletronico("Smartphone Samsung Galaxy A52", 1500.00f, 12);
        produto2 = new Eletronico("Ventilador Britania Turbo", 350.20f, 12);
        produto3 = new Eletronico("Microondas Brastemp", 500.00f, 24);
        produto4 = new Roupa("Uniforme Laranja Corinthians", 360.00f, 40, "Laranja e preto");
        produto5 = new Roupa("Tenis Nike Court", 125.00f, 36, "Azul e bege");
        produto6 = new Roupa("Moletom GOT - Brutall Kill", 159.98f, 42, "Preto");
        produto7 = new Alimento("Bolo de chocolate com cereja - Mamae eu quero",68.90f, "05/11/2025");
        produto8 = new Alimento("Lasanha a Bolonhesa Amabile & Kim", 24.90f, "15/06/2025");
        produto9 = new Alimento("Agua", 2.00f, "10/12/2025");

        cupomValorMinimo = new ValorMinimo(10, 500);
        cupomQuantidadeLimitada = new CupomLimitado(15, 2);

  
        venda1 = new Venda();
        venda2 = new Venda();
        venda3 = new Venda();

       //adiciona os produtos em cada compra
        venda1.adicionarProduto(produto1);
        venda1.adicionarProduto(produto2);

        venda2.adicionarProduto(produto6);
        venda2.adicionarProduto(produto8);
        venda2.adicionarProduto(produto9);

        venda3.adicionarProduto(produto3);

        // adicona as compras e o cupom
        vendas.add(venda1);
        vendas.add(venda2);
        vendas.add(venda3);

        cupons.add(cupomValorMinimo);
        cupons.add(cupomQuantidadeLimitada);
    }
    
    @Test
    void testCupomValMinAplicadoCorretamente() throws CupomInvalidoException {
          venda1.aplicarCupom(cupomValorMinimo);
        assertEquals(1665.18, venda1.getTotal(), 0.01);
    }
    
    @Test
    void testCupomValMinAplicadoIncorretamente() {
        // valor  < 500
        CupomInvalidoException thrown = assertThrows(CupomInvalidoException.class, () -> {
            venda2.aplicarCupom(cupomValorMinimo);
        });

        assertEquals("Cupom invalido!", thrown.getMessage());
    }
    
    @Test
    void testCupomQtdLmtAplicadoCorretamente() throws CupomInvalidoException {
        venda1.aplicarCupom(cupomQuantidadeLimitada);   
        assertEquals(1572.67, venda1.getTotal(), 0.01);
    }
    
    @Test
    void testCupomQtdLmtAplicadoIncorretamente() throws CupomInvalidoException{
         venda1.aplicarCupom(cupomQuantidadeLimitada);

        venda2.aplicarCupom(cupomQuantidadeLimitada);
        
        CupomInvalidoException thrown = assertThrows(CupomInvalidoException.class, () -> {
            venda3.aplicarCupom(cupomQuantidadeLimitada);
        });

        assertEquals("Cupom invalido!", thrown.getMessage());
    }

    @Test
    void testCalculoTotalVendaSemCupom() {
          assertEquals(1850.20, venda1.getTotal(), 0.01);
    }
    
    @Test
    void testCalculoTotalVendaComCupom() throws CupomInvalidoException {
         venda1.aplicarCupom(cupomValorMinimo);
        assertEquals(1665.18, venda1.getTotal(), 0.01);
    }
    
    @Test
    void testGerarRelatorios() {
        GerenciaVendas gestor = new GerenciaVendas (vendas, cupons);
        assertDoesNotThrow(gestor::gerarResumoVendas);
        assertDoesNotThrow(gestor::gerarResumoCupons);
    }
    
}