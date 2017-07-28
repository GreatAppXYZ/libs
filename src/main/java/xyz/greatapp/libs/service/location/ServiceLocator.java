package xyz.greatapp.libs.service.location;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.greatapp.libs.service.Environment;
import xyz.greatapp.libs.service.ServiceName;

@Component
public class ServiceLocator
{
    @Autowired
    private EurekaClient eurekaClient;

    public String getServiceURI(ServiceName serviceName, Environment environment)
    {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(serviceName.name(), false);
        String homePageUrl = instanceInfo.getHomePageUrl();
        boolean hasHttps = homePageUrl.contains("https://");
        homePageUrl = homePageUrl.replace("http://", "");
        homePageUrl = homePageUrl.replace("https://", "");
        homePageUrl = environment.getURIPrefix() + homePageUrl;
        homePageUrl = getUrlWithoutPort(homePageUrl);
        return hasHttps ? "https://" + homePageUrl : "http://" + homePageUrl;
    }

    private String getUrlWithoutPort(String originalUrl)
    {
        if (originalUrl.contains(":"))
        {
            String newUrl = originalUrl.substring(0, originalUrl.indexOf(":"));
            return newUrl.equals("localhost") ? originalUrl : newUrl;
        }
        return originalUrl;
    }
}