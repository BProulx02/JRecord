package codeGen.readWrite;

/*
 *   Example program for DTAR021.cbl
 *   This class uses the JRecord project (https://sourceforge.net/projects/jrecord/)
 * -------------------------------------------------------------------
 *        
 * *------------- Keep this notice in your final code ---------------
 * *   This code was generated by JRecord projects CodeGen program
 * *            on the: 26 Nov 2017 8:25:59 
 * *     from Copybook: DTAR021.cbl
 * *          Template: standard
 * *             Split: None   
 * * File Organization: FixedWidth   
 * *              Font: cp037
 * *   
 * *    CodeGen Author: Bruce Martin
 * *-----------------------------------------------------------------
 *
 *   This class should be used as an example of reading/writing files
 *   using JRecord. You will need to modify the code to meet your
 *   needs. The Author of CodeGen (Bruce Martin) program takes no 
 *   responsibility for the accuracy of the generated code. 
 *
 *   Good Luck
 *              Bruce Martin
 *
 * ------------------------------------------------------------------
 * v01  CodeGen        26 Nov 2017  Initial version
 *     (Bruce Martin)
 *
 * ------------------------------------------------------------------ 
 */


import java.io.IOException;

import net.sf.JRecord.JRecordInterface1;
import net.sf.JRecord.Common.IFileStructureConstants;
import net.sf.JRecord.Details.AbstractLine;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.IO.AbstractLineWriter;
import net.sf.JRecord.def.IO.builders.ICobolIOBuilder;

/**
 * Write Cobol file using a Cobol Copybook (Dtar021).
 *
 * This Generated program is intended as an example of using JRecord
 * rather than a useful program (that compiles - it wont).
 * You should regard it as a starting point and modify
 * it according to needs
 */
public final class WriteDtar021standard {

	private FieldNamesDtar021.RecordDtar021 rDtar021 = FieldNamesDtar021.RECORD_DTAR021;


	/**
	 * Example of LineReader  classes
	 */
	public WriteDtar021standard() {
		super();

        String outputFileName = getFilePath("DTAR022.bin");
        String copybookName   = getFilePath("DTAR021.cbl");

        try {
			ICobolIOBuilder iob = JRecordInterface1.COBOL
					.newIOBuilder(copybookName)
					.setFont("cp037")
					.setFileOrganization(IFileStructureConstants.IO_FIXED_LENGTH)
					.setSplitCopybook(CopybookLoader.SPLIT_NONE)
					;  
			AbstractLineWriter writer = iob.newWriter(outputFileName);

	        writer.write(createDtar021(iob, 123));
	        writer.write(createDtar021(iob, 1));
	        writer.write(createDtar021(iob, 2));
	        writer.write(createDtar021(iob, 321));

			writer.close();
		} catch (Exception e) {
			System.out.println();

			e.printStackTrace();
		}
	}


	/*
	 *   The following code contains sample assignments for every 
	 * field in the Cobol File. You should modify the code to suit
	 * your needs.
	 *   As I do not know where the data is coming from, I have used
	 * SourceOfDataForTheCobolFile instead. You should replace this with your
	 * class / classes  or remove it as needed.
	 *   To put it another way, it time for you to start Coding
	 */


	private AbstractLine createDtar021(ICobolIOBuilder iob, int data) 
			throws IOException {
		AbstractLine line = iob.newLine();

		line.getFieldValue(rDtar021.keycodeNo).set(data);
		line.getFieldValue(rDtar021.storeNo).set(data);
		line.getFieldValue(rDtar021.theDate).set(data);
		line.getFieldValue(rDtar021.deptNo).set(data);
		line.getFieldValue(rDtar021.qtySold).set(data);
		line.getFieldValue(rDtar021.salePrice).set(data);


		return line;
	}


	private String getFilePath(String name) {
		return this.getClass().getResource(name).getFile();
	}


	public static void main(String[] args) {
		new WriteDtar021standard();
	}
}

