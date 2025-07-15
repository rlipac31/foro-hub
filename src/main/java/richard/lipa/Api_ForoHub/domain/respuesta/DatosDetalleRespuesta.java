package richard.lipa.Api_ForoHub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import richard.lipa.Api_ForoHub.domain.topico.Topico;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public record DatosDetalleRespuesta(
         Long id,
         String rspuestaMensage,
         String solucion,
         String topicoTitulo,
         String topicoMensaje,
         String topicoNameCurso,
         String topicoFecha,
         String autorNombre,
        String autorEmail,
        String fechaRespuesta
) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getSolucion(),
                respuesta.getTopico().getTitulo(),
                respuesta.getTopico().getMensaje(),
                respuesta.getTopico().getCurso().getNombreCurso(),
                respuesta.getTopico().getFechaCreacion().format(
                        DateTimeFormatter.ofPattern( "d 'de' MMMM 'del' yyyy 'a las' h:mm a", new Locale("es", "ES"))
                ),
                respuesta.getAutor().getNombre(),
                respuesta.getAutor().getEmail(),
                respuesta.getFechaCreacion().format(
                        DateTimeFormatter.ofPattern( "d 'de' MMMM 'del' yyyy 'a las' h:mm a", new Locale("es", "ES"))
                )
        );
    }
}
