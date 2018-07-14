package calculate;
//�����ڼ�������
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
		primaryStage.setTitle("���ݵ�������");  //���ñ���
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setHgap(10);
        gridpane.setVgap(20);
		gridpane.setPadding(new Insets(25, 25, 25, 25));
		//welcome����
		Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        gridpane.add(scenetitle, 0, 0, 2, 1);
        //ע������1���봫���ı���.txt���ļ�
        Label label_txt = new Label("�봫���ı���.txt���ļ�");
        label_txt.setTextFill(Color.web("#FF0000"));
        gridpane.add(label_txt, 0, 1, 2, 1);
        //ע������2���봫������:  E:\\\\�ҵ��ĵ�\\\\1234.txt  ��ʽ���ļ�·��
        Label label_path = new Label("�봫������:  E:\\\\�ҵ��ĵ�\\\\1234.txt  ��ʽ���ļ�·��");
        label_path.setTextFill(Color.web("#FF0000"));
        gridpane.add(label_path, 0, 2, 2, 1);
        
        gridpane.add(new Label("�����뵼���ļ�·��: "), 0, 3);  //����label
		TextField text = new TextField();  //�����ı���
		text.setPrefColumnCount(25);  //�����ı��򳤶�
		gridpane.add(text, 1, 3);  //����ı���
		gridpane.add(new Label("�����뵼���ļ�·��: "), 0, 4);  //����label
		TextField text_export = new TextField();  //�����ı���
		text.setPrefColumnCount(25);  //�����ı��򳤶�
		gridpane.add(text_export, 1, 4);  //����ı���
		//���尴ť����ӵ�gridpane
		Button cancel = new Button("��  ��");
		Button imp = new Button("��  ��");
		HBox hbBtn = new HBox(20);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().addAll(cancel,imp);
		gridpane.add(hbBtn, 1, 5);
		//��հ�ť�Ĺ���
		cancel.setOnAction((ActionEvent e) -> {
			text.setText(null);
		});
		//������ť�Ĺ���
		imp.setOnAction((ActionEvent e) -> {
			ArrayList<String> sh = new ArrayList<>();  //�������飬�洢sh�ĵ���ֵ������ͬ
			ArrayList<String> dz = new ArrayList<>();
			ArrayList<String> db = new ArrayList<>();
			ArrayList<String> df = new ArrayList<>();
		    String title;  //����title�ַ���
		    String message;  //�����ַ���message
		    String url = text.getText();  //����·��
		    String url_export = text_export.getText();
		    File file = new File(url);  //ͨ��·�������ļ�
		    String filename = "����.txt";
		    File n_f = new File(url_export, filename);
			
			try {
				String encoding="GBK";  //��������ַ���
	            if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ���ڣ����ļ�����
	            	InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ
	                BufferedReader bufferedReader = new BufferedReader(read);
	                String lineTxt = null;  //�����ַ����洢�ı���ÿ�е��ַ���
	                while((lineTxt = bufferedReader.readLine()) != null){
	                    //System.out.println(lineTxt);  //�����Ƿ����ļ�
	                	//��sh��������洢������sh����
	                	//�������к����ַ���Sh����ȡSh��λ��+2�͵�һ��m+1��λ���м���ַ���������ͬ
	                	if(lineTxt.contains("Sh")){
	                		sh.add(lineTxt.substring(lineTxt.indexOf("Sh")+2, lineTxt.indexOf("m")+1));
	                	}
	                	//��dz����洢�����dz����
	                	if(lineTxt.contains("dz")){  
	                		dz.add(lineTxt.substring(lineTxt.indexOf("dz")+2, lineTxt.indexOf("Z")-1));
	                	}
	                	//��db����洢�����dz����
	                	if(lineTxt.contains("Db")){
	                		db.add(lineTxt.substring(lineTxt.indexOf("Db")+2, lineTxt.indexOf("m")+1));
	                	}
	                	//��df����洢�����dz����
	                	if(lineTxt.contains("Df")){
	                		df.add(lineTxt.substring(lineTxt.indexOf("Df")+2, lineTxt.indexOf("Z")-1));
	                	}
	                }
	                //�ر�read��
	                read.close();
	            }
	            //�ļ������ڣ�������ʾ������Ϣ
	            else{
	            	title = "����";  //Ϊtitle��ֵ������ͬ
	            	message = "�Ҳ���ָ���ļ�";  //Ϊmessage��ֵ������ͬ
	            	new AlertBox().display(title, message);  //��title��message��Ϊ��������  �½���AlerBox���������õ�diaplay����������ͬ
	            }
	        //��ȡ�г���������ʾ������Ϣ
	        }catch (Exception w ) {
	        	title = "����";
	        	message = "��ȡ�ļ����ݳ���";
	        	new AlertBox().display(title, message);
	        	//e.printStackTrace();
	        }
			//�жϵ�����������Ŀ�Ƿ���ڲ��
			//���ڲ������:�޿ɵ������ݻ����ĸ�������������Ŀ����
			if(sh.size()==0||dz.size()==0||db.size()==0||df.size()==0||!(sh.size()==dz.size()&&dz.size()==db.size()&&db.size()==df.size()) ){
				title = "����";
	        	message = "����ʧ��,�����ı������Ƿ�����";
	        	new AlertBox().display(title, message);
			}
			//�޲����������
			else{
				int judge = 0; //�ж��Ƿ񵼳��ļ�
				if (n_f.exists()) {
					judge = -1; //δ�ɹ�����
			        // �ļ��Ѿ����ڣ�����ļ��������Ϣ
					title = "����";
		        	message = "�ļ��Ѵ���";
		        	new AlertBox().display(title, message);
			    } else {
			    	judge = 1; //�ɹ�����
			        // �ȴ����ļ����ڵ�Ŀ¼
			        n_f.getParentFile().mkdirs();
			        try {
			            // �������ļ�
			            n_f.createNewFile();
			            BufferedWriter in = new BufferedWriter(new FileWriter(n_f));
			            in.write("sh\t\t\t dz\t\t\t db\t\t\t df\r\n"); // \r\n��Ϊ����  
			            in.flush(); // �ѻ���������ѹ���ļ�  
			            for(int i=0; i<sh.size(); i++){
			            	in.write(sh.get(i) + "\t" + dz.get(i) + "\t" + db.get(i) + "\t" + df.get(i) +"\r\n"); // \r\n��Ϊ����  
				            in.flush(); // �ѻ���������ѹ���ļ�  
			            }
			            in.close(); // ���ǵùر��ļ� 
			        } catch (IOException a) {
			        	title = "����";
			        	message = "�ļ���������";
			        	new AlertBox().display(title, message);
			            //a.printStackTrace();
			        }
			    }
				new DataImport().display(sh, dz, db, df,judge);  //�½�DataImport���󣬽���������sh��dz��db��df�����������봴�������diaplay����
				
			}
			
		});
		
		Scene scene = new Scene(gridpane,800,350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
