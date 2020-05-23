Proyecto EasyBooking - Los JavaTos
===================================
[a](src\\main\\resources\\img\\Logo EasyBooking_Blanco.png)
## Indicaciones
1. Móntese el proyecto Maven en local.
2. Compruebe la estructura del programa.
3. Lance el servidor. 
4. Lance el cliente.
5. Disfrute de la experiencia EasyBooking desde casa.
	
## Comandos a utilizar a lo largo del programa
Para lanzar el cliente y el servidor, estos serán los comandos que utilizaremos. 
```
mvn [clean | validate | compile | install | package]
```
```mvn clean```: removes any file created out of mvn execution.

```mvn validate```: validate the project is correct and all necessary information is available.

```mvn compile```: Compiles and loads the ant build.xml file.

```mvn install```: Builds a project and places its binaries in the local repository.

```mvn package```: Compile all the Java files, run any tests, and package the deliverable code and resources into target.

## ¿Cómo lanzar el servidor?
Se deben seguir los siguientes pasos:
1. Colóquese dentro de la carpeta server_src y abra la consola de comandos.
2. mvn clean
3. mvn validate (se puede omitir, el proyecto es correcto y toda la información necesaria está disponible.
4. mvn compile
5. mvn package

## ¿Cómo lanzar el cliente?
Se deben seguir los siguientes pasos:
1. Colóquese dentro de la carpeta client_src y abra la consola de comandos.
2. mvn clean
3. mvn validate (se puede omitir, el proyecto es correcto y toda la información necesaria está disponible).
4. mvn compile
5. mvn install
6. mvn package
7. mvn package (por segunda vez, necesario para que ejecute el jar generado por el maven-shade-plugin).

Para obtener más información del plugin maven-shade-plugin clique [aquí](https://maven.apache.org/plugins/maven-shade-plugin/usage.html).

## ¿Qué puedo hacer en EasyBooking?
Podré hacer, entre otras cosas:
1. Iniciar sesión y registrarme (se conectará a una RaspberryPi de la Universidad de Deusto a través de la VPN de la Universidad).
2. Buscar vuelos que te interesen.
3. Hacer reservas para vuelos futuros.
4. Pagar mediante Visa o Paypal.

## Contribuidores

Proyecto realizado para la asignatura de Diseño del Software, elaborado por Juan Solozabal, Lander Pisón y Javier Álvarez de Eulate. Lo más interesante de este proyecto quizá sea la implementación de patrones básicos como Singleton, Controller & Service Locator, Façade, AppServices, DAO, Gateways... así como una aplicación sencilla de Datanucleus. 

Para cualquier duda o propuesta de mejora no duden en contactar con nosotros.

Atentamente,

Los JavaTos.