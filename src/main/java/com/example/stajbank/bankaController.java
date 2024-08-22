package com.example.stajbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class bankaController {
    @Autowired
    bankaRepository bankaRepo;
    @Autowired
    private com.example.stajbank.bankaRepository bankaRepository;

    @GetMapping("/kullanicilar")
    public ResponseEntity<List<bankaEntity>> getAllUsers() {
        List<bankaEntity> users = bankaRepo.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/ekle")
    public ResponseEntity<bankaEntity> addUser(@RequestBody bankaEntity banka) {
        try {
            bankaEntity bankaEntity = new bankaEntity(banka.getMusteriHesapNo(),banka.getMusteriName(),banka.getMusteriSurname(),banka.getMusteriBakiye(), banka.getMusteriAge(), banka.getMusteriTcNo());
            bankaEntity savedBanka = bankaRepository.save(bankaEntity); // Bu satırda nesne metodu çağrılıyor
            return new ResponseEntity<>(savedBanka, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam String musteriName) {
        bankaEntity user = bankaRepository.findByMusteriName(musteriName);
        if (user != null) {
            bankaRepository.delete(user);
            return "Kullanıcı başarıyla silindi";
        } else {
            return "Kullanıcı bulunamadı";
        }
    }

    // Bakiye güncelleme işlemi GET isteği ile yapılacak
    @GetMapping("/updateBakiye/{hesapNo}")
    public ResponseEntity<String> updateBakiye(@PathVariable("hesapNo") Long hesapNo, @RequestParam("yeniBakiye") int yeniBakiye) {
        // Hesap numarasına göre bankaEntity'yi bul
        bankaEntity banka = bankaRepository.findById(hesapNo)
                .orElseThrow(() -> new ResourceNotFoundException("Hesap numarası bulunamadı: " + hesapNo));

        // Bakiye güncelle
        banka.setMusteriBakiye(yeniBakiye);

        // Güncellenmiş bankaEntity'yi kaydet
        bankaRepository.save(banka);

        return ResponseEntity.ok("Bakiye başarıyla güncellendi.");
    }

    // İç içe istisna sınıfı
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
