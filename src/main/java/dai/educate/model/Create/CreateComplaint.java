package dai.educate.model.Create;

public class CreateComplaint {

    private String title;
    private String complaint;

    public CreateComplaint(String title, String complaint) {
        this.title = title;
        this.complaint = complaint;
    }

    public CreateComplaint() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
