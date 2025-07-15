package richard.lipa.Api_ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String email,
        String contrasenia,
        Perfil perfil,
        Boolean state
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasenia(),
                usuario.getPerfil(),
                usuario.getState()
        );
    }
}
