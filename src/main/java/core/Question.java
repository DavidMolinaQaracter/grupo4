package core;

public class Question {
    private String enunciado;
    private String[] opciones;
    private int respuestaCorrecta;

    public Question(String enunciado, String[] opciones, int respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public boolean esCorrecta(int opcionElegida) {
        return opcionElegida == respuestaCorrecta;
    }

    public String getRespuestaCorrecta() {
        return opciones[respuestaCorrecta];
    }
}
