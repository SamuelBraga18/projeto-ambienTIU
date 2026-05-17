package br.com.ambientiubackend.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record Dto(
        @NotBlank
        String temperatura,

        @NotBlank
        String umidade,

        @NotBlank
        String iluminacao,

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime time
) {
}

