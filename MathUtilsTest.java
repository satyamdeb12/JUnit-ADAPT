package xyz.satyamdev;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When using MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	/*static*/ 
	void beforeAll() {
		System.out.println("Before All");
	}

	
	TestInfo testInfo;
	TestReporter testReporter;
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		System.out.println("Before Each");
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("After Each");
	}
	
	@Nested
	@DisplayName("in the add  method")
	@Tag("Math")
	class AddTest{
		@Test
		@DisplayName("When adding two positive numbers")
		void testAddPositive() {
			//MathUtils mathUtils = new MathUtils();
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual,()->"should return sum"+expected+" but returned "+actual);  //assertEquals(expected, actual,"Optional Error message when test fails");
			
		}
		@Test
		@DisplayName("When adding two negative numbers")
		void testAddNegative() {
			//MathUtils mathUtils = new MathUtils();
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			assertEquals(expected, actual,"should return the right sum");  //assertEquals(expected, actual,"Optional Error message when test fails");
			
		}
	}
	
	
	
	//@RepeatedTest(3)
	@Test
	@Tag("Circle")
	void testComputeCircleRadius(/*RepetitionInfo repetitionInfo*/) {
		//MathUtils mathUtils = new MathUtils();
		//int rep = repetitionInfo.getCurrentRepetition();
		//You can do something with the current repetition
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"Should return the circle Area");
		
	}
	
	@Test
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		//MathUtils mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0),"Divide by zero should throw");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("multiply method")
	void testMultiply() {
		//assertEquals(4, mathUtils.multiply(2, 2),"Should return the right product");
		System.out.println("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());;
		assertAll(
				()-> assertEquals(4, mathUtils.multiply(2, 2)),
				()-> assertEquals(0, mathUtils.multiply(2, 0)),
				()-> assertEquals(-2, mathUtils.multiply(-1, 2))
				);
	}
	
	@Test
	@Disabled
	//This method is meant to fail
	//Without the @Disabled annotation this test 
	//should be tested and provide a failure trace
	@DisplayName("The TDD disabled Method")
	void testDisabled() {
		fail("Meant to fail and not run");
	}
	
}
