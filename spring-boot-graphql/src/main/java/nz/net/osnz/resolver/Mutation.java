package nz.net.osnz.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import nz.net.osnz.model.User;
import nz.net.osnz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kefeng Deng (deng@51any.com)
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public User user(String name, String email) {
        return userRepository.addUser(User.builder().email(email).name(name).build());
    }

}
