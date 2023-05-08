package com.bsuir.course.Controller;


import com.bsuir.course.FileUploadUtil;
import com.bsuir.course.domain.Apartaments;
import com.bsuir.course.domain.User;
import com.bsuir.course.repository.ApartamentsRepository;
import com.bsuir.course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ApartamentsRepository apartamentsRepository;

    @GetMapping("/personal")
    public String personal(Model model, Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findOneByEmail(auth.getName());

        System.out.println(auth.getAuthorities());
        model.addAttribute("user", user);

        List<Apartaments> myApart = apartamentsRepository.findAllByUser(user);
        model.addAttribute("aparts", myApart);
        return "personal";
    }


    @GetMapping("/add")
    public String add(Model model) {
        Apartaments apartaments = new Apartaments();
        model.addAttribute("apartaments", apartaments);
        return "add";
    }

    @GetMapping("/filtr/{page}")
    public String filtr(@PathVariable String page, @RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model, @RequestParam("spisok") String type) {
        List<Apartaments> myApart = apartamentsRepository.findAll();
        List<Apartaments> myApartSorted = new ArrayList<>();
        System.out.println(type);
        for (Apartaments apartament : apartamentsRepository.findAll()) {
            if (type.equals("ARPR")) {
                if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                    myApartSorted.add(apartament);
                }
            } else if (type.equals("AR")) {
                if (apartament.getType().equals("Аренда")) {
                    if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                        myApartSorted.add(apartament);
                    }
                }
            } else if (type.equals("PR")) {
                if (apartament.getType().equals("Продажа")) {
                    if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                        myApartSorted.add(apartament);
                    }
                }
            }

        }
        if (min > max) {
            model.addAttribute("aparts", myApart);
        } else
            model.addAttribute("aparts", myApartSorted);
        return page;
    }

   /* @GetMapping("/filtr/rent")
    public String filtrRent(@RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model, @RequestParam("spisok") String type) {
        List<Apartaments> myApart = apartamentsRepository.findAll();
        List<Apartaments> myApartSorted = new ArrayList<>();
        System.out.println(type);
        for (Apartaments apartament : apartamentsRepository.findAll()) {
            if (type.equals("ARPR")) {
                if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                    myApartSorted.add(apartament);
                }
            } else if (type.equals("AR")) {
                if (apartament.getType().equals("Аренда")) {
                    if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                        myApartSorted.add(apartament);
                    }
                }
            } else if (type.equals("PR")) {
                if (apartament.getType().equals("Продажа")) {
                    if (apartament.getPrice() >= min && apartament.getPrice() <= max) {
                        myApartSorted.add(apartament);
                    }
                }
            }

        }
        if (min > max) {
            model.addAttribute("aparts", myApart);
        } else
            model.addAttribute("aparts", myApartSorted);
        return "rent";
    }*/

    @PostMapping("/add")
    public String addPost(Apartaments apartament, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findOneByEmail(auth.getName());
        apartament.setUser(user);

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            apartament.setPhotos(fileName);
            Apartaments savedApartament = apartamentsRepository.save(apartament);

            String uploadDir = "apart-photos/" + savedApartament.getId();

            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        } else {
            if (apartament.getPhotos().isEmpty())
                apartament.setPhotos(null);
            apartamentsRepository.save(apartament);
        }

        return "redirect:/account/personal";
    }

    @GetMapping("/updateFlat/{id}")
    public String updateFlat(@PathVariable(name = "id") Long id, Model model) {
        Apartaments apartaments = apartamentsRepository.findApartamentsById(id);
        model.addAttribute("apart", apartaments);
        return "pageUpdate";
    }

    @PostMapping("/updateApart")
    public String updateFlatPost(Apartaments apart, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findOneByEmail(auth.getName());

        Apartaments apartaments = apartamentsRepository.findApartamentsById(apart.getId());
        apartaments.setType(apart.getType());
        apartaments.setCity(apart.getCity());
        apartaments.setStreet(apart.getStreet());
        apartaments.setHome(apart.getHome());
        apartaments.setFlat(apart.getFlat());
        apartaments.setPrice(apart.getPrice());
        apartaments.setDescription(apart.getDescription());
        apartaments.setUser(user);

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            apartaments.setPhotos(fileName);
            apartamentsRepository.save(apartaments);

            String uploadDir = "apart-photos/" + apartaments.getId();

            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        } else {
            if (apartaments.getPhotos() == null) {
                apartaments.setPhotos(null);
            }
            apartamentsRepository.save(apartaments);
        }

        return "redirect:/account/personal";
    }

    @PostMapping("/deleteFlat")
    public String deleteFlat(@RequestParam Long id) {
        apartamentsRepository.delete(apartamentsRepository.findApartamentsById(id));
        return "redirect:/account/personal";
    }

    @PostMapping("/update")
    public String update(User user,
                         @RequestParam String firstname,
                         @RequestParam String lastname,
                         @RequestParam String phone,
                         @RequestParam("image") MultipartFile multipartFile) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User savedUser = userRepository.findOneByEmail(auth.getName());
        savedUser.setFirstName(firstname);
        savedUser.setLastName(lastname);
        savedUser.setPhone(phone);

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            savedUser.setPhotos(fileName);
            userRepository.save(savedUser);

            String uploadDir = "user-photos/" + savedUser.getEmail();

            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        } else {
            if (savedUser.getPhotos() == null) {
                savedUser.setPhotos(null);
            }
            userRepository.save(savedUser);
        }

        return "redirect:/account/personal";
    }
}
