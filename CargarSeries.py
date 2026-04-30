import requests as req

url = "http://localhost:8080/api/v1/series"

data1 = {
    "imdb" : "tt12324366",
    "titulo" : "Percy Jackson y los dioses del Olimpo",
    "director" : "Rick Riordan",
    "fechaEstreno" : "2023-12-19",
    "genero" : "Fantasia",
    "puntaje" : 7,
    "temporadas" : 2
}

data2 = {
    "imdb" : "tt0388629",
    "titulo" : "One Piece",
    "director" : "Eiichiro Oda",
    "fechaEstreno" : "1999-10-20",
    "genero" : "Anime",
    "puntaje" : 9,
    "temporadas" : 2
}


response1 = req.post(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)
response2 = req.post(url, json=data2)
print("Status code:", response2.status_code)
print("Respuesta:", response2.text)