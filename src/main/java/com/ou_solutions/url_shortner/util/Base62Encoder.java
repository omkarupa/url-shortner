package com.ou_solutions.url_shortner.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Base62Encoder {
	
	private static final String CHARACTER = "abcdefghijklmnopqrstuvwxyz123456789";
	private static final Integer COUNT = CHARACTER.length();
	
	public static String encode(long number)
	{
		if(number == 0l)
		{
			return String.valueOf(CHARACTER.charAt(0));
		}
		
		StringBuilder builder = new StringBuilder();
		while(number > 0)
		{
			int reminder = (int) (number % COUNT);
			builder.append(CHARACTER.charAt(reminder));
			number = number / COUNT;
		}
		
		return builder.reverse().toString();
	}

}
