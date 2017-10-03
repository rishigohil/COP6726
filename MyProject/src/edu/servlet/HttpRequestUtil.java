package edu.servlet;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil {

	public static String getString(final HttpServletRequest req, final String key) throws Exception {
		try {
			return req.getParameter(key).toString();
		} catch (Exception e) {
			throw new Exception("Fail to parsing: " + key, e);
		}
	}

	public static int getInt(final HttpServletRequest req, final String key) throws Exception {
		try {
			return Integer.parseInt(req.getParameter(key));
		} catch (Exception e) {
			throw new Exception("Fail to parsing: " + key, e);
		}
	}

	public static long getLong(final HttpServletRequest req, final String key) throws Exception {
		try {
			return Long.parseLong(req.getParameter(key));
		} catch (Exception e) {
			throw new Exception("Fail to parsing: " + key, e);
		}
	}

	public static boolean getBoolean(final HttpServletRequest req, final String key) throws Exception {
		try {
			return "true".equals(req.getParameter(key).toString()) ? true : false;
		} catch (Exception e) {
			throw new Exception("Fail to parsing: " + key, e);
		}
	}

	public static double getDouble(final HttpServletRequest req, final String key) throws Exception {
		try {
			return Double.parseDouble(req.getParameter(key));
		} catch (Exception e) {
			throw new Exception("Fail to parsing: " + key, e);
		}
	}

}
