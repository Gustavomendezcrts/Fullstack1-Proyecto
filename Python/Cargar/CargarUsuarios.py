import requests as req

url = "http://localhost:8080/api/v1/usuarios"

data1 = {
    "nombre" : "Tomas Martinez",
    "email" : "tomas.martinez@example.com",
    "contraseña" : "password123",
    "gustoPrincipal" : "example",
    "gustoSecundario" : "example2"
}

data2 = {
    "nombre" : "Gustavo Mendez",
    "email" : "gustavo.mendez@example.com",
    "contraseña" : "password456",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Gl"
}

data3 = {
    "nombre" : "Paz Ramirez",
    "email" : "paz.ramirez@example.com",
    "contraseña" : "password789",
    "gustoPrincipal" : "Fantasia",
    "gustoSecundario" : "Bl"
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


# while True:
#     i = 0
#     data = {
#         "nombre" : f"Usuario {i}",
#         "email" : f"usuario{i}@example.com",
#         "contraseña" : f"password{i}",
#         "gustoPrincipal" : f"Principar{i}",
#         "gustoSecundario" : f"Segundario{i}"
#     }

#     response1 = req.post(url, json=data)
#     print("Status code:", response1.status_code)
#     print("Respuesta:", response1.text)
#     i+=1