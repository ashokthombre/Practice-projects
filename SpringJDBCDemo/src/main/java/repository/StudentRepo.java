package repository;

import entites.Student;

import java.util.List;

public interface StudentRepo {

    public int insert(Student student);

    public int change(Student student);

    public int delete(int studentId);

    public Student getStudent(int studentId);

    public List<Student> getAllStudent();
}
