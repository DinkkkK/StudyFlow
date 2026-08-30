import java.util.ArrayList;
public class Subject {
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
}

class SubjectList {

    private ArrayList<Subject> subjects = new ArrayList<>();

    public boolean addSubject(Subject subject){
        if(duplicateChecker(subject.getSubjectName())){
            return false;

        }
        subjects.add(subject);
        return true;
    }

    public void displaySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found!");
            return;
        }
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(subjects.get(i).getSubjectName());
        }
    }

    public int countSubjects() {
        int total = subjects.size();
        return total;
    }

    public boolean removeSubject(String s) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getSubjectName().equalsIgnoreCase(s)) {
                subjects.remove(i);
                return true;
            }

        }
        return false;
    }

    public Subject findSubject(String subjectName) {

        for (int i = 0; i < subjects.size(); i++) {
            if (subjectName.equalsIgnoreCase(subjects.get(i).getSubjectName())) {
                return subjects.get(i);
            }
        }
        return null;
    }

    public boolean duplicateChecker(String subjectName) {
        for (Subject subject : subjects) {
            if (subjectName.equalsIgnoreCase(subject.getSubjectName())) {
               return true;
            }
        }
        return false;
    }
}


