import requests as req

url = "http://localhost:8080/api/v1/peliculas"

data1 = {
    "imdb" : "tt0241527",
    "titulo" : "Harry Potter y la Piedra Filosofal",
    "director" : "Chris Columbus",
    "fechaEstreno" : "2001-11-16",
    "genero" : "Fantasia"
}

data2 = {
    "imdb" : "tt0295297",
    "titulo" : "Harry Potter y la Cámara Secreta",
    "director" : "Chris Columbus",
    "fechaEstreno" : "2002-11-15",
    "genero" : "Fantasia"
}


response1 = req.post(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)
response2 = req.post(url, json=data2)
print("Status code:", response2.status_code)
print("Respuesta:", response2.text)



# for i in range(0,10):
#     dataN = {
#     "imdb" : "tt0295297",
#     "titulo" : f"Harry Potter y la Cámara Secreta {i}",
#     "director" : "Chris Columbus",
#     "fechaEstreno" : "2002-11-15",
#     "genero" : "Fantasia"
# }


#     responseN = req.post(url, json=dataN)
#     print("Status code:", responseN.status_code)
#     print("Respuesta:", responseN.text)