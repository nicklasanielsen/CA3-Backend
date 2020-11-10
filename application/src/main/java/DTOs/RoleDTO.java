package DTOs;

import entities.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mathias Nielsen
 */
public class RoleDTO {

    private String roleName;
    private List<UserDTO> userList = new ArrayList<>();

    public RoleDTO(Role role) {
        this.roleName = role.getRoleName();
        
        role.getUserList().forEach(user -> {
            userList.add(new UserDTO(user));
        });
    }

    public String getRoleName() {
        return roleName;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

}
