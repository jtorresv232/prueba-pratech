# prueba-pratech

Para correr el proyecto se debe tener en cuenta la siguiente configuración;

1. Tener SQL Server con una instancia corriendo.
  - Verificar que el servicio permita protocolo de conexión tcp/ip
  - A través de SQl Server Configuration manager verificar en los servicios que se encuentre corriendo el servicio SQL Server Browser;
  
2. Crear la base de datos.
  - Crearla con el script que se encuentra dentro del proyecto como "script.sql"
  
3. Conectar el backend
  - Dentro del backend en la ruta /src/main/resources/application.properties cambiar el nombre de la instancia "SQLEXPRESS", cambiarla por la instancia que se encuentra
  corriendo, el nombre "SQLEXPRESS" es el que viene por defecto.
  - Para correr el backend se puede hacer desde el IDE eclipse teniendo el plugin STS spring tools suite, ir a la ruta src/main/java/com/pratechtest/pratechtestbackend,
  allí se encuentra el archivo con la clase Main, presionar click derecho sobre el archivo->Run as -> Spring boot app
  
4 Correr el front-end
  - Desde cualquier terminal ubicarse en la carpeta base del proyecto front-end
  - luego correr el comando "npm i" para instalar las dependencias del proyecto
  - una vez instaladas correr el comando "npm start" para correr el proyecto que correra en el puerto 3000
  
5 - Desde el front-end crear una cuenta y loggearse.
