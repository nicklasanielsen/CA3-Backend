package DTOs;

import entities.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.roleName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleDTO other = (RoleDTO) obj;
        if (!Objects.equals(this.roleName, other.roleName)) {
            return false;
        }
        return true;
    }
}
