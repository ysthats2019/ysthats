package finder;

import filesystem.Dentry;
import javafx.scene.control.TreeView;

public class FinderFileTree {
    private final TreeView<Dentry> fileTree;
    private FinderMainWindow finderMainWindow;

    public FinderFileTree(){
        this.finderMainWindow = finderMainWindow;
        //this.fileTree = new TreeView(dentry.getTreeItem());
        this.fileTree = new TreeView();
        this.fileTree.setPrefWidth(150.0D);
        this.fileTree.getSelectionModel().selectFirst();
    }


      public TreeView<Dentry> getFileTree() {
          return this.fileTree;
      }
}
