/**
 * This class is generated by jOOQ
 */
package test.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import test.jooq.JooqDemo;
import test.jooq.Keys;
import test.jooq.tables.records.BookRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book extends TableImpl<BookRecord> {

	private static final long serialVersionUID = -1611071056;

	/**
	 * The reference instance of <code>jooq_demo.Book</code>
	 */
	public static final Book BOOK = new Book();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<BookRecord> getRecordType() {
		return BookRecord.class;
	}

	/**
	 * The column <code>jooq_demo.Book.id</code>.
	 */
	public final TableField<BookRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>jooq_demo.Book.title</code>.
	 */
	public final TableField<BookRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(200).nullable(false), this, "");

	/**
	 * The column <code>jooq_demo.Book.author_id</code>.
	 */
	public final TableField<BookRecord, Integer> AUTHOR_ID = createField("author_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>jooq_demo.Book</code> table reference
	 */
	public Book() {
		this("Book", null);
	}

	/**
	 * Create an aliased <code>jooq_demo.Book</code> table reference
	 */
	public Book(String alias) {
		this(alias, BOOK);
	}

	private Book(String alias, Table<BookRecord> aliased) {
		this(alias, aliased, null);
	}

	private Book(String alias, Table<BookRecord> aliased, Field<?>[] parameters) {
		super(alias, JooqDemo.JOOQ_DEMO, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<BookRecord> getPrimaryKey() {
		return Keys.KEY_BOOK_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<BookRecord>> getKeys() {
		return Arrays.<UniqueKey<BookRecord>>asList(Keys.KEY_BOOK_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book as(String alias) {
		return new Book(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Book rename(String name) {
		return new Book(name, null);
	}
}