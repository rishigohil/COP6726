package edu.action.evaluation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conf.DBConf;
import com.io.FileOut;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class CreateEvaluationFormAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final String id = LoginCheck.getId(req);
		if (id == null) {
			return "/error.jsp";
		}
		final String timeSlotAndPresenter = HttpRequestUtil.getString(req, "timeSlotAndPresenter");
		final String title = HttpRequestUtil.getString(req, "title");
		final String summary = HttpRequestUtil.getString(req, "summary");
		final String overall_rating = HttpRequestUtil.getString(req, "overall_rating");
		final String originality = HttpRequestUtil.getString(req, "originality");
		final String soundness = HttpRequestUtil.getString(req, "soundness");
		final String organization = HttpRequestUtil.getString(req, "organization");
		final String clarity = HttpRequestUtil.getString(req, "clarity");
		final String relevance = HttpRequestUtil.getString(req, "relevance");

		final String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		final FileOut fileOut = new FileOut(new File(DBConf.userHome, DBConf.title), id + "_" + timeSlotAndPresenter + "_" + date);
		fileOut.writeln("ID:" + id);
		fileOut.writeln("IP Address:\t" + ip);
		fileOut.writeln("TimeSlot/Presenter:\t" + timeSlotAndPresenter);
		fileOut.writeln("title:\t" + title);
		fileOut.writeln("summary:\t" + summary);
		fileOut.writeln("overall_rating:\t" + overall_rating);
		fileOut.writeln("originality:\t" + originality);
		fileOut.writeln("soundness:\t" + soundness);
		fileOut.writeln("organization:\t" + organization);
		fileOut.writeln("clarity:\t" + clarity);
		fileOut.writeln("relevance:\t" + relevance);
		fileOut.close();

		req.setAttribute("ID", id);
		req.setAttribute("timeSlotAndPresenter", timeSlotAndPresenter);
		req.setAttribute("title", title);
		req.setAttribute("summary", summary);
		req.setAttribute("overall_rating", overall_rating);
		req.setAttribute("originality", originality);
		req.setAttribute("soundness", soundness);
		req.setAttribute("organization", organization);
		req.setAttribute("clarity", clarity);
		req.setAttribute("relevance", relevance);

		return new StringBuilder("/evaluationCompleteForm.jsp").toString();
	}
}
