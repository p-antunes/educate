package dai.educate.repository;

import dai.educate.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dai.educate.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    /*
    FileDB findDistinctByNameFile(String name);

    @Override
    void delete(FileDB fileDB);
    */
}
