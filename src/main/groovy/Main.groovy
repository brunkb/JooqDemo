import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.util.GenerationTool
import test.jooq.tables.Author
import test.jooq.tables.Book

import java.sql.Connection
import java.sql.DriverManager

class Main {

    static void main(String[] args) {

        String userName = "test"
        String password = "test"
        String url = "jdbc:mysql://localhost:3306/jooq_demo"

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try {
//            GenerationTool.main("/Users/brunkb/IdeaProjects/JooqDemo/src/main/resources/library.xml")

            Connection conn = DriverManager.getConnection(url, userName, password)
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL)

            create.insertInto(Book.BOOK)
                    .set(Book.BOOK.ID, 5)
                    .set(Book.BOOK.AUTHOR_ID, 1)
                    .set(Book.BOOK.TITLE, "The Idiot's Guide to Programming")
                    .execute()



            Result<Record> result = create.select().from(Book.BOOK).fetch()
            println result

            println "Success!"

        }

        catch (any) {
            System.err.println "Something went wrong!"
            any.printStackTrace()
        }
    }

}