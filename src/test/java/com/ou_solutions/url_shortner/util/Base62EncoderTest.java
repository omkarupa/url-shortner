package com.ou_solutions.url_shortner.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Base62EncoderTest {

	@Test
	void shouldEncodeZero() {
		String result = Base62Encoder.encode(0L);

		assertEquals("a", result);
	}
	
	@Test
	void shouldEncodeGreaterThan62()
	{
		String result = Base62Encoder.encode(63l);
		assertEquals("b3", result);
	}
	
	@ParameterizedTest
	@CsvSource({"0,a","1,b"})
	void testEncoder(Long number, String expected)
	{
		assertEquals(expected, Base62Encoder.encode(number));
	}
	

}
