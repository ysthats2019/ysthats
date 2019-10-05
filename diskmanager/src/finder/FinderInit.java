package finder;


import filesystem.Attribute;
import filesystem.Dentry;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinderInit {


    private TreeItem<Dentry> currentRoot;
    private TreeItem<Dentry> root;
    private FinderFileTree finderFileTree = new FinderFileTree();


    public  void InitRoot(){
        root = new TreeItem<>(new Dentry("root",true,null,null));
        setIconForItem(root);
        currentRoot = root;
        finderFileTree.getFileTree().setRoot(root);
    }

    public void setIconForItem(TreeItem<Dentry> treeItem){
        if (treeItem.getValue().isDir()) {
            treeItem.setGraphic(new ImageView(new Image("icon/folder.png", 15.0D, 15.0D, true, true)));
        } else {
            treeItem.setGraphic(new ImageView(new Image("icon/docs.png", 15.0D, 15.0D, true, true)));
        }
    }

    public void addItemForRoot(TreeItem<Dentry> treeItem){
        currentRoot.getChildren().add(treeItem);
        treeItem.getValue().setFatherDentry(currentRoot.getValue());
        setIconForItem(treeItem);
    }

    public FinderFileTree getFinderFileTree() {
        return finderFileTree;
    }

    public  TreeItem<Dentry> getCurrentRoot() {
        return currentRoot;
    }

    public  void setCurrentRoot(TreeItem<Dentry> currentRoot) {
        this.currentRoot = currentRoot;
    }

}
