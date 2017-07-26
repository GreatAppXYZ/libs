package xyz.my_app.libs.service.requests.database;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertQuery
{
    private final String table;
    private final ColumnValue[] columnValues;
    private final String idColumnName;

    @JsonCreator
    public InsertQuery(
            @JsonProperty("table") String table,
            @JsonProperty("columnValues") ColumnValue[] columnValues,
            @JsonProperty("idColumnName") String idColumnName)
    {
        this.table = table;
        this.columnValues = columnValues;
        this.idColumnName = idColumnName;
    }

    public String getTable()
    {
        return table;
    }

    public ColumnValue[] getColumnValues()
    {
        return columnValues;
    }

    public String getIdColumnName()
    {
        return idColumnName;
    }
}
