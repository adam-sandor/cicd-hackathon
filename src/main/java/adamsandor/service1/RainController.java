package adamsandor.service1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RainController {

    @RequestMapping("/willitrain")
    public ResponseEntity<String> willItRain(@RequestParam(name = "dag") String day, @RequestHeader("Auth") String auth) {
        if (!"Jaapjan".equals(auth)) {
            throw new IllegalStateException("Invalid credentials in Auth header");
        }
        switch (day) {
            case "maandag": return ResponseEntity.ok("JA");
            case "dinsdag": return ResponseEntity.ok("JA");
            case "woensdag": return ResponseEntity.ok("NEE");
            case "donderdag": return ResponseEntity.ok("JA");
            case "vrijdag": return ResponseEntity.ok("JA");
            case "zaterdag": return ResponseEntity.ok("JA");
            case "zondag": return ResponseEntity.ok("JA");
        }
        throw new IllegalArgumentException("Dit is niet een dag: " + day);
    }
}
