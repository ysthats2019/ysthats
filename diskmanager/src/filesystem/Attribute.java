package filesystem;

public class Attribute {
    private String type;
    private int attrValue;
    private int startnum;
    private int length;
    private Dentry dentry;
    private int fatherstartnum;

    public Attribute(String type, int attrValue, int startnum, int length, Dentry dentry, int fatherstartnum) {
        this.type = type;
        this.attrValue = attrValue;
        this.startnum = startnum;
        this.length = length;
        this.dentry = dentry;
        this.fatherstartnum = fatherstartnum;
    }

    public String getType() {
      return this.type;
    }

    public int getattrValue() {
      return this.attrValue;
    }

    public int getstartnum() {
      return this.startnum;
    }

    public int getlength() {
      return this.length;
    }

    public Dentry getDentry() {
      return this.dentry;
    }

    public int getFatherStartnum() {
      return this.fatherstartnum;
    }

    public void setFatherStartnum(int fatherstartnum) {
      this.fatherstartnum = fatherstartnum;
    }

    public boolean isDir() {
      return (this.attrValue & 0x8) == 8;
    }
    public boolean isNormalFile() {
      return (this.attrValue & 0x4) == 4;
    }

    public boolean isSystemFile() {
      return (this.attrValue & 0x2) == 2;
    }

    public boolean isOnlyRead() {
      return (this.attrValue & 0x1) == 1;
    }

    public static int check(final boolean isDir, final boolean isNormalFile, final boolean isSystemFile, final boolean isOnlyRead) {
        int check = 0;
        if (isDir) {
            check += 8;
        }
        if (isNormalFile) {
            check += 4;
        }
        if (isSystemFile) {
            check += 2;
        }
        if (isOnlyRead) {
            ++check;
        }
        return check;
    }

    public void attrValuechange(final boolean isNormalFile, final boolean isSystemFile, final boolean isOnlyRead) {
        this.attrValue = check(this.isDir(), isNormalFile, isSystemFile, isOnlyRead);
    }

}
