<%@ page import="com.ensa.studentcrudhibernate.model.Student, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 100%; }
        th { background: #2E86AB; color: white; padding: 10px; }
        td { padding: 8px; border: 1px solid #ccc; }
        tr:nth-child(even) { background: #f2f2f2; }
        a { color: #2E86AB; } a.del { color: red; }
        .btn { background: #2E86AB; color: white; padding: 8px 16px; text-decoration: none; border-radius: 4px; }
    </style>
</head>
<body>
<h2>Student List</h2>
<a class="btn" href="students?action=new">+ Add Student</a><br><br>
<table>
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Course</th><th>Actions</th></tr>
    <% List<Student> list = (List<Student>) request.getAttribute("students");
        for (Student s : list) { %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getCourse() %></td>
        <td>
            <a href="students?action=edit&id=<%= s.getId() %>">Edit</a> |
            <a class="del" href="students?action=delete&id=<%= s.getId() %>"
               onclick="return confirm('Delete?')">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>