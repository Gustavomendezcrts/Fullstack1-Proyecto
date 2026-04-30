import requests as req

url = "http://localhost:8080/api/v1/series"

response = req.get(url)

print("Status code:", response.status_code)
print("Respuesta:", response.json())