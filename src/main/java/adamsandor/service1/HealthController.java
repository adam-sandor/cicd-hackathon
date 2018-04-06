package adamsandor.service1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private boolean healthy = true;

    @RequestMapping("/health")
    public ResponseEntity<String> health() {
        return healthy ?
                new ResponseEntity<>("YES", HttpStatus.OK) :
                new ResponseEntity<String>("NO", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(path = "/die")
    public void die() {
        healthy = false;
    }
}
