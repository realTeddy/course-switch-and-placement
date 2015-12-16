package edu.mum.presentation;

import java.io.PrintWriter;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxPhaseListener implements PhaseListener {

    @Override
    public PhaseId getPhaseId() {    // Want to be called in the restore view phase
        return PhaseId.RESTORE_VIEW; // in afterPhase()
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) { // not interested
    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) { // After the RESTORE VIEW phase
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        String s = request.getServletPath();
        if (s.contains("ajax.faces")) {

            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache");
            response.setStatus(HttpServletResponse.SC_OK);

            try {
                PrintWriter writer = response.getWriter();

                if (s.contains("blockCourses-ajax.faces")) {
                    
                }

            } catch (Exception ex) {
                System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
            }

            phaseEvent.getFacesContext().responseComplete();
        }
    }
}
