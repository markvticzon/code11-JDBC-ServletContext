package bpi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import bpi.model.ForexBean;


public class ProcessGetAllRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = new ForexBean().getConnection(
				getServletContext().getInitParameter("jdbcUrl"),
				getServletContext().getInitParameter("dbUsername"),
				getServletContext().getInitParameter("dbPassword"));
		
		
		ResultSet records =
				new ForexBean().getAllRecords(connection);
		
		
		//perform binding
		request.setAttribute("records", records);
		request.getRequestDispatcher("viewrecords.jsp").forward(request, response);
	}

}
