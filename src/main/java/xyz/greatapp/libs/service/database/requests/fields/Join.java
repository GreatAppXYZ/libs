package xyz.greatapp.libs.service.database.requests.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Join {
    private final String table;
    private final String column;

    public Join(@JsonProperty("table") String table,
                @JsonProperty("column") String column) {
        this.table = table;
        this.column = column;
    }

    public String getTable() {
        return table;
    }

    public String getColumn() {
        return column;
    }
}
