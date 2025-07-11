package richard.lipa.Api_ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import richard.lipa.Api_ForoHub.domain.curso.Curso;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String usuario_autor,
        String usuario_email,
        String usuario_perfil,
        Curso curso,
        LocalDateTime fechaCreacion
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getAutor().getEmail(),
                topico.getAutor().getPerfil().name(),
                topico.getCurso(),
                topico.getFechaCreacion()
        );
    }
}
