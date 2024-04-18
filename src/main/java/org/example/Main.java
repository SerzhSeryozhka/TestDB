package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws SQLException {
        // example0();
//        example1();
//        example2();
        exampleMe();
    }

    private static void example2() throws SQLException {
        Connection conn = connectToDB();
        ArrayList<User> users = loadUsers(conn);
        System.out.println("получен список из " + users.size() + " юзеров");
        users.forEach(System.out::println);

        conn.close();
    }

    public static ArrayList<User> loadUsers(Connection conn) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.user");
        while (rs.next()) {
            int x = rs.getInt("id");
            String fio = rs.getString("fio");
            double m = rs.getDouble("money");
            users.add(new User(x, fio, m));
        }
        rs.close();
        st.close();
        return users;
    }

    private static void exampleMe() throws SQLException {
        Connection conn = connectToDB();
        ArrayList<Tr> triangles = loadTriangle(conn);
        System.out.println("получен список из " + triangles.size() + " треугольников");
        triangles.forEach(System.out::println);

        conn.close();
    }

    public static ArrayList<Tr> loadTriangle(Connection conn) throws SQLException {
        ArrayList<Tr> triangles = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.\"Triangle\"");
        double a, b, c;
        while (rs.next()) {
            int x = rs.getInt("id");
            a = rs.getDouble("a");
            b = rs.getDouble("b");
            c = rs.getDouble("c");
            double sum = a + b + c;
            System.out.println("получена строка: " + c + " " + a + " " + b);
            System.out.println(sum);
            triangles.add(new Tr(a,b,c));
        }
        rs.close();
        st.close();
        return triangles;
    }

    private static void example1() throws SQLException {
        ArrayList<Tr> triangles = new ArrayList<>();
        Connection conn = connectToDB();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM public.\"Triangle\"");
        double a, b, c;
        while (rs.next()) {
            int x = rs.getInt("id");
            a = rs.getDouble("a");
            b = rs.getDouble("b");
            c = rs.getDouble("c");
            double sum = a + b + c;
            System.out.println("получена строка: " + c + " " + a + " " + b);
            System.out.println(sum);
            triangles.add(new Tr(a,b,c));
        }

        rs.close();
        st.close();
        conn.close();


    }

    public static void example0() {
        String url = "jdbc:postgresql://10.10.104.136:5432/test4";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("удалось подключиться к БД test4");
            conn.close();
        } catch (SQLException e) {
            System.out.println("все пропало");
            e.printStackTrace();
        }
    }

    public static Connection connectToDB() {
        String url = "jdbc:postgresql://10.10.104.136:5432/Geometry";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        props.setProperty("ssl", "false");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        } catch (SQLException e) {
            System.out.println("все пропало");
            e.printStackTrace();
            return null;
        }
    }
}