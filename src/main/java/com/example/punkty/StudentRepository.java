package com.example.punkty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface StudentRepository extends CrudRepository<StudentRow,Long> {
}
