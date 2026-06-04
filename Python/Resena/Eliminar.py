import requests as rq

url = "http://localhost:8080/api/v1/resenas/"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

id = input("ingresa el id de la Reseña a eliminar: \n")

response = rq.delete(url + id, headers=headers)

print(response.json())