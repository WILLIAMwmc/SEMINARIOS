<%@ page import="java.util.ArrayList" %>
<%@ page import="com.emergentes.LISTA" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Inscritos</title>
</head>
<body>
    <p>Nombre: WILLIAM MENDOZA COLQUE </p>
            <p>Carnet: 14184826 LP </p>
    <h1>LISTA DE INSCRITOS</h1>
    <a href="MainServlet?op=nuevo">Nuevo</a>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Fecha</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Turno</th>
            <th>Seminarios</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>

        <% 
        ArrayList<LISTA> lista = (ArrayList<LISTA>) session.getAttribute("listaper");
        if (lista != null) {
            for (LISTA inscrito : lista) { %>
                <tr>
                    <td><%= inscrito.getId() %></td>
                    <td><%= inscrito.getFecha() %></td>
                    <td><%= inscrito.getNombre() %></td>
                    <td><%= inscrito.getApellidos() %></td>
                    <td><%= inscrito.getTurno() %></td>
                    <td><%= inscrito.getSeminarios() %></td>
                    <td><a href="MainServlet?op=editar&id=<%= inscrito.getId() %>">Editar</a></td>
                    <td><a href="MainServlet?op=eliminar&id=<%= inscrito.getId() %>" onclick="return confirm('¿Está seguro de eliminar?')">Eliminar</a></td>
                </tr>
            <% }
        } %>
    </table>
</body>
</html>
