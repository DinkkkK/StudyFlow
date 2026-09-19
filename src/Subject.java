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

    public ArrayList<Assignment> getAssignments(){
        return assignments;

    }

    public boolean removeAssignment(String assignmentName) {
        for(int i = 0; i < assignments.size(); i++){
            if(assignments.get(i).getTitle().equalsIgnoreCase(assignmentName)) {
                  assignments.remove(i);
                  return true;
            }
    }
        return false;
}

    public Assignment findAssignment(String assignmentName){
        for (Assignment assignment : assignments) {
            if (assignment.getTitle().equalsIgnoreCase(assignmentName)){
                return assignment;
            }
        }
        return null;
    }

}



