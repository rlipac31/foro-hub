package richard.lipa.Api_ForoHub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank  String nombreCurso,
        @NotBlank  String categoriaCurso
) {
}
