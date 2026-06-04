import requests as rq

url = "http://localhost:8080/api/v1/series/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

id = input("ingresa el id de la serie a actualizar: \n")
info = {
    "imdb" : "tt12324366",
    "titulo" : "Percy Jackson y los dioses del Olimpo (Actualizado)",
    "director" : "Rick Riordan",
    "fechaEstreno" : "2023-12-19",
    "genero" : "Fantasia",
    "puntaje" : 9,
    "temporadas" : 2
}

response = rq.put(url + id, json=info, headers=headers)
print(response.json())