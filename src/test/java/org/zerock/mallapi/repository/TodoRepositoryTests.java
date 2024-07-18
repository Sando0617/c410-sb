package org.zerock.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.mallapi.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void testPaging() {
		
		Pageable pageable =
				PageRequest.of(0, 10, Sort.by("tno").descending());
		Page<Todo> result = todoRepository.findAll(pageable);
		
		log.info(result.getTotalElements());
		
		result.getContent().stream().forEach(todo -> log.info(todo));
		
		}
		
	}
