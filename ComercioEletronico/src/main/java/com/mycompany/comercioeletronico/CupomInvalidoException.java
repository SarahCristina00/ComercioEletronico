
package com.mycompany.comercioeletronico;


  public class CupomInvalidoException extends Exception {
          public enum Tipo {
            SEM_PRODUTOS("Nenhum produto foi selecionado."),
            CUPOM_UTILIZADO("Esse cupom já foi utilizado!"),
            CUPOM_INVALIDO("Cupom invalido!");

            private final String mensagem;

            Tipo(String mensagem) {
                this.mensagem = mensagem;
            }

            public String getMensagem() {
                return mensagem;
            }
        }

        public CupomInvalidoException(Tipo erroTipo) {
            super(erroTipo.getMensagem());
        }
        
        }