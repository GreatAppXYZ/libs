package xyz.greatapp.libs.service.requests.database;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateQueryRQ
{
    private final String table;
    private final ColumnValue[] sets;
    private final ColumnValue[] filters;

    @JsonCreator
    public UpdateQueryRQ(
            @JsonProperty("table") String table,
            @JsonProperty("sets") ColumnValue[] columnValues,
            @JsonProperty("filters") ColumnValue[] filters)
    {
        this.table = table;
        this.sets = columnValues;
        this.filters = filters;
    }

    public String getTable()
    {
        return table;
    }

    public ColumnValue[] getSets()
    {
        return sets;
    }

    public ColumnValue[] getFilters()
    {
        return filters;
    }
}
