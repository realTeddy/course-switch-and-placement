package edu.mum.presentation;

import com.google.gson.Gson;
import edu.mum.business.CourseManager;
import edu.mum.business.PreferenceManager;
import edu.mum.business.RegistrationManager;
import edu.mum.model.Course;
import edu.mum.model.Registration;
import edu.mum.viewmodel.CourseViewModel;
import edu.mum.viewmodel.RegistrationViewModel;
import java.io.PrintWriter;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxPhaseListener implements PhaseListener {

    public AjaxPhaseListener() {
        registrationManager = new RegistrationManager();
        courseManager = new CourseManager();
    }

    @Inject
    private UserBean userBean;
    private final RegistrationManager registrationManager;
    private final CourseManager courseManager;

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

                if (s.contains("getRegistrations-ajax.faces")) {
                    List<RegistrationViewModel> registrations = registrationManager.getRegistrations(userBean.getUser());
                    String json = new Gson().toJson(registrations);
                    writer.write(json);
                }
                else if (s.contains("blockCourses-ajax.faces")) {
                    String strBlockId = request.getParameter("blockId");
                    String strCourseId = request.getParameter("courseId");
                    int blockId = Integer.parseInt(strBlockId);
                    int courseId = Integer.parseInt(strCourseId);
                    List<CourseViewModel> preferences = courseManager.getCourses(userBean.getUser(), courseId, blockId);
                    String json = new Gson().toJson(preferences);
                    writer.write(json);
                }
                else if (s.contains("addPreferedCourse-ajax.faces")) {
                    String strRregistrationId = request.getParameter("registrationId");
                    String strCourseId = request.getParameter("courseId");
                    int registrationId = Integer.parseInt(strRregistrationId);
                    int courseId = Integer.parseInt(strCourseId);
                    boolean isPendingSwitch = registrationManager.addPreferedCourse(userBean.getUser(), registrationId, courseId);
                    String json = new Gson().toJson(isPendingSwitch);
                    writer.write(json);
                }
            } catch (Exception ex) {
                System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
            }

            phaseEvent.getFacesContext().responseComplete();
        }
    }
}
