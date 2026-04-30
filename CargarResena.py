import requests as req

url = "http://localhost:8080/api/v1/resenas"

data1 = {
    "puntaje": 7,
    "comentario": "test Percy Jackson",
    "usuario": {"id_usuario": 3},
    "serie": {"id_serie": 1}
}

data2 = {
    "puntaje": 9,
    "comentario": "test One Piece",
    "usuario": {"id_usuario": 2},
    "serie": {"id_serie": 2}
}

data3 = {
    "puntaje": 8,
    "comentario": "test Harry Potter",
    "usuario": {"id_usuario": 1},
    "pelicula": {"id_pelicula": 1}
}

data4 = {
    "puntaje": 8,
    "comentario": "test Harry Potter y la camara de los secretos",
    "usuario": {"id_usuario": 1},
    "pelicula": {"id_pelicula": 1}
}

response1 = req.post(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)
# response2 = req.post(url, json=data2)
# print("Status code:", response2.status_code)
# print("Respuesta:", response2.text)
# response3 = req.post(url, json=data3)
# print("Status code:", response3.status_code)
# print("Respuesta:", response3.text)
# response4 = req.post(url, json=data4)
# print("Status code:", response4.status_code)
# print("Respuesta:", response4.text)
