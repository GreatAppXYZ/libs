package xyz.greatapp.libs.service.database.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.greatapp.libs.service.database.requests.fields.ColumnValue;

public class InsertQueryRQ
{
    private final String table;
    private final ColumnValue[] columnValues;
    private final String idColumnName;

    @JsonCreator
    public InsertQueryRQ(
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
