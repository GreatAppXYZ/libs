package xyz.greatapp.libs.service.filters;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import xyz.greatapp.libs.service.Environment;
import xyz.greatapp.libs.service.context.ContextFilter;
import xyz.greatapp.libs.service.context.ThreadContextService;

@RunWith(MockitoJUnitRunner.class)
public class ContextFilterTest
{
    private ContextFilter contextFilter;
    @Mock
    private ThreadContextService threadContextService;
    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    private FilterChain filterChain;

    @Before
    public void setUp() throws Exception
    {
        contextFilter = new ContextFilter(threadContextService);
        given(httpServletRequest.getServerName()).willReturn("localhost");
    }

    @Test
    public void shouldCallInitializeContext() throws IOException, ServletException
    {
        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(any());
    }

    @Test
    public void shouldInitializeProdEnvironmentContext() throws IOException, ServletException
    {
        // given
        given(httpServletRequest.getServerName()).willReturn("prod.greatapp.xyz");

        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(Environment.PROD);
    }

    @Test
    public void shouldInitializeUATEnvironmentContext() throws IOException, ServletException
    {
        // given
        given(httpServletRequest.getServerName()).willReturn("uat.services.greatapp.xyz");

        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(Environment.UAT);
    }

    @Test
    public void shouldInitializeFunctionalTestEnvironmentContext() throws Exception
    {
        // given
        given(httpServletRequest.getServerName()).willReturn("test.localhost");

        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(Environment.AUTOMATION_TEST);
    }

    @Test
    public void shouldInitializeDevEnvironmentContext() throws IOException, ServletException
    {
        // given
        given(httpServletRequest.getServerName()).willReturn("localhost");

        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(Environment.DEV);
    }

    @Test
    public void shouldInitializeDevEnvironmentContextForUnknownServerName() throws IOException, ServletException
    {
        // given
        given(httpServletRequest.getServerName()).willReturn("Unknown");

        // when
        contextFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);

        // then
        verify(threadContextService).initializeContext(Environment.DEV);
    }
}
