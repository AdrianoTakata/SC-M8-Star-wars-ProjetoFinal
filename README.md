# SC-M8-Star-wars-ProjetoFinal
Projeto final do módulo Java Web

Acesso as requisições no Postman:
https://projeto-star-wars.postman.co/workspace/New-Team-Workspace~1a620261-0d28-465f-81a2-06470dd5f131/request/19837297-9527e3dd-a843-4ec4-94de-b0d2661ccc43

Endpoints:

*** Lista Rebelde
-GET
http://localhost:8080/rebelde
Descrição: Endpoint para listagem de todos os rebeldes cadastrados.

*** Cria rebelde
-POST
http://localhost:8080/rebelde
Descrição: Endpoint para criação de um rebelde.

Body Example:
{
    "nome": "Jeferson2",
    "idade": 34,
    "genero" : "M",
    "localizacao": {
        "latitude": 100,
        "longitude": 200,
        "nomeGalaxia": "Via Lactea"
    },
    "inventario": {
        "numeroArma": 1,
        "numeroMunicao": 100,
        "numeroAgua": 10,
        "numeroComida": 10
    }
}

*** Atualiza Localização
-PATCH
http://localhost:8080/rebelde/atualizaLocalizacao
Descrição: Endpoint para atualização das localizações do rebelde.

Example:
Header 
key = rebeldeID e value = UUID retornado após cadastro do rebelde
Body
{
        "latitude": 350,
        "longitude": 400,
        "nomeGalaxia": "Andromeda"
    }

*** Reposta Traidor
POST
http://localhost:8080/rebelde/reporta
Descrição: Endpoint para reportar um rebelde traidor.

Header Example:
key = rebeldeID e value = UUID retornado após cadastro do rebelde
