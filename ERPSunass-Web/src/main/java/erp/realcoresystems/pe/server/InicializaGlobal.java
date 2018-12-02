package erp.realcoresystems.pe.server;

import erp.realcoresystems.pe.model.util.FacesUtil;
/**
 * Created by AquilesMH on 31/08/2015.
 */
public abstract class InicializaGlobal {
    public   static void  InitGlobal(EntityGlobal objglobal){
        //HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance();
        //HttpSession httpSession = request.getSession(false);
        //httpSession.setAttribute("EntityGlobal", objglobal);
    	FacesUtil.putSessionMap("EntityGlobal", objglobal);
    }
}
