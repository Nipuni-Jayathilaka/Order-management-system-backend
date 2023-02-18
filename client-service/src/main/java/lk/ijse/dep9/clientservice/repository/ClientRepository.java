package lk.ijse.dep9.clientservice.repository;

import lk.ijse.dep9.clientservice.entity.Client;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClientRepository extends CrudRepository<Client,String> {
}
