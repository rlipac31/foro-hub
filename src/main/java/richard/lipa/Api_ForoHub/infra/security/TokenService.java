package richard.lipa.Api_ForoHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import richard.lipa.Api_ForoHub.domain.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {
    @Value("${api.security.token.secret}")//tiene que ser anotacion de sprinf framework
    private  String secret;
    private static final String ISSUER = "API Foro-Hub Alura";
    public  String generarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return   JWT.create()// devolvemos el token generado
                    .withIssuer(ISSUER)//aqui le pasamos la empresa o server que esta firmando este token, en este caso sera medi_vol
                    .withSubject(usuario.getEmail())//agreamos el nombre usuario
                    .withExpiresAt(fechaExpiracion())
                    //  .withClaim("nombre", usuario.getLogin())// para agregar datos dentro del token
                    .sign(algoritmo);//el algoritmo que firma el token
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw  new RuntimeException("Error al generar el token: ", exception);
        }


    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-05:00"));//tiempo de expiracion 2 horas despues de que inicio session
    }

    public String getSubject(String tokenJWT) {//verificar usuario
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.require(algoritmo)
                    .withIssuer(ISSUER)// tiene que ser extactamente igual al que se uso para generar el token
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token no valido o expirado"+ tokenJWT);
        }
    }
}
