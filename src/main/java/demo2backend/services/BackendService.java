package demo2backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class BackendService implements Serializable, IBackendService {

    private static final long serialVersionUID = 212536456464564L;

    @Secured("ROLE_ADMIN")
    public String adminMethod() {
        return "Hello from an admin method";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String userMethod() {
        return "Hello from a user method";
    }
}
