package net.ausiasmarch.connection;

class DatabaseParameters {

    private static final String URL = "jdbc:mysql://localhost:3306/spooller";
    private static final String USER = "root";
    private static final String PASSWORD = "tiger";

    static String getUrl() {
        return URL;
    }
    static String getUser() {
        return USER;
    }
    static String getPassword() {
        return PASSWORD;
    }
}
