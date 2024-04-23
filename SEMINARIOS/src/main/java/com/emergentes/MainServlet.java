package com.emergentes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op == null) {
            op = "";
        }

        HttpSession session = request.getSession();
        ArrayList<LISTA> lista = (ArrayList<LISTA>) session.getAttribute("listaper");

        switch (op) {
            case "nuevo":
                response.sendRedirect("edit.jsp");
                break;
            case "editar":
                String idStr = request.getParameter("id");
                if (idStr != null && !idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    LISTA seminario = buscarSeminarioPorId(lista, id);
                    if (seminario != null) {
                        request.setAttribute("seminario", seminario);
                        request.getRequestDispatcher("edit.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    response.sendRedirect("index.jsp");
                }
                break;
            case "eliminar":
                String idEliminarStr = request.getParameter("id");
                if (idEliminarStr != null && !idEliminarStr.isEmpty()) {
                    int idEliminar = Integer.parseInt(idEliminarStr);
                    eliminarSeminario(lista, idEliminar);
                }
                response.sendRedirect("index.jsp");
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
      
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String turno = request.getParameter("turno");
        String seminarios = request.getParameter("seminarios");

       
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = fechaActual.format(formatter);

        HttpSession session = request.getSession();

        
        ArrayList<LISTA> lista = (ArrayList<LISTA>) session.getAttribute("listaper");
        if (lista == null) {
            lista = new ArrayList<>();
            session.setAttribute("listaper", lista);
        }

      
        if (nombre != null && !nombre.isEmpty() && apellidos != null && !apellidos.isEmpty() && turno != null && !turno.isEmpty() && seminarios != null && !seminarios.isEmpty()) {
          
            int nuevoId = lista.size() + 1;
            LISTA nuevoSeminario = new LISTA(nuevoId, fecha, nombre, apellidos, turno, seminarios);

            
            lista.add(nuevoSeminario);

           
            response.sendRedirect("index.jsp");
        } else {
            
            request.setAttribute("error", "Todos los campos son obligatorios");
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }

    private LISTA buscarSeminarioPorId(ArrayList<LISTA> lista, int id) {
        for (LISTA seminario : lista) {
            if (seminario.getId() == id) {
                return seminario;
            }
        }
        return null;
    }

    private void eliminarSeminario(ArrayList<LISTA> lista, int id) {
        LISTA seminario = buscarSeminarioPorId(lista, id);
        if (seminario != null) {
            lista.remove(seminario);
        }
    }
}

