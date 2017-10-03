package edu.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.review.ReservesDao;
import com.db.dao.review.StudentsDao;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class ReserveTimeSlotsAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final String email = HttpRequestUtil.getString(req, "email");
		final String timeSlotId = HttpRequestUtil.getString(req, "timeSlotId");
		final String paperId = HttpRequestUtil.getString(req, "paperId");
		System.out.println("email: " + email);
		final StudentsDao studentsDao = StudentsDao.getInstance();
		if (!studentsDao.getKeySet().contains(email)) {
			req.setAttribute("errorMessage", "Email (" + email +") is incorrect. Please use the following format: FAUID@fau.edu");
			return "/error.jsp";
		}
		final ReservesDao reservesDao = ReservesDao.getInstance();
		reservesDao.updateRecord(paperId, timeSlotId + "," + email);
		return "/myAction?action=edu.action.review.RetrieveReservedTimeSlotsAction";
	}
}
