import requests as req

url = "http://localhost:8080/api/v1/resenas"

response = req.get(url)
data = response.json()  # lista de elementos

# 📏 tamaño de la lista
size = len(data)

print("Total elementos:", size)

# 🔁 recorrer y "eliminar"
for item in data:
    item_id = item["id_resena"]

    delete_url = f"http://localhost:8080/api/v1/resenas/{item_id}"

    delete_response = req.delete(delete_url)

    print(f"Eliminado ID {item_id} - Status:", delete_response.status_code)