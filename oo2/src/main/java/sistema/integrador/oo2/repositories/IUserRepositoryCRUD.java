package sistema.integrador.oo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistema.integrador.oo2.entities.User;
@Repository
public interface IUserRepositoryCRUD extends CrudRepository<User,Long> {

}
