import requests as rq


url = "http://localhost:8080/api/v1/peliculas/"
token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

info1 = {
    "imdb" : "tt0241527",
    "titulo" : "Harry Potter y la Piedra Filosofal",
    "director" : "Chris Columbus",
    "fechaEstreno" : "2001-11-16",
    "genero" : "Fantasia",
    "puntaje" : 8
}

info2 = {
    "imdb" : "tt0109506",
    "titulo" : "The Crow",
    "director" : "Alex Proyas",
    "fechaEstreno" : "1994-05-13",
    "genero" : "Fantasia Oscura",
    "puntaje" : 8
}

response1 = rq.post(url, json=info1, headers=headers)
print(response1.json())
response2 = rq.post(url, json=info2, headers=headers)
print(response2.json())