package _01.jdbc.notes;

public class NotesJDBC {

}

// 1 - ilgili veritabani icin jar dependency ekleyecegiz.
// 2 - spring in JDBC destegi icin spring-jdbc dependency tanimini ekleyelim.
// 3 - configuration detaylarini properties te dutabiliriz ( jdbc.properties)
// 4 - org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
// sinifi yardimi ile proeprties bilgilerini okyuabiliriz.

// 5 - org.springframework.jdbc.datasource.DriverManagerDataSource ile
// DataSource objesini olusturabiliriz.
// 6 - DAO sinifina DataSource objesini inject ederiz.
// 7 - elimizde artik DataSource objesi var , Connection i alip , jdbc kodu ile
// islerimizi halledebiliriz.

