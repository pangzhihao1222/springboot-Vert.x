package io.javac.vertx.vertxdemo.controller;

import io.javac.vertx.vertxdemo.annotation.RequestBlockingHandler;
import io.javac.vertx.vertxdemo.annotation.RequestMapping;
import io.javac.vertx.vertxdemo.base.ControllerHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@RequestMapping("/user")
public class UserController {
    @RequestBlockingHandler
    @RequestMapping("/getUserInfo")
    public ControllerHandler getUserInfo(){
        return vertxRequest -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            Map<String, String> map = new HashMap<>();
            map.put("name", "大白");
            map.put("age", "18");
            File file = new File("D:\\abc.txt");

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("abc");
                fileWriter.close();
                String abc = "abc";
                vertxRequest.buildVertxRespone().responeSuccess(map);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        };
    }
}
