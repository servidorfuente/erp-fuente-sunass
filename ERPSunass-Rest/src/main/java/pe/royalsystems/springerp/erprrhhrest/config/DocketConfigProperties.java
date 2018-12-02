package erp.realcoresystems.pe.erprrhhrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
//@ConfigurationProperties("swagger.info")
public class DocketConfigProperties {
	
	
	@Value("${swagger.info.title}")
	private String title;

	@Value("${swagger.info.description}")
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
