package br.com.fuctura.biblioteca.exceptions;

public class FieldMessage {

    private String defaultMessage;
    private String field;

    public FieldMessage(String field, String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
