package edu.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionIF {

	public String process(final HttpServletRequest req, final HttpServletResponse res, final String ip) throws Exception;

}
