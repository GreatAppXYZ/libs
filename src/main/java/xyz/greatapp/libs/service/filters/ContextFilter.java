package xyz.greatapp.libs.service.filters;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import xyz.greatapp.libs.service.Environment;
import xyz.greatapp.libs.service.context.ThreadContextService;

@Component
@Order(HIGHEST_PRECEDENCE)
public class ContextFilter extends GenericFilterBean
{
    private final ThreadContextService threadContextService;

    @Autowired
    public ContextFilter(ThreadContextService threadContextService)
    {
        this.threadContextService = threadContextService;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        threadContextService.initializeContext(getEnvironment((HttpServletRequest) request));
        chain.doFilter(request, response);
    }

    private Environment getEnvironment(HttpServletRequest request)
    {
        if (request.getServerName().startsWith("prod."))
        {
            return Environment.PROD;
        }
        if (request.getServerName().startsWith("uat."))
        {
            return Environment.UAT;
        }
        if (request.getServerName().startsWith("test.localhost"))
        {
            return Environment.AUTOMATION_TEST;
        }
        return Environment.DEV;
    }
}
