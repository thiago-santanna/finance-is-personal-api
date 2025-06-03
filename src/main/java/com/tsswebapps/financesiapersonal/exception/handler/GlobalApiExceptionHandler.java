package com.tsswebapps.financesiapersonal.exception.handler;

import com.tsswebapps.financesiapersonal.exception.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

public class GlobalApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalApiExceptionHandler.class);
    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = """
            Ocorreu um erro interno inesperado no sistema. 
            Tente novamente e, se o problema persistir, 
            entre em contato com o administrador.
            """;

    private final MessageSource messageSource;

    public GlobalApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // --- Sobrescrita de Handlers Padrão do Spring para Melhorar as Mensagens ---

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, List<String>> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String fieldName = error.getField();
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale()); // Para i18n
            // String errorMessage = error.getDefaultMessage(); // Sem i18n
            errors.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(errorMessage);
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            String objectName = error.getObjectName();
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            // String errorMessage = error.getDefaultMessage();
            errors.computeIfAbsent(objectName, k -> new ArrayList<>()).add(errorMessage);
        }

        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
        ErrorResponse body = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Dados inválidos", detail, errors);
        log.warn("Erro de validação: {}", errors);
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = "O corpo da requisição está inválido. Verifique erros de sintaxe JSON.";
        ErrorResponse body = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Mensagem incompreensível", detail);
        log.warn("JSON malformado: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        if (ex instanceof MethodArgumentTypeMismatchException mismatchEx) {
            String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', que é de um tipo inválido. " +
                            "Corrija e informe um valor compatível com o tipo %s.",
                    mismatchEx.getName(), mismatchEx.getValue(), Objects.requireNonNull(mismatchEx.getRequiredType()).getSimpleName());
            ErrorResponse body = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Parâmetro de URL inválido", detail);
            return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
        }
        return super.handleTypeMismatch(ex, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = String.format("O recurso '%s' que você tentou acessar não existe.", ex.getRequestURL());
        ErrorResponse body = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Recurso não encontrado", detail);
        log.warn("Handler não encontrado para a requisição: {}", ex.getRequestURL());
        return handleExceptionInternal(ex, body, headers, HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = String.format("O método '%s' não é suportado para esta requisição. Métodos suportados são: %s",
                ex.getMethod(), ex.getSupportedHttpMethods());
        ErrorResponse body = new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), "Método não suportado", detail);
        log.warn("Método HTTP não suportado: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.METHOD_NOT_ALLOWED, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = String.format("O tipo de mídia '%s' não é suportado. Tipos suportados são: %s",
                ex.getContentType(), ex.getSupportedMediaTypes());
        ErrorResponse body = new ErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "Tipo de mídia não suportado", detail);
        log.warn("Tipo de mídia não suportado: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = String.format("O tipo de mídia solicitado no cabeçalho 'Accept' não é suportado pela API. Tipos suportados são: %s",
                ex.getSupportedMediaTypes());
        ErrorResponse body = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Tipo de mídia não aceitável", detail);
        log.warn("Tipo de mídia não aceitável: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.NOT_ACCEPTABLE, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = String.format("O parâmetro de requisição obrigatório '%s' do tipo '%s' não está presente.",
                ex.getParameterName(), ex.getParameterType());
        ErrorResponse body = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Parâmetro obrigatório ausente", detail);
        log.warn("Parâmetro de requisição ausente: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(
            ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String detail = "Erro ao vincular parâmetro da requisição. Verifique se os cabeçalhos ou cookies necessários estão presentes.";
        ErrorResponse body = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Erro de vinculação da requisição", detail);
        log.warn("Erro de vinculação da requisição: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, WebRequest request) {
        String detail = String.format("O arquivo excede o tamanho máximo permitido de %s.", ex.getMaxUploadSize());
        ErrorResponse body = new ErrorResponse(HttpStatus.PAYLOAD_TOO_LARGE.value(), "Arquivo muito grande", detail);
        log.warn("Tentativa de upload de arquivo muito grande: {}", ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.PAYLOAD_TOO_LARGE, request);
    }


    // --- Handler Genérico para Exceções Não Tratadas (Fallback) ---

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse body = new ErrorResponse(status.value(), "Erro interno do servidor", MSG_ERRO_GENERICA_USUARIO_FINAL);

        // Log detalhado do erro para a equipe de desenvolvimento
        log.error("Erro não capturado na API: {}", ex.getMessage(), ex);

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }


    /**
     * Método centralizado para construir a ResponseEntity.
     * Pode ser sobrescrito para customizações adicionais.
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        if (body == null) {
            body = new ErrorResponse(statusCode.value(),
                    HttpStatus.valueOf(statusCode.value()).getReasonPhrase(), // Título padrão do status
                    ex.getMessage());
        } else if (body instanceof String strBody) { // Se o Spring passou uma String, encapsulamos
            body = new ErrorResponse(statusCode.value(),
                    HttpStatus.valueOf(statusCode.value()).getReasonPhrase(),
                    strBody);
        }
        // Adicionar log para todas as exceções tratadas por este método central
        if (statusCode.is5xxServerError()) {
            log.error("Erro interno do servidor: Status {}, Causa: {}", statusCode, ex.getMessage(), ex);
        } else if (statusCode.is4xxClientError()) {
            log.warn("Erro do cliente: Status {}, Causa: {}", statusCode, ex.getMessage());
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
