# Final_ComputacionGrafica

README.TXT

Proyecto: Sistema de Renderizado con Ray Tracing en Java

Punto implementado:
Hemos implementado el punto de trazado de rayos (ray tracing) para renderizar escenas 3D que contienen esferas y triángulos. Se hace lectura desde un archivo `escena.txt` para construir la escena con cámaras, luces, materiales, colores y objetos geométricos.

Entorno sugerido:
- Lenguaje: Java (versión 8 o superior)
- Editor: Visual Studio Code (u otro compatible)
- Sistema operativo: Windows, macOS o Linux

Estructura del proyecto:
- `geometry/`: contiene las clases `Sphere.java`, `Triangle.java`, `Ray.java`, etc.
- `math/`: operaciones matemáticas (`Vector4.java`, `Matrix4x4.java`, etc.)
- `display/`: lógica de escena (`Scene.java`, `Canvas.java`, etc.)

Cómo compilar:
Desde la raíz del proyecto, ejecutar:

    javac */*.java

Cómo ejecutar:
Una vez compilado, correr el siguiente comando desde la raíz del proyecto:

    java display.Scene

Requisitos de entrada:
- El archivo `escena.txt` debe estar en el mismo directorio de ejecución o en la ruta esperada por `Scene.java`.
- El archivo `escena.txt` contiene los datos de cámaras, luces, materiales, colores, esferas y triángulos.

Archivos entregados:
- Código fuente del proyecto en Java.
- Archivo `escena.txt` con configuración de prueba.
- Video de demostración (máximo 3 minutos) mostrando el programa en ejecución.
- Este archivo `README.TXT`.

Importante:
- Se implementó estrictamente el método de intersección para esferas y triángulos tal como se especifica en el examen.
- Se utilizó el sistema de coordenadas de cámara (UVN) para transformar objetos.
- No se usaron librerías externas ni herramientas no permitidas.

Penalización por entrega tardía:
- Entiendo que cada hora o fracción de demora implica una reducción de 0.5 puntos sobre la nota final.

Autor:
Salomé Serna Restrepo, Santiago Sánchez Carvajal y Alejandro Arango
28 de mayo 2025
