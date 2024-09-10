package org.example;

import java.util.*;

public class StudentsGroup {
    // set variables
    private Student headmen;
    private ArrayList<Student> students;
    private ArrayList<String> exercises;
    private Map<UUID, Map<String,Boolean>> performanceByStudent = new HashMap<>();

    // set constructor
    StudentsGroup(Student headmen, ArrayList<Student> students, ArrayList<String> exercises) {
        this.headmen = headmen;
        this.students = students;
        this.exercises = exercises;
    }

    // a private method to set performance for all students by all exercises in HashMap
    private void setPerformance() {
        //        performanceByStudent = new HashMap<UUID, Map<String,Boolean>>();
        for (Student student : this.students) {
            Map<String,Boolean> performanceByExercise = new HashMap<>();
            for (String exercise : this.exercises) {
                performanceByExercise.put(exercise, false);
            }
            performanceByStudent.put(student.getId(), performanceByExercise);
        }
    }
    // a private method to update performance according to changes in students on exercises arrays
    private void updatePerformance(UUID idOfStudent) {
        if ( performanceByStudent.isEmpty()){
            setPerformance();
        } else if (!performanceByStudent.containsKey(idOfStudent)){
            Map<String,Boolean> performanceByExercise = new HashMap<>();
            for (String exercise : this.exercises) performanceByExercise.put(exercise, false);
            performanceByStudent.put(idOfStudent, performanceByExercise);
        }
        for (String exercise : exercises) {
            if (!performanceByStudent.get(idOfStudent).containsKey(exercise)) {
                performanceByStudent.get(idOfStudent).put(exercise, false);
            }
        }
    }

    // method to set performance as true for current student & exercise
    public void setPerformanceTrue(UUID idOfStudent, String exercise){
        updatePerformance(idOfStudent);
        performanceByStudent.get(idOfStudent).replace(exercise,true);
    }
    // method to change the headmen
    public void changeHeadmen(Student headmen) {
        this.headmen = headmen;
    }
    // method to add new student
    public void addStudent(Student student) {
        this.students.add(student);
    }
    // method to remove student
    public void removeStudent(Student student){
        this.students.remove(student);
    }
    // method to add new exercise
    public void addExercise(String exercise) {
        this.exercises.add(exercise);
    }

    // getters
    public Map<String,Boolean> getPerformanceByStudent(UUID idOfStudent) {
        updatePerformance(idOfStudent);
        return performanceByStudent.get(idOfStudent);
    }
    public ArrayList<String> getExercises(){
        return exercises;
    }
    public Student getHeadmen() {
        return headmen;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
}
