package com.movieflix.movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Nome do serviço de streaming obrigatório") String name) {
}
