package ec.edu.ups.apirest.controller;

import ec.edu.ups.apirest.entity.User;
import ec.edu.ups.apirest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> listar() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User buscarUsuario(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw  new RuntimeException("Usuario no existe");
        }
        return user;
    }

    @PostMapping("/users")
    public User nuevo(@RequestBody User user) {
        user.setId(0);
        userService.save(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String eliminar(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("No se puede eliminar");

        }
        userService.deleteById(id);
        return "Usuario: "+ user.getNombres() + " se elimino";
    }


}
