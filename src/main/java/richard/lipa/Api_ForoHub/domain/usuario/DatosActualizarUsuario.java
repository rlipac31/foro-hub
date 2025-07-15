package richard.lipa.Api_ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
          String nombre,
          String contrasenia,
          Perfil perfil
) {
}
