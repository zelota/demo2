package demo2ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import demo2ui.components.DemoLabel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * https://vaadin.com/docs/v8/framework/articles/IBGettingStartedWithVaadinSpringWithoutSpringBoot.html
 *
 * https://vaadin.com/framework/spring
 *
 * http://spring.io/guides/gs/crud-with-vaadin/
 *
 * https://vaadin.com/docs/framework/advanced/advanced-spring.html
 *
 * Spring Security:
 * http://javawebtutor.com/articles/spring/spring-security-tutorial.php
 */
@SpringUI
@Theme("mytheme")
@SuppressWarnings("serial")
public class Demo2UI extends UI {

    @Autowired
    private DemoLabel demoLabel;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button, demoLabel);
        
        setContent(layout);
    }
}
