package _01.jpa.notes;

public class NotesJDBC {

}


// JPA yaklasimi icin ;

// 1 - spring tarafinda , spring-orm dependency tanimini eklememiz gereklidir!
// spring-orm dependency , zaten spring-jdbc dependency sine ihtiyac duyar.yani
// bu jar'i ekler. spring-orm dependency tanimini ekledigimizde ek olarak
// spring-jdbcye gerek yoktur.

// 2 - ilgili JPA implemantasyonu icin dependency ekledik. (eclipseLink olabilir)
// ya da Native Hibernate depdency i olabilir.