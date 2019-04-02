package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command {
	private static final String RESULT_PATH = "/views/msg/result";
	public static String getCmd(HttpServletRequest req) throws ServletException {
		String uri = req.getRequestURI();
		String cmd = req.getParameter("cmd");
		if(cmd!=null) {
			return cmd;
		}
		int idx = uri.lastIndexOf("/");
		if(idx==0 || idx==-1) {
			throw new ServletException("올바르지 않은 요청입니다.");
		}
		return uri.substring(idx+1);
	}
	
	public static void goResultPage(HttpServletRequest request, 
			HttpServletResponse response, String url, String msg) 
					throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(RESULT_PATH);
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		rd.forward(request, response);
	}
}