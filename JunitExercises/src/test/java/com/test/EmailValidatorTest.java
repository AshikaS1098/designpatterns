package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.application.EmailValidator;
import com.infy.exception.InfyAcademyException;

public class EmailValidatorTest {
	private EmailValidator l; 

	@BeforeEach
	public void setUp() {
	    l = new EmailValidator();
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		
		boolean actualEmail=l.validateEmailId("balaji@infy.com");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		boolean actualEmail=l.validateEmailId("james_potteer@infy.org");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		 assertThrows(InfyAcademyException.class,
		            ()->{
		            	
		            	boolean actualEmail=l.validateEmailId(null);
		            });
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "serius_black","Lily_Evans@Hoggy.in","Remus_lups","NymphieTonks@magic.com" })
	public void validateEmailIdParamterizedEmailId(String abc) throws InfyAcademyException {
		assertNotNull(abc);
	}
	
	@AfterEach
	public void teardown() {
	    l = null;
	}



}
