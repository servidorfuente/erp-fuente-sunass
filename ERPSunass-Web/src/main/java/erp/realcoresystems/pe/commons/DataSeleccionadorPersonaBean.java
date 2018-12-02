package erp.realcoresystems.pe.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.service.PersonamastService;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import erp.realcoresystems.pe.commons.model.PaginaModel;

import erp.realcoresystems.pe.model.util.FacesUtil;

@ManagedBean(name = "dataSeleccionadorPersonaBean")
@ViewScoped
public class DataSeleccionadorPersonaBean implements Serializable{

	private static final long serialVersionUID = 7967645537013772301L;

	@ManagedProperty(value = "#{personamastService}")	
    private PersonamastService personamastService;

    private EventosBean eventoSeleccion= new EventosBean();
    /*Busqueda de PERSONAS*/
    private LazyDataModel<Personamast> modelPersona;
    // Entidad Seleccionada de seleccionarPersona.xhtml
    private Personamast personaEntidadSeleccion =null; // new PersonamastAnter();
    private Personamast personaEntidadSeleccionFiltro = new Personamast();//new PersonamastAnter();
    private List<Personamast> personamastListar = null;//new ArrayList<PersonamastAnter>();
    private String formularioPadre = null;
    private String descSeleccionador = null;
    private String sectorAplicarUpdate;
    
	public void iniciar(){
		FacesUtil.putSessionMap("namedBeanSingleton", "dataSeleccionadorPersonaBean");
	}
    
    public void inicializar() {        
		if(personaEntidadSeleccionFiltro!=null){
			personaEntidadSeleccionFiltro.setNombrecompleto(null);
			sectorAplicarUpdate = personaEntidadSeleccionFiltro.getSectorAplicarUpdate();
			formularioPadre = personaEntidadSeleccionFiltro.getDescripcion01();
			descSeleccionador = personaEntidadSeleccionFiltro.getDescripcion02();						
			personaEntidadSeleccionFiltro.setString1("");
			listarPersonMast();				
		}	    
    }
    
    public LazyDataModel<Personamast> listarPersonMast() {
    	modelPersona = new LazyDataModel<Personamast>() {
            private static final long serialVersionUID = 1L;
            @Override
            public List<Personamast> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                      Map<String, Object> filters) {
            	cargarObjetoFiltrosSeleccPersonas(first, pageSize, 0);
				personamastListar = personamastService.listarElementos(personaEntidadSeleccionFiltro);
                if (getRowCount() <= 0) {
                    setRowCount(personamastService.contadorTotalesPersona(personaEntidadSeleccionFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return personamastListar;
            }
			/* Agregar*/
			@Override
			public Personamast getRowData(String rowKey) {				
				for(Personamast event : personamastListar) {
					if((""+event.getPersona()).equals(""+rowKey)) {//Error here
						personaEntidadSeleccion =  event;
						return event;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(Personamast event) {
				return event.getPersona();
			}
			/* Agregar*/
        };
        return modelPersona;
    }

	public void cargarObjetoFiltrosSeleccPersonas(int first, int pageSize,int counter) {
		if(personaEntidadSeleccionFiltro==null){
			personaEntidadSeleccionFiltro= new Personamast();	
		}							
		personaEntidadSeleccionFiltro.setInicio(first);
		personaEntidadSeleccionFiltro.setNumeroFilas(pageSize);					
	}
	
    public void eventoSeleccionPersona(ActionEvent actionEvent) {
    	if(eventoSeleccion.getEventoSeleccionPersonamast()!=null){    		
    		eventoSeleccion.getEventoSeleccionPersonamast().retornoSeleccion(personaEntidadSeleccion,"Selección");
    		personaEntidadSeleccionFiltro = new Personamast();
    		sectorAplicarUpdate = "@all";
    	}	
    	
    }
    
	public void doubleClick(SelectEvent event){
		if(eventoSeleccion.getEventoSeleccionPersonamast()!=null){   
			Personamast persona = (Personamast)event.getObject();		
			eventoSeleccion.getEventoSeleccionPersonamast().retornoSeleccion(persona,"Selección");
			personaEntidadSeleccionFiltro = new Personamast();
			sectorAplicarUpdate = "@all";
		}
	}
    
    public void eventoCancelSeleccionPersona(ActionEvent actionEvent) {
		
    }

	public LazyDataModel<Personamast> getModelPersona() {
		return modelPersona;
	}

	public void setModelPersona(LazyDataModel<Personamast> modelPersona) {
		this.modelPersona = modelPersona;
	}

	public Personamast getPersonaEntidadSeleccion() {
		return personaEntidadSeleccion;
	}

	public void setPersonaEntidadSeleccion(Personamast personaEntidadSeleccion) {
		this.personaEntidadSeleccion = personaEntidadSeleccion;
	}

	public Personamast getPersonaEntidadSeleccionFiltro() {
		return personaEntidadSeleccionFiltro;
	}

	public void setPersonaEntidadSeleccionFiltro(Personamast personaEntidadSeleccionFiltro) {
		this.personaEntidadSeleccionFiltro = personaEntidadSeleccionFiltro;
	}

	public List<Personamast> getPersonamastListar() {
		return personamastListar;
	}

	public void setPersonamastListar(List<Personamast> personamastListar) {
		this.personamastListar = personamastListar;
	}

	public EventosBean getEventoSeleccion() {
		return eventoSeleccion;
	}

	public void setEventoSeleccion(EventosBean eventoSeleccion) {
		this.eventoSeleccion = eventoSeleccion;
	}

	
	public String getFormularioPadre() {
		return formularioPadre;
	}

	public void setFormularioPadre(String formularioPadre) {
		this.formularioPadre = formularioPadre;
	}

	public String getDescSeleccionador() {
		return descSeleccionador;
	}

	public void setDescSeleccionador(String descSeleccionador) {
		this.descSeleccionador = descSeleccionador;
	}

	public String getSectorAplicarUpdate() {
		return sectorAplicarUpdate;
	}

	public void setSectorAplicarUpdate(String sectorAplicarUpdate) {
		this.sectorAplicarUpdate = sectorAplicarUpdate;
	}

	public void setPersonamastService(PersonamastService personamastService) {
		this.personamastService = personamastService;
	}
	
	
  
}
