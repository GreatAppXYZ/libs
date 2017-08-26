package xyz.greatapp.libs.service.database.requests.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Join {
    private final String table;
    private final String leftColumn;
    private final String rightColumn;

    public Join(@JsonProperty("table") String table,
                @JsonProperty("leftColumn") String leftColumn,
                @JsonProperty("rightColumn") String rightColumn) {
        this.table = table;
        this.leftColumn = leftColumn;
        this.rightColumn = rightColumn;
    }

    public String getTable() {
        return table;
    }

    public String getLeftColumn() {
        return leftColumn;
    }

    public String getRightColumn() {
        return rightColumn;
    }
}
