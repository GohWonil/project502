package org.choongang.file.repositories;

import org.choongang.file.entities.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FileInfoReposetory extends JpaRepository<FileInfo, Long>, QuerydslPredicateExecutor<FileInfo> {

}
