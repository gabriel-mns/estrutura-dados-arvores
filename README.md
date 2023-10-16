# 🌳 Árvore Binária AVL | Árvore Binária

Implementação de Árvore Binária e Árvore Binária AVL desenvolvidas na disciplina de Resolução de Problemas Estruturados em Computação.

## 🔗 Estrutura do Código

O código está estruturado em 5 classes:

- **Node**: Representação de um nó da classe `ArvoreBinaria`. Possui pointers para o nó menor (à esquerda) e para o nó maior (à direita) e armazena um dado do tipo int.

- **ArvoreBinaria**: Representação de uma árvore binária com os métodos de inserção, remoção e busca. Possui uma única referência ao `Node` `root` que representa a raiz da `ArvoreBinaria`.

- **NodeAvl**: Possui as mesmas referências da classe `Node`, com a diferença de possuir também o atributo de altura que o `NodeAvl` está. Essa altura será atualizada toda vez antes de realizar uma operação de rebalanceamento da `ArvoreAvl`.

- **ArvoreAvl**: Assim como a árvore binária, possui uma única referência a `NodeAvl` `root` que representa a raiz da árvore. A diferença para a classe `ArvoreAvl` e `ArvoreBinaria` é que a `ArvoreAvl`, ao terminar de inserir ou remover algum dado da `ArvoreAvl`, o método `rebalancear(NodeAvl)` é chamado. Esse método verificará o fator de balanceamento (FB) dos `NodeAvl`'s e fará as devidas rotações (caso necessário).

- **Relatório**: Classe que possui o método `main()` e também outros dois métodos para realização dos testes e exibição dos resultados.
