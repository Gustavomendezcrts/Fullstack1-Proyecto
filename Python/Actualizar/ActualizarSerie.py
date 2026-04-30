import requests as req

url = "http://localhost:8080/api/v1/series/2"

data1 = {
    "imdb" : "tt0388629",
    "titulo" : "One Piece (Actualizado)",
    "director" : "Eiichiro Oda",
    "fechaEstreno" : "1999-10-20",
    "genero" : "Anime",
    "puntaje" : 9,
    "temporadas" : 2
}


response1 = req.put(url, json=data1)
print("Status code:", response1.status_code)
print("Respuesta:", response1.text)
