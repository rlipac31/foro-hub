package richard.lipa.Api_ForoHub.domain.topico;

import richard.lipa.Api_ForoHub.domain.curso.Curso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        String autor_nombre,
        String autor_email,
        String nombreCurso,
        String categoriaCurso,
        String fechaCreacion, // ← nuevo campo bonito


        Boolean state
) {

    public DatosListaTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getAutor().getEmail(),
                topico.getCurso().getNombreCurso(),
                topico.getCurso().getCategoriaCurso(),
                topico.getFechaCreacion().format(
                        DateTimeFormatter.ofPattern("d 'de' MMMM 'del' yyyy", new Locale("es", "ES"))
                ), // ← aquí se genera la cadena formateada
                topico.getState()
        );

    }


}
