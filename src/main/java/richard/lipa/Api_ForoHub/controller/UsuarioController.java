package richard.lipa.Api_ForoHub.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import richard.lipa.Api_ForoHub.domain.usuario.DatosDetalleUsuario;
import richard.lipa.Api_ForoHub.domain.usuario.DatosRegistroUsuario;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;
import richard.lipa.Api_ForoHub.domain.usuario.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

        @Autowired
        private UsuarioRepository repository;
        @Autowired
        private PasswordEncoder passwordEncoder; // Inyecta el PasswordEncoder // biene de SecurityConfigurations

    @Transactional
    @PostMapping
    public ResponseEntity registar(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){

        var usuario = new Usuario(datos);
        var passwordPlano = datos.contrasenia();
        var passwordHasheado = passwordEncoder.encode(passwordPlano);
        usuario.setContrasenia(passwordHasheado);
        var usuarioNuevo =   repository.save(usuario);
        var uri = uriComponentsBuilder.path("usuario/{id}").buildAndExpand( usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuarioNuevo));
    }
}
