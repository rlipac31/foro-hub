package richard.lipa.Api_ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String email,
        String contrasenia,
        Perfil perfil
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasenia(),
                usuario.getPerfil()
        );
    }
}
