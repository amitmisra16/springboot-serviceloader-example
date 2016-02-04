package com.springboot.serviceloader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.serviceloader.service.impl.DictionaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootServiceloaderExampleApplication.class)
public class SpringbootServiceloaderExampleApplicationTests {

	@Autowired
	DictionaryService dictionaryService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGeneralDictionary() {
		String word = "book";
		String definition = dictionaryService.getDefinition(word);
		Assert.assertNotNull(definition);

		word = "editor";
		definition = dictionaryService.getDefinition(word);
		Assert.assertNotNull(definition);
	}

	@Test
	public void testExtendedDictionary() {
		String word = "xml";
		String definition = dictionaryService.getDefinition(word);
		Assert.assertNotNull(definition);

		word = "REST";
		definition = dictionaryService.getDefinition(word);
		Assert.assertNotNull(definition);
	}

	@Test
	public void testNoDefFound() {
		String word = "hello";
		String definition = dictionaryService.getDefinition(word);
		Assert.assertEquals(DictionaryService.NO_DEF_FOUND, definition);
	}

}
