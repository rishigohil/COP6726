package edu.action.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class FormAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final String timeSlotId = HttpRequestUtil.getString(req, "timeSlotId");
		req.setAttribute("timeSlotId", timeSlotId);
		return"/projectForm.jsp";
	}
}
