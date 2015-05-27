package com.seifernet.shadowsatyr.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.seifernet.snwf.util.SNWFDefinitions;

public class Tail {
		
	private static final int BUFFER_SIZE = 8192;
	
	private final FileChannel channel;
	private long filePos;
	private ByteBuffer buf;
	private int bufPos;
	private byte lastLineBreak = '\n';
	private ByteArrayOutputStream baos = new ByteArrayOutputStream( );
	 
	public Tail( File file ) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		channel = raf.getChannel();
		filePos = raf.length();
	}
	 
	public String readLine(  ) throws IOException {
		while ( true ) {
			if (bufPos < 0) {
				if (filePos == 0) {
					if (baos == null) {
						return null;
					}
					String line = bufToString( );
					baos = null;
					return line;
				}
	 
				long start = Math.max(filePos - BUFFER_SIZE, 0);
				long end = filePos;
				long len = end - start;
	 
				buf = channel.map( FileChannel.MapMode.READ_ONLY, start, len );
				bufPos = (int) len;
				filePos = start;
			}
	 
			while ( bufPos-- > 0 ) {
					byte c = buf.get(bufPos);
					if (c == '\r' || c == '\n') {
						if (c != lastLineBreak) {
							lastLineBreak = c;
							continue;
						}
						lastLineBreak = c;
						return bufToString();
					}
					baos.write(c);
				}
			}
		}
	 
		private String bufToString( ) throws UnsupportedEncodingException {
			if (baos.size() == 0) {
				return "";
			}
	 
			byte[] bytes = baos.toByteArray();
			for (int i = 0; i < bytes.length / 2; i++) {
				byte t = bytes[i];
				bytes[i] = bytes[bytes.length - i - 1];
				bytes[bytes.length - i - 1] = t;
			}
	 
			baos.reset();
			return new String( bytes, SNWFDefinitions.UTF8_CHARSET  );
		}
	
}
