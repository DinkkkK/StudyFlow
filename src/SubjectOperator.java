import java.util.ArrayList;
public class SubjectOperator {

        private ArrayList<Subject> subjects = new ArrayList<>();

        public boolean addSubject(Subject subject){
            if(duplicateChecker(subject)){
                return false;

            }
            subjects.add(subject);
            return true;
        }

        public ArrayList<Subject> returnSubjects() {

            return subjects;
        }



        public int countSubjects() {
            int total = subjects.size();
            return total;
        }

        public boolean removeSubject(String s) {
            for (int i = 0; i < subjects.size(); i++) {
                if (subjects.get(i).getSubjectName().equalsIgnoreCase(s) ||
                        subjects.get(i).getSubjectCode().equalsIgnoreCase(s)){

                    subjects.remove(i);
                    return true;
                }

            }
            return false;
        }

        public Subject findSubject(String subjectIdentifier) {

            for (int i = 0; i < subjects.size(); i++) {
                if (subjectIdentifier.equalsIgnoreCase(subjects.get(i).getSubjectName()) ||
                        subjectIdentifier.equalsIgnoreCase(subjects.get(i).getSubjectCode())){

                    return subjects.get(i);
                }
            }
            return null;
        }

        public boolean duplicateChecker(Subject newSubject) {
            for (Subject subject : subjects) {
                if (newSubject.getSubjectName().equalsIgnoreCase(subject.getSubjectName()) ||
                        newSubject.getSubjectCode().equalsIgnoreCase(subject.getSubjectCode())) {

                    return true;
                }
            }
            return false;
        }
    }


