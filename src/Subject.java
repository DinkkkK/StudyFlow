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

    public ArrayList<Assignment> returnAssignment(){
        return assignments;

    }

    public boolean removeAssignment(String assignment){
        for(int i = 0; i < assignments.size(); i++){
            if(assignments.get(i).getTitle().equalsIgnoreCase(assignment)){
            assignments.remove(i);
            return true;
        }
    }
        return false;
}
}



