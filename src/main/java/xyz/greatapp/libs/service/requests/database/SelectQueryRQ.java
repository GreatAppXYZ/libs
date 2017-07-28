package xyz.greatapp.libs.service.requests.database;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectQueryRQ
{
    private final String table;
    private final ColumnValue[] filters;

    @JsonCreator
    public SelectQueryRQ(@JsonProperty("table") String table, @JsonProperty("filters") ColumnValue[] filters)
    {
        this.table = table;
        this.filters = filters;
    }

    public String getTable()
    {
        return table;
    }

    public ColumnValue[] getFilters()
    {
        return filters;
    }
}