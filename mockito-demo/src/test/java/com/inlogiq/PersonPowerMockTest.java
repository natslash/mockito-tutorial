package com.inlogiq;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.inlogiq.IdentityUtilities;
import com.inlogiq.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ IdentityUtilities.class, Person.class })
public class PersonPowerMockTest {

	/**
	 * Test of initialize method, of class Person.
	 */
	@Test
	public void testInitialize() {
		System.out.println("initialize");
		PowerMockito.mockStatic(IdentityUtilities.class);
		when(IdentityUtilities.getUUID()).thenReturn("ABC-123");
		Person instance = new Person();
		instance.initialize();
		String result = instance.getId();
		assertEquals(result, "ABC-123");
	}

	@Test
	public void testGenerateId() throws Exception {
		System.out.println("generateId()");
		Person instance = PowerMockito.spy(new Person());

		/*
		 * Setup the expectation to the private method using the method name
		 */
		PowerMockito.when(instance, "generateId").thenReturn("UNIT-1A");

		instance.initialize();

		assertEquals("UNIT-1A", instance.getId());

		// Optionally verify that the private method was actually called
		PowerMockito.verifyPrivate(instance).invoke("generateId");
		
		//Verify that a method is called atelast once
		Mockito.verify(instance, atLeastOnce()).getId();

	}

	@Test
	public void ObjectsNotEqual() {
		System.out.println("Objects not Equal");
		Person p = new Person();
		Object o = new Object();
		assertFalse(p.equals(o));
	}

}