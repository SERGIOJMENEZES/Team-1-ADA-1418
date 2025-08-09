# Ecommerce (Projeto Final)


Reformulamos o desafio proposto no LMS, criando um projeto com requisitos equivalentes:

" Desenvolva um sistema que apresente uma lista de produtos de Ecommerce Neste sistema cada produto deve possuir alguns atributos como o nome, data de lançamento, valor do produto e descrição. Cada Produto também deve possuir um Vendedor e uma lista de Produtos similares que interessam o cliente, adicione atributos para os produtos. Implemente uma aplicação em que o usuário possa:

- cadastrar Produto
- cadastrar Vendedor
- cadastrar Pessoa ou CNPJ
- associar um produto (com seus Vendedores e Clientes) as suas categorias e tipos
- permita pesquisar Produto cadastrados pelo nome, desconsiderando letras maiúsculas e minúsculas
- Carrinho e ItemCarrinho
"

## Descrição
Este projeto é uma implementação simples de um sistema de Ecommerce utilizando os conceitos fundamentais de Programação Orientada a Objetos (POO) em Java. O objetivo é organizar e gerenciar informações de produtos, clientes e pedidos, simulando funcionalidades básicas de uma loja online.

---

## Estrutura do Projeto
O projeto está organizado na arquitetura MVC, nas seguintes camadas principais:
- **Model**: Contém as classes que representam as entidades do sistema:
  - `Produto`: representa os produtos disponíveis para venda, com atributos como nome, descrição, preço, categoria, condição, estoque e status.
  - `Cliente`: representa os clientes, com dados pessoais e métodos para autenticação e redefinição de senha.
  - `Pedido`: representa os pedidos realizados, contendo a lista de produtos, valor total, status e cliente associado.
  - `Pessoa` (classe abstrata): superclasse para pessoas do sistema, base para `Cliente`.
  - `Enums` para categorizar produtos e controlar o status dos pedidos: `Categoria`, `Condição` e `StatusPedido`.
- **Controller**: Responsável pela lógica de negócio e manipulação das entidades:
  - `ProdutoController`: controle de criação, ativação, desativação, venda e reposição de produtos.
  - `PedidoController`: criação e gestão de pedidos, alteração de status e buscas por critérios diversos.
- **Utils**:
  - `IdGenerator`: utilitário para geração de IDs únicos e thread-safe para produtos e pedidos.

---

## Funcionalidades
- **Cadastro e gestão de produtos**:
  - Criar produtos com atributos como nome, descrição, preço, categoria, condição, estoque e status (ativo/inativo).
  - Controle de estoque com métodos para aumentar e reduzir estoque.
  - Ativação e desativação de produtos para controle de disponibilidade.
- **Gerenciamento de pedidos**:
  - Criação de pedidos vinculados a clientes, com lista de produtos e cálculo do valor total.
  - Consulta e busca de pedidos por ID, status, data e cliente.
  - Alteração do status do pedido (ex: realizado, pago, enviado, entregue, cancelado).
- **Gerenciamento de clientes**:
  - Armazenamento de dados pessoais (nome, CPF, email, telefone).
  - Autenticação básica via senha.
  - Redefinição de senha com validação.
  - Atualização dos dados pessoais.
- **Geração automática de IDs únicos** para produtos e pedidos, garantindo unicidade no sistema.
- **Controle de status de pedidos e categorização de produtos** usando enums (`StatusPedido`, `Categoria`, `Condicao`).

---

## Conceitos Aplicados
- **Encapsulamento**:
  - Atributos privados com acesso via getters e setters, garantindo controle sobre o acesso e validação dos dados.
  - Validações nos setters e construtores para evitar estados inválidos.
- **Herança**:
- Classe abstrata `Pessoa` como base para `Cliente`, reutilizando atributos e métodos comuns.
- **Abstração**:
  - Separação clara das responsabilidades entre classes (ex: `Produto` cuida dos dados do produto, `Pedido` da lógica do pedido, `Cliente` das informações pessoais e autenticação).
  - Uso de classes controller para abstrair a lógica de manipulação das entidades (ex: `ProdutoController`, `PedidoController`).
- **Polimorfismo**:
- Sobrescrita do método `toString` para apresentar informações de forma customizada.
- Uso do modificador `abstract` para `Pessoa` que não deve ser instanciada diretamente.
- **Modularização**:
- Separação das `enums` em pacote próprio para melhor organização (`Categoria`, `Condicao`, `StatusPedido`).
- Utilização de classe utilitária para geração de IDs.
- **Thread Safety**:
  - Uso de `AtomicInteger` para gerar IDs de forma segura em ambientes concorrentes.
