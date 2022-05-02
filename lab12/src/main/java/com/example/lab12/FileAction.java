package com.example.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileAction {
    @Value("D:\\WorkOrStudy\\JavaUniversity\\lab12\\src\\main\\resources\\Input.txt")
    private String filePath1;
    @Value("D:\\WorkOrStudy\\JavaUniversity\\lab12\\src\\main\\resources\\Hashed.txt")
    private String filePath2;

    @PostConstruct
    public void hashFile(){
        try(FileInputStream file1 = new FileInputStream(filePath1);
            FileOutputStream file2 = new FileOutputStream(filePath2)){
            byte[] buffer = new byte[file1.available()];
            // считываем буфер
            file1.read(buffer, 0, buffer.length);
            file1.close();
            //хешируем
            for(int i=0;i<buffer.length;i++){
                buffer[i]+=10;
            }
            //записываем в файл
            file2.write(buffer,0,buffer.length);
        } catch (IOException e) {
            try(FileOutputStream file2 = new FileOutputStream(filePath2)){
                byte[] buffer = new byte[]{'n', 'u', 'l', 'l'};
                file2.write(buffer);
            } catch (IOException ex) {
                System.out.println("Something went wrong...");
            }
        }
    }

    @PreDestroy
    public void deleteFile() throws IOException {
        // Удаляем файл
        Files.delete(Path.of(filePath1));
    }

}
