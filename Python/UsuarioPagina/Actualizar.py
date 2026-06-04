import requests as rq

url = "http://localhost:8080/api/v1/usuarios/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

id = input("ingresa el id del usuario a actualizar: \n")
info = {
    "nombre" : "Gustavo Mendez (Actualizado)",
    "email" : "gustavo.mendez@example.com",
    "contraseña" : "password4567",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Accion"
}

response = rq.put(url + id, json=info, headers=headers)
print(response.json())