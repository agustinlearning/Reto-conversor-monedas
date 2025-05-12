# 💱 Conversor de Monedas con API

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)

Aplicación Java que convierte monedas en tiempo real usando [ExchangeRate-API](https://www.exchangerate-api.com/), con almacenamiento de historial en JSON.

## 🚀 **Características**
- Consulta tasas de cambio actualizadas
- Soporta múltiples monedas (USD, DOP, EUR, etc.)
- Guarda respuestas de la API en `api_response.json`
- Interfaz de usuario intuitiva con validación
- Código estructurado con Gson para manejo de JSON

## 📦 **Estructura del Proyecto**


## 🔧 **Configuración**
1. **Requisitos**:
    - Java 17+
    - Librerías:
        - Gson (incluir en `pom.xml` o descargar .jar)
        - Módulo `java.net.http`

2. **API Key**:
    - Reemplaza `apiKey` en `Principal.java` por tu clave de [ExchangeRate-API](https://www.exchangerate-api.com/)

## 🖥️ **Uso**
1. Ejecuta `Principal.java`
2. Selecciona monedas del menú:


### 📌 **Cómo usar este README.md**:
1. Copia el contenido a un archivo `README.md` en tu proyecto.
2. Personaliza las secciones con tus datos (licencia, autor, etc.).
3. Actualiza las "Mejoras Futuras" según tu roadmap.

### 🔍 **Visualización en GitHub**:
Este archivo mostrará:
- Badges de estado
- Sintaxis resaltada
- Estructura de archivos como árbol
- Formatos especiales para código y modelos