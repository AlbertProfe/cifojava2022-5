package io.company.library.controller;

import io.company.library.model.BookImages;
import io.company.library.repository.BookImagesRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64.Encoder;
import java.util.Base64;
import java.util.Optional;

@RestController
public class BookImagesController {

    @Autowired
    BookImagesRepository bookImagesRepository;

    @PostMapping("/uploadImage")
    public BookImages saveBookImage( @RequestParam String name, @RequestParam MultipartFile file) throws IOException {
        BookImages bookImage  = new BookImages();
        bookImage.setName(name);
        bookImage.setImage( new Binary(file.getBytes() ));

        bookImagesRepository.save(bookImage);

        return bookImage;

    }

    @GetMapping("/getDataImage")
    public String getDataBookImage(@RequestParam  String id){

        Optional<BookImages> bookImage = bookImagesRepository.findById(id);
        Encoder encoder = Base64.getEncoder();

        return encoder.encodeToString( bookImage.get().getImage().getData() );

    }

    @GetMapping("/getImage")
    public ResponseEntity<byte[]> getBookImage(@RequestParam String id){

        Optional<BookImages> bookImage = bookImagesRepository.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>( bookImage.get().getImage().getData(), headers, HttpStatus.OK );

    }
}
