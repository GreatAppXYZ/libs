package xyz.greatapp.libs.service.context;

import xyz.greatapp.libs.service.Environment;
import org.springframework.stereotype.Component;

@Component
public class ThreadContextServiceImpl implements ThreadContextService
{
    private static final ThreadLocal<ThreadContext> THREAD_CONTEXT = new ThreadLocal<>();

    @Override
    public void initializeContext(Environment environment)
    {
        ThreadContext threadContext = new ThreadContext();
        threadContext.setEnvironment(environment);
        setThreadContextOnThread(threadContext);
    }

    @Override
    public ThreadContext getThreadContext()
    {
        return THREAD_CONTEXT.get();
    }

    @Override
    public Environment getEnvironment()
    {
        return getThreadContext().getEnvironment();
    }

    @Override
    public void setThreadContextOnThread(ThreadContext threadContext)
    {
        THREAD_CONTEXT.set(threadContext);
    }
}
