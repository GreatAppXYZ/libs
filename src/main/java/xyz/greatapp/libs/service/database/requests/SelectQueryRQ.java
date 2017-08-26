package xyz.greatapp.libs.service.database.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.greatapp.libs.service.database.requests.fields.ColumnValue;
import xyz.greatapp.libs.service.database.requests.fields.Join;

public class SelectQueryRQ
{
    private final String table;
    private final Join[] joins;
    private final ColumnValue[] filters;

    @JsonCreator
    public SelectQueryRQ(
            @JsonProperty("table") String table,
            @JsonProperty("filters") ColumnValue[] filters,
            @JsonProperty("joins") Join[] joins)
    {
        this.table = table;
        this.joins = joins;
        this.filters = filters;
    }

    @JsonCreator
    public SelectQueryRQ(
            @JsonProperty("table") String table,
            @JsonProperty("filters") ColumnValue[] filters)
    {
        this.table = table;
        this.joins = new Join[0];
        this.filters = filters;
    }

    public String getTable()
    {
        return table;
    }

    public Join[] getJoins() {
        return joins;
    }

    public ColumnValue[] getFilters()
    {
        return filters;
    }
}
