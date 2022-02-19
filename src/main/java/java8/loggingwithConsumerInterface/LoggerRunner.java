package java8.loggingwithConsumerInterface;

public class LoggerRunner {

	public static void main(String[] args) {

		DemoLogger.log("Pass", "Review Cycle is Passed");
		DemoLogger.log("Fail", "Review Cycle is Failed");
		DemoLogger.log("Skip", "Review Cycle is Skipped");

		DemoLogger.operation("ADD", 6);
		DemoLogger.operation("MULTIPLY", 6);
		DemoLogger.operation("DIVIDE", 6);
	}

}
