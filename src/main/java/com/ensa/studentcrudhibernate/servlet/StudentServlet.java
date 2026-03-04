package com.ensa.studentcrudhibernate.servlet;

import com.ensa.studentcrudhibernate.dao.StudentDAO;
import com.ensa.studentcrudhibernate.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new" -> req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);
            case "edit" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("student", dao.getById(id));
                req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
            }
            case "delete" -> {
                dao.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("students?action=list");
            }
            default -> {
                List<Student> list = dao.getAll();
                req.setAttribute("students", list);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        Student s = new Student();
        if ("update".equals(action)) {
            s.setId(Integer.parseInt(req.getParameter("id")));
        }
        s.setName(req.getParameter("name"));
        s.setEmail(req.getParameter("email"));
        s.setAge(Integer.parseInt(req.getParameter("age")));
        s.setCourse(req.getParameter("course"));

        if ("insert".equals(action)) {
            dao.save(s);
        } else {
            dao.update(s);
        }
        resp.sendRedirect("students?action=list");
    }
}
