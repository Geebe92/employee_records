package com.project.employee_records.service;

import com.project.employee_records.model.Record;
import com.project.employee_records.repository.RecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    @Override
    public Optional<Record> getRecord(Integer idRecord) {
        return recordRepository.findById(idRecord);
    }

    @Override
    public Page<Record> getRecords(Pageable pageable) {
        return recordRepository.findAll(pageable);
    }

    @Override
    public Record setRecord(Record record) {
        recordRepository.save(record);
        return record;
    }

    @Override
    public void deleteRecord(Integer idRecord) {
        recordRepository.deleteById(idRecord);
    }
}
