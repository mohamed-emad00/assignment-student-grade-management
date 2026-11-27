import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private String name;
    private Set<Subject> subjects = new HashSet<>();

    public Student(String name, Set<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    public void printGrades(){
        for(Subject subject : subjects){
            System.out.println("The subject name: " + subject.getName() + " grade: " + subject.getGrade());
        }
    }
    public int countPassedSubject(){
        int noPassed = 0;
        for(Subject subject: subjects){
            if(subject.getGrade() >= 50){
                noPassed++;
            }
        }
        return noPassed;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
