import requests as req

url = "http://localhost:8080/api/v1/usuarios/3"

data1 = {
    "nombre" : "Paz Ramirez (Actualizado)",
    "email" : "paz.ramirez@example.com",
    "contraseña" : "password789",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Percy Jackson"
}

response1 = req.put(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)