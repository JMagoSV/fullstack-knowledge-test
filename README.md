# fullstack-knowledge-test
Fullstack knowledge test, java, spring boot, maven, angular cli

#### Contenido del repositorio
- **marvel-consumer**: Proyecto maven spring boot que consume la api de marvel y devuelve los resultado, está empaquetado en un jar y para utilizarse debe llamarse la dependency
- **marvel-api**: API REST que utiliza marvel-consumer, devuelve los resultados de marvel api y los eventos (consultas) que se dan dentro del api rest
- **marvel-webapp**: Proyecto en angular-cli que contiene el routing de los componentes, servicios y que también muestra las tablas de datos y el popup con los detalles de cada registro consultado
- **Marvel.postman_collection**: Archivo que puede ser importado de postman para probar los servicios.

#### Instrucciones
- Empaquetar **marvel-consumer**
- Empaquetar y correr **marvel-api **(Configurado en el puerto 80)
- Descargar dependencias y correr **marvel-webapp**