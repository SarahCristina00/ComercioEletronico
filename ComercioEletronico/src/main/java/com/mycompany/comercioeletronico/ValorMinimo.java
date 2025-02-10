
package com.mycompany.comercioeletronico;

public class ValorMinimo extends Cupom{
    
            private final float minimo;
        
        public ValorMinimo( int percentual, float min) {
            super(percentual);
            if(min<=0){
              throw new IllegalArgumentException("O valor Minimo da compra deve ser maior que R$00,00");
            }
            minimo = min;
         }
        
        public float getValorMinimo(){
            return minimo;
        }

    @Override
    public boolean aplicavel(float valorVenda) {
          
        return getSituacao() && valorVenda>= minimo;
    }
}

