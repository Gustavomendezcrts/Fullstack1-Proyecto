# FilmFlux
## Informacion General
Este proyecto es sobre un sistema de recomendacion de Peliculas o series en conjunto a un sistema de reseñas para esto mismo.

Se trabaja con las librerias de Lombook y Jakarta dentro de un sistema de SpringBoot.

>[!NOTE]
>## Los endpoints principales del sistema es
>- **Get Peliculas**
>   - http://Localhost:8080/api/v1/peliculas
>   - [Ir a endpoint](http://Localhost:8080/api/v1/peliculas)
>- **Get Series**
>   - http://Localhost:8080/api/v1/series
>   - [Ir a endpoint](http://Localhost:8080/api/v1/series)
>- **Get Usuarios**
>   - http://Localhost:8080/api/v1/usuarios
>   - [Ir a endpoint](http://Localhost:8080/api/v1/usuarios)
>- **Get Reseñas** 
>   - http://Localhost:8080/api/v1/resenas
>   - [Ir a endpoint](http://Localhost:8080/api/v1/resenas)

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
## Autores 
### Tomas Martines - Gustavo Mendez
