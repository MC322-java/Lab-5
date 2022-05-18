# Lab05 - Mundo de Wumpus
 * [Mundo de Wumpus](https://github.com/MC322-java/Lab-5/tree/main/src/pt/c40task/l05wumpus)

# Alunos
  * Andreas Cisi Ramos (246932)
  * Luiz Fernando Batista Morato (223406)
 
## Cursos
  * Engenharia da Computação (34)


## DESTAQUES

# 1. Consistência com arquitetura inicial

# 2. Distribuição da lógica do jogo

# 3. Delegar o máximo relacionado a cada componente

# 4. Encapsulamento
  * Todos os atributos das classes tem visibilidade privada ou protegida sendo necessário acessá-los pelos métodos especiais "getters" e "setters".
  * As classes apresentam Construtores para instanciar os objetos.
![Encapasulamento](https://user-images.githubusercontent.com/82724293/169097430-f96f7811-6f01-4707-8de4-63673b989cb3.png)

# 5. Polimorfismo
  * Há um método da SuperClasse Componente que é sobrescrito pelas classes filhas Wumpus, Ouro, Buraco, Brisa e Fedor.
![Componente](https://user-images.githubusercontent.com/82724293/169097871-f243b99d-500a-45be-9662-7746ed35bbb0.png)
![Wumpus](https://user-images.githubusercontent.com/82724293/169098143-88a9bd8c-ac53-451e-9c98-a25cc7bcfb4b.png)
![Fedor](https://user-images.githubusercontent.com/82724293/169099266-ff7ea5c1-269a-463f-a981-5cec3779f16d.png)

  * Há sobrecarga de métodos na classe Componente (o método especial Construtor).
![Sobrecarga](https://user-images.githubusercontent.com/82724293/169098931-b39fe8a4-a405-4799-af52-7e4a5aa7e63b.png)


# 6. Fácil expansão
 
