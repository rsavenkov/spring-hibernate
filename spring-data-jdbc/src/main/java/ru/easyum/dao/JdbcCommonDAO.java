package ru.easyum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcCommonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int insertCourse(int id, String name, int duration) {
        return jdbcTemplate.update("INSERT INTO COURSE VALUES(?, ?, ?)", id, name, duration);
    }

    public List<Map<String, Object>> getCourses() {
        return jdbcTemplate.queryForList("SELECT * FROM COURSE");
    }
}
