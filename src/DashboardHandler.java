public class DashboardHandler {

    private SubjectList subs;

    public DashboardHandler(SubjectList subs){
        this.subs = subs;
    }

    public void handleDashboard(){
        System.out.println("Current Subjects:");
        int numberOfSubjects = subs.countSubjects();
        System.out.println(numberOfSubjects);
        System.out.println("Assignments");
        System.out.println();
        System.out.println("Coming Soon");
        System.out.println();
        System.out.println("Study Planner");
        System.out.println();
        System.out.println("Coming Soon");
    }
}
