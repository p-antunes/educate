package dai.educate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dai.educate.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
