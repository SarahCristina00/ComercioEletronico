
package com.mycompany.comercioeletronico;

public abstract class  Cupom {
 
    private int codigo;
    private int percentual;
    private boolean ativo;
    
    private static int contCupom = 1;
   
    public Cupom( int percent){
       if(percent <0 || percent >100) {
           throw new IllegalArgumentException("O percentual de desconto deve estar entre 0 e 100");
       }
        codigo = contCupom++;
        percentual = percent;
        this.ativo = true;
    }
    
   public int getCodigo() {
        return codigo;
    }
   
   public boolean getSituacao() {
        return ativo;
    }

    public float getPercentualDesconto() {
        return percentual;
    }
    
    public abstract boolean aplicavel(float valorVenda);
    
    public float aplicarDesconto(float valor){

        if(!ativo){
            System.out.println("Cupom inativo!");
            return valor;
        }
            float desconto = valor * percentual/100;
            return valor - desconto;
        }
    }
    
