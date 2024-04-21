package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.RoleDTO;
import pe.edu.upc.musictooltf.Entities.Role;
import pe.edu.upc.musictooltf.Services.IRoleService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("musictool/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @PostMapping
    public void insert(@RequestBody RoleDTO roleDTO){
        ModelMapper m=new ModelMapper();
        Role r=m.map(roleDTO,Role.class);
        roleService.insert(r);
    }

    @GetMapping
    public List<RoleDTO> list(){
        return roleService.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        roleService.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        Role r = roleService.findById(id);
        RoleDTO roleDTO =m.map(r,RoleDTO.class);
        return roleDTO;
    }


    @GetMapping("/find")
    public List<RoleDTO> findByRoleName(@RequestParam String name) {
        return roleService.findByRoleName(name).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RoleDTO.class);
        }).collect(Collectors.toList());
    }
}
