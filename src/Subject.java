import java.util.ArrayList;
public class Subject {
    private String subjectName;
    private String subjectCode;
    private int credits;
    private ArrayList<Assignment> assignments = new ArrayList<>();

    public Subject(String subjectName, String subjectCode, int credits) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.credits = credits;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    public String getSubjectCode(){
        return this.subjectCode;
    }
    public int getCredits(){
        return this.credits;
    }

    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
    }

    public void displayAssignment(){
        for(int i = 0; i < assignments.size(); i++){
            System.out.println(assignments.get(i).getTitle() + " | " +
                               assignments.get(i).getGivenDate() + " | " +
                               assignments.get(i).getDueDate());
        }
    }


}


