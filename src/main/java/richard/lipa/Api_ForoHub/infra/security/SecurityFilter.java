package richard.lipa.Api_ForoHub.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import richard.lipa.Api_ForoHub.domain.usuario.UsuarioRepository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private  TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);
        if(tokenJWT != null){
            var subjet = tokenService.getSubject((String) tokenJWT);
            var usuario = repository.findByEmailContaining(subjet);
            var autenticacion = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticacion);
        }
        // si no hay token pasa a control de la clase SecurityConfiguratios y metods de  de sprin security
        filterChain.doFilter(request, response);

    }

    private Object recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader  != null){
            return  authorizationHeader.replace("Bearer ", "");
        }
        // si no hay token en nel header devuelve null y pasa a control de securityConfigurations
        return  null;
    }
}
