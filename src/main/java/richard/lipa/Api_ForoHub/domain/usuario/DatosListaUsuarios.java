package richard.lipa.Api_ForoHub.domain.usuario;

import java.util.List;

public record DatosListaUsuarios(
        Long id,
        String nombre,
        String email,
        Perfil perfil
) {


    public DatosListaUsuarios(Usuario usuario) {
       this(
               usuario.getId(),
               usuario.getNombre(),
               usuario.getEmail(),
               usuario.getPerfil()
       );
    }


}
