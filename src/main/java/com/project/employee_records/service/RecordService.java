package com.project.employee_records.service;

import com.project.employee_records.model.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RecordService {
    Optional<Record> getRecord(Integer idRecord);
    Page<Record> getRecords(Pageable pageable);
    Record setRecord(Record record);
    void deleteRecord(Integer idRecord);
}
