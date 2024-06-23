package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.FindUserNameWithTotalPurchaseByWithDate;
import pe.edu.upc.musictooltf.DTOs.QuantityContentByArtistDTO;
import pe.edu.upc.musictooltf.DTOs.UserDTO;
import pe.edu.upc.musictooltf.Entities.Users;
import pe.edu.upc.musictooltf.Services.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musictool/users")
public class UserController {
    @Autowired
    private IUserService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<Boolean> usuarioExiste(@RequestParam String username){
        boolean exists = uS.existsUser(username);
        return ResponseEntity.ok(exists);
    }

    @PostMapping
    public void registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable Long id, @RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.update(id,u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listById(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id), UserDTO.class);
        return dto;
    }

    @GetMapping
    public List<UserDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/")
    public ResponseEntity<Boolean> usuarioExiste(@RequestParam String username){
        boolean exists = uS.existsUser(username);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/findUserNameWithTotalPurchaseByWithDate")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<FindUserNameWithTotalPurchaseByWithDate> findUserNameWithTotalPurchaseByWithDate(@RequestParam LocalDate startDate, @RequestParam LocalDate finalDate){
        List<String[]> rowList = uS.findUserNameWithTotalPurchaseByWithDate(startDate,finalDate);
        List<FindUserNameWithTotalPurchaseByWithDate> dtoList= new ArrayList<>();

        for(String[] column : rowList) {
            FindUserNameWithTotalPurchaseByWithDate dto = new FindUserNameWithTotalPurchaseByWithDate();
            dto.setUserName(column[0]);
            dto.setDate(LocalDate.parse(column[1]));
            dto.setTotalPurchase(Double.parseDouble(column[2]));
            dtoList.add(dto);
        }
        return dtoList;
    }

}
