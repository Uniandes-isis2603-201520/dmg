# DMG (Primid webPage)


## Descripción del proyecto

Proyecto Primid, modela una herramienta para la planeacion de viajes.
Integra servicios REST implementando JAX-RS.


## Estructura del proyecto

El proyecto sigue la estructura de los proyectos Maven. 
Por lo tanto, el código fuente Java está ubicado en la carpeta `src/main/java` dentro del proyecto.
El código de la página web está ubicado en la carpeta `src/main/webapp`. 

Para entender el código fuente del ejemplo, es necesario revisar los siguientes archivos:

```
Servidor-JAXRS
│   README.md
│
└───src/main/java
    ├───co.edu.uniandes.rest.resources
    │   │   RestConfig.java
    │   │   TimelineResource.java
    │   │   ViajeroResource.java
    │   |   EventoResource.java
    │   |   MultimediaResource.java
    |   |   ItinerarioResource.java
    │
    ├───co.edu.uniandes.rest.dtos
    │   │   ViajeroDTO.java
    │   |   EventDTO.java
    │   |   MultimediaDTO.java
    |   |   ItinerarioDTO.jjave
    │
    ├───co.edu.uniandes.rest.mocks
    │   │   ViajeroLogicMock.java 
    |   │   EventoLogicMock.java
    |   │   MultimediaLogicMock.java 
    |   |   ItinerarioLogicMock.java
    │
    ├───co.edu.uniandes.rest.exceptions
    │   │   PrimidLogicException.java
    │   │   EventoLogicException.java
    │   │   MultimediaLogicException.java
    |   |   ItinerarioLogicException.java
    │
    └───co.edu.uniandes.converters
        │   PrimidLogicExceptionMapper.java        
```

| Clase | Descripción |
| ----- | ----------- |
| `RestConfig.java` | Indica que la aplicación expone recursos REST. Solo se re	quiere uno en la aplicación. Especifica la ruta `/api` como prefijo para los recursos REST |
| `ViajeroResource.java` | Define el recurso con la ruta `/api/viajero`. Contiene métodos para procesar las peticiones GET, POST, PUT y DELETE de acuerdo al API definido |
| `EventoResource.java` | Define el recurso con la ruta `/api/eventos`. Contiene métodos para procesar las peticiones GET, POST, PUT y DELETE de acuerdo al API definido |
| `MultimediaResource.java` | Define el recurso con la ruta `/api/multimedia`. Contiene métodos para procesar las peticiones GET, POST, PUT y DELETE de acuerdo al API definido |
| `ViajeroDTO.java` | Define los datos que se transfiere entre el cliente y el servidor. Como se usa como tipo de retorno en los métodos de `ViajeroResource`, JAX-RS convierte automáticamente de JSON a esta clase y de esta clase a JSON.  |
| `EventoDTO.java` | Define los datos que se transfiere entre el cliente y el servidor. Como se usa como tipo de retorno en los métodos de `EventoResource`, JAX-RS convierte automáticamente de JSON a esta clase y de esta clase a JSON.  |
| `MultimediaDTO.java` | Define los datos que se transfiere entre el cliente y el servidor. Como se usa como tipo de retorno en los métodos de `MultimediaResource`, JAX-RS convierte automáticamente de JSON a esta clase y de esta clase a JSON.  |
| `ViajeroLogicMock.java` | Simula un servicio de lógica de negocios. En este ejemplo, el Mock manipula los elementos en una lista de viajeros (Un lista de `ViajeroDTO`). |
| `EventoLogicMock.java` | Simula un servicio de lógica de negocios. En este ejemplo, el Mock manipula los elementos en una lista de eventos (Un lista de `EventoDTO`). |
| `PrimidLogicException.java` | Excepción lanzada por PriimidLogicMock cuando se genera un error. |
| `EventoLogicException.java` | Excepción lanzada por EventodLogicMock cuando se genera un error del recurso Evento. |
| `MultimediaLogicException.java` | Excepción lanzada por MultimediaLogicMock cuando se genera un error del recurso Multimedia. |
| `PrimidLogicExceptionMapper.java` | Convertidor de la excepción `PrimidLogicException` a mensajes REST. |


## Documentación del API

### Entidad Evento

La comunicación entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "description" : '',    /* Tipo String */
    "pathImage" : ''    /* Tipo String */
}
```

Si se solicta la servidor una lista de ciudades, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato: 

 ```javascript
[ 
  {
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "description" : '',    /* Tipo String */
    "pathImage" : ''    /* Tipo String */
  }, {
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "description" : '',    /* Tipo String */
    "pathImage" : ''    /* Tipo String */
  } /* ... otras eventos */   
]
```

### Servicios REST

Al ejecutarlo en su propia máquina, el recurso REST estará disponible en:
*  `http://localhost:8080/Servidor-JAXRS/api/eventos` 

La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/eventos|Lista los registros de Evento (READ)|||Colección de registros de Evento
**GET**|/eventos/*:id*|Obtener los atributos de una instancia de Evento (READ)|**@PathParam id**: Identificador del registro||Atributos de la instancia de Evento
**POST**|/eventos|Crear una nueva instancia de la entidad Evento (CREATE)||Atributos de la instancia de Evento a crear|Instancia de Evento creada, incluyendo su nuevo ID
**PUT**|/itinerarios/*:id*/planCiudades/*:id*/planEventos/*:id*|Actualiza una instancia de la entidad Itinerario (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Evento|Instancia del Itinerario actualizada
**DELETE**|/eventos/*:id*|Borra instancia de Evento en el servidor (DELETE)|**@PathParam id**: Identificador del registro||



## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional. 
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opción de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener los eventos | GET http://localhost:8080/Servidor-JAXRS/api/eventos |
| Obtener un evento   | GET http://localhost:8080/Servidor-JAXRS/api/eventos/{id} donde id es el `id` del evento a obtener. Por ejemplo, para traer la ciudad con el id=1 es posible usar el URL http://localhost:8080/Primid/api/eventos/1 | 
| Agregar un evento   | POST http://localhost:8080/Servidor-JAXRS/api/eventos  incluyendo en la petición un evento. Por ejemplo, es posible usar `{ "id": 4, "name": "Tomorroland", "descrption":"Concierto de musica electronica", "pathImage":"/rutaImagen/tomorrowLand.jpg" }` |
| Modificar un evento | PUT http://localhost:8080/Servidor-JAXRS/api/eventos/{id} donde id es el `id` del evento a modificar. Por ejemplo, para modificar el evento con el id=1 es necesario usar el URL http://localhost:8080/Primid/api/eventos/1 y enviar como parámetro los datos del nuevo evento, por ejemplo, `{ "id": 1, "name": "Tomorroland2", "descrption":"Concierto de musica electronica", "pathImage":"/rutaImagen/tomorrowLand.jpg" }` |  
| Borrar un evento    | DELETE http://localhost:8080/Primid/api/eventos/{id} donde id es el `id` del evento a eliminar. Por ejemplo, para eliminar el vento con el id=2 es necesario usar el URL http://localhost:8080/Primid/api/eventos/2 | 

### Entidad Viajero

La comunicación entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "email" : '',    /* Tipo String */
    "rutaImagen" : ''    /* Tipo String */
}
```

Si se solicta la servidor una lista de ciudades, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato: 

 ```javascript
[ 
  {
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "email" : '',    /* Tipo String */
    "ruta" : ''    /* Tipo String */
  }, {
    "id" : 2,     /* Tipo Long */
    "name" : ''    /* Tipo String */
    "email" : '',    /* Tipo String */
    "ruta" : ''    /* Tipo String */
  } /* ... otras ciudades */   
]
```

### Servicios REST

Al ejecutarlo en su propia máquina, el recurso REST estará disponible en:
*  `http://localhost:8080/Servidor-JAXRS/api/viajero` 

La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/viajeros|Lista los registros de viajero (READ)|||Colección de registros de Viajero
**GET**|/viajero/*:id*|Obtener los atributos de una instancia de Viajero (READ)|**@PathParam id**: Identificador del registro||Atributos de la instancia de Viajero
**POST**|/viajeros|Crear una nueva instancia de la entidad Viajero (CREATE)||Atributos de la instancia de Viajero a crear|Instancia de Viajero creada, incluyendo su nuevo ID
**PUT**|/viajero/*:id*|Actualiza una instancia de la entidad Viajero (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Viajero|Instancia de Viajero actualizada
**DELETE**|/viajero/*:id*|Borra instancia de Viajero en el servidor (DELETE)|**@PathParam id**: Identificador del registro||



## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional. 
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opción de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener las ciudades | GET http://localhost:8080/Servidor-JAXRS/api/viajeros |
| Obtener una ciudad   | GET http://localhost:8080/Servidor-JAXRS/api/viajero/{id} donde id es el `id` del Viajero a obtener. Por ejemplo, para traer la el viajero con el id=1 es posible usar el URL http://localhost:8080/Servidor-JAXRS/api/viajero/1 | 
| Agregar un Viajero  | POST http://localhost:8080/Servidor-JAXRS/api/viajero  incluyendo en la petición un Viajero. Por ejemplo, es posible usar `{ "id": 1, "name": "Juan", "mail":"juan@uniandes.edu.co", "ruta":"/data/profile.png" }` |
| Modificar una Viajero | PUT http://localhost:8080/Servidor-JAXRS/api/viajero/{id} donde id es el `id` del viajero a modificar. Por ejemplo, para modificar la ciudad con el id=1 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/viajero/1 y enviar como parámetro los datos del nuevo viajero, por ejemplo, `{ "id": 1, "name": "JuanC", "mail":"juanC@uniandes.edu.co", "ruta":"/data/profileC.png" }` |  
| Borrar un Viajero    | DELETE http://localhost:8080/Servidor-JAXRS/api/viajero/{id} donde id es el `id` del viajero a eliminar. Por ejemplo, para eliminar el viajero con el id=2 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/viajero/2 | 

### Entidad Multimedia

La comunicación entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "tipo" : '',    /* Tipo String */
    "visible" : '',    /* Tipo boolean */
    "ruta" : ''    /* Tipo String */
}
```

Si se solicta la servidor una lista de ciudades, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato: 

 ```javascript
[ 
  {
    "id" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "tipo" : '',    /* Tipo String */
    "visible" : '',    /* Tipo boolean */
    "ruta" : ''    /* Tipo String */
  }, {
    "id" : 2,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "tipo" : '',    /* Tipo String */
    "visible" : '',    /* Tipo boolean */
    "ruta" : ''    /* Tipo String */
  } /* ... otros archivos multimedia */   
]
```

### Servicios REST

Al ejecutarlo en su propia máquina, el recurso REST estará disponible en:
*  `http://localhost:8080/Servidor-JAXRS/api/multimedia` 

La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/multimedia|Lista los registros de Multimedia (READ)|||Colección de registros de archivos multimedia
**GET**|/multimedia/*:id*|Obtener los atributos de una instancia de archivo multimedia (READ)|**@PathParam id**: Identificador del registro ||Atributos de la instancia del archivo  Multimedia 
**POST**|/multimedia|Crear una nueva instancia de la entidad Multimedia (CREATE)||Atributos de la instancia de Multimedia a crear|Instancia de Multimedia creada, incluyendo su nueva ruta
**PUT**|/multimedia/*:id*|Actualiza una instancia de la entidad Multimedia (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Multimedia|Instancia de Multimedia actualizada
**DELETE**|/multimedia/*:id*|Borra instancia de Multimedia en el servidor (DELETE)|**@PathParam id**: Identificador del registro||




## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional. 
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opción de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener los archivos multimedia | GET http://localhost:8080/Servidor-JAXRS/api/multimedia |
| Obtener un archivo multimedia   | GET http://localhost:8080/Servidor-JAXRS/api/multimedia/{id} donde id es el `id` del archivo multimedia a obtener. Por ejemplo, para traer el archivo con el id=1 es posible usar el URL http://localhost:8080/Servidor-JAXRS/api/multimedia/1 | 
| Agregar un archivo multimedia   | POST http://localhost:8080/Servidor-JAXRS/api/multimedia  incluyendo en la petición un archivo. Por ejemplo, es posible usar `{ "id": 4, "name": "torre eiffel", "tipo": "imagen", "visible": true, "ruta":"https://github.com/Uniandes-isis2603-201520/dmg/edit/master/imagenes/torre-eiffel.jpg" }` |
| Modificar un archivo multimedia | PUT http://localhost:8080/Servidor-JAXRS/api/multimedia/{id} donde id es el `id` del archivo a modificar. Por ejemplo, para modificar el archivo con el id=1 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/multimedia/1 y enviar como parámetro los datos del nuevo archivo, por ejemplo, `{ "id": 1, "name": "nube" }` |  
| Borrar un archivo multimedia    | DELETE http://localhost:8080/Servidor-JAXRS/api/multimedia/{id} donde id es el `id` del archivo a eliminar. Por ejemplo, para eliminar el archivo con el id=2 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/multimedia/2 | 

### Entidad Itinerario

La comunicación entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "idItinerario" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "resumen" : '',    /* Tipo String */
    "fechaInicio" : '',    /* Tipo Date */
    "fechaFin" : ''    /* Tipo Date */
}
```

Si se solicta la servidor una lista con los itinerarios del usuario, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato: 

 ```javascript
[ 
  {
    "idItinerario" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "resumen" : '',    /* Tipo String */
    "fechaInicio" : '',    /* Tipo Date */
    "fechaFin" : ''    /* Tipo Date */
  }, {
    "idItinerario" : 1,     /* Tipo Long */
    "name" : '',    /* Tipo String */
    "resumen" : '',    /* Tipo String */
    "fechaInicio" : '',    /* Tipo Date */
    "fechaFin" : ''    /* Tipo Date */
  } /* ... otros itinerarios */   
]
```

### Servicios REST

Al ejecutarlo en su propia máquina, el recurso REST estará disponible en:
*  `http://localhost:8080/Servidor-JAXRS/api/itinerarios` 

La descripción del API REST se presenta a continuación:

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/itinerarios|Lista los registros de Itinerario (READ)|||Colección de registros de Itinerario
**GET**|/itinerarios/*:id*|Obtener los atributos de una instancia de Itinerario (READ)|**@PathParam id**: Identificador del itinerario||Atributos del Itinerario
**PUT**|/itinerarios|Crear una nueva instancia de Itinerario (CREATE)||Atributos de la instancia de Itinerario a crear|Instancia de Itinerario creada
**POST**|/itinerarios/*:id*|Actualiza una instancia de la entidad Itinerario (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Evento|Instancia del Itinerario actualizada
**DELETE**|/itinerarios/*:id*|Borra instancia de Itinerario en el servidor (DELETE)|**@PathParam id**: Identificador del Itinerario||



## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional. 
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opción de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener los itinerarios | GET http://localhost:8080/Servidor-JAXRS/api/itinerarios |
| Obtener un itinerario   | GET http://localhost:8080/Servidor-JAXRS/api/itinerarios/{id} donde id es el `id` del itinerario buscado.| 
| Agregar un itinerario   | PUT http://localhost:8080/Servidor-JAXRS/api/itinerarios  incluyendo en la petición un itinerario. Por ejemplo, es posible usar `{ "id": 4, "name": "MiViaje", "resumen":"viaje familiar", "fechaInicio":"2016/03/14","fechaFin":"2016/03/19" }` |
| Modificar un evento | POST http://localhost:8080/Servidor-JAXRS/api/itinerarios/{id} donde id es el `id` del itinerario a modificar. Por ejemplo, para modificar el itinerario con el id=1 es necesario usar el URL http://localhost:8080/Primid/api/itinerarios/1 y enviar como parámetro los datos del nuevo itinerario, por ejemplo, `{ "id": 1, "name": "MiViajeEnFamilia", "resumen":"otro viaje", "fechaInicio":"2016/03/14","fechaFin":"2016/03/19" }` |  
| Borrar un itinerario    | DELETE http://localhost:8080/Primid/api/itinerarios/{id} donde id es el `id` del itinerario a eliminar. Por ejemplo, para eliminar el itinerario con el id=2 es necesario usar el URL http://localhost:8080/Primid/api/itinerarios/2 | 

