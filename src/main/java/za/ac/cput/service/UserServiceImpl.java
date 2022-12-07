package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.model.User;
import za.ac.cput.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//

    @Service
    public class UserServiceImpl implements IUserService {

        private static IUserService service;

        @Autowired
        private IUserRepository userRepository;


        @Override
        public User save(User user) {
            return this.userRepository.save(user);
        }

        @Override // Might give an error
        public Optional<User> read(String userId) {
            return this.userRepository.findById(userId);
        }

        @Override
        public void delete(User user) {
            this.userRepository.delete(user);

        }
        @Override
        public List<User> findAll() {
            return this.userRepository.findAll().stream().collect(Collectors.toList());
        }
    }
