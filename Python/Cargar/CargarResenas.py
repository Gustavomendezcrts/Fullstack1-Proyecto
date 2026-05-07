import requests as req

url = "http://localhost:8080/api/v1/resenas"

data1 = {
    "puntaje": 7,
    "comentario": "test Percy Jackson",
    "usuario": {"idUsuario": 3},
    "serie": {"idSerie": 1}
}

data2 = {
    "puntaje": 9,
    "comentario": "test One Piece",
    "usuario": {"idUsuario": 2},
    "serie": {"idSerie": 2}
}

data3 = {
    "puntaje": 8,
    "comentario": "test Harry Potter",
    "usuario": {"idUsuario": 1},
    "pelicula": {"idPelicula": 1}
}

data4 = {
    "puntaje": 8,
    "comentario": "test Harry Potter y la camara de los secretos",
    "usuario": {"idUsuario": 1},
    "pelicula": {"idPelicula": 1}
}

response1 = req.post(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)
response2 = req.post(url, json=data2)
print("Status code:", response2.status_code)
print("Respuesta:", response2.text)
response3 = req.post(url, json=data3)
print("Status code:", response3.status_code)
print("Respuesta:", response3.text)
response4 = req.post(url, json=data4)
print("Status code:", response4.status_code)
print("Respuesta:", response4.text)
