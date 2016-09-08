package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.service.LoginService;
import com.ipartek.formacion.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
	private LoginService loginService = null;
	private HttpSession session = null;

	private final String VIEW_LOGIN = "index.jsp";
	private final String VIEW_BACK_INDEX = "backoffice/index.jsp";

	@Override()
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		this.loginService = LoginServiceImpl.getInstance();
	}

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

		final String pUsuario = request.getParameter("usuario");
		final String pPass = request.getParameter("pass");
		String mensaje = "";

		final Usuario user = this.loginService.checkLogin(pUsuario, pPass);
		this.session = request.getSession();

		if (user == null) {
			mensaje = "Nombre o contraseña incorrectos";
			this.dispatcher = request.getRequestDispatcher(this.VIEW_LOGIN);
		} else {
			mensaje = "Bienvenido" + " " + user.getNombre();
			this.dispatcher = request.getRequestDispatcher(this.VIEW_BACK_INDEX);
			this.session.setAttribute("usuario", user);
		}
		request.setAttribute("mensaje", mensaje);
		this.dispatcher.forward(request, response);

	}

}
