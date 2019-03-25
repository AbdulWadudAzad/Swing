
package com.coderbd.test;

import com.coderbd.domain.User;
import com.coderbd.services.UserService;
import java.util.Date;

public class UserTest {
    public static void main(String[] args) {
       // UserService.createTable();
      
       // User user=new User("azad","1234","billcollector","wadud","azad","azadmiu@gmail.com","01625030111",new Date(),true);
      // User user=new User("admin","1234","admin","abdul","wadud","wadudmiu@gmail.com","01625030116",new Date(),true);
      // UserService.insert(user);
      
      
       User u = UserService.getUserbyUserName("admin", "1234", true);
       System.out.println(u);
    }
  
}
