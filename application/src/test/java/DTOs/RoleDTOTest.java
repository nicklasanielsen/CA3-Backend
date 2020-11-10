package DTOs;

import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nikolaj Larsen
 */
public class RoleDTOTest {
    Role role1;
    RoleDTO dto;
    
    
    public RoleDTOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        role1 = new Role("User");
        dto = new RoleDTO(role1); 
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRoleName method, of class RoleDTO.
     */
    @Test
    public void testGetRoleName() {
        System.out.println("getRoleName");
        RoleDTO instance = dto;
        
        String expResult = "User";
        String result = instance.getRoleName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserList method, of class RoleDTO.
     */
    @Test
    public void testGetUserList() {
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        List<User> users = new ArrayList<>();
        User user = new User("user1", "Sven", "Jensen", "password123", roles);
        users.add(user);
        UserDTO userDTO = new UserDTO(user);
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(userDTO);
        System.out.println("getUserList");
        RoleDTO instance = dto;
        
        List<UserDTO> expResult = userDTOs;
        List<UserDTO> result = instance.getUserList();
        
        assertEquals(expResult, result);
    }
    
}
