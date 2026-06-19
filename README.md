# Kata 5 - Persistencia con SQLite y Carga de Datos Remota

## Descripción

Esta práctica amplía la kata anterior para incorporar persistencia mediante SQLite y la carga de datos desde una fuente externa.

La aplicación permite almacenar los datos obtenidos desde una fuente remota en una base de datos SQLite y generar histogramas a partir de la información persistida. Se mantiene una clara separación entre las capas de acceso a datos, lógica de negocio y presentación.

---

## Estructura del proyecto

```
src/main/java
├── app
│   └── Main.java
├── io
│   ├── CSVSongParser.java
│   ├── CSVSongReader.java
│   ├── DatabaseRecorder.java
│   ├── DatabaseStore.java
│   ├── Recorder.java
│   ├── SongParser.java
│   └── Store.java
├── model
│   └── Song.java
├── tasks
│   └── HistogramBuilder.java
├── view
│   └── MainFrame.java
└── viewmodel
    └── Histogram.java
```

---

## Objetivos de la práctica

- Incorporar persistencia mediante SQLite.
- Cargar datos desde una fuente externa.
- Almacenar los registros obtenidos en una base de datos.
- Generar histogramas utilizando los datos almacenados.
- Mantener una arquitectura modular y organizada.
- Separar las responsabilidades entre acceso a datos, lógica y presentación.

---

## Clases del proyecto

### Main.java
Punto de entrada de la aplicación.

### Song.java
Clase inmutable que representa una canción y sus atributos.

### SongReader.java
Clase encargada de leer el dataset desde una fuente externa.

### CSVSongReader.java
Clase encargada de obtener y leer los datos en formato CSV.

### SongParser.java
Interfaz que define cómo convertir una línea del archivo en un objeto `Song`.

### CSVSongParser.java
Clase encargada de transformar cada línea del CSV en un objeto `Song`.

### Recorder.java
Interfaz que define el almacenamiento de los datos.

### DatabaseRecorder.java
Clase encargada de guardar los registros en la base de datos SQLite.

### Store.java
Interfaz encargada del acceso a los datos almacenados.

### DatabaseStore.java
Clase responsable de recuperar la información almacenada en SQLite.

### HistogramBuilder.java
Clase encargada de generar histogramas a partir de los datos almacenados.

### Histogram.java
Clase view model que almacena los valores y las frecuencias observadas en el histograma.

### MainFrame.java
Clase responsable de la interfaz gráfica y de la representación visual del histograma.

---

## Uso de Git

Se han realizado commits durante el desarrollo para registrar los cambios del proyecto y facilitar el seguimiento de la práctica.

---

## Nota

Esta práctica forma parte del aprendizaje sobre persistencia de datos y arquitectura por capas. Se ha implementado el almacenamiento en SQLite y la generación de histogramas utilizando la información persistida, manteniendo una separación clara entre el modelo de datos, el acceso a datos, la lógica de negocio y la interfaz gráfica.
