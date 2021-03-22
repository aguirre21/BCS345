package simplecalc2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LayoutGUIController {
    private String crntArthOp="DEFAULT";
    private String oprnd1="0";
    
    @FXML
    private TextField txtBox;

    @FXML
    private void addNums(ActionEvent event) {
        Button btn = (Button)event.getSource();
        
        if(btn.getText().equals("0")){
            txtBox.setText(txtBox.getText()+"0");
        }
        else if (btn.getText().equals("1")){
            txtBox.setText(txtBox.getText()+"1");
        }
        else if(btn.getText().equals("2")){
            txtBox.setText(txtBox.getText()+"2");
        }
        else if(btn.getText().equals("3")){
            txtBox.setText(txtBox.getText()+"3");
        }
        else if(btn.getText().equals("4")){
            txtBox.setText(txtBox.getText()+"4");
        }
        else if(btn.getText().equals("5")){
            txtBox.setText(txtBox.getText()+"5");
        }
        else if(btn.getText().equals("6")){
            txtBox.setText(txtBox.getText()+"6");
        }
        else if(btn.getText().equals("7")){
            txtBox.setText(txtBox.getText()+"7");
        }
        else if(btn.getText().equals("8")){
            txtBox.setText(txtBox.getText()+"8");
        }
        else if(btn.getText().equals("9")){
            txtBox.setText(txtBox.getText()+"9");
        }
        
    }

    @FXML
    private void arthmeticOp(ActionEvent event) {
        Button btn = (Button)event.getSource();
        
        if(btn.getText().equals("/")){
            if(crntArthOp.equals("DEFAULT")){
                oprnd1 = txtBox.getText();
                crntArthOp = "DIVIDED";
                txtBox.clear();
            }
        }
        else if(btn.getText().equals("X")){
            if(crntArthOp.equals("DEFAULT")){
                oprnd1 = txtBox.getText();
                crntArthOp = "MULTI";
                txtBox.clear();
            }
        }
        else if(btn.getText().equals("-")){
            if(crntArthOp.equals("DEFAULT")){
                oprnd1 = txtBox.getText();
                crntArthOp = "SUBTRACT";
                txtBox.clear();
            }
        }
        else if(btn.getText().equals("+")) {
            if(crntArthOp.equals("DEFAULT")){
                oprnd1 = txtBox.getText();
                crntArthOp = "ADD";
                txtBox.clear();
            }
        }
    }

    @FXML
    private void prcssResults(ActionEvent event) {
        int int1 = Integer.parseInt(oprnd1);
        int int2 = Integer.parseInt(txtBox.getText());
        if(crntArthOp.equals("DIVIDED")){
            txtBox.setText("" + (int1 / int2));
        }
        else if(crntArthOp.equals("MULTI")){
            txtBox.setText("" + (int1 * int2));
        }
        else if(crntArthOp.equals("SUBTRACT")){
            txtBox.setText("" + (int1 - int2));
        }
        else if(crntArthOp.equals("ADD")) {
            txtBox.setText("" + (int1 + int2));
        }
    }

    @FXML
    private void clrOp(ActionEvent event) {
        Button btn = (Button)event.getSource();
        String oprnd2 = "0";
        
        if(btn.getText().equals("CE")){
            txtBox.clear();
            txtBox.setText("" + oprnd1);
            crntArthOp = "DEFAULT";
        }
        else if(btn.getText().equals("C")){
            txtBox.clear();
            crntArthOp= "DEFAULT";
        }
        else if(btn.getText().equals("Delete")){
            oprnd2 = txtBox.getText();
            
            char[] ch = new char[oprnd2.length()];
            
            for (int i = 0; i < oprnd2.length() - 1; i++){
                ch[i] = oprnd2.charAt(i);
            }
      
            String str = new String(ch);
            txtBox.setText(str);
        }
    }

}
