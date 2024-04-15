package team.seisaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.seisaku.model.StudentModel;

@Repository
public interface StudentRepository  extends JpaRepository<StudentModel, Long>{
}
