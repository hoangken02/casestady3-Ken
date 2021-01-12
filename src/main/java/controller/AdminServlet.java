package controller;

import dao.classroomService.ClassroomDAO;
import dao.classroomService.IClassroomDAO;
import dao.studentServive.StudentDAO;
import dao.userService.UserDAO;
import model.Classroom;
import model.Student;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "showClassroom":
                RequestDispatcher dispatcher = request.getRequestDispatcher("/classroom?action=#");
                dispatcher.forward(request, response);
                break;
            case "insertClassroom":
                insertClassoom(request, response);
                dispatcher = request.getRequestDispatcher("view/amin/insertClassroom");
                dispatcher.forward(request, response);
                break;
            case "insertUser":
                insertUser(request, response);
                dispatcher = request.getRequestDispatcher("view/admin/insertUser");
                dispatcher.forward(request, response);
                break;
            case "insertStudent":
                insertStudent(request, response);
                dispatcher = request.getRequestDispatcher("view/admin/insertStudent");
                dispatcher.forward(request, response);
                break;
            default:
                doGet(request, response);
        }
    }

    private void insertClassoom(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int centerId = Integer.parseInt(request.getParameter("centerID"));
        int courseId = Integer.parseInt(request.getParameter("courseID"));
        int userId = Integer.parseInt(request.getParameter("userID"));
        int recentModuleId = Integer.parseInt(request.getParameter("recentModule"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        IClassroomDAO classroomDAO = new ClassroomDAO();
        boolean rs = false;
        try {
            rs = classroomDAO.insertClassroom(new Classroom(name, centerId, courseId, userId, recentModuleId, startDate, endDate));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs) {
            request.setAttribute("message", "add student success!");
            System.out.println("add student success!");
        } else {
            request.setAttribute("message", "");
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String useName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        int centerId = Integer.parseInt(request.getParameter("centerId"));

        UserDAO userDAO = new UserDAO();
        boolean rs = false;
        try {
            rs = userDAO.insertUser(new User(firstName, lastName, useName, password, email, password, phoneNumber, centerId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs) {
            request.setAttribute("message", "add student success!");
            System.out.println("add student success!");
        } else {
            request.setAttribute("message", "");
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));

        StudentDAO studentDAO = new StudentDAO();
        boolean rs = false;
        try {
            rs = studentDAO.insertStudent(new Student(firstname, lastname, email, phoneNumber, classroomId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs) {
            request.setAttribute("message", "add student success!");
            System.out.println("add student success!");
        } else {
            request.setAttribute("message", "");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertClassroom":
                insertClassoom(request, response);
                break;
            case "insertStudent":
                insertStudent(request, response);
                break;
            case "insertUser":
                insertUser(request, response);
                break;
            case "showClassroom":

            case "listUser":
                listUser(request, response);
                break;
            case "listClass":
                listClass(request, response);
                break;
            case "listStudent":
                listStudent(request, response);
                break;
            default:

        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.selectAllUsers();
        System.out.println(users.size());
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/listUser");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listClass(HttpServletRequest request, HttpServletResponse response) {
        ClassroomDAO classroomDAO = new ClassroomDAO();
        List<Classroom> classrooms = classroomDAO.selectAllClassrooms();
        System.out.println(classrooms.size());
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/listClass");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.selectAllStudents();
        System.out.println(students.size());
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/listStudent");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showClassroom(HttpServletRequest request,HttpServletResponse response){

    }
}
