import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Shance Zhao
 * @StudentID 24013122
 */
public class Main {

    // course data
    protected static List<Course> COURSES = new ArrayList<>();

    //lecturers data
    protected static Map<String, Lecturer> LECTURES = new HashMap<>();

    //lecture and course data, key=LectureID,value=<courseId, Campus>
    protected static Map<String, List<CampusMatchKey>> courseMatchData = new HashMap<>();


    protected static Map<CampusMatchKey, Lecturer> lecturerMatchData = new HashMap<>();

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

        LECTURES.put("1105236", new Lecturer("1105236","Amy","Sheffield",Campus.PN));
        LECTURES.put("1235894", new Lecturer("1235894","Victoria","Jensen",Campus.PN));
        LECTURES.put("7225669", new Lecturer("7225669","James","Lee",Campus.PN));
        LECTURES.put("1328991", new Lecturer("1328991","Colin","Delmont",Campus.PN));
        LECTURES.put("1562347", new Lecturer("1562347","Thomas","Becker",Campus.AUCKLAND));
        LECTURES.put("5664789", new Lecturer("5664789","Steven","Hobbs",Campus.AUCKLAND));
        LECTURES.put("3658947", new Lecturer("3658947","Andrew","Jackson",Campus.AUCKLAND));
        LECTURES.put("6332698", new Lecturer("6332698","Jonathon","Wood",Campus.AUCKLAND));
        LECTURES.put("12345678", new Lecturer("12345678","Mickey","Mouse",Campus.AUCKLAND));
        LECTURES.put("24013122", new Lecturer("24013122","Shance","Zhao",Campus.AUCKLAND));
    }
    public static void main(String[] args){
        // System init
        List<AbsTask> list = initSystem();
        list.forEach(AbsTask::run);
    }

    public static List<AbsTask> initSystem(){
        List<AbsTask> tasks = new ArrayList<>();
        tasks.add(new Task1("School Full Name: School of Mathematical and Computational Sciences"));
        tasks.add(new Task2("All papers details:"));
        tasks.add(new Task3(Major.CS, "Papers that belong to Major CS:"));
        tasks.add(new Task4("Paper that have exam:"));
        tasks.add(new Task5("Papers that their assignments weight higher than 50.0%:"));
        tasks.add(new Task6("Paper offering details:"));
        tasks.add(new Task7("24013122","The paper offering that I teach:"));
        tasks.add(new Task8("159234",Campus.AUCKLAND, "The lecturer of Auckland offering of 159234:"));
        return tasks;
    }

    public static String formatMajor2Str(List<Major> majors){
        StringBuilder ms = new StringBuilder("(");
        majors.forEach(i->ms.append(i).append(" "));
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
enum Campus{
    DISTANCE("Distance"),
    AUCKLAND("Auckland"),
    PN      ("PN      ");

    private final String campusName;

    public String getCampusName() {
        return campusName;
    }

    Campus(String name) {
        campusName = name;
    }

}

/**
 * Lecturer structure definition
 */
class Lecturer{

    private String id;

    private String firstName;
    private String lastName;
    private Campus campus;

    public Lecturer(String id, String firstName, String lastName, Campus campus) {
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

    public Campus getCampus() {
        return campus;
    }
}

/**
 * Course and Campus match Key
 */
class CampusMatchKey{

    private Course course;

    private Campus campus;

    public CampusMatchKey(Course course, Campus campus) {
        this.course = course;
        this.campus = campus;
    }

    public Course getCourse() {
        return course;
    }

    public Campus getCampus() {
        return campus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampusMatchKey that = (CampusMatchKey) o;
        return Objects.equals(course, that.course) && campus == that.campus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, campus);
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
        System.out.println(taskTitle);
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
        Main.COURSES.forEach(i-> System.out.println(i.toString()));
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
        List<Course> list = Main.COURSES.stream().filter(i -> i.getMajors().contains(major)).toList();
        list.forEach(i-> System.out.println(i.toString2()));
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
        List<Course> list = Main.COURSES.stream().filter(i -> i.getExam() > 0).toList();
        list.forEach(i-> System.out.println(i.toString2()));
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
        List<Course> list = Main.COURSES.stream().filter(i -> i.getAssignments() > 50).toList();
        list.forEach(i-> System.out.println(i.toString2()));
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
        List<String> lecturers = new ArrayList<>(Main.LECTURES.keySet());
        Main.COURSES.forEach(i->{
            Random random = new Random();
            for (Campus campus : Campus.values()) {

                while (true) {
                    int index = random.nextInt(lecturers.size());
                    String lid = lecturers.get(index);
                    //check how many courses of this lecturer teaching now
                    List<CampusMatchKey> courseofLecturer = Main.courseMatchData.get(lid);
                    if (courseofLecturer == null) {
                        courseofLecturer = new ArrayList<>();
                    }
                    //check if this is in campus course and match the lecturer's campus
                    Lecturer lecturer = Main.LECTURES.get(lid);
                    if (!campus.equals(Campus.DISTANCE) && !lecturer.getCampus().equals(campus)) {
                        //random again
                        continue;
                    }
                    CampusMatchKey campusMatchKey = new CampusMatchKey(i, campus);
                    courseofLecturer.add(campusMatchKey);

                    //save matching data
                    Main.courseMatchData.put(lid, courseofLecturer);
                    Main.lecturerMatchData.put(campusMatchKey, lecturer);

                    System.out.println(i.getNumber()+" "+ campus.getCampusName() + " "+lecturer.getName());

                    if (courseofLecturer.size() >= 4) {
                        //this lecturer can not accept courses anymore
                        lecturers.remove(index);
//                        System.out.println("----------remove lecturer id+"+lid+"----index:"+index+"--remain length+"+lecturers.size());
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
        List<CampusMatchKey> campusMatchKeys = Main.courseMatchData.get(myID);
        Lecturer lecturer = Main.LECTURES.get(myID);
        if(campusMatchKeys!= null){
            campusMatchKeys.forEach((key) -> System.out.println("Paper Offering -  " + key.getCourse().getCourseName() + "    "+ key.getCampus().getCampusName() + "    Lecturer: " + lecturer.getName()));
            System.out.println("I am teaching "+ campusMatchKeys.size()+" paper(s)");
        }
    }
}

class Task8 extends AbsTask{

    private String courseNumber;

    private Campus campus;

    Task8(String courseId,Campus campus, String title) {
        super(8, title);
        this.courseNumber = courseId;
        this.campus = campus;
    }

    @Override
    void run() {
        info();
        //use target courseNumber to find in campus teaching lecturer
        Optional<Course> optional = Main.COURSES.stream().filter(i -> i.getNumber().equals(courseNumber)).findFirst();
        Course course = optional.orElseThrow();
        Lecturer lecturer = Main.lecturerMatchData.get(new CampusMatchKey(course, campus));
        System.out.println("Lecturer's Name: " + lecturer.getName());
        List<CampusMatchKey> keyList = Main.courseMatchData.get(lecturer.getId());
        System.out.println("This lecturer is teaching "+ keyList.size()+" paper(s)");
    }
}
