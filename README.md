# Black Rock Robot

### Challenge
-------------

```
Dado: Um espaço plano de 10x10 (Matriz).
Crie: Um robô capaz de responder aos seguintes comandos:
  - Andar x casas; 
  - Virar para x (esquerda, direita, baixo e cima);
  - Virar para x e andar x casas; 
  - O seu espaço plano é circular, caso o robô atinja o final [9] volta começa a contar novamente do começo [0];
  - Pense que o robô pode “aprender” a executar outras funções, ou até mesmo criar-se uma versão 2 do robô, então acrescentar novas funcionalidades deve ser simples e sem impacto na aplicação toda.
  - Imaginando que você pode acessar seu robô remotamente, crie um consumer REST para executar os comandos. Pode modelar as requests como desejar.
 
Regras:
  - Código escrito em inglês;
  - Deve-se criar testes de unidade; “Junit, Mockito”;
  - Deve-se criar testes de comportamento; “Cucumber”;
  - A cada movimento de andar é preciso informar qual a localização atual do robô no espaço;
  - Informar qual tempo gasto para execução total da atividade;
  - Seguir o máximo possível os conceitos de SOLID.
```   


### Hours worked
----------------


| Tempo | Trabalho                                                                                              |
|-------|-------------------------------------------------------------------------------------------------------|
| 03:00 | Crição/Configuração do Projeto e implementação da 1.0 versão apenas para passar os tests of Behavior. |   
| 04:00 | Implementação do Pattern Command tornar possivel e prático adicionar novos comandos.                  |              
| 04:00 | Criação do Front-end para exibir o Robo se movimentando pela area.                                    |


### Feature Implemented
----------------------- 

* Criação do Robo.
* Criação da Area/Casa.
* Andar x Area/Casa.
* Andar: esquerda, direita, baixo e cima.  
* Caso o Robo atinja o limite/horizontal da Area/Casa ele volta para o inicio.  
* Caso o Robo atinja o limite/vertial da Area/Casa ele volta para o inicio. 
* Implementação do Pattern Command para gerenciar os Comandos do Robo, tornar possivel e prático adicionar novos comandos. 
* Implementação de REST para enviar comandos ao Robo remotamente.
* Implementação de um Front-end para exibir o Robo se movimentando.
* Implementação de um Front-end controle para enviar comandos remotamente para o Robo.


### TODO
--------

* To implement the actions/commands "Turn to".
* To implement the ground with "Circular"
 


