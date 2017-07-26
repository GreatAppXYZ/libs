package xyz.my_app.libs.service.filters;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static xyz.my_app.libs.service.Environment.DEV;
import static xyz.my_app.libs.service.Environment.PROD;
import static xyz.my_app.libs.service.Environment.AUTOMATION_TEST;
import static xyz.my_app.libs.service.Environment.UAT;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import xyz.my_app.libs.service.Environment;
import xyz.my_app.libs.service.context.ThreadContextService;

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
            return PROD;
        }
        if (request.getServerName().startsWith("uat."))
        {
            return UAT;
        }
        if (request.getServerName().startsWith("test.localhost"))
        {
            return AUTOMATION_TEST;
        }
        return DEV;
    }
}
