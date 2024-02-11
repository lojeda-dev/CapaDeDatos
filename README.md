# CapaDeDatos

#Introducción
¡Bienvenido a CapaDeDatos! Este proyecto, desarrollado en Java 17 y gestionado con Maven, tiene como objetivo principal poner en práctica el concepto transaccional con JDBC. La capacidad de ejecutar múltiples sentencias que modifican el estado de la base de datos (DELETE, UPDATE, INSERT) abriendo una sola conexión es el núcleo de esta implementación.

#Cómo Utilizar
Sigue estos pasos para comenzar a utilizar CapaDeDatos:

Clona el repositorio en tu máquina local.
Abre el proyecto en tu entorno de desarrollo compatible con Java 17 y Maven.
Explora la estructura de paquetes, centrándote en PersonaDAO, PersonaDTO y PersonaMain.
Utiliza la clase PersonaTest en el paquete PersonaMain para realizar pruebas y entender la interacción con la capa de datos.
Tecnologías Utilizadas
El proyecto se desarrolla en Java 17 y utiliza Maven como gestor de dependencias. Además, se aprovecha la potencia de JDBC para la interacción con la base de datos. La elección de estas tecnologías garantiza un desarrollo robusto y eficiente.

#Arquitectura del Proyecto
La estructura del proyecto está organizada en tres paquetes:

#PersonaDAO:
Clase Conexion: Configuración de la base de datos y método para obtener una nueva conexión.
Interface IPersonaDAO: Declaración de métodos (seleccionarTodos, actualizar, insertar y borrar) para manipular los datos.
Clase PersonaDAOimpl: Implementación de los métodos mencionados anteriormente, junto con la lógica asociada a cada uno.

#PersonaDTO:
Clase Persona: Entidad con propiedades y métodos asociados.

#PersonaMain:
Clase PersonaTest: Contiene pruebas para validar el funcionamiento de la capa de datos.

#Sugerencias de Posibles Mejoras
Aquí algunas sugerencias para mejorar aún más el proyecto:

Implementación de pruebas unitarias adicionales para aumentar la cobertura.
Manejo de excepciones más detallado y robusto.
Integración con un sistema de logging para facilitar la depuración.
Uso de patrones de diseño para mejorar la modularidad y extensibilidad del código.

#Casos de Uso
Este proyecto ofrece funcionalidades clave para manipular datos en la base de datos, incluyendo:

Selección de todos los registros.
Actualización de información existente.
Inserción de nuevos registros.
Eliminación de registros.

¡Gracias por tu interés!





