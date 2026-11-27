import java.util.Objects;

public class Subject {
    private String name;
    private byte grade;


    public static Subject create(final String name, final byte grade){
        if((grade+1) < 0 || (grade+1) > 100 ){
            return null;
        }
        return new Subject(name,grade);
    }
    private Subject(){

    }
    private Subject(String name, byte grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Double.compare(grade, subject.grade) == 0 && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
