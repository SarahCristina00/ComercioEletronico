package com.mycompany.comercioeletronico;

public class Roupa extends Produto {
      
   private int tamanho;
   private String cor;
     
     
    public Roupa( String item, float valor, int tam, String cor) {
        super( item, valor);
        tamanho = tam;
        this.cor = cor;
    }
    
    @Override
        public String getProduto(){
        return super.getProduto()+ " | Tamanho: " + tamanho + " | Cor: " + cor;
    }
}
