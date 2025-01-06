package com.project.employee_records.controller;

import com.project.employee_records.model.Record;
import com.project.employee_records.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RecordController {
    private final RecordService recordService;

    @GetMapping("/records/{idRecord}")
    public ResponseEntity<Record> getRecord(@PathVariable Integer idRecord){
        return ResponseEntity.of(recordService.getRecord(idRecord));
    }

    @GetMapping("/records")
    public Page<Record> getRecords(Pageable pageable){
        return recordService.getRecords(pageable);
    }

    @PostMapping("/records")
    public ResponseEntity<Void> saveRecord(@RequestBody Record record){
        Record createRecord = recordService.setRecord(record);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idRecord}").buildAndExpand(createRecord.getIdRecord()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        headers.add("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/records/{idRecord}")
    public ResponseEntity<Void> updateRecord(@RequestBody Record record, @PathVariable Integer idRecord){
        return recordService.getRecord(idRecord)
                .map(r -> {
                    recordService.setRecord(record);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/records/{idRecord}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Integer idRecord){
        return recordService.getRecord(idRecord)
                .map(r -> {
                    recordService.deleteRecord(idRecord);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
