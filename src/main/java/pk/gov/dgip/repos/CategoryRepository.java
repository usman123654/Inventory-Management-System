package pk.gov.dgip.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.gov.dgip.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}