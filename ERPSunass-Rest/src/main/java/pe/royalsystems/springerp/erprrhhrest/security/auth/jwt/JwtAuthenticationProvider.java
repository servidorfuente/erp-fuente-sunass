package erp.realcoresystems.pe.erprrhhrest.security.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import erp.realcoresystems.pe.erprrhhrest.security.UserContext;
import erp.realcoresystems.pe.erprrhhrest.security.auth.JwtAuthenticationToken;
import erp.realcoresystems.pe.erprrhhrest.security.config.JwtSettings;

import java.util.ArrayList;
import java.util.List;


//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;

/**
 * @author araucoj
 *
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
    private final JwtSettings jwtSettings;

//    @Autowired
//    ClienteService clienteService ;

    //@Autowired
    //private UserService userService;

    
    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object rawAccessToken = authentication.getCredentials();

        /**POR IMPLEMETAR ...*/
        
//        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
//        Long subject = Long.valueOf(jwsClaims.getBody().getSubject());
//        String code = jwsClaims.getBody().getSubject();
        System.out.println("TEST JWT AUTH:"+rawAccessToken);

        String code = "xxxx";
        //Usuario user = userService.getByUserId(subject).orElseThrow(() -> new UsernameNotFoundException("User Id no encontrado: " + subject));                
        List<GrantedAuthority> authorities  = new  ArrayList<>();
        authorities.add( new SimpleGrantedAuthority("ADMIN"));
        authorities.add( new SimpleGrantedAuthority("USUARIO"));

//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getRol().authority()))
//                .collect(Collectors.toList());

        UserContext context = UserContext.create(code, authorities);
        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}