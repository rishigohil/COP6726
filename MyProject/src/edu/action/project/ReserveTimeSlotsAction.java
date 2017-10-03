package edu.action.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.project.ProjectReservesDao;
import com.db.dao.review.StudentsDao;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class ReserveTimeSlotsAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final String email01 = HttpRequestUtil.getString(req, "email01");
		final String email02 = HttpRequestUtil.getString(req, "email02");
		final String email03 = HttpRequestUtil.getString(req, "email03");
		final String timeSlotId = HttpRequestUtil.getString(req, "timeSlotId");
		final String projectTitle = HttpRequestUtil.getString(req, "projectTitle");

		final StudentsDao studentsDao = StudentsDao.getInstance();
		if (!studentsDao.getKeySet().contains(email01)) {
			req.setAttribute("errorMessage", "Email (" + email01 + ") is incorrect. Please use the following format: FAUID@fau.edu");
			return "/error.jsp";
		}
		if (!studentsDao.getKeySet().contains(email02)) {
			req.setAttribute("errorMessage", "Email (" + email02 + ") is incorrect. Please use the following format: FAUID@fau.edu");
			return "/error.jsp";
		}
		if (!studentsDao.getKeySet().contains(email03)) {
			req.setAttribute("errorMessage", "Email (" + email03 + ") is incorrect. Please use the following format: FAUID@fau.edu");
			return "/error.jsp";
		}

		final ProjectReservesDao reservesDao = ProjectReservesDao.getInstance();
		reservesDao.updateRecord(timeSlotId, email01 + "," + email02 + "," + email03 + "," + projectTitle);
		return "/myAction?action=edu.action.project.RetrieveReservedTimeSlotsAction";
	}
}
