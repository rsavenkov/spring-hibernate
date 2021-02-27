<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create course</title>
</head>
<body>
    <h1>Создание курса:</h1>
    <form action="/course/save" method="post">
        <input name="name">
        <input name="duration" type="number">
        <button type="submit">Создать</button>
    </form>
    <hr/>
    <form action="courseUpload" method="post" enctype="multipart/form-data">
        <input type="text" name="name">
        <input type="file" name="file">
        <input type="submit">
    </form>
</body>
</html>
