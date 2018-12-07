<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://devices-registry.herokuapp.com/functions" %>
<html>
<head>
    <title>Devices registry</title>
</head>
<body>
    <hr/>
        <a href="devices?action=create">Add Device</a>
    <hr/>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Id</th>
                <th>Serial No</th>
                <th>Type</th>
                <th>Description</th>
                <th>Created At</th>
            </tr>
        </thead>
        <c:forEach items="${devices}" var="device">
            <tr>
                <td>${device.id}</td>
                <td>${device.serialNo}</td>
                <td>${device.type}</td>
                <td>${device.description}</td>
                <td>${fn:formatDateTime(device.createdAt)}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
