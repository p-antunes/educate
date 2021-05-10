package dai.educate.model.Create;

public class CreateReport {

    private String title;
    private String description;

    public CreateReport(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public CreateReport() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
