# Case Star Wars

## Objetivo

* Implementação de API do mundo Star Wars

## O que foi feito nesse projeto

* API Star Wars: Busca personagens, filmes, planetas, espécies, naves e veículos.
* API Termos: Consulta termos e quantidade de buscas para todos os domínios(personagens, filmes, planetas, espécies, naves e veículos).
* API Sugestões: Sugere termos para todos os domínios(personagens, filmes, planetas, espécies, naves e veículos).

## Ao executar os passos abaixo conseguiremos rodar a aplicação:

### Pré requisitos

* Docker

Para acessar a aplicação é necessário que todos os pré requisitos estejam instalados.

## Baixando o projeto

* Agora vamos baixar o projeto, abra o terminal(shell ou CMD) e digite:

```
docker pull rafakiyota/case-star-wars
```

## Rodando a aplicação

* Após baixar o projeto vamos rodar a aplicação, abra o terminal(shell ou CMD) e digite:

```
docker run -d -p 7075:7075 rafakiyota/case-star-wars
```

## Acessando a documentação

* Para visualizar a documentação das APIs acesse [Documentação Swagger](http://localhost:7075/case-star-wars/swagger-ui/).
