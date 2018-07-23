package nz.net.osnz.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import nz.net.osnz.model.User;
import nz.net.osnz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Kefeng Deng (deng@51any.com)
 */
@Component
public class QueryUser implements GraphQLQueryResolver {

    @Autowired
    private UserRepository userRepository;

    public User user(Long id) {
        return userRepository.getUserById(id);
    }


    public List<User> users() {
        return userRepository.getUsers();
    }


}
