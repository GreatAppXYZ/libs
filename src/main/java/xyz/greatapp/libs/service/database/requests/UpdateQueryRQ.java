package xyz.greatapp.libs.service.database.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.greatapp.libs.service.database.requests.fields.ColumnValue;

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
