package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {
    TimeEntryRepository timeEntryRepository;

    public SetupController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        timeEntryRepository.setup();
        return new ResponseEntity( HttpStatus.OK);
    }
}
