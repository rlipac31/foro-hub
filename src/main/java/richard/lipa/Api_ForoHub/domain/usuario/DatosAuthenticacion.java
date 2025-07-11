package richard.lipa.Api_ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAuthenticacion(
        @NotBlank String email,
        @NotBlank String contrasenia
) {
}
