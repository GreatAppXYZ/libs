package xyz.greatapp.libs.service.context;

import xyz.greatapp.libs.service.Environment;

public interface ThreadContextService {

    void initializeContext(Environment env);

    ThreadContext getThreadContext();

    Environment getEnvironment();

    void setThreadContextOnThread(ThreadContext threadContext);
}
