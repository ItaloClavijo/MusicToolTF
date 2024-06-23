package pe.edu.upc.musictooltf.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insert(@RequestBody RoleDTO roleDTO){
        ModelMapper m=new ModelMapper();
        Role r=m.map(roleDTO,Role.class);
        roleService.insert(r);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> list(){
        return roleService.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Integer id){
        roleService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public RoleDTO listId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        Role r = roleService.findById(id);
        RoleDTO roleDTO =m.map(r,RoleDTO.class);
        return roleDTO;
    }

    @GetMapping("/find")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> findByRoleName(@RequestParam String name) {
        return roleService.findByRoleName(name).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RoleDTO.class);
        }).collect(Collectors.toList());
    }
}
