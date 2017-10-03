package edu.action.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.KeyValue;
import com.db.dao.review.PapersDao;
import com.db.dao.review.ReservesDao;
import com.db.dao.review.StudentsDao;

import edu.servlet.ActionIF;

public class RetrieveReservedTimeSlotsAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final ReservesDao reservesDao = ReservesDao.getInstance();
		final List<KeyValue> papers = PapersDao.getInstance().getRecords();
		final Map<String, String> map = reservesDao.getMap();
		final Set<String> set = map.keySet();
		final List<KeyValue> reservedTimeSlots = new ArrayList<KeyValue>();
		for (final KeyValue paper : papers) {
			final String key = paper.getKey();
			if (set.contains(key)) {
				final String[] dateAndEmail = map.get(key).split(",");
				reservedTimeSlots.add(new KeyValue(dateAndEmail[0] + "/" + StudentsDao.getInstance().getRecord(dateAndEmail[1]), paper.getValue()));
			}
		}
		Collections.sort(reservedTimeSlots);
		req.setAttribute("reservedTimeSlots", reservedTimeSlots);
		return "/reviewRetrieveReservedTimeSlots.jsp";
	}
}
