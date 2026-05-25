package com.example.practice.system_design.java9_14example.string_example;

public class StringEaxmple2 {

    public static void main(String[] args) {
        var name  = "Alice";
        var age   = 30;
        var email = "alice@example.com";

        // Text block — no escaping, clean indentation
        var json = """
                {
                  "name":  "%s",
                  "age":   %d,
                  "email": "%s"
                }
                """.formatted(name, age, email);
        System.out.println(json);

        // SQL query — exactly as you'd write it
        var sql = """
                SELECT u.id, u.name, o.total
                FROM   users u
                JOIN   orders o ON u.id = o.user_id
                WHERE  u.active = true
                ORDER  BY o.total DESC
                """;
        System.out.println(sql);
    }
}
