package edu.action.evaluation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.evaluation.LoginDao;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class UpdatePasswordAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final String id = LoginCheck.getId(req);
		if (id == null) {
			return "/error.jsp";
		}
		final String password = HttpRequestUtil.getString(req, "newPassword1");
		LoginDao.getInstance().updateRecord(id, password);
		req.setAttribute("id", id);
		return "/changePasswordResult.jsp";
	}
}
