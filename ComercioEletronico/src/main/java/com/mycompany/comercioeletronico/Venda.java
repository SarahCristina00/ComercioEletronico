package com.mycompany.comercioeletronico;

import com.mycompany.comercioeletronico.Produto.ProdutoInvalidoException;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private int id;
    private List<Produto> produtos;
    private float total;
    private Cupom cupomAplicado = null;
    

        private static int contVendas = 1;
    public Venda(){
        id = contVendas++;
        produtos = new ArrayList<>();
        total = 0;
    }
    
   public float getTotal(){
        return total;
    }
    public int getId(){
        return id;
    }

    public void adicionarProduto(Produto produto){
        try{
            produto.validar();
            produtos.add(produto);
            total+=produto.getPreco();
        }catch(ProdutoInvalidoException e){
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
        
    }
   
   
     public boolean temCupom(){
        return cupomAplicado!=null;
    }
       
   public void aplicarCupom(Cupom cupom) throws CupomInvalidoException{
   
       if (produtos.isEmpty()){
           throw new CupomInvalidoException (CupomInvalidoException.Tipo.SEM_PRODUTOS);
       }
        
    
       if(temCupom()){
           throw new CupomInvalidoException (CupomInvalidoException.Tipo.CUPOM_UTILIZADO);
       }
       
   
       if(!cupom.aplicavel(total)){
           throw new CupomInvalidoException (CupomInvalidoException.Tipo.CUPOM_INVALIDO);
       }
       
       float novoTotal = cupom.aplicarDesconto(total);
       cupomAplicado = cupom;
       total = novoTotal;
   }
    
    public void getVenda() {
    System.out.println("\n----/----/----/----/ Compra: " + id + "----/----/----/---\n Produtos:");
    produtos.forEach(item -> System.out.println(item.getProduto()));
    double totalProdutos = produtos.stream().mapToDouble(Produto::getPreco).sum();
    System.out.println("Total: R$" + String.format("%.2f", totalProdutos));

    if (temCupom()) {
        System.out.println("Cupom Aplicado: " + cupomAplicado.getCodigo());
        System.out.println("Desconto: " + cupomAplicado.getPercentualDesconto() + "%");
        System.out.println("Novo total com cupom: R$" + String.format("%.2f", total));
    } else {
        System.out.println("Nenhum cupom aplicado.");
    }
}

}