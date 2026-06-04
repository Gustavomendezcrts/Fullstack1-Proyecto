import requests as rq

url = "http://localhost:8080/api/v1/series"

token = input("ingresa el token: \n")

headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

response = rq.get(url, headers=headers)
print(response.json())