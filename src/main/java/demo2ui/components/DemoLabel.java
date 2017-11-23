package demo2ui.components;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;

@SpringComponent
public class DemoLabel extends Label {

    public DemoLabel() {
        setValue("This is the DemoLabel!");
    }
}
