package pandastudios.dotasound.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pandastudios.dotasound.Board
import pandastudios.dotasound.data.DbContract.FavouritesEntry
import pandastudios.dotasound.data.DbContract.RecentsEntry

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "dotasoundboard.db"
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_FAVOURITES_TABLE = ("CREATE TABLE " + FavouritesEntry.TABLE_NAME + " ("
                + FavouritesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FavouritesEntry.COLUMN_BOARD_TITLE + " TEXT NOT NULL,"
                + FavouritesEntry.COLUMN_BOARD_IMAGE + " INTEGER NOT NULL );")


        val SQL_CREATE_RECENTS_TABLE = ("CREATE TABLE " + RecentsEntry.TABLE_NAME + " ("
                + RecentsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + RecentsEntry.COLUMN_BOARD_TITLE + " TEXT NOT NULL,"
                + RecentsEntry.COLUMN_BOARD_IMAGE + " INTEGER NOT NULL,"
                + RecentsEntry.COLUMN_DATE_ADDED + " INTEGER NOT NULL );")

        db.execSQL(SQL_CREATE_FAVOURITES_TABLE)
        db.execSQL(SQL_CREATE_RECENTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${FavouritesEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${RecentsEntry.TABLE_NAME}")
        onCreate(db)
    }

    private fun queryFavourites(): Cursor = readableDatabase.query(FavouritesEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                FavouritesEntry._ID + " DESC")


    fun getFavouritesList(): ArrayList<Board> {
        val favouritesCursor = queryFavourites()
        val list = ArrayList<Board>()

        for (i in 0 until favouritesCursor.count) {
            favouritesCursor.moveToPosition(i)
            list.add(Board(
                    getBoardImageFromFavouritesCursor(favouritesCursor),
                    getBoardTitleFromFavouritesCursor(favouritesCursor)))
        }

        favouritesCursor.close()
        return list
    }

    fun isFavourite(heroKey: String): Boolean {
        var isFavourite = false

        val favouritesCursor = readableDatabase.query(FavouritesEntry.TABLE_NAME,
                null,
                "${FavouritesEntry.COLUMN_BOARD_TITLE}=?",
                arrayOf(heroKey),
                null,
                null,
                null)

        if (favouritesCursor.count > 0)
            isFavourite = true

        favouritesCursor.close()
        return isFavourite
    }

    fun insertFavourite(boardTitle: String, boardImage: Int): Long {
        val contents = ContentValues()
        contents.put(FavouritesEntry.COLUMN_BOARD_TITLE, boardTitle)
        contents.put(FavouritesEntry.COLUMN_BOARD_IMAGE, boardImage)
        return writableDatabase.insert(FavouritesEntry.TABLE_NAME, null, contents)
    }

    fun deleteFavourite(heroKey: String): Int = writableDatabase.delete(FavouritesEntry.TABLE_NAME,
             "${FavouritesEntry.COLUMN_BOARD_TITLE}=?", arrayOf(heroKey))

    private fun queryRecents(): Cursor = readableDatabase.query(RecentsEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            RecentsEntry.COLUMN_DATE_ADDED + " DESC")

    fun getRecentsList(): ArrayList<Board> {
        val recentsCursor = queryRecents()
        val list = ArrayList<Board>()

        for (i in 0 until recentsCursor.count) {
            recentsCursor.moveToPosition(i)
            list.add(Board(
                    getBoardImageFromRecentsCursor(recentsCursor),
                    getBoardTitleFromRecentsCursor(recentsCursor)))
        }

        recentsCursor.close()
        return list
    }

    private fun queryRecentByTitle(boardTitle: String): Cursor = readableDatabase.query(RecentsEntry.TABLE_NAME,
            null,
            "${RecentsEntry.COLUMN_BOARD_TITLE}=?",
            arrayOf(boardTitle),
            null,
            null,
            null)



    fun insertRecent(boardTitle: String, boardImage: Int) {
        val contents = ContentValues()
        contents.put(RecentsEntry.COLUMN_BOARD_TITLE, boardTitle)
        contents.put(RecentsEntry.COLUMN_BOARD_IMAGE, boardImage)
        contents.put(RecentsEntry.COLUMN_DATE_ADDED, System.currentTimeMillis())

        // First check that the board title isn't in the table already, else just update it
        val cursor = queryRecentByTitle(boardTitle)
        if (cursor.count > 0)
            writableDatabase.update(RecentsEntry.TABLE_NAME, contents,
                    "${RecentsEntry.COLUMN_BOARD_TITLE}=?", arrayOf(boardTitle))
        else writableDatabase.insert(RecentsEntry.TABLE_NAME, null, contents)
    }

    fun deleteOldRecents() {
        val maxSize = 20
        val recentsCursor = queryRecents()
        val list = ArrayList<String>()

        (0 until recentsCursor.count)
                .filter { it > maxSize }
                .forEach { list.add(Integer.toString(recentsCursor.getInt(recentsCursor.getColumnIndex(RecentsEntry._ID)))) }

        recentsCursor.close()
        writableDatabase.delete(RecentsEntry.TABLE_NAME, "_ID=?", list.toTypedArray())
    }



    private fun getBoardTitleFromFavouritesCursor(c: Cursor): String = c.getString(c.getColumnIndex(FavouritesEntry.COLUMN_BOARD_TITLE))
    private fun getBoardImageFromFavouritesCursor(c: Cursor): Int = c.getInt(c.getColumnIndex(FavouritesEntry.COLUMN_BOARD_IMAGE))

    private fun getBoardTitleFromRecentsCursor(c: Cursor): String = c.getString(c.getColumnIndex(RecentsEntry.COLUMN_BOARD_TITLE))
    private fun getBoardImageFromRecentsCursor(c: Cursor): Int = c.getInt(c.getColumnIndex(RecentsEntry.COLUMN_BOARD_IMAGE))

}
