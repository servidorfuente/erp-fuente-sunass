package erp.realcoresystems.pe.erprrhhrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"erp.realcoresystems.pe"})
@EnableConfigurationProperties
@EnableScheduling
@EnableCaching
public class ERPRRHHRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(erp.realcoresystems.pe.erprrhhrest.ERPRRHHRestApplication.class, args);
    }
}
