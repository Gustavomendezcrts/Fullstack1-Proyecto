import requests as rq


url = "http://localhost:8080/api/v1/series/"
token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

info = {
    "imdb" : "tt12324366",
    "titulo" : "Percy Jackson y los dioses del Olimpo",
    "director" : "Rick Riordan",
    "fechaEstreno" : "2023-12-19",
    "genero" : "Fantasia",
    "puntaje" : 7,
    "temporadas" : 2
}

response1 = rq.post(url, json=info, headers=headers)
print(response1.json())
