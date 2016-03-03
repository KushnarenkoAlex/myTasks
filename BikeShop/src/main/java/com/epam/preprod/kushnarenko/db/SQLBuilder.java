package main.java.com.epam.preprod.kushnarenko.db;

import java.sql.SQLException;

import main.java.com.epam.preprod.kushnarenko.constants.Const;

public class SQLBuilder {

    private StringBuilder query;

    public SQLBuilder() {
        query = new StringBuilder();
    }

    public SQLBuilder select(String... fields) throws SQLException {
        if (fields.length == 0) {
            throw new SQLException();
        }
        query.append(Const.SELECT).append(Const.SPACE);
        SQLBuilder.appendArray(query, fields);
        return this;
    }

    private static void appendArray(StringBuilder query, String[] array) {
        for (String s : array) {
            query.append(s).append(Const.COMA);
        }
        query.deleteCharAt(query.length() - 1).append(Const.SPACE);
    }

    @Override
    public String toString() {
        return query.toString();
    }

    private static void appendValue(StringBuilder query, String value) {
        query.append(value).append(Const.SPACE);
    }

    public SQLBuilder from(String table) throws SQLException {
        if (table == null || table.isEmpty()) {
            throw new SQLException();
        }
        query.append(Const.FROM).append(Const.SPACE);
        SQLBuilder.appendValue(query, table);
        return this;
    }

    public SQLBuilder where(String... conditions) throws SQLException {
        if (conditions.length == 0) {
            throw new SQLException();
        }
        query.append(Const.WHERE).append(Const.SPACE);
        SQLBuilder.appendArray(query, conditions);
        return this;
    }

    public static String addConditions(Condition c, String... conditions) {
        if (conditions.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (String s : conditions) {
            stringBuilder.append(s).append(Const.SPACE).append(c).append(Const.SPACE);
        }
        stringBuilder.delete(stringBuilder.length() - c.toString().length() - 1, stringBuilder.length()).append(")");
        return stringBuilder.toString();
    }

    private SQLBuilder orderBy(String... conditions) throws SQLException {
        if (conditions.length == 0) {
            throw new SQLException();
        }
        query.append(Const.ORDER_BY).append(Const.SPACE);
        SQLBuilder.appendArray(query, conditions);
        return this;
    }

    public SQLBuilder orderDesc(String... conditions) throws SQLException {
        this.orderBy(conditions);
        query.append(Const.DESC).append(Const.SPACE);
        return this;
    }

    public SQLBuilder orderAsc(String... conditions) throws SQLException {
        this.orderBy(conditions);
        return this;
    }

    public SQLBuilder limit(Integer from, Integer count) {
        query.append(Const.LIMIT).append(Const.SPACE).append(from).append(Const.COMA).append(count);
        return this;
    }

}
