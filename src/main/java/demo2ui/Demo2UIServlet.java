package demo2ui;

import com.vaadin.spring.server.SpringVaadinServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", asyncSupported = true)
public class Demo2UIServlet extends SpringVaadinServlet {
}
