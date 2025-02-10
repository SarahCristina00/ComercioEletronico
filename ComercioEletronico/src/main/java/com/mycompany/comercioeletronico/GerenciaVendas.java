
package com.mycompany.comercioeletronico;
import java.util.List;

public class GerenciaVendas implements ResumoVendas{
      
   private final List <Venda> vendas;
   private final List <Cupom> cupons;
 
   public GerenciaVendas(List <Venda> vendas, List <Cupom> cupons){
       this.vendas = vendas;
       this.cupons = cupons;
   }
   
  

@Override
public void gerarResumoVendas() {
    double totalArrecadado = 0.0;
    int totalVendas = 0;
    System.out.println(" \n=============== Relatorio de Vendas:  ===============");
    for (Venda venda : vendas) {
        totalVendas++;
        totalArrecadado += venda.getTotal();
        System.out.println("\nVenda ID: " + venda.getId() + " | Total: R$" + String.format("%.2f", venda.getTotal()));
    }
    System.out.println("Quantidade total de vendas realizadas: " + totalVendas);
    System.out.println("Valor total arrecadado: R$" + String.format("%.2f", totalArrecadado));
}

@Override
public void gerarResumoCupons() {
    System.out.println("\n=============== Cupons Ativos: ===============");
    for (Cupom cupom : cupons) {
        if (cupom.getSituacao()) {
            System.out.println("\n Codigo: " + cupom.getCodigo() + " | Desconto: " + cupom.getPercentualDesconto() + "%");
            System.out.println("Criterio de utilizacao: ");
        }
            if(cupom instanceof ValorMinimo){
                ValorMinimo cupomValorMinimo = (ValorMinimo) cupom;
                System.out.println("Valor minimo: R$" + cupomValorMinimo.getValorMinimo());
            }
            else if (cupom instanceof CupomLimitado) {
                CupomLimitado cupomLimitado = (CupomLimitado) cupom;
                System.out.println("Maximo de aplicacoes do cupom: " + cupomLimitado.getMax());
            }
        }
    }
}


