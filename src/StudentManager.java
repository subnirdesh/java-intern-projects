public class StudentManager {
    private  StudentModel[] students;
    private int studentCount;

    public StudentManager() {
        students = new StudentModel[3];
        studentCount = 0;
    }

    public void addStudent(int id, String name, int age, String email, String course) {
        if (studentCount < students.length) {
            StudentModel studentModel = new StudentModel(id, name, age, email, course);
            students[studentCount] = studentModel;
            studentCount++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Cannot add more students.");

        }
    }

    public void updateStudent(int id, String name, int age, String email, String course) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                students[i].setName(name);
                students[i].setAge(age);
                students[i].setEmail(email);
                students[i].setCourse(course);
                System.out.println("Student updated successfully!");
                break;

            }
        }
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                students[i] = students[studentCount - 1];
                students[studentCount - 1] = null;
                studentCount--;
                System.out.println("Student deleted successfully!");

            }
        }
    }

    public void displayAllStudents() {
        for(int i=0;i<studentCount;i++){
            if(students[i] != null){
                System.out.println( "Id : "+students[i].getId());
                System.out.println( "Name : "+students[i].getName());
                System.out.println( "Age : "+students[i].getAge());
                System.out.println( "Email : "+students[i].getEmail());
                System.out.println( "Course: "+students[i].getCourse());
                for(int j=0; j<15; j++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void displaySpecificStudent (int id){
        for(int i =0; i<studentCount; i++){
            if(id==students[i].getId()){
                System.out.println( "Id : " +students[i].getId());
                System.out.println( "Name : "+students[i].getName());
                System.out.println( "Age : "+students[i].getAge());
                System.out.println( "Email : "+students[i].getEmail());
                System.out.println( "Course: "+students[i].getCourse());
            }

        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(1, "Sanjay Sharma", 20, "sanjay.sharma@email.com", "Computer Science");
        manager.addStudent(2, "Anita Karki", 19, "anita.karki@email.com", "Mathematics");
        manager.addStudent(3, "Ramesh Thapa", 21, "ramesh.thapa@email.com", "Physics");
        manager.displayAllStudents();
        manager.displaySpecificStudent(1);
    }
}



