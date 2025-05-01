package com.mango.api;

import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class upDataApi {

    @Autowired
    private StudentServiceImpl studentService;

    private Map<String, Object> buildResponse(int code, String msg, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("msg", msg);
        response.put("data", data);
        return response;
    }

    @PostMapping("/api/auth/add_new_student")
    public ResponseEntity<Map<String, Object>> add_new_student(
            @RequestParam("userId") String userId,
            @RequestParam("userName") String name,
            @RequestParam("s_year") String year,
            @RequestParam("s_major") String sex,
            @RequestParam("s_class") String born,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) {
        System.out.println(userId);
        System.out.println(name);
        System.out.println(year);
        System.out.println(sex);
        System.out.println(born);
        System.out.println(phone);
        System.out.println(password);
        Student custom = new Student();
        custom.setS_id(userId);
        custom.setS_name(name);
        custom.setS_year(year);
        custom.setS_major(sex);
        custom.setS_class(born);
        custom.setS_phone_number(phone);
        custom.setPassword(password);
        studentService.addStudentPassword(custom);
        return ResponseEntity.ok(buildResponse(200, "登录成功", new HashMap<>()));
    }
}
