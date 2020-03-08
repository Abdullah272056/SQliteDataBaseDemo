package com.example.sqlitedatabasedemo;

public class Query {
    public static final String DATAbASE_NAME="Student";
    public static final Integer DATAbASE_VERSION=1;
    public static final String TABLE_NAME="Student";

    public static final String ID                = "id";
    public static final String STUDENT_NAME      = "name";
    public static final String STUDENT_ROLL   = "address";

    public static final String CREATE_TABLE=" CREATE TABLE "+TABLE_NAME +"("
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +STUDENT_NAME+" TEXT, "
            +STUDENT_ROLL+" Text"
            +
            ")";

}
