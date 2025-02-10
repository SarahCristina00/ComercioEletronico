package com.mycompany.comercioeletronico;


public class Alimento extends Produto{
    protected String validade;
    
  
    public Alimento ( String item, float valor, String data) {
        super(item, valor);
        validade = data;
    }
    
    @Override
    public String getProduto(){
        return super.getProduto()+ " | Validade: " + validade;
    }
}
