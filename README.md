# Lab05 - Mundo de Wumpus
 * [Mundo de Wumpus](https://github.com/MC322-java/Lab-5/tree/main/src/pt/c40task/l05wumpus)

# Alunos
  * Andreas Cisi Ramos (246932)
  * Luiz Fernando Batista Morato (223406)
 
## Cursos
  * Engenharia da Computação (34)


## DESTAQUES

# 1. Consistência com arquitetura inicial
  * A Caverna é uma matriz de Salas, essas salas detem Componentes. 
  
![image](https://user-images.githubusercontent.com/82724293/169167145-b3293665-f3ba-4764-b590-ef75116aadd8.png)
![image](https://user-images.githubusercontent.com/82724293/169167208-2ffa2de5-9599-45b0-8bc5-49d95bfe921a.png)
  * As classes primárias são filhas da classe Componente.
 
![image](https://user-images.githubusercontent.com/82724293/169167421-1490628b-a030-43f0-9f4a-c0749dbfaa06.png)

  * Cada Componente apresenta uma referência para caverna e detem sua posição (linha x coluna) guardada.

![image](https://user-images.githubusercontent.com/82724293/169167932-fe155cab-8a3a-4892-ac86-a746bac58d37.png)

# 2. Distribuição da lógica do jogo

# 3. Delegar o máximo relacionado a cada componente
  * Usando de exemplo a classe Herói, foi colocado o máximo de métodos que estão relacionados com ele nessa classe, o herói que se move, coleta o ouro, equipa a flecha, sabe se tem flecha ou não, ataca o Wumpus, por mais que o Controle de jogo pegue a informação que ele acertou ou errou a flecha, ele que tem 50% de chance de matar o Wumpus.
  
![image](https://user-images.githubusercontent.com/82724293/169102006-0c72910f-3137-4881-af4a-45c56b76b6c4.png)

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
  * A arquitetura proporciona facil disponibilidade para criação de mais componentes, tendo em vista que as salas detem um ArrayList de componentes podendo ter quantos componentes forem necessários.
  
![image](https://user-images.githubusercontent.com/82724293/169166073-d9252eb9-0117-4361-bb05-ee26f7a5ed40.png)
  * Além do mais, a classe componente apresenta apenas um atributo que necessitaria alguma mudança no código , que seria o peso ( sua prioridade ) em relação as demais componentes abordadas no jogo.
 
![image](https://user-images.githubusercontent.com/82724293/169165882-00a0ed9c-4215-4213-a878-bc480c0c4e87.png)
  * A classe apresentaria um construtor que completaria o ID e essa prioridade da classe logo no momento de instanciar, como no exemplo do Wumpus abaixo. 
 
![image](https://user-images.githubusercontent.com/82724293/169166007-59cf1be4-52b5-4411-94e9-c0f88c822334.png)
  * Necessitaria apenas adicionar mais um "case" no "switch" da classe Montador para o caso da nova classe requerida.
 
![image](https://user-images.githubusercontent.com/82724293/169165797-354cd4ee-a099-4a2e-b6f1-4145823d0d22.png)


 
