# Flock REST api

## Descripción:
El siguiente proyecto fue desarrollado a partir del uso del framework spring boot, en Java 8 con base de datos en memoria H2.

Plataforma:

    - Java 8
    - Spring Boot

Dependencias:

    - Swagger
    - Lombook
    - Logger
    

##Aclaracion !!
## Para poder ejecutar los endopoints debera previamente desde un browser deberá loguearse previamente:

### Puede accederse desde el root, el cual lo redireccionara al login:
[http://localhost:8080/](http://localhost:8080/)

### O puede accederse desde el la ruta de login:
[http://localhost:8080/login](http://localhost:8080/login)

###Para cerrar la sesión, puede hacerlo desde la url:
[http://localhost:8080/logout](http://localhost:8080/logout)

##Lista de usuarios:
```
Usuario: admin        -       Password: 1234
Usuario: amanca       -       Password: 1234
Usuario: flock        -       Password: 1234
Usuario: simpleuser   -       Password: 1234
```

#Desarrollo

Para el siguiente proyecto se desarrollaron 2 endpoints manejados por un solo controlador, que cumplen con lo requerido.
Corresponden a 2 método de acceso por verbo GET:

### A - .../api/provincia (GET)

Permite obetener las coordenadas de una provicia pasando por parámetro su nombre.

### B - .../api/nombresProvincias (GET)

Permite obetener una lista con los nombres de las provicia que sirven de parametro para el punto anterior.


##Capa de seguridad

Para este apartado se trabajo con el modulo de spring security. Al iniciar la aplicacion una serie de usuarios se cargan 
en una base embebida en memoria y sirven como parametro para el acceso.

Se creo un servicio que retorna un UserDetails con el fin de garantizar la autenticación.


##Documentación
Para probar los endpoints puede hacerlo desde Swagger accediendo a la siguente pagina:
###* Recuerede que debe loguearse antes.

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Test 
Para los casos de testing se creo un test simple para la clase provinceServices.

## Logs
Para logs se uso la libreria Logger de slf4j.
