package erp.realcoresystems.pe.erprrhhrest.security.auth.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import erp.realcoresystems.pe.erprrhhrest.security.auth.TokenAuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author araucoj
 *
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
  
	
  public JwtLoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));    
    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {
	  
	  /**Autenticar respuesta*/
      //if (!HttpMethod.POST.name().equals(request.getMethod()) || !WebUtil.isAjax(request)) {
      if (!HttpMethod.POST.name().equals(request.getMethod())) {
          if(logger.isDebugEnabled()) {
              logger.debug("Metodo de Autenticacion no soportado. Request method: " + request.getMethod());
          }
          throw new AuthenticationServiceException("Metodo de Autenticacion no soportado");
      }

      UserCredentials userLoginRequest = new ObjectMapper().readValue(request.getReader(), UserCredentials.class);
      //UserCredentials userLoginRequest = new ObjectMapper().readValue(request.getInputStream(), AccountCredentials.class);
      
      if (StringUtils.isBlank(userLoginRequest.getUsername()) || StringUtils.isBlank(userLoginRequest.getPassword())) {
          throw new AuthenticationServiceException("Usuario o Contraseña no provistos");
      }

      UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
    		  userLoginRequest.getUsername(), 
    		  userLoginRequest.getPassword());
      
      return this.getAuthenticationManager().authenticate(token);	  

  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest req,
      HttpServletResponse res, FilterChain chain,
      Authentication auth) throws IOException, ServletException {
    TokenAuthenticationService
        .addAuthentication(res, auth.getName());
  }
}