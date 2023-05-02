# SpringBoot3 Login con Thymeleaf

Este proyecto es una muestra de como configurar **Spring Secutiry 6** con **Springboot 3** utilizando como motor de plantilla 
**thymeleaf**, en cuanto a la personalizacion de la pagina de inicio de sesion y registro, se esta utilizando **bootstrap 5**.

**Empezando:**

Antes de iniciar el proyecto, este necesita algunos requerimientos:

- JDK 17 o superior.
- MYSQL como gestor de base de datos.
- Maven como empaquetador.

Si no tenes instalado el JDK o tenes una version del JDK por debajo del 17, podes ir a este link para descargarlo [aqui](https://learn.microsoft.com/en-us/java/openjdk/download).

En caso de maven tambien te dejo el link para que lo descarges [aqui](https://maven.apache.org/download.cgi)

**Formas de Iniciar el proyecto**

Clonate el repositorio de GitHub:
```shell
git clone https://github.com/mikellbobadilla/login_thymeleaf.git

cd login_thymeleaf
```

**Normal sin Docker**

En el archivo **application.properties** estan los datos para conectarse a la base de datos, podes modificarlos y es necesario con tus propios datos.

Pero es necesario crear un base de datos llamada **login** o cambiarla por una que ya creaste.

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/login
spring.datasource.username=spring
spring.datasource.password=holamundo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

SI no tenes instalado MYSQL pero si tenes instalado **Docker y docker-compose**, encontraras dento del proyecto
el archivo **docker-compose.yml**, solo sera necesario que ejecutes el comando:

```shell
# Si estas en linux agregale sudo al comando. 
docker-compose up -d
```
Luego de que la base de datos este corriendo solo tenes que iniciar el proyecto:

```shell
mvn spring-boot:run
```

**Si tenes Docker**

lo primero que tenes que hacer es compilar la **App**

```shell
mvn clean # para limpiar datos que no se necesitan
mvn install # para compilar y generar el archivo .jar
```

si correctamente compilo la app ya podemos generar la imagen de **Docker**

```shell
# Si estas en linux es necesario ejecutarlo con sudo
docker build -t login_app:1.0.0 .

docker image ls # Para ver si correctamente tenemos la imagen
```

Si vemos que la imagen se genero correctamente, ahora solo queda correr el **docker-compose**

```shell
# Linux en modo sudo
docker-compose up -d
```