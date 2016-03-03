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
    │
    ├───co.edu.uniandes.rest.dtos
    │   │   ViajeroDTO.java
    │   |   EventDTO.java
    │   |   TimelineDTO.java
    │
    ├───co.edu.uniandes.rest.mocks
    │   │   ViajeroLogicMock.java 
    |   │   EventoLogicMock.java 
    │   |   TimelineLogicMock.java
    │
    ├───co.edu.uniandes.rest.exceptions
    │   │   PrimidLogicException.java
    │   │   EventoLogicException.java
    │   |   TimelineLogicExceptioni.java
    │
    └───co.edu.uniandes.converters
        │   PrimidLogicExceptionMapper.java        
```

| Clase | Descripción |
| ----- | ----------- |
| `RestConfig.java` | Indica que la aplicación expone recursos REST. Solo se re	quiere uno en la aplicación. Especifica la ruta `/api` como prefijo para los recursos REST |
| `ViajeroResource.java` | Define el recurso con la ruta `/api/viajero`. Contiene métodos para procesar las peticiones GET, POST, PUT y DELETE de acuerdo al API definido |
| `ViajeroDTO.java` | Define los datos que se transfiere entre el cliente y el servidor. Como se usa como tipo de retorno en los métodos de `ViajeroResource`, JAX-RS convierte automáticamente de JSON a esta clase y de esta clase a JSON.  |
| `ViajeroLogicMock.java` | Simula un servicio de lógica de negocios. En este ejemplo, el Mock manipula los elementos en una lista de viajeros (Un lista de `ViajeroDTO`). |
| `PrimidLogicException.java` | Excepción lanzada por PriimidLogicMock cuando se genera un error. |
| `PrimidLogicExceptionMapper.java` | Convertidor de la excepción `PrimidLogicException` a mensajes REST. |


## Documentación del API

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
**GET**|/cities|Lista los registros de City (READ)|||Colección de registros de City 
**GET**|/cities/*:id*|Obtener los atributos de una instancia de City (READ)|**@PathParam id**: Identificador del registro||Atributos de la instancia de City
**POST**|/cities|Crear una nueva instancia de la entidad City (CREATE)||Atributos de la instancia de City a crear|Instancia de City creada, incluyendo su nuevo ID
**PUT**|/cities/*:id*|Actualiza una instancia de la entidad City (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de City|Instancia de City actualizada
**DELETE**|/cities/*:id*|Borra instancia de City en el servidor (DELETE)|**@PathParam id**: Identificador del registro||



## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional. 
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opción de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener las ciudades | GET http://localhost:8080/Servidor-JAXRS/api/cities |
| Obtener una ciudad   | GET http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a obtener. Por ejemplo, para traer la ciudad con el id=1 es posible usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/1 | 
| Agregar una ciudad   | POST http://localhost:8080/Servidor-JAXRS/api/cities  incluyendo en la petición una ciudad. Por ejemplo, es posible usar `{ "id": 4, "name": "barranquilla" }` |
| Modificar una ciudad | PUT http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a modificar. Por ejemplo, para modificar la ciudad con el id=1 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/1 y enviar como parámetro los datos de la nueva cuidad, por ejemplo, `{ "id": 1, "name": "Santa Fe de Bogota" }` |  
| Borrar una ciudad    | DELETE http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a eliminar. Por ejemplo, para eliminar la ciudad con el id=2 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/2 | 
