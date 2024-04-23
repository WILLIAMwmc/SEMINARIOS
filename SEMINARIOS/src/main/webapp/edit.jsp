<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.emergentes.LISTA" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro de Seminarios</title>
</head>
<body>
    
    <h1>REGISTRO DE SEMINARIOS</h1>
    <form action="MainServlet" method="post">
        <table>
            <tr>
                <td><label for="fecha">Fecha</label></td>
                <td><input type="date" id="fecha" name="fecha"></td>
            </tr>
            <tr>
                <td><label for="nombre">Nombre</label></td>
                <td><input type="text" id="nombre" name="nombre"></td>
            </tr>
            <tr>
                <td><label for="apellidos">Apellidos</label></td>
                <td><input type="text" id="apellidos" name="apellidos"></td>
            </tr>
            <tr>
                <td>Turno</td>
                <td>
                    <input type="radio" id="turnoManana" name="turno" value="Mañana">
                    <label for="turnoManana">Mañana</label><br>
                    <input type="radio" id="turnoTarde" name="turno" value="Tarde">
                    <label for="turnoTarde">Tarde</label><br>
                    <input type="radio" id="turnoNoche" name="turno" value="Noche">
                    <label for="turnoNoche">Noche</label>
                </td>
            </tr>
            <tr>
                <td>SEMINARIOS DISPONIBLES</td>
                <td>
                    <input type="checkbox" name="seminarios" value="Inteligencia Artificial"> Inteligencia Artificial<br>
                    <input type="checkbox" name="seminarios" value="Machine Learning"> Machine Learning<br>
                    <input type="checkbox" name="seminarios" value="Simulación con Arena"> Simulación con Arena<br>
                    <input type="checkbox" name="seminarios" value="Robótica Educativa"> Robótica Educativa<br>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Enviar"></td>
            </tr>
        </table>
    </form>
</body>
</html>
