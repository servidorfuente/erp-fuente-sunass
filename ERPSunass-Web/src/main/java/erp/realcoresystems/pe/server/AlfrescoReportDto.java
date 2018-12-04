package erp.realcoresystems.pe.server;

import java.util.Map;

public class AlfrescoReportDto {
	
	private String alfrescoTipoDocumental;
	private Map<String, Object> metadataMap;
	private String[] alfrescoMetadata;
	private String[] alfrescoSubCarpetas;
	
	public String getAlfrescoTipoDocumental() {
		return alfrescoTipoDocumental;
	}
	public void setAlfrescoTipoDocumental(String alfrescoTipoDocumental) {
		this.alfrescoTipoDocumental = alfrescoTipoDocumental;
	}
	public String[] getAlfrescoMetadata() {
		return alfrescoMetadata;
	}
	public void setAlfrescoMetadata(String[] alfrescoMetadata) {
		this.alfrescoMetadata = alfrescoMetadata;
	}
	public String[] getAlfrescoSubCarpetas() {
		return alfrescoSubCarpetas;
	}
	public void setAlfrescoSubCarpetas(String[] alfrescoSubCarpetas) {
		this.alfrescoSubCarpetas = alfrescoSubCarpetas;
	}
	public void setMetadataMap(Map<String, Object> metadataMap) {
		this.metadataMap = metadataMap;
	}
	public Map<String, Object> getMetadataMap() {
		return metadataMap;
	}
	
}
