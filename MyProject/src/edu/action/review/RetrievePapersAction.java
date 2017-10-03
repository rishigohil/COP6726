package edu.action.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.KeyValue;
import com.db.dao.review.PapersDao;
import com.db.dao.review.ReservesDao;

import edu.servlet.ActionIF;
import edu.servlet.HttpRequestUtil;

public class RetrievePapersAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {		
		final String timeSlotId = HttpRequestUtil.getString(req, "timeSlotId");		
		final List<KeyValue> papers = PapersDao.getInstance().getRecords();
		final Set<String> set = ReservesDao.getInstance().getKeySet();
		final List<KeyValue> rtnPapers = new ArrayList<KeyValue>();
		for (final KeyValue paper : papers) {
			if (!set.contains(paper.getKey())) {
				rtnPapers.add(paper);
			}
		}
		req.setAttribute("timeSlotId", timeSlotId);
		req.setAttribute("papers", rtnPapers);		
		return "/reviewRetrievePapers.jsp";
	}
}
