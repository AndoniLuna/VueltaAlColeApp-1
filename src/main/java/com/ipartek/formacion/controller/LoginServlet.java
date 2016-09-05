package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override()
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override()
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO trazas de LOG4J
		// TODO filtro para backoffice

		final String pUsuario = request.getParameter("usuario");
		final String pPass = request.getParameter("pass");

		if (USUARIO_NAME_ADMIN.equals(pUsuario) && USUARIO_PASS_ADMIN.equals(pPass)) {
			this.dispatcher = request.getRequestDispatcher("backoffice/index.jsp");
		} else {
			this.dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mensaje", "Usuario o contraseña incorrrectos");
		}
		this.dispatcher.forward(request, response);
	}

}
