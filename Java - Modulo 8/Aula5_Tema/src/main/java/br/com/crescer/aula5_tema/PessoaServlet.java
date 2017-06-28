package br.com.crescer.aula5_tema;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaServlet extends HttpServlet {

@Override
protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try(final PrintWriter out = response.getWriter();){
            out.append("<html>");
            out.append("<head>");
                out.append("<title>");
                    out.append("Minha Pagina Servlet");
                out.append("</title>");
            out.append("</head>");
            out.append("<body>");
                out.append("<h1>");
                    out.append("Ola, seja bem vindo ao primeiro servlet");
                out.append("</h1>");
            out.append("</body>");
            out.append("</html>");
        }
    }
}