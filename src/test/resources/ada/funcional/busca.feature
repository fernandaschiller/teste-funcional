#language: pt

Funcionalidade: Realizar buscas no Google

  Cenário: Validar pesquisa simples
    Dado que usuario acessa pagina home
    Quando digitar 'cachorro'
    E teclar enter
    Entao deve retornar 'cachorro'

