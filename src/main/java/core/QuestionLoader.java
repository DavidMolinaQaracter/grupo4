package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class QuestionLoader {

    public static ArrayList<Question> cargar(String path) {
        ArrayList<Question> preguntas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String pregunta = linea;

                int correcta = Integer.parseInt(br.readLine().trim()) - 1;
                
                String[] opciones = new String[4];
                for (int i = 0; i < 4; i++) {
                    opciones[i] = br.readLine();
                }

                preguntas.add(new Question(pregunta, opciones, correcta));

                br.readLine(); // línea en blanco separadora
            }

        } catch (IOException e) {
            System.out.println("Error cargando preguntas: " + e.getMessage());
        }

        return preguntas;
    }
}
