
package xyz.greatapp.libs.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResult
{
    private final boolean success;
    private final String message;
    private final String object;
    private String extraInfo;

    public ServiceResult(boolean success, String message, String object)
    {
        this(success, message, object, "");
    }

    private ServiceResult(
            @JsonProperty("success") boolean success,
            @JsonProperty("message") String message,
            @JsonProperty("object") String object,
            @JsonProperty("extraInfo") String extraInfo)
    {
        this.success = success;
        this.message = message;
        this.object = object;
        this.extraInfo = extraInfo;
    }

    public ServiceResult(boolean success, String serviceMessage)
    {
        this(success, serviceMessage, null, "");
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getMessage()
    {
        return message;
    }

    public String getObject()
    {
        return object;
    }

    public String getExtraInfo()
    {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo)
    {
        this.extraInfo = extraInfo;
    }
}
