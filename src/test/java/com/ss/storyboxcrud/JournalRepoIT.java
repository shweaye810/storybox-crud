package com.ss.storyboxcrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ss.storyboxcrud.model.Journal;
import com.ss.storyboxcrud.repo.JournalRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class JournalRepoIT {
	@Autowired
	JournalRepo repo;
	
	@Before
	public void before() {
		repo.deleteAll();
	}
	
	@WithMockUser(username="test1")
	@Test(expected=AccessDeniedException.class)
	public void testJournalAndContextNoRole() {
		String username = "doe";
		Journal journal = new Journal();
		journal.setUsername(username);
		
		repo.findByUsername(username, null);
	}
	
	@WithMockUser(username="test1", roles="ADMIN")
	@Test()
	public void testJournalAndContext() {
		String username = "doe";
		Journal journal = new Journal();
		journal.setUsername(username);
		journal.setDate(LocalDateTime.now());
		journal.setText("testing");
		
		repo.save(journal);
		Collection<Journal> journals = repo.findByUsername(username, null);
		assertNotNull(journal);
		assertEquals(1, journals.size());
	}
}
