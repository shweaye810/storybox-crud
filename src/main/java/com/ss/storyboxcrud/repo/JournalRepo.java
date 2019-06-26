package com.ss.storyboxcrud.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.ss.storyboxcrud.model.Journal;

@Repository
public interface JournalRepo extends MongoRepository<Journal, String> {

	@PreAuthorize("hasPermission(#username, 'admin')")
	List<Journal> findByUsername(@Param("username") String username, Pageable pageable);

	@PreAuthorize("hasPermission(#username, 'admin')")
	List<Journal> findByUsernameAndTextContaining(@Param("username") String username, @Param("text") String text,
			Pageable pageable);

	@RestResource(exported = false)
	@Override
	Page<Journal> findAll(Pageable pageable);

	@PostAuthorize("hasPermission(returnObject.get().username, 'admin')")
	@Override
	Optional<Journal> findById(String id);

	@PostAuthorize("hasPermission(returnObject.get().username, 'admin')")
	@Override
	Iterable<Journal> findAllById(Iterable<String> ids);

	@PreAuthorize("hasPermission(#journal.getUsername(), 'admin')")
	@Override
	<S extends Journal> S save(@Param("journal") S entity);

	@RestResource(exported = false)
	@Override
	void deleteById(String id);

	@RestResource(exported = false)
	@Override
	void delete(Journal entity);

	@RestResource(exported = false)
	@Override
	void deleteAll(Iterable<? extends Journal> entities);

	@RestResource(exported = false)
	@Override
	void deleteAll();
}
