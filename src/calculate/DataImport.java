package calculate;
//数据输出框
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DataImport {
	public void display(ArrayList<String> a , ArrayList<String> b, ArrayList<String> c, ArrayList<String> d,int j){
	    Stage window = new Stage();
	    window.setTitle("数据导出框");
	    
	    //modality要使用Modality.APPLICATION_MODEL
	    window.initModality(Modality.APPLICATION_MODAL);
	    //定义窗体大小
	    window.setMinWidth(1000);
	    window.setMinHeight(400);
	    //定义关闭窗口的按钮
	    Button button = new Button("关闭窗口");
	    button.setOnAction(e -> window.close());  //关闭窗口的功能
	    
	    GridPane pane = new GridPane();
	    pane.setHgap(10);
        pane.setVgap(20);
        
        if(j == -1){
        	Label label_txt = new Label("导出失败！");
        	label_txt.setTextFill(Color.web("#FF0000"));
            pane.add(label_txt, 0, 0, 2, 1);
        }
        if(j == 1){
        	Label label_txt = new Label("导出成功！");
        	label_txt.setTextFill(Color.web("#FF0000"));
            pane.add(label_txt, 0, 0, 2, 1);
        }
        
	    //输出导出的数据
	    for(int i=0; i<a.size(); i++){
	    	//输出第i个sh
	    	pane.add(new Label("sh: "),0 , i+1);  //设置label并天价到pane中
			TextField text_sh = new TextField();  //设置文本框
			text_sh.setText(a.get(i));  //为文本框赋值
			text_sh.setPrefColumnCount(10);  //设置文本框大小
			text_sh.setEditable(false);  //设置文本框禁止修改属性
			pane.add(text_sh, 1, i+1);  //在pane中添加文本框
			//输出第i个dz
			pane.add(new Label("dz: "),3, i+1);  //同上
			TextField text_dz = new TextField();  //
			text_dz.setText(b.get(i));
			text_dz.setPrefColumnCount(10);
			text_dz.setEditable(false);
			pane.add(text_dz, 4, i+1);
			//输出第i个db
			pane.add(new Label("db: "),6, i+1);  //同上
			TextField text_db = new TextField();  //
			text_db.setText(c.get(i));
			text_db.setPrefColumnCount(10);
			text_db.setEditable(false);
			pane.add(text_db, 7, i+1);
			//输出第i个df
			pane.add(new Label("df: "),9, i+1);  //同上
			TextField text_df = new TextField();  //
			text_df.setText(c.get(i));
			text_df.setPrefColumnCount(10);
			text_df.setEditable(false);
			pane.add(text_df, 10, i+1);
			
	    }
	    //向pane中添加关闭窗口的按钮
	    pane.add(button, 5, a.size()+1,3,1);
	    pane.setAlignment(Pos.CENTER);

	    Scene scene = new Scene(pane);
	    window.setScene(scene);
	    //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
	    window.showAndWait();
	    }

}
