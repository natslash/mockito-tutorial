package com.inlogiq;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AppTest {

	@Test
	public void testFirstMethod() {
		mock(App.class);
		
		when(App.firstMethod("Test")).thenReturn(null);
		assertTrue(App.firstMethod("Test").equals(null));
	}

}
