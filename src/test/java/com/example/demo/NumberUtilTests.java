
package com.example.demo;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberUtilTests {

	private NumberUtil numberUtil;

	@Before
	public void setUp() {
		numberUtil = new NumberUtil();
	}
	
	@After
	public void tearDown() throws Exception {
		numberUtil = null;
	}

	@Test
	public void testGetUnigeNumbersSortedOrderShouldPass() {
		Integer[] sortedArray = new Integer[] { 1, 1, 3, 3, 5, 7, 8, 8, 10 };
		Integer[] expectedUniqueNumbers = new Integer[] { 1, 3, 5, 7, 8, 10 };
		Integer[] uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
		Assert.assertTrue(Arrays.equals(expectedUniqueNumbers, uniqueNumbers));
	}
	
	@Test
	public void testGetUnigeNumbersUnsortedOrderShouldFail() {
		Integer[] sortedArray = new Integer[] { 3, 1, 3, 4, 5, 4, 8, 8, 10 };
		Integer[] expectedUniqueNumbers = new Integer[] { 1, 3, 4, 5, 8, 10 };
		Integer[] uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
		Assert.assertFalse(Arrays.equals(expectedUniqueNumbers, uniqueNumbers));
	}

}
