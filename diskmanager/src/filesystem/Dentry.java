package filesystem;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.TreeMap;

public class Dentry {
	private String name;
	private boolean isDir;
	private Attribute attr;
	private Dentry fatherdentry;
    private TreeItem<Dentry> treeItem;
    private TreeMap<String, Dentry> dirContains = new TreeMap();

    public Dentry(String name, boolean isDir, Attribute attr, Dentry fatherdentry) {
	this.name = name;
	this.attr = attr;
	this.fatherdentry = fatherdentry;
	this.isDir = isDir;
    }

    public TreeItem<Dentry> getTreeItem() {
            return this.treeItem;
    }

    public String getname() {
      return this.name;
    }

    public void setname(String name) {
      this.name = name;
    }

    public boolean isDir() {
      return this.isDir;
    }

    public Attribute getattr() {
        return this.attr;
    }

    public void setFatherDentry(Dentry fatherdentry) {
        this.fatherdentry = fatherdentry;
    }

    public Dentry getFatherDentry() {
        return this.fatherdentry;
    }

    public String getAbsolutePath() {
        if (this.fatherdentry == null) {
            return this.name;
        }
        if (this.isDir) {
            return this.fatherdentry.getAbsolutePath() + "/" + this.name;
        }
        return this.fatherdentry.getAbsolutePath();
    }
    public String toString() {
        return this.name;
    }

}


