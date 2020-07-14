package com.bp.batman.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Rating {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Source")
    String Source;

    @ColumnInfo(name = "Value")
    String Value;

    @ColumnInfo(name = "f_key")
    Integer f_key;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getF_key() {
        return f_key;
    }

    public void setF_key(Integer f_key) {
        this.f_key = f_key;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

}
