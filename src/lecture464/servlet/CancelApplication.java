package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Application;

/**
 * Servlet implementation class CancelApplication
 */
public class CancelApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("sunjundashabi");
		HttpSession session=request.getSession();
		ArrayList<Application> selectedApplication= (ArrayList<Application>) session.getAttribute("selectedApplication");
		String Index=request.getParameter("CancelApp");
		int index=Integer.parseInt(Index);
		Application cancelApplication=selectedApplication.get(index-1);
		session.setAttribute("index", index);
		cancelApplication.setStatus(0);
		session.removeAttribute("cancelApplication");
		session.setAttribute("cancelApplication", cancelApplication);
	    response.sendRedirect("CancelApplication.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
