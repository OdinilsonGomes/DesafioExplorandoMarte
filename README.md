# DesafioExplorandoMarte
Exercico para Exploração do marte com N sondas 

Hello! 

O sistema está funcional e imprimindo resultados iguais aos do exercicio, faltando aprimorar em alguns detalhes que seram feitos dentro do tempo estabelecido.

Permite o Registo de um planalto, de acordo ao desafio o planato é retangular logo se forem inseridas coordenas equivalentes a de um quadrado o sistema solicitará as coordenadas novamente

Após a Insercao da coordenada correta do planalto o sistema solicita a cordenada da sonda bem como as suas instruçoes consecutivamente, o sistema só para se for inserido um comando de operação como Sair (S), Imprimir (P) ou ainda (H) para Ajuda.

------- conceitos tecnicos -------------------

Foram criadas as seguintes classes:
Bussola - essa classe serve de orientação para a sonda, nela é possivel saber qual o polo a direita ou esquerda de num determinado grau
Planalto - planalto é uma classe que contem uma lista para lançamento das sondas, ela é difenida pelo comprimento e largura que de acordo ao exercicio deve ser retangular
Sonda - essa classe tem a sua coordenada x,y inicia sempre no ponto (0,0), possuindo metodos para mover e girar de uma interface "sondaAcao" usando a bussola como meio de orientação
No final ten-se o a classe main com metodos para criar os objectos e gerenciar os comandos digitados 

