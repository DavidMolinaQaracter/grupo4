# Trivia Quiz Game – Proyecto en Java - Grupo 4

---

## Descripción del proyecto

**Trivia Quiz Game** es un juego de preguntas tipo cuestionario (quiz) desarrollado en **Java** utilizando:

El jugador debe responder preguntas de opción múltiple y al final se muestra:
- Puntaje final  
- Detalle de respuestas correctas e incorrectas  

---

## Estructura del proyecto

src/
└─ main/
└─ java/
├─ core/ → Lógica del juego (POO)
│ ├─ Question.java
│ ├─ Quiz.java
│ ├─ GameResult.java
│ └─ QuestionLoader.java
│
├─ ui/ → Interfaz gráfica Swing
│ ├─ MainMenu.java
│ ├─ QuizWindow.java
│ └─ ResultsWindow.java
│
├─ data/ → Archivo con preguntas
│ └─ data.txt
│
└─ Main.java → Ejecuta el juego

---

## Ejecución del programa 

Desde terminal dentro del proyecto:

```bash
javac src/main/java/core/*.java src/main/java/ui/*.java src/main/java/Main.java
java -cp src/main/java Main
```

