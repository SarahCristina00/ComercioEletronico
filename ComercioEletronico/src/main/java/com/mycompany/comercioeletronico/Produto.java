
package com.mycompany.comercioeletronico;

public class Produto {
    private int id;
    private String nome;
    private float preco;
    
    
    private static int cont = 1;
    
    
    
    public Produto ( String produto, float valor){
        
        id = cont++;
        nome = produto;
        preco = valor;
    }
    
    
    public int getId(){
         return id;
    }
    public double getPreco(){
        return preco;
    }
    public String getNome(){
        return nome;
    }
    
    public String getProduto(){
        return "ID: " + id + " | Produto: " + nome +" | Preco: R$" + preco;
    }
    
       public static class ProdutoInvalidoException extends Exception {
        public ProdutoInvalidoException(String message) {
            super(message);
        }
    }
   public void validar() throws ProdutoInvalidoException {
    if (preco <= 0) {
        throw new ProdutoInvalidoException("O valor da compra deve ser maior que R$0,00.");
    }
}

}
