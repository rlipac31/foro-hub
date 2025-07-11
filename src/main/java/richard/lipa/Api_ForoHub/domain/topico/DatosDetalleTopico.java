package richard.lipa.Api_ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import richard.lipa.Api_ForoHub.domain.curso.Curso;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
* ítulo, mensaje, fecha de creación, estado, autor y curso*/
public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String usuario_autor,
        String usuario_email,
        Curso curso,
        String fechaCreacion,
        Boolean state
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getAutor().getEmail(),
                topico.getCurso(),
                topico.getFechaCreacion().format(
                        DateTimeFormatter.ofPattern( "d 'de' MMMM 'del' yyyy 'a las' h:mm a", new Locale("es", "ES"))
                ),
                topico.getState()
        );
    }
}
