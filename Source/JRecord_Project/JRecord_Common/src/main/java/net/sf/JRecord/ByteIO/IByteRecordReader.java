package net.sf.JRecord.ByteIO;

import java.io.IOException;

import net.sf.JRecord.Common.ISetData;




/**
 * Read a series of Byte-Array Records from what ever
 * This is general interface that users can use to some data-store
 * e.g.<ul>
 * <li>IBM ZFile on the IBM mainframe
 * <li>Google File Store
 * </ul>
 * 
 * Usage
 * <pre>
 *     IByteRecordReader myByteReader =...
 *     AbstractLineReader reader = JRecordInterface1.COBOL
 *         .newIOBuilder(...)
 *              ....
 *         .newReader(myByteReader);
 * </pre>
 * 
 * @author Bruce Martin
 *
 */
public interface IByteRecordReader {


	/**
	 * Read into an existing 'line'
	 * @param line The 'line' to updated with data read from the file.
	 * @return wether the read was succesfull (true) or eof (false)
	 * @throws IOException any IOError that occurs.
	 */
	boolean readInto(ISetData line) throws IOException;
	/**
	 * Read one line from the input file as an array of bytes
	 *
	 * @return line read in
	 *
	 * @throws IOException io error
	 */
	byte[] read() throws IOException;

	/**
	 * Closes the file
	 *
	 * @throws IOException io error
	 */
	void close() throws IOException;

//	/**
//	 * @param lineLength The lineLength to set.
//	 */
//	void setLineLength(int lineLength);

}