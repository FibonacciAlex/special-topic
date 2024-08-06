import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Shanco Zhao
 * @StudentID 24013122
 */
public class Main {

    // course data
    protected static List<Course> COURSES = new ArrayList<>();

    //lecturers data
    protected static Map<String, Lecturer> LECTURES = new HashMap<>();

    //lecture and course data, key=LectureID,value=<DeliverType, course>
    protected static Map<String, Map<DeliverType,Course>> courseMatchData = new HashMap<>();

    // Initial data
    static {
        COURSES.add(new Course(
                "158100","Information Technology Principles","IT, IS",70,30,0));
        COURSES.add(new Course(
                "158120","Web-based IT Fundamentals","IT, IS",60,40,0));
        COURSES.add(new Course(
                "159101","Applied Programming ","IT, IS, CS, DS, SE",50,50,0));
        COURSES.add(new Course(
                "159201","Algorithms and Data Structures","CS, DS, SE, IS",40,20,40));
        COURSES.add(new Course(
                "159234","Object-Oriented Programming","CS, SE",50,10,40));
        COURSES.add(new Course(
                "158337","Database Development","IT, SE, DS",60,0,40));
        COURSES.add(new Course(
                "158345","Professionalism in the Information Sciences","IT, IS, CS, DS, SE",100,0,0));

        LECTURES.put("1105236", new Lecturer("1105236","Amy","Sheffield","PN      "));
        LECTURES.put("1235894", new Lecturer("1235894","Victoria","Jensen","PN      "));
        LECTURES.put("7225669", new Lecturer("7225669","James","Lee","PN      "));
        LECTURES.put("1328991", new Lecturer("1328991","Colin","Delmont","PN      "));
        LECTURES.put("1562347", new Lecturer("1562347","Thomas","Becker","Auckland"));
        LECTURES.put("5664789", new Lecturer("5664789","Steven","Hobbs","Auckland"));
        LECTURES.put("3658947", new Lecturer("3658947","Andrew","Jackson","Auckland"));
        LECTURES.put("6332698", new Lecturer("6332698","Jonathon","Wood","Auckland"));
        LECTURES.put("12345678", new Lecturer("12345678","Mickey","Mouse","Auckland"));
        LECTURES.put("24013122", new Lecturer("24013122","Shance","Zhao","Auckland"));
    }
    public static void main(String[] args){
        // System init
        List<AbsTask> list = initSystem();
        list.forEach(i->{
            i.run();
        });
    }

    public static List<AbsTask> initSystem(){
        List<AbsTask> tasks = new ArrayList<>();
        tasks.add(new Task1("School Full Name: School of Mathematical and Computational Sciences"));
        tasks.add(new Task2("All papers details"));
        tasks.add(new Task3(Major.CS, "Papers that belong to Major CS"));
        tasks.add(new Task4("Paper that have exam"));
        tasks.add(new Task5("Papers that their assignments weight higher than 50.0%"));
        tasks.add(new Task6("Paper offering details"));
        tasks.add(new Task7("24013122","The paper offering that I teach"));
        tasks.add(new Task8("159234","The lecturer of Auckland offering of 159234"));
        return tasks;
    }

    public static String formatMajor2Str(List<Major> majors){
        StringBuilder ms = new StringBuilder("(");
        majors.stream().forEach(i->ms.append(i).append(" "));
        ms.append(")");
        return ms.toString();
    }
}

/**
 * Course Structure definition
 */
class Course{

    private String number;
    private String courseName;
    private List<Major> majors;
    private int assignments;
    private int tests;
    private int exam;

    public Course(String number, String courseName, String majors, int assignments, int tests, int exam) {
        this.number = number;
        this.courseName = courseName;
        this.majors = Major.formatMajors(majors);
        this.assignments = assignments;
        this.tests = tests;
        this.exam = exam;
    }

    public String getNumber() {
        return number;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public int getAssignments() {
        return assignments;
    }

    public int getTests() {
        return tests;
    }

    public int getExam() {
        return exam;
    }

    @Override
    public String toString() {
        return number +" " + courseName+ " "+Main.formatMajor2Str(majors);
    }

    public String toString2(){
        return "Paper - "+number +" " + courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(number, course.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

/**
 * Majors enum
 */
enum Major{
    IT,
    IS,
    CS,
    DS,
    SE;

    public static List<Major> formatMajors(String majors) {
        List<Major>  majorStr = Arrays.stream(majors.split(","))
                .map(String::trim)
                .map(s -> s.replaceAll("\\s+", ""))
                .map(s->valueOf(s.toUpperCase()))
                .collect(Collectors.toList());
        return majorStr;
    }
}

/**
 * Course Deliver Campus
 */
enum DeliverType{
    DISTANCE,
    CAMPUS;
}

/**
 * Lecturer structure definition
 */
class Lecturer{

    private String id;

    private String firstName;
    private String lastName;
    private String campus;

    public Lecturer(String id, String firstName, String lastName, String campus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.campus = campus;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return firstName+" "+lastName;
    }

    public String getCampus() {
        return campus;
    }
}

/**
 * Define the parameter and behavior of task
 */
abstract class AbsTask{
    int id;

    String taskTitle;

    AbsTask(int id, String title){
        this.id = id;
        this.taskTitle = title;
    }
    protected void info(){
        System.out.println("-------------- Task "+id+"---------------------");
        System.out.println(taskTitle+":");
    }
    abstract void run();
}

class Task1 extends AbsTask {
    Task1(String title) {
        super(1, title);
    }

    @Override
    void run() {
        info();
    }
}

class Task2 extends AbsTask{

    Task2( String title) {
        super(2, title);
    }

    @Override
    void run() {
        info();
        Main.COURSES.stream().forEach(i->{
            System.out.println(i.toString());
        });
    }
}

class Task3 extends AbsTask{

    private Major major;

    Task3(Major major, String title) {
        super(3, title);
        this.major = major;
    }

    @Override
    void run() {
        info();
        List<Course> list = Main.COURSES.stream().filter(i -> i.getMajors().contains(major)).collect(Collectors.toList());
        list.forEach(i->{
            System.out.println(i.toString2());
        });
        System.out.println("Total matching papers in specified Major - "+ major+" :"+ list.size());
    }
}

class Task4 extends AbsTask{

    Task4(String title) {
        super(4, title);
    }

    @Override
    void run() {
        info();
        List<Course> list = Main.COURSES.stream().filter(i -> i.getExam() > 0).collect(Collectors.toList());
        list.forEach(i->{
            System.out.println(i.toString2());
        });
        System.out.println("Total number of papers that have exam: "+ list.size());
    }
}

class Task5 extends AbsTask{

    Task5(String title) {
        super(5, title);
    }

    @Override
    void run() {
        info();
        List<Course> list = Main.COURSES.stream().filter(i -> i.getAssignments() > 50).collect(Collectors.toList());
        list.forEach(i->{
            System.out.println(i.toString2());
        });
        System.out.println("Total number of papers that have assignments weighted more than 50%: "+ list.size());
    }
}

class Task6 extends AbsTask{


    Task6(String title) {
        super(6, title);

    }

    @Override
    void run() {
        info();
        Main.COURSES.forEach(i->{
            List<String> lecturers = Main.LECTURES.keySet().stream().collect(Collectors.toList());

            Random random = new Random();
            for (DeliverType deliverType : DeliverType.values()) {

                while (true) {
                    int index = random.nextInt(lecturers.size());
                    String lid = lecturers.get(index);
                    //check course number of this lecture
                    Map<DeliverType, Course> assignCourses = Main.courseMatchData.get(lid);
                    if (assignCourses == null) {
                        assignCourses = new HashMap<>();
                    }
                    //check this lecture in campus course
                    if (deliverType.equals(DeliverType.CAMPUS) && assignCourses.get(deliverType) != null) {
                        //random again
                        continue;
                    }
                    assignCourses.put(deliverType, i);
                    Main.courseMatchData.put(lid, assignCourses);
                    Lecturer lecturer = Main.LECTURES.get(lid);
                    String dType = "Distance";
                    if(deliverType.equals(DeliverType.CAMPUS)){
                        dType = lecturer.getCampus();
                    }
                    System.out.println(i.getNumber()+" "+ dType + " "+lecturer.getName());

                    if (assignCourses.size() >= 4) {
                        //this lecturer can not accept courses anymore

                        lecturers.remove(index);
                        System.out.println("----------remove lecturer id+"+lid+"----index:"+index+"--remain length+"+lecturers.size());
                    }
                    break;
                }
            }
        });
    }
}


class Task7 extends AbsTask{

    String myID;

    Task7(String myID,String title) {
        super(7, title);
        this.myID = myID;
    }

    @Override
    void run() {
        info();
        Map<DeliverType, Course> map = Main.courseMatchData.get(myID);
        Lecturer lecturer = Main.LECTURES.get(myID);
        if(map!= null){
            map.forEach((deliverType, course) -> {
                String dType = "Distance";
                if(DeliverType.CAMPUS.equals(deliverType)){
                    dType = lecturer.getCampus();
                }
                System.out.println("Paper Offering -  " + course.getCourseName() + "    "+ dType + "    Lecturer: " + lecturer.getName());
            });
            System.out.println("I am teaching "+ map.size()+" paper(s)");
        }
    }
}

class Task8 extends AbsTask{
    private String courseNumber;
    Task8(String courseId, String title) {
        super(8, title);
        this.courseNumber = courseId;
    }

    @Override
    void run() {
        info();
        //use target courseNumber to find in campus teaching lecturer
        String targetLecturerId = "";
        T1:for (String i : Main.courseMatchData.keySet()) {
            Map<DeliverType, Course> map = Main.courseMatchData.get(i);
            for (Map.Entry<DeliverType, Course> entry : map.entrySet()) {
                DeliverType k = entry.getKey();
                Course v = entry.getValue();
                if (v.getNumber().equals(courseNumber) && DeliverType.CAMPUS.equals(k)) {
                    targetLecturerId = i;
                    break T1;
                }
            }
        };

        if(targetLecturerId == ""){
            System.out.println("No lecturer teach "+ courseNumber+ " in campus!");
            return;
        }
        Lecturer lecturer = Main.LECTURES.get(targetLecturerId);
        if(!lecturer.getCampus().equals("Auckland")){
            System.out.println("lecturer "+lecturer.getName()+" teach "+ courseNumber+ "in campus "+ lecturer.getCampus());
            return;
        }
        System.out.println("Lecturer's Name:" + lecturer.getName());
        Map<DeliverType, Course> map = Main.courseMatchData.get(lecturer.getId());
        System.out.println("This lecturer is teaching "+ map.keySet().size()+" paper(s)");
    }
}
