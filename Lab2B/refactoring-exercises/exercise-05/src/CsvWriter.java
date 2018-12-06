import java.io.IOException;
import java.io.OutputStream;

// There was a bad smell called Divergent Change. I changed System.out.print/ln to OutputStream to handle various
// formatting and prevent from making many changes in the class when we'd like to change formatting. I generalised it.
// the only thing we have to do is to just give appropriate parameter.
public class CsvWriter {
	public CsvWriter() {
	}
	
	public void write(OutputStream os, String[][] lines) throws IOException {
		for (int i = 0; i < lines.length; i++)
			writeLine(os,lines[i]);
	}

	private void writeLine(OutputStream os, String[] fields) throws IOException {
		if (fields.length == 0)
			os.write('\n');
		else {
			writeField(os, fields[0]);

			for (int i = 1; i < fields.length; i++) {
				os.write(",".getBytes());
				writeField(os, fields[i]);
			}
			os.write('\n');
		}
	}

	private void writeField(OutputStream os, String field) throws IOException {
		if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
			writeQuoted(os, field);
		else
			os.write(field.getBytes());
	}

	private void writeQuoted(OutputStream os, String field) throws IOException {

		os.write('\"');
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == '\"')
				os.write("\"\"".getBytes());
			else
				os.write(c);
		}
		os.write('\"');
	}
}