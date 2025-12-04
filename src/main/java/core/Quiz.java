package core;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz {

    private ArrayList<Question> preguntas;
    private ArrayList<GameResult> resultados;

    private int indiceActual;
    private int puntaje;

    public Quiz() {
        preguntas = QuestionLoader.cargar("src/main/java/data/data.txt");
        resultados = new ArrayList<>();
        indiceActual = 0;
        puntaje = 0;
        Collections.shuffle(preguntas);
    }

    public Question getPreguntaActual() {
        if (indiceActual < preguntas.size()) {
            return preguntas.get(indiceActual);
        }
        return null;
    }

    public void responder(int opcionElegida) {

        Question actual = getPreguntaActual();
        boolean correcta = actual.esCorrecta(opcionElegida);

        if (correcta) puntaje++;

        resultados.add(new GameResult(
                actual.getEnunciado(),
                actual.getRespuestaCorrecta(),
                correcta
        ));

        indiceActual++;
    }

    public boolean hayMasPreguntas() {
        return indiceActual < preguntas.size();
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getTotalPreguntas() {
        return preguntas.size();
    }

    public ArrayList<GameResult> getResultados() {
        return resultados;
    }

    public void reiniciar() {
        indiceActual = 0;
        puntaje = 0;
        resultados.clear();
        Collections.shuffle(preguntas);
    }
}
