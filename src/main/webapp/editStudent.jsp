<%@ page import="com.ensa.studentcrudhibernate.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Student</title>
    <style>
        body { font-family: Arial; margin: 30px; }
        input { padding: 7px; margin: 5px 0 10px; width: 300px; display: block; }
        button { background: #2E86AB; color: white; padding: 8px 20px; border: none; cursor: pointer; }
    </style>
</head>
<body>
<% Student s = (Student) request.getAttribute("student"); %>
<h2>Edit Student</h2>
<form action="students?action=update" method="post">
    <input type="hidden" name="id" value="<%= s.getId() %>">
    Name:   <input type="text"   name="name"   value="<%= s.getName() %>"   required>
    Email:  <input type="email"  name="email"  value="<%= s.getEmail() %>"  required>
    Age:    <input type="number" name="age"    value="<%= s.getAge() %>"    required>
    Course: <input type="text"   name="course" value="<%= s.getCourse() %>" required>
    <button type="submit">Update</button>
    <a href="students?action=list">Cancel</a>
</form>
</body>
</html>