package com.biscato.kollaidoskop;

import java.io.IOException;

import javax.servlet.http.*;
import com.google.appengine.api.users.*;

@SuppressWarnings("serial")
public class KollaidoskopServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        if (user != null){
			Questionaire questions = new Questionaire();
			String displayString = questions.getQuestionaire();
			resp.setContentType("plain/text");
			resp.getWriter().println(displayString);
        } else {
            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }

	}
}
