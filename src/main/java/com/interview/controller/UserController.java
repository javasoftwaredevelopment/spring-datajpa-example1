package com.interview.controller;

import com.interview.dto.UserDto;
import com.interview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    /*
    1) User kayıtlarını, firstName alanında "SE" karakteri içerenler olarak filtreleyecek,
       ve id alanına göre tersten sıralayacak bir servis ucu ekle.

    2) Yeni bir User kaydı oluşturacak servis ucu ekle ve kaydetmeden önce validation uygula.
       İpucu: Projede validation için gerekli dependency eksik olabilir mi acaba :)

       Ornek:
       Eklenecek kullanıcıya ait JSON data:
        {
            "firstName": "GÖKSU",
            "lastName": "ÇOŞKUN",
            "addresses": [
                {
                    "address": "MAMAK/ANKARA",
                    "addressType": 2,
                    "active": true
                },
                        {
                    "address": "GELİBOLU/ÇANAKKALE",
                    "addressType": 1,
                    "active": false
                }
            ]
        }

    3) Bir kullanicinin, son 10 gun icerisinde olusturulan adreslerinin sayisini donen bir servis ucu ekle.

    4) User silmek için servis ucu ekle. Sadece ADMIN rolüne sahip kullanıcıların bu işlemi yapabilmesini sağla.

    5) Properties dosyasına "environment.name" isimli bir özellik ekle ve bu değeri uygulama içinde kullan.
    */

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id).orElse(null));
    }

}
