package DTOs;

import entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mathias Nielsen
 */
public class UserDTO {

    private String userName;
    private String fullName;
    private List<RoleDTO> roleList = new ArrayList<>();
    private Date created;

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.fullName = user.getFirstName() + " " + user.getLastName();

        user.getRoleList().forEach(role -> {
            roleList.add(new RoleDTO(role));
        });
        
        this.created = user.getCreated();
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getCreated() {
        return created;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

}
