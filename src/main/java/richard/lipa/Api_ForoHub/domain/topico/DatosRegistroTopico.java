package richard.lipa.Api_ForoHub.domain.topico;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import richard.lipa.Api_ForoHub.domain.curso.Curso;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autorId,
        @NotBlank String nombreCurso,
        @NotBlank String categoriaCurso
) {
}
