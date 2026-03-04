<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Student</title>
    <style>
        body { font-family: Arial; margin: 30px; }
        input, select { padding: 7px; margin: 5px 0 10px; width: 300px; display: block; }
        button { background: #2E86AB; color: white; padding: 8px 20px; border: none; cursor: pointer; }
    </style>
</head>
<body>
<h2>Add Student</h2>
<form action="students?action=insert" method="post">
    Name:   <input type="text"   name="name"   required>
    Email:  <input type="email"  name="email"  required>
    Age:    <input type="number" name="age"    required>
    Course: <input type="text"   name="course" required>
    <button type="submit">Save</button>
    <a href="students?action=list">Cancel</a>
</form>
</body>
</html>