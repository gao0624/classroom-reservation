package com.mango.api;

import com.mango.constant.WebConstant;
import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.JwtUtils;
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
    public ResponseEntity<Map<String, Object>> check(@RequestParam("password") String psw, @RequestParam("telephone") String phone, HttpServletRequest request) {

        Student student = service.getStudentByPhone(phone);
        if (student == null) {
            return ResponseEntity.ok(buildResponse(404, "用户不用存在", null));
        }
        if(!psw.equals(student.getPassword())){
            return ResponseEntity.ok(buildResponse(401,"密码错误",null));
        }

        String token = JwtUtils.generateToken(student.getS_id(),
                student.getS_id().equals("admin") ? "admin" : "student");

        Map<String,Object> data = new HashMap<>();
        data.put("token",token);
        data.put("userId",student.getS_id());
        data.put("userName", student.getS_name());
        data.put("role", student.getS_id().equals("admin") ? "admin" : "student");
        return ResponseEntity.ok(buildResponse(200, "登录成功", data));
    }
}
