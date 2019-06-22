package com.ss.storyboxcrud.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.ss.storyboxcrud.model.Journal;

@Repository
//@CrossOrigin
//@PostAuthorize("returnObject.username == authentication.principal.nickName")
public interface JournalRepo extends MongoRepository<Journal, String>{

	List<Journal> findByUsername(@Param("username") String username, Pageable pageable);
}
