import core.Question;
import core.Quiz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        Scanner sc = new Scanner(System.in);

        System.out.println("===== TRIVIA QUIZ (Console Test) =====");
        System.out.println();

        while (quiz.hayMasPreguntas()) {

            Question q = quiz.getPreguntaActual();

            System.out.println(q.getEnunciado());
            String[] opciones = q.getOpciones();
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }

            System.out.print("Tu respuesta: ");

            int respuesta;
            try {
                respuesta = Integer.parseInt(sc.nextLine()) - 1;
            } catch (NumberFormatException e) {
                respuesta = -1; // respuesta inválida por defecto
            }

            quiz.responder(respuesta);

            System.out.println();
        }

        System.out.println("===== RESULTADOS =====");
        System.out.println("Puntaje final: " + quiz.getPuntaje() +
                           "/" + quiz.getTotalPreguntas());
        System.out.println();

        quiz.getResultados().forEach(r -> {
            System.out.println(r.getPregunta());
            System.out.println("Correcta: " + r.getRespuestaCorrecta());
            System.out.println("¿Acertaste?: " + (r.isFueCorrecta() ? "Si" : "No"));
            System.out.println();
        });

        System.out.println("Fin del juego");
        sc.close();
    }
}
