package com.parth.TaskFunnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*** Created by parshah on 17-Sep-16.*/

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexController() {

    return "/index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveTask(@RequestBody String task) {
        String message = "";
        try{
            File Dir = new File("task repository");
            message = String.valueOf(Dir.mkdir());
            File tasks = new File("task repository/tr.txt");
            message = String.valueOf(tasks.createNewFile() + "for file");

            //message = "Saved!";
        }catch (Exception e){
            message = "Error: " + e;
        }
        return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
    }

}
