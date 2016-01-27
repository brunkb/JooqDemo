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

        Map dbCreds = [
         userName : "test",
         password : "test",
         url : "jdbc:mysql://localhost:3306/jooq_demo"]

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try {
//            GenerationTool.main("/Users/brunkb/IdeaProjects/JooqDemo/src/main/resources/library.xml")

            Connection conn = DriverManager.getConnection(dbCreds.url, dbCreds.userName, dbCreds.password)
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL)

//            create.insertInto(Book.BOOK)
//                    .set(Book.BOOK.ID, 5)
//                    .set(Book.BOOK.AUTHOR_ID, 1)
//                    .set(Book.BOOK.TITLE, "The Idiot's Guide to Programming")
//                    .execute()




//            Map insertTest = [(Book.BOOK.ID): 6,
//                              (Book.BOOK.AUTHOR_ID): 2,
//                              (Book.BOOK.TITLE): "Learn JOOQ in 24 Hours"]

//            create.insertInto(Book.BOOK).set(insertTest).execute()

//
//            create.update(Author.AUTHOR)
//                    .set(Author.AUTHOR.FIRST_NAME, "Ezra")
//                    .set(Author.AUTHOR.LAST_NAME, "Bridger")
//                    .where(Author.AUTHOR.ID.equal(3))
//                    .execute()

            create.update(Book.BOOK)
                    .set(Book.BOOK.TITLE, "A Brief Introduction to JOOQ")
                    .where(Book.BOOK.ID.equal(2))
                    .execute()

            //JdbcExample.jdbcInsert(dbCreds)
            //JdbcExample.jdbcSelect(dbCreds)
            //JdbcExample.jdbcUpdate(dbCreds, "Using JOOQ", 7)



            //Result<Record> result = create.select().from(Book.BOOK).fetch()
            //println result

            Result<Record> authors = create.select().from(Author.AUTHOR).fetch()
            //println authors

            def result = create.select()
                    .from(Author.AUTHOR.join(Book.BOOK)
                    .on(Book.BOOK.AUTHOR_ID.equal(Author.AUTHOR.ID)))
                    .fetch()

            println result

            println "Success!"

        }

        catch (any) {
            System.err.println "Something went wrong!"
            any.printStackTrace()
        }
    }

}