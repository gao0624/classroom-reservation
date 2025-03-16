package com.mango.api;

import com.mango.constant.WebConstant;
import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginControllerApi {
    @Autowired
    StudentServiceImpl service;

    private Map<String, Object> buildResponse(int code, String msg, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("msg", msg);
        response.put("data", data);
        return response;
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<Map<String, Object>> check(@RequestParam("password") String psw, @RequestParam("telephone") String phone,Model model, HttpServletRequest request) {

        Student student = service.getStudentByPhone(phone);
        if (student == null) {
            //model.addAttribute("msg","该用户不存在!");
            return ResponseEntity.ok(buildResponse(200, "登录成功", new HashMap<>()));
        }else {
            if (psw.equals(student.getPassword())) {
                HttpSession session = request.getSession();

                session.setAttribute(WebConstant.LOGIN_USER,student);
                if (student.getS_id().equals("admin")) {
                    //如果是管理员则跳转到后台页面
                    //return "admin";
                }else {
                    //如果是用户则显示在前端页面  并在前端页面显示用户信息
                    session.setAttribute(WebConstant.LOGIN_USER, student);
                    Map<String, Object> userData = new HashMap<>();
                    userData.put("userId", student.getS_id());
                    userData.put("userName", student.getS_name());
                    userData.put("role", student.getS_id().equals("admin") ? "admin" : "student");
                    return ResponseEntity.ok(buildResponse(200, "登录成功", userData));
                    //return "student";
                }
            } else {
                return ResponseEntity.ok(buildResponse(200, "登录成功", new HashMap<>()));
            }
        }
        return ResponseEntity.ok(buildResponse(200, "登录成功", new HashMap<>()));
    }
}
