//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static ConcurrentHashMap<String , Student> studentMap = new ConcurrentHashMap<>();
    public static void printMenu(){
        System.out.println("1. Show All Students names");
        System.out.println("2. Show all Students grades in each subject");
        System.out.println("3. Search Student by name");
        System.out.println("4. Count Passed Students");
        System.out.println("0. Exit");
    }

    public static void main() {
        Scanner scan = new Scanner(System.in);
        Student[] students = new Student[5];
        for(int i=0; i < students.length; i++){
            System.out.println("Enter the student info of " + i);
            System.out.print("Enter the student name of " + i + ":");
            String studentName = scan.nextLine();
            System.out.println("Enter the student grades in each subject");
            Set<Subject> subjectSet = new HashSet<>();
            for(int j =0 ; j < 3; j++){
                System.out.print("Enter the subject name of " + j + ":");
                String subjectName = scan.nextLine();
                System.out.print("Enter the subject grade of " + j + ":");
                byte grade = scan.nextByte();
                scan.nextLine();
                while ((grade+1) < 0 || (grade +1) > 100 ){
                    System.out.println("Invalid grade");
                    System.out.println("Enter the grade again: ");
                    grade = scan.nextByte();
                }
                subjectSet.add(Subject.create(subjectName,grade));
            }
            students[i] = new Student(studentName,subjectSet);
            studentMap.put(studentName,students[i]);
        }
        byte option = -1;
        do{
            printMenu();
            option = scan.nextByte();
        switch (option){
            case 1:
                System.out.println("Students names: ");
                for(int i=0; i< students.length; i++){
                    System.out.println( i + ":" + students[i]);
                }
                break;
            case 2:
                System.out.println("Students grades: ");
                for(int i=0; i< students.length; i++){
                    System.out.println(i + " Student grade for " + students[i].getName() + ": ");
                    students[i].printGrades();
                }
                break;
            case 3:
                System.out.println("Enter Student name to search for grades: ");
                String name = scan.nextLine();
                Student student = studentMap.get(name);
                student.printGrades();
                break;
            case 4:
                for(int i=0;i < students.length; i++){
                    System.out.println("the number of passed subject for "+ students[i].getName() + ": " + students[i].countPassedSubject() );
                }
                break;
            case 0:
                System.out.println("GoodBye");
                break;

            default:
                System.out.println("Invalid option");

        }

        }while (option !=0);

    }
}