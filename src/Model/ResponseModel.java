package Model;

public class ResponseModel {
    private String message;
    private String status;
    private String comment;

    public ResponseModel(){}

    public String get_message(){
        return  this.message;
    }

    public String get_status(){
        return  this.status;
    }

    public String get_comment(){
        return  this.comment;
    }

    public void set_message(String pesan){
        this.message = pesan;
    }

    public void set_status(String status_respon){
        this.status = status_respon;
    }

    public void set_comment(String comment_respon){
        this.comment = comment_respon;
    }
}