
package com.mycompany.comercioeletronico;


public class Eletronico extends Produto{

    
   private int garantia;

    public Eletronico( String item, float valor, int meses) {
        super( item, valor);
        garantia = meses;
    }

    public int getGarantia(){
        return garantia;
    }
    
    @Override
    public String getProduto(){
        return super.getProduto()+ " | Garantia: " + garantia + " meses";
    }
    
}
