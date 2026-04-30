import requests as req

url = "http://localhost:8080/api/v1/resenas/1"

data1 = {
    "puntaje": 7,
    "comentario": "test Percy Jackson (Actualizado)",
    "usuario": {"id_usuario": 3},
    "serie": {"id_serie": 1}
}


response1 = req.put(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)