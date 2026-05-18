# FilmFlux
## Informacion General
Este proyecto es sobre un sistema de recomendacion de Peliculas o series en conjunto a un sistema de reseñas para esto mismo.

Se trabaja con las librerias de Lombook y Jakarta dentro de un sistema de SpringBoot.

---
## Get Started
se necesita una base de datos del tipo MySql se recomienda el uso de Laragon para el manejo de este tipo de base de datos [DESCARGA LARAGON](https://laragon.org/download).

Tambien se recomienda el uso de Heidi SQL para la visualizacion de las distintas tablas de la base de datos               [DESCARGAR HEIDI](https://www.heidisql.com/download.php).

se tiene que descargar el proyecto para la ejecucion con el comando 

`Git clone https://github.com/Gustavomendezcrts/Fullstack1-Proyecto.git`

> [!NOTE]
> Al momento de ejecucion la aplicacion por si sola creara las tablas y sus atributos al igual que sus relaciones, no es necesario crearlas manualmente

> [!TIP]
> Para agregar informacion de pruebas se recomienda el uso de PostMan con la coleccion de Postman que se agrego en la carpeta `\postman`
---
## Atrubutos de tablas de la Base de datos 
>**Pelicula**
>- Id
>- IMDb
>- Titulo
>- Director
>- Fecha de estreno
>- Genero
>- Puntaje (1 - 10)


>**Serie**
>- Id
>- IMDb
>- Titulo
>- Director
>- Fecha de estreno
>- Genero
>- Puntaje (1 - 10)
>- Temporadas (Cantidad)

>**Usuario**
>- Id
>- Nombre
>- Email
>- Contraseña
>- Gusto Principal (serie/pelicula)
>- Gusto Secundario (serie/pelicula)

>**Resena**
>- Id
>- Puntaje (1 - 10)
>- comentario
>- Id Usuario
>- Id Pelicula (si es de una pelicula)
>- Id Serie (si es de una serie)
---
>[!IMPORTANT]
>### PARA UTILIZAR LOS SIGUIENTES EJEMPLOS PARA LOS ENDPOINTS SE REQUIERE QUE LA APLICACION ESTE EN EJECUCION

>[!NOTE]
>## Los endpoints principales del sistema son
>
>- **Get Películas**
>   - http://localhost:8080/api/v1/peliculas
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/peliculas)
>
>- **Get Películas por Género**
>   - http://localhost:8080/api/v1/peliculas/genero/{genero}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/peliculas/genero/accion)
>
>- **Post Crear Película**
>   - http://localhost:8080/api/v1/peliculas
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/peliculas)
>
>- **Put Actualizar Película**
>   - http://localhost:8080/api/v1/peliculas/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/peliculas/1)
>
>- **Delete Eliminar Película**
>   - http://localhost:8080/api/v1/peliculas/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/peliculas/1)
>
>
>- **Get Series**
>   - http://localhost:8080/api/v1/series
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/series)
>
>- **Get Serie por ID**
>   - http://localhost:8080/api/v1/series/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/series/1)
>
>- **Post Crear Serie**
>   - http://localhost:8080/api/v1/series
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/series)
>
>- **Put Actualizar Serie**
>   - http://localhost:8080/api/v1/series/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/series/1)
>
>- **Delete Eliminar Serie**
>   - http://localhost:8080/api/v1/series/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/series/1)
>
>
>- **Get Usuarios**
>   - http://localhost:8080/api/v1/usuarios
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios)
>
>- **Get Usuario por ID**
>   - http://localhost:8080/api/v1/usuarios/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios/1)
>
>- **Get Usuario por Username**
>   - http://localhost:8080/api/v1/usuarios/username/{username}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios/username/admin)
>
>- **Post Crear Usuario**
>   - http://localhost:8080/api/v1/usuarios
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios)
>
>- **Put Actualizar Usuario**
>   - http://localhost:8080/api/v1/usuarios/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios/1)
>
>- **Delete Eliminar Usuario**
>   - http://localhost:8080/api/v1/usuarios/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/usuarios/1)
>
>
>- **Get Reseñas**
>   - http://localhost:8080/api/v1/resenas
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas)
>
>- **Get Reseña por ID**
>   - http://localhost:8080/api/v1/resenas/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/1)
>
>- **Get Reseñas por Usuario**
>   - http://localhost:8080/api/v1/resenas/resenasPorUsuario/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/resenasPorUsuario/1)
>
>- **Get Reseñas por Película**
>   - http://localhost:8080/api/v1/resenas/resenasPorPelicula/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/resenasPorPelicula/1)
>
>- **Get Reseñas por Serie**
>   - http://localhost:8080/api/v1/resenas/resenasPorSerie/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/resenasPorSerie/1)
>
>- **Post Crear Reseña**
>   - http://localhost:8080/api/v1/resenas
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas)
>
>- **Put Actualizar Reseña**
>   - http://localhost:8080/api/v1/resenas/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/1)
>
>- **Delete Eliminar Reseña**
>   - http://localhost:8080/api/v1/resenas/{id}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/resenas/1)
>
>
>- **Get Poster TMDB por IMDB ID**
>   - http://localhost:8080/api/v1/tmdb/{imdbCode}
>   - Aquí un ejemplo de endpoint: [Ir a endpoint](http://localhost:8080/api/v1/tmdb/tt0111161)
---
## Autores 
### Tomas Martines - Gustavo Mendez
