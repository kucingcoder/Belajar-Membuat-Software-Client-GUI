package View;

import Controller.ConnectURI;
import Model.ResponseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class Gui {
    private JPanel MainPanel;
    private JButton Submit;
    private JTextField Messagebox;
    private JTextField Statusbox;
    private JTextField Commentbox;
    private JButton Exit;
    private JPanel FormPanel;
    private JPanel ExitPanel;
    private JButton Minimazebtn;
    private JPanel HeaderPanel;

    public Gui() {
        HeaderPanel.setBackground(Color.GRAY);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                Messagebox.setText("");
                Statusbox.setText("");
                Commentbox.setText("");
                try {
                    ConnectURI koneksiku = new ConnectURI();
                    URL myAddress = koneksiku.buildURL("https://harber.mimoapps.xyz/api/getaccess.php/");
                    String responese = koneksiku.getResponseFromHttpUrl(myAddress);

                    JSONArray responeseJSON = new JSONArray(responese);
                    ArrayList<ResponseModel> DaftarResponseModel = new ArrayList<>();
                    for(int i = 0; i < responeseJSON.length(); i++){
                        ResponseModel resModel = new ResponseModel();
                        JSONObject myJSONObject = responeseJSON.getJSONObject(i);
                        resModel.set_message(myJSONObject.getString("message"));
                        resModel.set_status(myJSONObject.getString("status"));
                        resModel.set_comment(myJSONObject.getString("comment"));
                        DaftarResponseModel.add(resModel);
                    }
                    for (ResponseModel respon : DaftarResponseModel){
                        Messagebox.setText(respon.get_message());
                        Statusbox.setText(respon.get_status());
                        Commentbox.setText(respon.get_comment());
                    }

                    JOptionPane.showMessageDialog(new JFrame(), "Berhasil Mengambil Data", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception error){
                    JOptionPane.showMessageDialog(new JFrame(), error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                MainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        HeaderPanel.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Submit.requestFocus();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
    }

    public JPanel get_content(){
        return MainPanel;
    }

    public JButton get_minimze_btn(){
        return Minimazebtn;
    }
}
