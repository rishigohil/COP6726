package edu.action.evaluation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class EvaluationFormAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		
		final String id = LoginCheck.getId(req);
		if (id == null) {
			return "/error.jsp";
		}
		
		final String presentation = HttpRequestUtil.getString(req, "presentation");
		final int index = presentation.indexOf(',');
		final String timeSlotAndPresenter = presentation.substring(0, index);
		final String title = presentation.substring(index + 1);
		req.setAttribute("timeSlotAndPresenter", timeSlotAndPresenter);
		req.setAttribute("title", title);
		return "/evaluationForm.jsp";
	}
}
