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

import jakarta.servlet.RequestDispatcher;
import object.entity;

@WebServlet("/tarun1")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarun");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        entity e1 = em.find(entity.class, id);

        if (e1 != null && e1.getName().equals(name)) {
            resp.sendRedirect("display.html");
        } else {
            req.setAttribute("errorMessage", "Invalid ID or Password.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
