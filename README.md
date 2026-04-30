# FilmFlux
## Modelos
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
>- Id Serie (si es de una serie)
>- Id Pelicula (si es de una pelicula)
---
## BD's
>[!NOTE]
>La base de datos con nombre FilmFlux se crea de forma automatica con el mysql de Laragon en el caso de que no se encuentre la base de datos

>[!TIP]
>Para utilizar el visor de sql que se utiliza en la creacion de estre proyecto
>[DESCARGAR HEIDI](https://www.heidisql.com/download.php)
>App para crear y gestionar el MySQL
>[DESCARGA LARAGON](https://laragon.org/download)

---
## Scrips de testeo
> [!TIP]
> Para testear el método POST en este proyecto se agregaron archivos Python.
> Dentro de la carpeta `/Python`.
>
> Instala la librería necesaria:
>
> ```bash
> pip install requests
> ```