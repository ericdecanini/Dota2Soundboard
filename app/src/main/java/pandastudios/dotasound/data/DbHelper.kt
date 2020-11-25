package pandastudios.dotasound.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import pandastudios.dotasound.data.DbContract.FavouritesEntry
import pandastudios.dotasound.data.DbContract.RecentsEntry
import pandastudios.dotasound.data.DbContract.LaunchpadsEntry
import android.text.TextUtils
import android.util.Log
import pandastudios.dotasound.*
import pandastudios.dotasound.R.id.name


class DbHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    val LOG_TAG = DbHelper::class.java.simpleName
    val utility = Utility()

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

        val SQL_CREATE_LAUNCHPADS_TABLE = ("CREATE TABLE " + LaunchpadsEntry.TABLE_NAME + " ("
                + LaunchpadsEntry._ID + " INTEGER PRIMARY KEY,"
                + LaunchpadsEntry.COLUMN_NAME + " TEXT NOT NULL,"
                + LaunchpadsEntry.COLUMN_SOUNDURIS + " TEXT NOT NULL,"
                + LaunchpadsEntry.COLUMN_VOLUMES + " TEXT NOT NULL );")

        db.execSQL(SQL_CREATE_FAVOURITES_TABLE)
        db.execSQL(SQL_CREATE_RECENTS_TABLE)
        db.execSQL(SQL_CREATE_LAUNCHPADS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${FavouritesEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${RecentsEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${LaunchpadsEntry.TABLE_NAME}")
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

        cursor.close()
    }

    fun deleteOldRecents() {
        val maxSize = 20
        val recentsCursor = queryRecents()
        val list = ArrayList<String>()

        (0 until recentsCursor.count)
                .filter { it > maxSize }
                .forEach {
                    recentsCursor.moveToPosition(it)
                    list.add(Integer.toString(recentsCursor.getInt(recentsCursor.getColumnIndex(RecentsEntry._ID))))
                }

        recentsCursor.close()

        val args = TextUtils.join(", ", list.toTypedArray())
        writableDatabase.execSQL(String.format("DELETE FROM %s WHERE %s IN (%s);", RecentsEntry.TABLE_NAME, RecentsEntry._ID, args))
    }

    fun queryLaunchpads(): Cursor = readableDatabase.query(LaunchpadsEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null)

    fun getLaunchpadTitles(): Array<String?> {
        val cursor = queryLaunchpads()
        val namesArray = arrayOfNulls<String>(8)

        for (i in 0 until 8) {
            if (i < cursor.count) {
                cursor.moveToPosition(i)
                namesArray[i] = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_NAME))
            } else {
                val name = context.getString(R.string.launchpad_title_default, i + 1)
                namesArray[i] = name
                insertLaunchpad(i, name, utility.generateNullSoundUris(context), utility.generateDefaultSoundVolumes(context))
            }
        }

        cursor.close()
        return namesArray
    }

    fun queryLaunchpadById(id: String): Cursor = readableDatabase.query(LaunchpadsEntry.TABLE_NAME,
            null,
            "${LaunchpadsEntry._ID}=?",
            arrayOf(id),
            null,
            null,
            null)

    fun getLaunchpadById(context: Context, id: Int): Array<LaunchpadButton?> {
        val cursor = queryLaunchpadById(Integer.toString(id))
        val buttonCount = context.resources.getInteger(R.integer.buttonCount)

        // Handle possible errors
        if (cursor.count != 1) {
            Log.i(LOG_TAG, "Launchpad at $id not found: Inserting new launchpad")
            insertLaunchpad(id, context.getString(R.string.launchpad_title_default, id + 1), utility.generateNullSoundUris(context), utility.generateDefaultSoundVolumes(context))
            return arrayOfNulls(buttonCount)
        }
        cursor.moveToFirst()

        // Get the sounds that are saved plus nulls to make 16/32 items
        val loadedSounds = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_SOUNDURIS)).split(",")
        val loadedVolumes = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_VOLUMES)).split(",")
        val sounds = arrayOfNulls<LaunchpadButton?>(buttonCount)

        for (i in 0 until loadedSounds.size) {
            if (loadedSounds[i] != "null")
                sounds[i] = LaunchpadButton(loadedSounds[i], Integer.parseInt(loadedVolumes[i]))
        }

        cursor.close()
        return sounds
    }

    fun getLaunchpadTitle(id: Int): String {
        val cursor = queryLaunchpadById(Integer.toString(id))
        if (cursor.count != 1) {
            Log.e(LOG_TAG, "Error getting launchpad title at $id")
            return ""
        }

        cursor.moveToFirst()
        val title = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_NAME))
        cursor.close()
        return title
    }

    fun updateLaunchpadTitle(id: Int, title: String): Int {
        val cursor = queryLaunchpadById(Integer.toString(id))

        // Check cursor contents
        if (cursor.count != 1) {
            Log.e(LOG_TAG, "Error updating cursor at $id")
            return -1
        }

        // Gather contents
        cursor.moveToFirst()
        val soundUris = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_SOUNDURIS))
        val soundVolumes = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_VOLUMES))
        cursor.close()
        val contents = ContentValues()

        contents.put(LaunchpadsEntry.COLUMN_NAME, title)
        contents.put(LaunchpadsEntry.COLUMN_SOUNDURIS, soundUris)
        contents.put(LaunchpadsEntry.COLUMN_VOLUMES, soundVolumes)

        return writableDatabase.update(LaunchpadsEntry.TABLE_NAME, contents, "${LaunchpadsEntry._ID}=?", arrayOf(id.toString()))
    }

    fun insertLaunchpad(id: Int, name: String, soundUris: String, volumes: String) {
        val contents = ContentValues()
        contents.put(LaunchpadsEntry._ID, id)
        contents.put(LaunchpadsEntry.COLUMN_NAME, name)
        contents.put(LaunchpadsEntry.COLUMN_SOUNDURIS, soundUris)
        contents.put(LaunchpadsEntry.COLUMN_VOLUMES, volumes)

        writableDatabase.insert(LaunchpadsEntry.TABLE_NAME, null, contents)
    }

    fun updateLaunchpad(id: Int, name: String, soundUris: String, volumes: String): Int {
        val contents = ContentValues()
        contents.put(LaunchpadsEntry._ID, id)
        contents.put(LaunchpadsEntry.COLUMN_NAME, name)
        contents.put(LaunchpadsEntry.COLUMN_SOUNDURIS, soundUris)
        contents.put(LaunchpadsEntry.COLUMN_VOLUMES, volumes)

        return writableDatabase.update(LaunchpadsEntry.TABLE_NAME, contents, "${LaunchpadsEntry._ID}=?", arrayOf(id.toString()))
    }

    fun updateLaunchpadButtonVolume(id: Int, position: Int, volume: Int): Int {
        val cursor = queryLaunchpadById(Integer.toString(id))

        // Check cursor contents
        if (cursor.count != 1) {
            Log.e(LOG_TAG, "Error updating cursor at $id")
            return -1
        }

        // Gather contents
        cursor.moveToFirst()
        val title = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_NAME))
        val soundUris = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_SOUNDURIS))
        val soundVolumes = cursor.getString(cursor.getColumnIndex(LaunchpadsEntry.COLUMN_VOLUMES))
        cursor.close()

        // Update the new volume
        val volumesArray = soundVolumes.split(",").toTypedArray()
        volumesArray[position] = Integer.toString(volume)
        val newVolumes = concatenateVolumes(volumesArray)

        // Set up the Content Values
        val contents = ContentValues()
        contents.put(LaunchpadsEntry.COLUMN_NAME, title)
        contents.put(LaunchpadsEntry.COLUMN_SOUNDURIS, soundUris)
        contents.put(LaunchpadsEntry.COLUMN_VOLUMES, newVolumes)

        return writableDatabase.update(LaunchpadsEntry.TABLE_NAME, contents, "${LaunchpadsEntry._ID}=?", arrayOf(id.toString()))
    }

    private fun concatenateVolumes(soundVolumes: Array<String>): String {
        val builder = StringBuilder()
        for (i in 0 until soundVolumes.size) {
            if (i != 0) builder.append(",")

            if (soundVolumes[i] == null) {
                builder.append("5")
            } else {
                builder.append(soundVolumes[i])
            }
        }

        return builder.toString()
    }

    fun deleteLaunchpad(id: Int) {
        writableDatabase.delete(LaunchpadsEntry.TABLE_NAME, "${LaunchpadsEntry._ID}=?", arrayOf(id.toString()))
    }

    private fun getBoardTitleFromFavouritesCursor(c: Cursor): String = c.getString(c.getColumnIndex(FavouritesEntry.COLUMN_BOARD_TITLE))
    private fun getBoardImageFromFavouritesCursor(c: Cursor): Int = c.getInt(c.getColumnIndex(FavouritesEntry.COLUMN_BOARD_IMAGE))

    private fun getBoardTitleFromRecentsCursor(c: Cursor): String = c.getString(c.getColumnIndex(RecentsEntry.COLUMN_BOARD_TITLE))
    private fun getBoardImageFromRecentsCursor(c: Cursor): Int = c.getInt(c.getColumnIndex(RecentsEntry.COLUMN_BOARD_IMAGE))

}
