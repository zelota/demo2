package demo2ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import demo2backend.SecurityUtils;
import demo2backend.services.BackendService;
import demo2backend.services.IBackendService;
import demo2ui.views.AccessDeniedView;
import demo2ui.views.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * https://vaadin.com/docs/v8/framework/articles/IBGettingStartedWithVaadinSpringWithoutSpringBoot.html
 * <p>
 * https://vaadin.com/framework/spring
 * <p>
 * http://spring.io/guides/gs/crud-with-vaadin/
 * <p>
 * https://vaadin.com/docs/framework/advanced/advanced-spring.html
 * <p>
 * Spring Security:
 * http://javawebtutor.com/articles/spring/spring-security-tutorial.php
 * <p>
 * Vaadin:
 * https://vaadin.com/blog/a-hybrid-approach-to-spring-security-in-vaadin-applications
 * https://vaadin.com/blog/filter-based-spring-security-in-vaadin-applications
 */
@SpringUI
@Theme(ValoTheme.THEME_NAME)
@Push(transport = Transport.WEBSOCKET_XHR)
@SuppressWarnings("serial")
public class Demo2UI extends UI {

    @Autowired
    AuthenticationManager authenticationManager;

    // ez nem tudom miért nem megy... :(
//    @Autowired
//    IBackendService backendService;

    @Autowired
    SpringViewProvider viewProvider;

    @Autowired
    ErrorView errorView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Demo2");
        if (SecurityUtils.isLoggedIn()) {
            showMain();
        } else {
            showLogin();
        }
    }

    private void showLogin() {
        setContent(new demo2ui.forms.LoginForm(this::login));
    }

    private void showMain() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeFull();

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        layout.addComponent(buttons);

//        buttons.addComponent(new Button("Invoke user method", event -> {
//            // This method should be accessible by both 'user' and 'admin'.
//            Notification.show(backendService.userMethod());
//        }));
        buttons.addComponent(new Button("Navigate to user view", event -> {
            getNavigator().navigateTo("");
        }));
//        buttons.addComponent(new Button("Invoke admin method", event -> {
//            // This method should be accessible by 'admin' only.
//            Notification.show(backendService.adminMethod());
//        }));
        buttons.addComponent(new Button("Navigate to admin view", event -> {
            getNavigator().navigateTo("admin");
        }));
        buttons.addComponent(new Button("Logout", event -> logout()));

        Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
        layout.setExpandRatio(viewContainer, 1.0f);

        setContent(layout);
        setErrorHandler(this::handleError);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        navigator.setErrorView(errorView);
        viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
    }

    private boolean login(String username, String password) {
        try {
            Authentication token = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            // Reinitialize the session to protect against session fixation attacks. This does not work
            // with websocket communication.
            VaadinService.reinitializeSession(VaadinService.getCurrentRequest());
            SecurityContextHolder.getContext().setAuthentication(token);
            // Now when the session is reinitialized, we can enable websocket communication. Or we could have just
            // used WEBSOCKET_XHR and skipped this step completely.
            getPushConfiguration().setTransport(Transport.WEBSOCKET);
            getPushConfiguration().setPushMode(PushMode.AUTOMATIC);
            // Show the main UI
            showMain();
            return true;
        } catch (AuthenticationException ex) {
            return false;
        }
    }

    private void logout() {
        getSession().close();
        getPage().reload();
    }

    private void handleError(com.vaadin.server.ErrorEvent event) {
        Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
        if (t instanceof AccessDeniedException) {
            Notification.show("You do not have permission to perform this operation",
                    Notification.Type.WARNING_MESSAGE);
        } else {
            DefaultErrorHandler.doDefault(event);
        }
    }
}
