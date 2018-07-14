package calculate;
//��ʾ��
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public void display(String title , String message){
    Stage window = new Stage();
    window.setTitle(title);
    //modalityҪʹ��Modality.APPLICATION_MODEL
    window.initModality(Modality.APPLICATION_MODAL);
    //���ô��ڴ�С
    window.setMinWidth(300);
    window.setMinHeight(150);
    //����رմ��ڵİ�ť
    Button button = new Button("�رմ���");
    button.setOnAction(e -> window.close());
    //����label�����������ֵ
    Label label = new Label(message);
    VBox layout = new VBox(10);
    //��layout�����label ��  button��ť
    layout.getChildren().addAll(label , button);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    //ʹ��showAndWait()�ȴ���������ڣ������������main�е��Ǹ����ڲ�����Ӧ
    window.showAndWait();
    }
}
