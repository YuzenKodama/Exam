package team.seisaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import team.seisaku.model.StudentModel;
import team.seisaku.repository.StudentRepository;


@Service
@Transactional
public class StudentService {


    @Autowired
    private StudentRepository repository;

    /**
     * 学生一覧の取得
    
     */
    public List<StudentModel> getUseriList() {
        List<StudentModel> entityList = this.repository.findAll();
        return entityList;
    }

    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public StudentModel get(@NonNull Long index) {
        StudentModel student = this.repository.findById(index).orElse(new StudentModel());
        return student;
    }

    public void save(@NonNull StudentModel student) {
        this.repository.save(student);
    }

    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}

