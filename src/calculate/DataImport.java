package calculate;
//���������
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
	    window.setTitle("���ݵ�����");
	    
	    //modalityҪʹ��Modality.APPLICATION_MODEL
	    window.initModality(Modality.APPLICATION_MODAL);
	    //���崰���С
	    window.setMinWidth(1000);
	    window.setMinHeight(400);
	    //����رմ��ڵİ�ť
	    Button button = new Button("�رմ���");
	    button.setOnAction(e -> window.close());  //�رմ��ڵĹ���
	    
	    GridPane pane = new GridPane();
	    pane.setHgap(10);
        pane.setVgap(20);
        
        if(j == -1){
        	Label label_txt = new Label("����ʧ�ܣ�");
        	label_txt.setTextFill(Color.web("#FF0000"));
            pane.add(label_txt, 0, 0, 2, 1);
        }
        if(j == 1){
        	Label label_txt = new Label("�����ɹ���");
        	label_txt.setTextFill(Color.web("#FF0000"));
            pane.add(label_txt, 0, 0, 2, 1);
        }
        
	    //�������������
	    for(int i=0; i<a.size(); i++){
	    	//�����i��sh
	    	pane.add(new Label("sh: "),0 , i+1);  //����label����۵�pane��
			TextField text_sh = new TextField();  //�����ı���
			text_sh.setText(a.get(i));  //Ϊ�ı���ֵ
			text_sh.setPrefColumnCount(10);  //�����ı����С
			text_sh.setEditable(false);  //�����ı����ֹ�޸�����
			pane.add(text_sh, 1, i+1);  //��pane������ı���
			//�����i��dz
			pane.add(new Label("dz: "),3, i+1);  //ͬ��
			TextField text_dz = new TextField();  //
			text_dz.setText(b.get(i));
			text_dz.setPrefColumnCount(10);
			text_dz.setEditable(false);
			pane.add(text_dz, 4, i+1);
			//�����i��db
			pane.add(new Label("db: "),6, i+1);  //ͬ��
			TextField text_db = new TextField();  //
			text_db.setText(c.get(i));
			text_db.setPrefColumnCount(10);
			text_db.setEditable(false);
			pane.add(text_db, 7, i+1);
			//�����i��df
			pane.add(new Label("df: "),9, i+1);  //ͬ��
			TextField text_df = new TextField();  //
			text_df.setText(c.get(i));
			text_df.setPrefColumnCount(10);
			text_df.setEditable(false);
			pane.add(text_df, 10, i+1);
			
	    }
	    //��pane����ӹرմ��ڵİ�ť
	    pane.add(button, 5, a.size()+1,3,1);
	    pane.setAlignment(Pos.CENTER);

	    Scene scene = new Scene(pane);
	    window.setScene(scene);
	    //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
	    window.showAndWait();
	    }

}
