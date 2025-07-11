package richard.lipa.Api_ForoHub.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import richard.lipa.Api_ForoHub.domain.curso.Curso;
import richard.lipa.Api_ForoHub.domain.topico.*;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;
import richard.lipa.Api_ForoHub.domain.usuario.UsuarioRepository;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor con ID " + datos.autorId() + " no encontrado."));
        Curso curso = new Curso(datos.nombreCurso(), datos.categoriaCurso());
        var topico = new Topico(datos.titulo(), datos.mensaje(), usuario, curso);
        var nuevoTopico = topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("topico/{id}").buildAndExpand(nuevoTopico.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DatosDetalleTopico(nuevoTopico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listar(@PageableDefault(size = 10, sort = {"curso.nombreCurso", "fechaCreacion"}, page = 0) Pageable paginacion){
        var page = topicoRepository.findAllByStateTrue(paginacion).map(DatosListaTopicos::new);
        return  ResponseEntity.ok(page);
    }


}
