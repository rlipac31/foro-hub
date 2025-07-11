package richard.lipa.Api_ForoHub.domain.usuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuario(
        @NotBlank String nombre,
        @NotBlank  String email,
        @NotBlank  String contrasenia,
        @NotNull Perfil perfil
) {
}
