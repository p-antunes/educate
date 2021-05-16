package dai.educate.model.Create;

public class CreateSuggestion {

    private String title;
    private String suggestion;

    public CreateSuggestion(String title, String suggestion) {
        this.title = title;
        this.suggestion = suggestion;
    }

    public CreateSuggestion() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
