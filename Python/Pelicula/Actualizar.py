import requests as rq

url = "http://localhost:8080/api/v1/peliculas/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

id = input("ingresa el id de la pelicula a actualizar: \n")
info = {
    "imdb" : "tt0241527",
    "titulo" : "Harry Potter y la Piedra Filosofal (Actualizado)",
    "director" : "Chris Columbus",
    "fechaEstreno" : "2001-11-16",
    "genero" : "Fantasia",
    "puntaje" : 9
}

response = rq.put(url + id, json=info, headers=headers)
print(response.json())