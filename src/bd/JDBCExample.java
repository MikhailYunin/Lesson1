package bd;

import javax.sound.midi.Soundbank;
import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTable();
//        insertIntoBook("Книга 1", 345);
//        insertIntoBook("Книга 2", 399);
//        insertIntoBook("Книга 3", 211);
//        insertIntoBook("Книга 4", 50);

        selectAll();
    }

    public static void createTable() throws ClassNotFoundException, SQLException {

        String sqlCreate = "\n" +
                "CREATE TABLE IF NOT EXISTS Book(\n" +
                "    id SERIAL PRIMARY KEY, \n" +
                "    tittle TEXT NOT NULL,\n" +
                "    pageCount INTEGER NOT NULL\n" +
                ");";

        // регистрация драйвера
        Class.forName("org.postgresql.Driver");

        // выполнение подключения
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleBD", "user", "000000")) {
            try (Statement statement = connection.createStatement()) {
                //statement.executeUpdate();
                //statement.executeQuery();
                int res = statement.executeUpdate(sqlCreate);
                System.out.println(res);
            }
        }
    }

    public static void insertIntoBook (String title, int pageCount) throws SQLException, ClassNotFoundException {
        String sqlInsert = "INSERT INTO Book (title, pageCount) VALUES (?, ?);";

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleBD", "user", "000000")) {
            try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
                statement.setString(1, title); // указываем на какое место добавляем данные (знак вопроса)
                statement.setInt(2, pageCount);
                int res = statement .executeUpdate();
                System.out.println(res);
            }
        }
    }

    public static void selectAll () throws SQLException, ClassNotFoundException {
        String sqlSelectAlll = "SELECT * FROM Book";
        // регистрация драйвера
        Class.forName("org.postgresql.Driver");

        // выполнение подключения
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleBD", "user", "000000")) {
            try (Statement statement = connection.createStatement()) {
                //statement.executeUpdate();
                //statement.executeQuery();
                ResultSet resultSet = statement.executeQuery(sqlSelectAlll);
                while (resultSet.next()){
                    String title = resultSet.getString("title");
                    int pageCount = resultSet.getInt("pageCount");
                    System.out.println("title: " + title);
                    System.out.println("pageCount");
                }
            }
        }

    }
}
