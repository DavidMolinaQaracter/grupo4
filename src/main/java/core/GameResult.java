package core;
public class GameResult {
    private String pregunta;
    private String respuestaCorrecta;
    private boolean fueCorrecta;

    public GameResult(String pregunta, String respuestaCorrecta, boolean fueCorrecta) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.fueCorrecta = fueCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean isFueCorrecta() {
        return fueCorrecta;
    }
}
