package codeGen.readWrite;
 /*
  *   Example program for DTAR021.cbl
  *   This class uses the JRecord project (https://sourceforge.net/projects/jrecord/)
  * -------------------------------------------------------------------
  *        
  * *------------- Keep this notice in your final code ---------------
  * *   This code was generated by JRecord projects CodeGen program
  * *            on the: 26 Nov 2017 8:20:4 
  * *     from Copybook: DTAR021.cbl
  * *          Template: pojo
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

import net.sf.JRecord.cgen.def.IReader;
import net.sf.JRecord.cgen.impl.io.IoBuilder;
import codeGen.readWrite.io.IoBuilderDtar021;
import codeGen.readWrite.data.LineDtar021Pojo;


/**
 * Read Cobol file using a Cobol Copybook (Dtar021).
 *
 * This Generated program is intended as an example of using JRecord
 * rather than a useful program (that compiles - it wont).
 * You should regard it as a starting point and modify
 * it according to needs
 */
public final class ReadDtar021pojo {

 
    /**
     * Example of Using a PojoReader  classes
     */
    public ReadDtar021pojo() {
        super();
        
        String dataFile        = getFilePath("DTAR020.bin");
        String inCopybookName  = getFilePath("DTAR021.cbl");

        IReader<LineDtar021Pojo> reader = null;
        int lineNum = 0;
        try {
            IoBuilder<LineDtar021Pojo> iob = IoBuilderDtar021.newIoBuilder(inCopybookName);
            LineDtar021Pojo line;

            reader = iob.newReader(dataFile);
            
            while ((line = reader.read()) != null) {
                lineNum += 1;
                
               System.out.println(
                              line.getKeycodeNo()
                      + " " + line.getStoreNo()
                      + " " + line.getTheDate()
                      + " " + line.getDeptNo()
                      + " " + line.getQtySold()
                      + " " + line.getSalePrice()
                   );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Read --> " + lineNum);
    }

    
    private String getFilePath(String name) {
    	return this.getClass().getResource(name).getFile();

    }

    public static void main(String[] args) {
        new ReadDtar021pojo();
    }
}

