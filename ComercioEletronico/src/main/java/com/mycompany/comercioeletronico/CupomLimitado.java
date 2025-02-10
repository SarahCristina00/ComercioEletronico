
package com.mycompany.comercioeletronico;

public class CupomLimitado extends Cupom{
    private int max;
    private int aplicacaoAtual;
    
    public CupomLimitado(int percentual, int val){
        
        super(percentual);
        max = val;
        aplicacaoAtual = 0;
    }
     public int getMax(){
         return max;
     }
     public int getaplicacaoAtual(){
         return aplicacaoAtual;
     }
    @Override
    public boolean aplicavel(float valorVenda) {
        return getSituacao() && aplicacaoAtual<max;
    }
    
    @Override
    public float aplicarDesconto(float valor) {
        if (aplicavel(valor)) {
            aplicacaoAtual++;
            return super.aplicarDesconto(valor);  //se o desconto for valido, aplica
        } else {
            System.out.println("Esse cupom não pode ser aplicado, limite de uso atingido ou valor insuficiente");
                return valor; //caso não, retorna o valor inicial
    }
}
}


