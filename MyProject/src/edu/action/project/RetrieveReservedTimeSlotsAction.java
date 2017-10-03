package edu.action.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.project.ProjectReservesDao;

import edu.servlet.ActionIF;

public class RetrieveReservedTimeSlotsAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		req.setAttribute("reservedTimeSlots", ProjectReservesDao.getInstance().getRecords());
		return "/projectRetrieveReservedTimeSlots.jsp";
	}
}
