package pandastudios.dotasound;

public class SectionOrRow {

    private Board row;
    private String section;
    private boolean isRow;

    public static SectionOrRow createRow(Board row) {
        SectionOrRow ret = new SectionOrRow();
        ret.row = row;
        ret.isRow = true;
        return ret;
    }

    public static SectionOrRow createSection(String section) {
        SectionOrRow ret = new SectionOrRow();
        ret.section = section;
        ret.isRow = false;

        return ret;
    }

    public Board getRow() {
        return row;
    }

    public String getSection() {
        return section;
    }

    public boolean isRow() {
        return isRow;
    }
}
