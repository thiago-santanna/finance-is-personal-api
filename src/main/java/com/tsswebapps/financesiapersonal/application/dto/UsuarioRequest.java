package com.tsswebapps.financesiapersonal.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "Nome não pode ser vazio")
        String nome,
        @NotBlank(message = "E-mail não pode ser vazio")
        @Email(message = "E-mail está inválido")
        String email,
        @NotBlank(message = "Senha não pode ser vazio")
        @Size(min = 5, max = 16, message = "Senha deve ter entre 5 e 16 caracteres")
        String senha,
        @NotBlank(message = "Telefone não pode ser vazio e deve conter apenas números")
        /**
         * Validação para telefone brasileiro.
         * Aceita os formatos:
         * (XX) XXXX-XXXX
         * (XX) XXXXX-XXXX (celular com 9º dígito)
         * XX XXXX-XXXX
         * XX XXXXX-XXXX
         * XXXXXXXXXX
         * XXXXXXXXXXX
         *
         * Com ou sem DDI +55:
         * +55 (XX) XXXXX-XXXX
         * +55 XX XXXXX-XXXX
         * +55XXXXXXXXXXX
         *
         * A regex abaixo permite flexibilidade com ou sem parênteses, espaços e traços.
         * Ela captura o DDI opcional (+55), o DDD (2 dígitos) e o número (8 ou 9 dígitos).
         */
        @Pattern(
                regexp = "^(?:\\+55\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})-?(\\d{4}))$",
                message = "Formato de telefone inválido. Use formatos como (XX) XXXXX-XXXX, XX XXXXX-XXXX ou XXXXXXXXXXX, opcionalmente com +55."
        )
        String telefone
) {
}
