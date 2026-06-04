import requests as rq


url = "http://localhost:8080/api/v1/resenas/"
token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

info1 = {
    "puntaje": 7,
    "comentario": "test HAPO",
    "usuario": {"idUsuario": 1},
    "pelicula": {"idPelicula": 1}
}
response1 = rq.post(url, json=info1, headers=headers)
print(response1.json())