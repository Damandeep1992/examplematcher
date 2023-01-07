package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;

@Service
public class LibraryReadServiceImpl {

	@Autowired
	LibraryRepository readRepository;
	
	public List<Library> getAllLibrary() {
		return readRepository.findAll(); 
	}
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks= new Library();
		libraryWithNoBooks.setComaSeparatedBooknames(" ");
		
		ExampleMatcher exampleMatcher= ExampleMatcher.matching().withMatcher("comaSeparatedBooknames",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
				
			Example<Library> example= Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}
	
}
