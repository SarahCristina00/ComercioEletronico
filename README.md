# 🛒 Comércio Eletrônico em Java

Bem-vindo ao **Comércio Eletrônico em Java**! 🎉 Este projeto simula uma loja virtual, 
permitindo a gestão de produtos, vendas e cupons de desconto. Vamos explorar os conceitos 
de **herança, polimorfismo, interfaces e tratamento de exceções** de maneira prática e aplicada! 🚀

## 📌 Sobre o Sistema
Este sistema de e-commerce permite:
✅ Cadastro e gerenciamento de produtos por categoria.  
✅ Aplicação de diferentes tipos de **cupons de desconto**.  
✅ Realização de vendas e cálculo do total com descontos.  
✅ Geração de relatórios de vendas e cupons disponíveis.  
✅ Implementação de testes de unidade com **JUnit**.  

## 🏪 Funcionalidades

### 📦 Gerenciamento de Produtos
Os produtos possuem os seguintes atributos:
- **ID**: Identificador único.
- **Nome**: Nome do produto.
- **Preço**: Valor do produto.

Além disso, temos categorias específicas:
- 📱 **Eletrônicos**: Possuem um prazo de garantia.
- 👕 **Roupas**: Incluem tamanho e cor.
- 🍏 **Alimentos**: Possuem data de validade.

### 💰 Cupons de Desconto
O sistema suporta dois tipos de cupons:
1️⃣ **Cupom de Quantidade Limitada**: Pode ser utilizado um número limitado de vezes.  
2️⃣ **Cupom com Valor Mínimo**: Pode ser usado ilimitadamente, mas exige um valor mínimo de compra.  

### 🛍️ Realização de Vendas
Cada venda inclui:
- **ID**: Identificador único.
- **Lista de Produtos**: Itens comprados pelo cliente.
- **Cupom Aplicado** (opcional).

O sistema exibe um **resumo detalhado** com os produtos comprados, descontos aplicados e o valor final da compra.  

### 📊 Relatórios
O sistema implementa uma **interface Relatorio** com métodos para:
- 📈 **Gerar Relatório de Vendas**: Exibe o total de vendas e o valor arrecadado.
- 🎟️ **Listar Cupons Ativos**: Mostra os cupons disponíveis e seus critérios de aplicação.

### ⚠️ Tratamento de Exceções
O sistema inclui a exceção personalizada **CupomInvalidoException**, garantindo que apenas cupons válidos sejam aplicados.  

## 🔧 Requisitos Técnicos
- **Linguagem**: Java ☕
- **JDK**: 21 🏗️
- **Gerenciador de Dependências**: Maven 🛠️
- **Framework de Testes**: JUnit ✅

## 🏃 Como Rodar o Projeto
1️⃣ Clone o repositório:

git clone <https://github.com/SarahCristina00/ComercioEletronico>

2️⃣ Acesse a pasta do projeto:

cd ecommerce-java

3️⃣ Instale as dependências:

mvn install

4️⃣ Execute o programa:

java -jar target/ecommerce.jar

## 🧪 Testes
Este projeto conta com testes unitários para: ✔️ Validação dos descontos aplicados por cada tipo de cupom.
✔️ Cálculo do total da venda com e sem cupons.
✔️ Testes dos métodos de relatórios.

## 🎯 Extras
✅ O sistema impede a aplicação de cupons inválidos!
✅ Relatórios detalhados para facilitar a análise!
✅ Código bem estruturado e seguindo boas práticas!

### 💻 Vamos criar um e-commerce de sucesso? (づ ◕‿◕ )づ

## 👨‍💻 Autor
Desenvolvido mim como parte da disciplina de Orientação a Objetos no curso de Sistemas de Informação da UFJF.

🛍️ Que as compras com desconto estejam com você! 🏷️
