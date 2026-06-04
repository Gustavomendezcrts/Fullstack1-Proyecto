import requests as rq

url = "http://localhost:8080/api/v1/resenas/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

id = input("ingresa el id de la Reseña a actualizar: \n")
info = {
    "puntaje": 8,
    "comentario": "test Percy Jackson (Actualizado)",
    "usuario": {"id_usuario": 1},
    "serie": {"id_serie": 1}
}

response = rq.put(url + id, json=info, headers=headers)
print(response.json())