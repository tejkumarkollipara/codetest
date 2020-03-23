package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtil.class);
	static Integer[] numbers = new Integer[] { 1, 1, 3, 3, 5, 7, 8, 8, 10 };

	public static void main(String s[]) {
		NumberUtil numberUtil = new NumberUtil();
		Integer[] uniqueNumbers = numberUtil.getUniqueNumbers(numbers);
	}

	public Integer[] getUniqueNumbers(Integer[] sortedArray) {
		Integer[] uniqueNumbers = null;
		try {
			int arrayLength = sortedArray.length;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < arrayLength; i++) {
				while (i < arrayLength - 1 && sortedArray[i] == sortedArray[i + 1]) {
					i++;
				}
				LOGGER.info(sortedArray[i] + " ");
				list.add(sortedArray[i]);
			}
			uniqueNumbers = list.toArray(new Integer[list.size()]);
		} catch (Exception e) {
			LOGGER.error("Exceptionoccured while processing sorted numbers ", e);
		}
		return uniqueNumbers;
	}

}
