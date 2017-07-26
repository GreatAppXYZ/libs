package xyz.my_app.libs.service.context;

import xyz.my_app.libs.service.Environment;

public class ThreadContext {
    private Environment _environment;

    public Environment getEnvironment() {
        return _environment;
    }

    public void setEnvironment(Environment environment) {
        _environment = environment;
    }
}
