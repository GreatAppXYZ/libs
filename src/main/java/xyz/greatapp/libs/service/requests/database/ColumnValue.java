package xyz.greatapp.libs.service.requests.database;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnValue
{
    private final String column;
    private final Object value;

    public ColumnValue(@JsonProperty("column") String column, @JsonProperty("value") Object value)
    {
        this.column = column;
        this.value = value;
    }

    public String getColumn()
    {
        return column;
    }

    public Object getValue()
    {
        return value;
    }
}
