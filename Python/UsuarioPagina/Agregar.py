import requests as rq


url = "http://localhost:8080/api/v1/peliculas/"
token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

u1 = {
    "nombre" : "Gustavo Mendez",
    "email" : "gustavo.mendez@example.com",
    "contraseña" : "password123",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Accion"
}

u2 = {
    "nombre" : "Tomas Martinez",
    "email" : "tomas.martinez@example.com",
    "contraseña" : "password456",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Accion"
}

u3 = {
    "nombre" : "Paz Ramirez (Actualizado)",
    "email" : "paz.ramirez@example.com",
    "contraseña" : "password789",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Percy Jackson"
}

response1 = rq.post(url, json=u1, headers=headers)
print(response1.json())
response2 = rq.post(url, json=u2, headers=headers)
print(response2.json())
response3 = rq.post(url, json=u3, headers=headers)
print(response3.json())