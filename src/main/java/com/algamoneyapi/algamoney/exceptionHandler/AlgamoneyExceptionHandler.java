package com.algamoneyapi.algamoney.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

    //lm
    @Autowired
    private MessageSource messageSource;

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagemusuario = messageSource.getMessage("mensagem ivalida", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.getCause().toString();
        return handleExceptionInternal(ex, new Erro(mensagemusuario, mensagemDesenvolvedor), headers, HttpStatus.BAD_REQUEST, request);
    }

    public static class Erro {

        private String mensagemusuario;
        private String MensagemDesenvolvedor;

        public Erro(String mensagemusuario, String mensagemDesenvolvedor) {
            this.mensagemusuario = mensagemusuario;
            MensagemDesenvolvedor = mensagemDesenvolvedor;
        }

        public String getMensagemusuario() {
            return mensagemusuario;
        }

        public void setMensagemusuario(String mensagemusuario) {
            this.mensagemusuario = mensagemusuario;
        }

        public String getMensagemDesenvolvedor() {
            return MensagemDesenvolvedor;
        }

        public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
            MensagemDesenvolvedor = mensagemDesenvolvedor;
        }
    }
}
