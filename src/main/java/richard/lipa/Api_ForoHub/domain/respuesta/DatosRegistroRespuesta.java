package richard.lipa.Api_ForoHub.domain.respuesta;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import richard.lipa.Api_ForoHub.domain.topico.Topico;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta (
       @NotBlank String mensaje,
       @NotNull Long topicoId,
       @NotNull Long autorId,
       String solucion
){
}
