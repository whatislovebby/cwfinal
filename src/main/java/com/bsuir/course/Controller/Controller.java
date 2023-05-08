package com.bsuir.course.Controller;


import com.bsuir.course.domain.Apartaments;
import com.bsuir.course.domain.User;
import com.bsuir.course.repository.ApartamentsRepository;
import com.bsuir.course.repository.UserRepository;
import com.bsuir.course.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;
    private final UserRepository userRepository;
    private final ApartamentsRepository apartamentsRepository;

    @GetMapping("/")
    public String home(Model model){
        List<Apartaments> aparts = apartamentsRepository.findAll();
        model.addAttribute("aparts", aparts);
        return "index";
    }
    @GetMapping("/filtr")
    public String filtr(){
        return "rent";
    }
    @GetMapping("/{id}")
    public String flat(@PathVariable(name = "id") Long id, Model model){
        Apartaments apartaments = apartamentsRepository.findApartamentsById(id);
        model.addAttribute("apart", apartaments);
        return "page";
    }

    @GetMapping("/login")
    public String login(){
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "signIn";
        }*/
        return "signIn";
    }


    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@RequestParam String firstname, @RequestParam String lastname,
                             @RequestParam String email, @RequestParam String password, Model model){

        if(userRepository.existsByEmail(email)){
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "signUp";
        }
        else {
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setPassword(password);

            userService.save(user);
            return "redirect:/login";
        }

    }



    @GetMapping("/sale")
    public String sale(Model model){
        List<Apartaments> apartaments = apartamentsRepository.findAllByType("Продажа");
        model.addAttribute("aparts", apartaments);
        return "sale";
    }

    @GetMapping("/sale/{id}")
    public String saleFlat(@PathVariable(name = "id") Long id, Model model){
        Apartaments apartaments = apartamentsRepository.findApartamentsById(id);
        model.addAttribute("apart", apartaments);
        return "page";
    }

    @GetMapping("/rent")
    public String rent(Model model){
        List<Apartaments> apartaments = apartamentsRepository.findAllByType("Аренда");
        model.addAttribute("aparts", apartaments);
        return "rent";
    }

    @GetMapping("/rent/{id}")
    public String rentFlat(@PathVariable(name = "id") Long id, Model model){
        Apartaments apartaments = apartamentsRepository.findApartamentsById(id);
        model.addAttribute("apart", apartaments);
        return "page";
    }



}
