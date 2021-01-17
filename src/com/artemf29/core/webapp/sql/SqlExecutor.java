package com.artemf29.core.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlExecutor<T> {
    T execute(PreparedStatement preparedStatement) throws SQLException;
}
