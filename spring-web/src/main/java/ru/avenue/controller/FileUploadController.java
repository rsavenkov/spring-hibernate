package ru.avenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping(path = "/courseUpload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
//            String fileName = ((.StandardMultipartFile) file).filename;
            try (FileOutputStream stream = new FileOutputStream("file.jpg")) {
                stream.write(file.getBytes());
            }
            return "redirect:/uploadSuccess";
        }
        return "redirect:/uploadFailure";
    }
}
