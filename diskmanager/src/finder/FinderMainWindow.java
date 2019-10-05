package finder;

import filesystem.Attribute;
import filesystem.Dentry;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinderMainWindow extends BorderPane {
    private FlowPane flowPane;
    private FinderFileTree finderFileTree;


    public FinderMainWindow() {
        this.initFlowPane();
        this.initFileTree();
        this.setLeft(this.finderFileTree.getFileTree());
        this.setCenter(this.flowPane);
    }

    private void initFlowPane() {
        this.flowPane = new FlowPane();
        this.flowPane.setPadding(new Insets(1.0D, 1.0D, 1.0D, 1.0D));
        this.flowPane.setVgap(5.0D);
        this.flowPane.setHgap(5.0D);

    }

    private void initFileTree() {
        FinderInit finderInit = new FinderInit();
        finderInit.InitRoot();

        //示例
        TreeItem<Dentry> bin = new TreeItem<>(new Dentry("bin",true,null,null));
        finderInit.addItemForRoot(bin);
        TreeItem<Dentry> file = new TreeItem<>(new Dentry("file",false,null,null));
        finderInit.setCurrentRoot(bin);
        finderInit.addItemForRoot(file);
        TreeItem<Dentry> pwd = new TreeItem<>(new Dentry("pwd",true,null,null));
        finderInit.addItemForRoot(pwd);
        this.finderFileTree = finderInit.getFinderFileTree();

//        //鼠标聚焦
//        finderFileTree.getFileTree().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<Dentry>>() {
//            @Override
//            public void changed(ObservableValue<? extends TreeItem<Dentry>> observable, TreeItem<Dentry> oldValue, TreeItem<Dentry> newValue) {
//                finderInit.setCurrentRoot(newValue);
//                System.out.println(newValue.getValue());
//            }
//        });

    }

    public FlowPane getFlowPane() {
        return this.flowPane;
    }
}
