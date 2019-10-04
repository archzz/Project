package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	private List<Question> questions ;
		private int noOfQuestions;
	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionOnJava();
		noOfQuestions=questions.size();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Integer questionNo=(Integer) session.getAttribute("qNo");
		
		if(questionNo==null)
			questionNo=0;
		else
			questionNo++;
		session.setAttribute("qNo", questionNo);
		
		PrintWriter out=response.getWriter();
		
		if(questionNo>= questions.size() )  {
			
			response.setContentType("text/html");
			out.print("<form action='DisplayResultServlet'>");
			out.print("<button type='submit'>Submit</button>");
			out.print("</form>");
			
		}
		

		Question q=questions.get(questionNo++);
		session.setAttribute("currentQs",q);
		
		response.setContentType("text/html");
	
		
		out.print("<form action='CalculateScoreServlet'>");
		out.print("<h3>"+q.getQuestion()+ "</h3>");
		int optionNo=0;
		for(Option o:q.getOptions()) {
			
			 
			 out.print("<h4>");
			 out.print("<input type='radio' name='op' value='"+(optionNo++)+"'>");
			 out.print(o.getOption());
			 out.print("</h4>");
		}
	      
	    out.print("<button type='submit'>Continue</button>");
		out.print("</form>");
	}
	
}

