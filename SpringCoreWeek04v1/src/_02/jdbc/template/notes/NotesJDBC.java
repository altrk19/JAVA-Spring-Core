package _02.jdbc.template.notes;

public class NotesJDBC {

}

//jdbc template daha basit.

// JDBCTemplate yaklasiminda ; ek olarak Spring e ait
// org.springframework.jdbc.core.JdbcTemplate sinifini kullaniyoruz.
// DataSource objesini, constructor injection yaklasimi ile JdbcTemplate
// objesine veriyoruz.
// Boylece daha pratik sekilde sql islemlerini yapabiliriz.

// --------------------------
// JPA yaklasimi icin ;

// 1 - spring tarafinda , spring-orm dependency tanimini eklememiz gereklidir!
// spring-orm dependency , zaten spring-jdbc dependency sine ihtiyac duyar.yani
// bu jar'i ekler. spring-orm dependency tanimini ekledigimizde ek olarak
// spring-jdbcye gerek yoktur.

// 2 - ilgili JPA implemantasyonu icin dependency ekledik. (eclipseLink olabilir)
// ya da Native Hibernate depdency i olabilir.