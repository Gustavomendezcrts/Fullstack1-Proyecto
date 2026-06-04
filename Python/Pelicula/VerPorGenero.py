import requests as rq

url = "http://localhost:8080/api/v1/peliculas/genero/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

genero = input("ingresa el genero a buscar: \n")

response = rq.get(url + genero, headers=headers)
print(response.json())