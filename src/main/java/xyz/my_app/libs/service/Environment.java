package xyz.my_app.libs.service;

public enum Environment {
    DEV(""), AUTOMATION_TEST("test."), UAT("uat."), PROD("prod."), INTEGRATION_TEST("");

    private final String uriPrefix;

    Environment(String uriPrefix)
    {
        this.uriPrefix = uriPrefix;
    }

    public String getURIPrefix()
    {
        return uriPrefix;
    }
}
