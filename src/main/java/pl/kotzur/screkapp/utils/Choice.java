package pl.kotzur.screkapp.utils;

public class Choice {

    private String colName;
    private String type;

    public Choice() {
    }

    public Choice(String colName, String type) {
        this.colName = colName;
        this.type = type;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
