package server;

import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import object.entity;

@WebServlet("/save")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = (req.getParameter("name"));
		int age = Integer.parseInt(req.getParameter("age"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarun");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		entity e = new entity();
		e.setId(id);
		e.setName(name);
		e.setAge(age);
		tr.begin();
		em.persist(e);
		tr.commit();
		resp.sendRedirect("Welcome.html");
	}
}
