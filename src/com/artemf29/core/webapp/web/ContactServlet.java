package com.artemf29.core.webapp.web;

import com.artemf29.core.webapp.Config;
import com.artemf29.core.webapp.storage.ContactStorage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    private ContactStorage contactStorage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contactStorage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uuid = request.getParameter("uuid");
            String action = request.getParameter("action");
            if (action == null) {
                request.setAttribute("contacts",contactStorage.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            }
    }
}
