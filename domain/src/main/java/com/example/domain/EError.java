package com.example.domain;

public enum EError {

    ERROR_WIFI("Sin internet, por favor conectarse algún punto de red"),
    ERROR_CONNECTION("No se ha podido establecer una conexión con el servidor"),
    ERROR_DATA("Error al obtener los datos, contactarse con su Administrador"),
    ERROR_NULL_LOCATION("No se pudo obtener su ubicación actual");

    private String message;

    EError(String poMessage) {
        message = poMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
