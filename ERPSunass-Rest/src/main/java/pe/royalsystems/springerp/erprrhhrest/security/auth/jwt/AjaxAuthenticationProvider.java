package erp.realcoresystems.pe.erprrhhrest.security.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import erp.realcoresystems.pe.erprrhhrest.security.UserContext;
import erp.realcoresystems.pe.erprrhhrest.security.config.JwtSettings;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by araucoj.
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
    //private final BCryptPasswordEncoder encoder;
    
	private final JwtSettings jwtSettings;
	
//    @Autowired
//    ClienteService clienteService ;
    
    @Autowired
    public AjaxAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }
    

//    @Value("${spring.security.ldap.active}")
//    private boolean ldapActive;

//    @Autowired
//    public AjaxAuthenticationProvider(final DatabaseUserService userService, final BCryptPasswordEncoder encoder) {
//        this.userService = userService;
//        this.encoder = encoder;
//    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "Datos de autenticación no proveidos");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        /**Validar*/
//        Cliente objCliente = new Cliente();
//        objCliente.setDesLoginCli(username);
//        objCliente.setDesPassCli(password);
//        Cliente objRestCliente = new Cliente();
//        objRestCliente = clienteService.buscar(objCliente);
        
        Object objRestCliente =null;
        if(objRestCliente!=null){
        	/**Obtener SEGURIDAD ...PERFILES; PERMISOS...etc*/
            //String code = (String) authentication.getDetails();                   
            //Cliente userCliente = clienteService.obtenerPorID(code);
            List<GrantedAuthority> authorities  = new  ArrayList<>();
            authorities.add( new SimpleGrantedAuthority("ADMIN"));
            authorities.add( new SimpleGrantedAuthority("USUARIO"));
                    
            //UserContext userContext = UserContext.create(objRestCliente.getCodCliente(), authorities);
            UserContext userContext = UserContext.create("cod", authorities);
            return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());        	
        }else{
        	throw new AuthenticationServiceException("Autorizacion incorrecta");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}