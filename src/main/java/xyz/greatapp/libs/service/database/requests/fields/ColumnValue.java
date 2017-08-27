package xyz.greatapp.libs.service.database.requests.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnValue
{
    private final String column;
    private final Object value;
    private final String table;

    public ColumnValue(@JsonProperty("column") String column,
                       @JsonProperty("value") Object value,
                       @JsonProperty("table") String table)
    {
        this.column = column;
        this.value = value;
        this.table = table;
    }

    public ColumnValue(String column, Object value) {
        this(column, value, "");
    }

    public String getColumn()
    {
        return column;
    }

    public Object getValue()
    {
        return value;
    }

    public String getTable() {
        return table;
    }
}
