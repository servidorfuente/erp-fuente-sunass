package erp.realcoresystems.pe.erprrhhrest.security.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import erp.realcoresystems.pe.erprrhhrest.security.config.WebSecurityConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

/**
 * @author araucoj
 *
 */
public class TokenAuthenticationService {
	
  //@Autowired
  //private JwtSettings settings;
  
  public static void addAuthentication(HttpServletResponse res, String username) {	 
		 
    String JWT = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + WebSecurityConfig.JWT_EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, WebSecurityConfig.JWT_SECRET)
        .compact();
    res.addHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM, WebSecurityConfig.JWT_TOKEN_PREFIX + " " + JWT);
  }

  public static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM);
    if (token != null) {
      // parse the token.
      String user = Jwts.parser()
          .setSigningKey(WebSecurityConfig.JWT_SECRET)
          .parseClaimsJws(token.replace(WebSecurityConfig.JWT_TOKEN_PREFIX, ""))
          .getBody()
          .getSubject();

      return user != null ?
          new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
          null;
    }
    return null;
  }
}