package pandastudios.dotasound.data;

import android.provider.BaseColumns;

public class DbContract {

    public static final class FavouritesEntry implements BaseColumns {
        public static final String TABLE_NAME = "favourites";
        public static final String COLUMN_BOARD_TITLE = "boardtitle";
        public static final String COLUMN_BOARD_IMAGE = "boardimage";
    }

    public static final class RecentsEntry implements BaseColumns {
        public static final String TABLE_NAME = "recents";
        public static final String COLUMN_BOARD_TITLE = "boardtitle";
        public static final String COLUMN_BOARD_IMAGE = "boardimage";
        public static final String COLUMN_DATE_ADDED = "dateadded";
    }

}
