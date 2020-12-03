package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;

@Controller
public class UserController {
	private static String SALT = "123456";
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj do_register(@RequestBody Map<String, String> map) {
		String message = "";
		User user = null;
		try {
			String id = map.get("id");
			String firstname = map.get("firstname");
			String lastname = map.get("lastname");
			String email = map.get("email");
			String password = map.get("password");
			password = PasswordUtil.getInstance().createPassword(password, SALT);
			
			System.out.println(id + " " + firstname + " " + lastname + " " + email + " " + password);
			user = new User(id, firstname, lastname, email, password);
			UserManager rm = new UserManager();
			message = rm.insertUser(user);
			return new ResponseObj(200, user);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Please try again....";
			return new ResponseObj(500, user);
		}
	}
	@RequestMapping(value = "/user/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj do_editprofile(@RequestBody Map<String, String> map) {
		String message = "";
		User user = null;
		try {
			String id = map.get("id");
			String firstname = map.get("firstname");
			String lastname = map.get("lastname");
			String email = map.get("email");
			String password = map.get("password");
			password = PasswordUtil.getInstance().createPassword(password, SALT);
			
			System.out.println(id + " " + firstname + " " + lastname + " " + email + " " + password);
			user = new User(id, firstname, lastname, email, password);
			UserManager rm = new UserManager();
			message = rm.editUser(user);
			return new ResponseObj(200, user);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Please try again....";
			return new ResponseObj(500, user);
		}
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj do_deleteuser(@RequestBody Map<String, String> map) {
		User user = null;
		String massage = "";
		try {
			String id = map.get("id");
			
			UserManager rm = new UserManager();
			user = rm.getUserProfile(id);
			massage = rm.deleteUser(user);
			if(user != null) {
				return new ResponseObj(200, massage);
			}else { 
				return new ResponseObj(200, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseObj(500, null);
		}
	}
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public @ResponseBody ResponseObj do_listUsers(HttpServletRequest request) {
		List<User> users = null;
		try {
			UserManager rm = new UserManager();
			users = rm.listAllUsers();

			return new ResponseObj(200, users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseObj(500, users);
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj do_login(@RequestBody Map<String, String> map) {
		String message = "";
		User user = null;
		try {
			String id = map.get("id");
			String password = map.get("password");
			password = PasswordUtil.getInstance().createPassword(password, SALT);
			
			user = new User(id,"","","", password);
			UserManager rm = new UserManager();
			message = rm.doHibernateLogin(user);
			if("login success".equals(message)) {
				return new ResponseObj(200, "1");
			}else {
				return new ResponseObj(200, "0");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Please try again....";
			return new ResponseObj(500, 0);
		}
	}
	@RequestMapping(value = "/user/getprofile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj do_getProfile(@RequestBody Map<String, String> map) {
		User user = null;
		try {
			String id = map.get("id");
			
			UserManager rm = new UserManager();
			user = rm.getUserProfile(id);
			if(user != null) {
				return new ResponseObj(200, user);
			}else { 
				return new ResponseObj(200, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseObj(500, null);
		}
	}
}
