package com.bsuir.course.Controller;

import com.bsuir.course.domain.User;
import com.bsuir.course.repository.ApartamentsRepository;
import com.bsuir.course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;

    private final ApartamentsRepository apartamentsRepository;
    @GetMapping("/users")
    public String tasks(Model model) {


        if (userRepository.findAll().isEmpty()) {

            return "redirect:/";
        }
        else if (!userRepository.findAll().isEmpty()) {

            Iterable<User> users = userRepository.findByRolesName("USER");
            model.addAttribute("users", users);
            return "admin/users";
        }

        return null;
    }


    @PostMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam String userEmail) {
        User user = userRepository.findOneByEmail(userEmail);
        apartamentsRepository.deleteApartamentsByUser(user);
        userRepository.deleteUsersByUserEmail(userEmail);



        return "redirect:/admin/users";
    }

    @PostMapping("/blockUser")
    public String blockUser(Model model, @RequestParam String UserEmail) {
        User user = userRepository.findOneByEmail(UserEmail);
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/unblockUser")
    public String unblockUser(Model model, @RequestParam String UserEmail) {
        User user = userRepository.findOneByEmail(UserEmail);
        user.setEnabled(false);
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/personal")
    public String personal(Model model, Authentication authentication, String email) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        email = auth.getName();
        User user = userRepository.findOneByEmail(email);
        model.addAttribute("user", user);
        return "admin/personal";
    }

    @PostMapping("/update")
    public String update(Model model, org.springframework.security.core.Authentication authentication, String email, HttpServletResponse response,
                         @RequestParam String phone,
                         @RequestParam String firstname,
                         @RequestParam String lastname
    ) throws IOException {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        email = auth.getName();
        User user = userRepository.findOneByEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPhone(phone);
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/admin/personal";
    }

}
