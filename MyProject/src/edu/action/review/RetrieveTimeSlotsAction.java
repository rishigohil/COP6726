package edu.action.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.KeyValue;
import com.db.dao.review.ReservesDao;
import com.db.dao.review.TimeSlotsDao;

import edu.servlet.ActionIF;

public class RetrieveTimeSlotsAction implements ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception {
		final List<KeyValue> timeSlotList = TimeSlotsDao.getInstance().getRecords();
		final Set<String> reservedTimeSlotSet = ReservesDao.getInstance().getValueSet(0);
		final List<KeyValue> rtnTimeSlotList = new ArrayList<KeyValue>();
		for (final KeyValue timeSlot : timeSlotList) {
			if (reservedTimeSlotSet.contains(timeSlot.getKey())) {
				continue;
			}
			rtnTimeSlotList.add(timeSlot);
		}
		req.setAttribute("timeSlotList", rtnTimeSlotList);
		return "/reviewRetrieveTimeSlots.jsp";
	}
}
