package com.ohgiraffers.restapi;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ohgiraffers.restapi.RestApiApplication;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
@Tag(name = "Spring Boot Valid 연동 (USER) ")
@RestController
@RequestMapping("/valid")
public class Test {
    private List<TestDTO> test;

    public Test() {
        test = new ArrayList<>();

        test.add(new TestDTO(1, "1.01v", "2024-06-07", "Team S-O-O-P", new Date()));
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) throws UserNotFoundException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<TestDTO> foundUserList = test.stream().filter(test -> test.getNo() == userNo)
                .collect(Collectors.toList());

        TestDTO foundUser = null;
        if (foundUserList.size() > 0){
            foundUser=foundUserList.get(0);

        }else {
            throw new UserNotFoundException("회원 정보를 찾을 수 없음!!!");
        }
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }



}
