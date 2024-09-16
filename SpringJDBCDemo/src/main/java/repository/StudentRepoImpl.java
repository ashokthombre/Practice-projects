package repository;

import entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentRepo")
public class StudentRepoImpl implements StudentRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {

        String query="insert into student (name,city) values(?,?)";

        int update = jdbcTemplate.update(query, student.getName(), student.getCity());
        return update;
    }

    @Override
    public int change(Student student) {

        String query="update student set name=?,city=? where id=?";
        int update = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return update;
    }

    @Override
    public int delete(int studentId) {
        String query="delete from student where id=?";
        int deleted = this.jdbcTemplate.update(query, studentId);
        return deleted;
    }

    @Override
    public Student getStudent(int studentId) {
        String query="select * from student where id =?";
      RowMapper<Student> rowMapper = new RowMapperImpl();

        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

        return student;


    }

    @Override
    public List<Student> getAllStudent() {

        String query="select * from student";

        List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
        return  student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
