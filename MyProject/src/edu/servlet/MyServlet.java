package edu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/MyProject", urlPatterns = { "/myAction" })

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
		super.doGet(req, res);
		service(req, res);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
		service(req, res);
	}

	protected void printJsp(final HttpServletRequest req, HttpServletResponse res, String jspfile) {
		RequestDispatcher dispatcher = null;
		try {
			dispatcher = getServletContext().getRequestDispatcher(jspfile);
			dispatcher.forward(req, res);
		} catch (Exception e) {
			this.printErr(req, res, "printJsp Failed", e);
		}
	}

	protected void printErr(HttpServletRequest req, HttpServletResponse res, String message, Exception e) {
		try {
			final StringBuilder strbuf = new StringBuilder();
			strbuf.append("JSP/Servlet Error (Catched by MyServlet) :[");
			strbuf.append(message);
			strbuf.append("] Request URI: " + req.getRequestURI());
			String user = req.getRemoteUser();
			if (user != null) {
				strbuf.append(", USER: " + user);
			}
			strbuf.append(", USER LOCATION: " + req.getRemoteHost() + "(" + req.getRemoteAddr() + ")");
			final java.io.PrintWriter out = res.getWriter();
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><title>Error</title></head><body bgcolor=white><xmp>");
			out.println(strbuf.toString());
			if (e != null) {
				e.printStackTrace(out);
			}
			out.println("</xmp></body></html>");
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void service(final HttpServletRequest req, final HttpServletResponse res) throws IOException {

		final String actionName = req.getParameter("action");
		if (actionName == null) {
			printErr(req, res, "No action name", null);
			return;
		}		
		try {
			System.out.println("Call " + actionName);
			ActionIF action = (ActionIF) Class.forName(actionName).newInstance();
			final String returnJsp = action.process(req, res, getClientIpAddr(req));
			if (returnJsp != null) {
				printJsp(req, res, returnJsp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			printErr(req, res, "Action Error: " + actionName, e);
			return;
		}
	}

	public String getClientIpAddr(final HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}