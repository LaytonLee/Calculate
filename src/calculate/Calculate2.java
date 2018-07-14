package calculate;
//主窗口及主功能
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileWriter;  
import java.io.IOException; 
import java.util.ArrayList;
import javafx.scene.paint.Color;  


public class Calculate2 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage){
		GridPane gridpane = new GridPane();
		primaryStage.setTitle("数据导出助手");  //设置标题
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setHgap(10);
        gridpane.setVgap(20);
		gridpane.setPadding(new Insets(25, 25, 25, 25));
		//welcome标题
		Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        gridpane.add(scenetitle, 0, 0, 2, 1);
        //注意事项1：请传入文本（.txt）文件
        Label label_txt = new Label("请传入文本（.txt）文件");
        label_txt.setTextFill(Color.web("#FF0000"));
        gridpane.add(label_txt, 0, 1, 2, 1);
        //注意事项2：请传入例如:  E:\\\\我的文档\\\\1234.txt  格式的文件路径
        Label label_path = new Label("请传入例如:  E:\\\\我的文档\\\\1234.txt  格式的文件路径");
        label_path.setTextFill(Color.web("#FF0000"));
        gridpane.add(label_path, 0, 2, 2, 1);
        
        gridpane.add(new Label("请输入导入文件路径: "), 0, 3);  //设置label
		TextField text = new TextField();  //设置文本框
		text.setPrefColumnCount(25);  //设置文本框长度
		gridpane.add(text, 1, 3);  //添加文本框
		gridpane.add(new Label("请输入导出文件路径: "), 0, 4);  //设置label
		TextField text_export = new TextField();  //设置文本框
		text.setPrefColumnCount(25);  //设置文本框长度
		gridpane.add(text_export, 1, 4);  //添加文本框
		//定义按钮并添加到gridpane
		Button cancel = new Button("清  空");
		Button imp = new Button("导  出");
		HBox hbBtn = new HBox(20);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().addAll(cancel,imp);
		gridpane.add(hbBtn, 1, 5);
		//清空按钮的功能
		cancel.setOnAction((ActionEvent e) -> {
			text.setText(null);
		});
		//导出按钮的功能
		imp.setOnAction((ActionEvent e) -> {
			ArrayList<String> sh = new ArrayList<>();  //链表数组，存储sh的导出值，以下同
			ArrayList<String> dz = new ArrayList<>();
			ArrayList<String> db = new ArrayList<>();
			ArrayList<String> df = new ArrayList<>();
		    String title;  //定义title字符串
		    String message;  //定义字符串message
		    String url = text.getText();  //传入路径
		    String url_export = text_export.getText();
		    File file = new File(url);  //通过路径导入文件
		    String filename = "导出.txt";
		    File n_f = new File(url_export, filename);
			
			try {
				String encoding="GBK";  //定义编码字符集
	            if(file.isFile() && file.exists()){ //判断文件是否存在，若文件存在
	            	InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
	                BufferedReader bufferedReader = new BufferedReader(read);
	                String lineTxt = null;  //定义字符串存储文本中每行的字符串
	                while((lineTxt = bufferedReader.readLine()) != null){
	                    //System.out.println(lineTxt);  //测试是否导入文件
	                	//向sh数组链表存储导出的sh数据
	                	//若此行中含有字符串Sh，截取Sh的位置+2和第一个m+1的位置中间的字符串；以下同
	                	if(lineTxt.contains("Sh")){
	                		sh.add(lineTxt.substring(lineTxt.indexOf("Sh")+2, lineTxt.indexOf("m")+1));
	                	}
	                	//向dz数组存储导入的dz数据
	                	if(lineTxt.contains("dz")){  
	                		dz.add(lineTxt.substring(lineTxt.indexOf("dz")+2, lineTxt.indexOf("Z")-1));
	                	}
	                	//向db数组存储导入的dz数据
	                	if(lineTxt.contains("Db")){
	                		db.add(lineTxt.substring(lineTxt.indexOf("Db")+2, lineTxt.indexOf("m")+1));
	                	}
	                	//向df数组存储导入的dz数据
	                	if(lineTxt.contains("Df")){
	                		df.add(lineTxt.substring(lineTxt.indexOf("Df")+2, lineTxt.indexOf("Z")-1));
	                	}
	                }
	                //关闭read流
	                read.close();
	            }
	            //文件不存在，报错，显示错误信息
	            else{
	            	title = "警告";  //为title赋值，以下同
	            	message = "找不到指定文件";  //为message赋值，以下同
	            	new AlertBox().display(title, message);  //将title，message作为参数传入  新建的AlerBox对象所调用的diaplay方法，以下同
	            }
	        //读取中出错，报错，显示错误信息
	        }catch (Exception w ) {
	        	title = "警告";
	        	message = "读取文件内容出错";
	        	new AlertBox().display(title, message);
	        	//e.printStackTrace();
	        }
			//判断导出的数据数目是否存在差错
			//存在差错，报错:无可导出数据或者四个导出数据项数目不等
			if(sh.size()==0||dz.size()==0||db.size()==0||df.size()==0||!(sh.size()==dz.size()&&dz.size()==db.size()&&db.size()==df.size()) ){
				title = "警告";
	        	message = "查找失败,请检查文本数据是否有误";
	        	new AlertBox().display(title, message);
			}
			//无差错，导出数据
			else{
				int judge = 0; //判断是否导出文件
				if (n_f.exists()) {
					judge = -1; //未成功导出
			        // 文件已经存在，输出文件的相关信息
					title = "警告";
		        	message = "文件已存在";
		        	new AlertBox().display(title, message);
			    } else {
			    	judge = 1; //成功导出
			        // 先创建文件所在的目录
			        n_f.getParentFile().mkdirs();
			        try {
			            // 创建新文件
			            n_f.createNewFile();
			            BufferedWriter in = new BufferedWriter(new FileWriter(n_f));
			            in.write("sh\t\t\t dz\t\t\t db\t\t\t df\r\n"); // \r\n即为换行  
			            in.flush(); // 把缓存区内容压入文件  
			            for(int i=0; i<sh.size(); i++){
			            	in.write(sh.get(i) + "\t" + dz.get(i) + "\t" + db.get(i) + "\t" + df.get(i) +"\r\n"); // \r\n即为换行  
				            in.flush(); // 把缓存区内容压入文件  
			            }
			            in.close(); // 最后记得关闭文件 
			        } catch (IOException a) {
			        	title = "警告";
			        	message = "文件导出出错";
			        	new AlertBox().display(title, message);
			            //a.printStackTrace();
			        }
			    }
				new DataImport().display(sh, dz, db, df,judge);  //新建DataImport对象，将数组链表sh，dz，db，df做参数，传入创建对象的diaplay方法
				
			}
			
		});
		
		Scene scene = new Scene(gridpane,800,350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
