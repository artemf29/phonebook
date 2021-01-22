package com.artemf29.core.webapp.web;

import com.artemf29.core.webapp.Config;
import com.artemf29.core.webapp.builder.OrganizationBuilder;
import com.artemf29.core.webapp.builder.PersonBuilder;
import com.artemf29.core.webapp.contacts.Contact;
import com.artemf29.core.webapp.contacts.Organization;
import com.artemf29.core.webapp.contacts.Person;
import com.artemf29.core.webapp.contacts.object.Gender;
import com.artemf29.core.webapp.contacts.object.PhoneNumber;
import com.artemf29.core.webapp.storage.ContactStorage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    private ContactStorage contactStorage;
    private String type = "P";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contactStorage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String name = request.getParameter("name");
        String number = request.getParameter("number");

        Contact contact;
        PersonBuilder personBuilder = new PersonBuilder();
        OrganizationBuilder organizationBuilder = new OrganizationBuilder();

        final boolean isCreate = (uuid.equals("0"));

        if (isCreate) {
                contact = type.equals("P") ? personBuilder.createNull() : organizationBuilder.createNull();
        } else {
            contact = contactStorage.get(uuid);
            type = "O";
        }
        if (contact instanceof Person || type.equals("P")) {
            String gender = request.getParameter("gender");
            personBuilder.setUuid(contact.getUuid());
            personBuilder.setName(name);
            personBuilder.setNumber(new PhoneNumber(number));
            personBuilder.setGender(gender.equals("MALE") ? Gender.MALE : Gender.FEMALE);
            personBuilder.setCreateDate(contact.getCreateDate());
            personBuilder.setUpdateDate();
            contact = personBuilder.create();
        } else {
            String info = request.getParameter("info");
            organizationBuilder.setUuid(contact.getUuid());
            organizationBuilder.setName(name);
            organizationBuilder.setNumber(new PhoneNumber(number));
            organizationBuilder.setInfo(info);
            organizationBuilder.setCreateDate(contact.getCreateDate());
            organizationBuilder.setUpdateDate();
            contact = organizationBuilder.create();
        }

        if (isCreate) {
            contactStorage.create(contact);
        } else {
            contactStorage.update(contact);
        }
        response.sendRedirect("contact");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("contacts", contactStorage.getAll());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }
        Contact contact;
        switch (action) {
            case "delete": {
                contactStorage.delete(uuid);
                response.sendRedirect("contact");
                return;
            }
            case "view":
                contact = contactStorage.get(uuid);
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(request, response);
                break;
            case "search": {
                request.setAttribute("contacts", contactStorage.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
                break;
            }
            case "add": {
                request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
                break;
            }
            case "addP": {
                type = "P";
                PersonBuilder personBuilder = new PersonBuilder();
                contact = personBuilder.createNull("0");
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
                break;
            }
            case "addO": {
                type = "O";
                OrganizationBuilder organizationBuilder = new OrganizationBuilder();
                contact = organizationBuilder.createNull("0");
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
                break;
            }
            case "edit": {
                contact = contactStorage.get(uuid);
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
                break;
            }
            default:
                throw new IllegalArgumentException("Action" + action + " is illegal");
        }
    }
}
