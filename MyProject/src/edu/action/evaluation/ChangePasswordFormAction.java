package edu.action.evaluation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.servlet.ActionIF;

public class ChangePasswordFormAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		if (LoginCheck.createSession(req) == false) {
			req.setAttribute("errorMessage", "ID/PASSWORD is incorrect");
			return "/error.jsp";
		}
		return new StringBuilder("/changePasswordForm.jsp").toString();
	}
}
