package xyz.my_app.libs.service.context;

import xyz.my_app.libs.service.Environment;

public interface ThreadContextService {

    void initializeContext(Environment env);

    ThreadContext getThreadContext();

    Environment getEnvironment();

    void setThreadContextOnThread(ThreadContext threadContext);
}
