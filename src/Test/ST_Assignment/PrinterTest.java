package ST_Assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {
	
	@Mock
	Printer printerMock;
	
	@Test
	public void testPrintInfo() {
		//Printer printerMock = new Printer();

		// Define test data
        String name = "John Doe";
        String memberType = "member";
        String roomType = "Standard";
        
        // Call the method under test
        printerMock.printInfo(name, memberType, roomType);
        
        // Verify that the printInfo method was called with the correct arguments
        verify(printerMock).printInfo(name, memberType, roomType);

	}
}

//@Test
//public void testPrintInfoV2() {
//  // Create a mock System.out
//  PrintStream mockedPrintStream = mock(PrintStream.class);
//  System.setOut(mockedPrintStream);
//
//  // Create an instance of the class under test
//  Printer infoPrinter = new Printer();
//
//  // Define test data
//  String name = "John Doe";
//  String memberType = "member";
//  String roomType = "Standard";
//
//  // Call the method under test
//  infoPrinter.printInfo(name, memberType, roomType);
//
//  // Verify that the correct output was printed
//  verify(mockedPrintStream).println("\n==============================================");
//  verify(mockedPrintStream).println("                   Result                     ");
//  verify(mockedPrintStream).println("==============================================\n");
//  verify(mockedPrintStream).println("        Name          : " + name);
//  verify(mockedPrintStream).println("        Member Type   : " + memberType);
//  verify(mockedPrintStream).println("        Room Type     : " + roomType);
//  verify(mockedPrintStream).println("\n==============================================");
//
//  // Reset System.out to its original state
//  System.setOut(System.out);
//}

