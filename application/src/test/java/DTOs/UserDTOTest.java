package DTOs;

import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.Date;
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
public class UserDTOTest {
    List<Role> roles;
    User user;
    UserDTO dto;
    
    public UserDTOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        roles = new ArrayList<>();
        roles.add(new Role("User"));
        user = new User("User1", "Sven", "Svensen", "password123", roles);
        dto = new UserDTO(user);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class UserDTO.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        UserDTO instance = dto;
        
        String expResult = "User1";
        String result = instance.getUserName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class UserDTO.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        UserDTO instance = dto;
        
        String expResult = "Sven Svensen";
        String result = instance.getFullName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreated method, of class UserDTO.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        UserDTO instance = dto;
        
        assertNotNull(instance.getCreated());
    }

    /**
     * Test of getRoleList method, of class UserDTO.
     */
    @Test
    public void testGetRoleList() {
        Role role1 = new Role("User");
        RoleDTO roledto = new RoleDTO(role1);
        List<RoleDTO> rolerole = new ArrayList<>();
        rolerole.add(roledto);
        System.out.println("getRoleList");
        UserDTO instance = dto;
        
        List<RoleDTO> expResult = rolerole;
        List<RoleDTO> result = instance.getRoleList();
        
        assertEquals(expResult, result);
    }
    
}
