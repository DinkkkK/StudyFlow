public class Assignment {
    private String title;
    private String givenDate;
    private String dueDate;

    public Assignment(String title, String givenDate, String dueDate){
        this.title = title;
        this.givenDate = givenDate;
        this.dueDate = dueDate;
    }
    public String getTitle(){
        return this.title;
    }

    public String getGivenDate(){
        return this.givenDate;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGivenDate(String givenDate){
        this.givenDate = givenDate ;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
}

