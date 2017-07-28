package xyz.greatapp.libs.service.context;

import xyz.greatapp.libs.service.Environment;

public class ThreadContext {
    private Environment _environment;

    public Environment getEnvironment() {
        return _environment;
    }

    public void setEnvironment(Environment environment) {
        _environment = environment;
    }
}
