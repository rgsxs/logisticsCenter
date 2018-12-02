package com.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.general.BaseBean;

/**
 *
 * @version 1.0, 3 14, 2001
 * @author  wwei
 */

public class FileManage {

        /**  createDir  create a dir or a dir and file if the dir is not exist
         *   @param  file_name , the file name to be created
         *   @return boolean  , return true if the dir have created
         */

	public static boolean createDir (String file_name ){

		try{
			for(int i=file_name.indexOf(File.separatorChar);i!=-1;){
				String s_dir = file_name.substring(0,i+1);
				File f = new File(s_dir);
				if(!f.exists())	f.mkdir();
				i=file_name.indexOf(File.separatorChar,i+1);
			}
		}catch(Exception e){
            BaseBean base = new BaseBean() ;
            base.writeLog(e) ;
			return false;
		}
		return true ;
	}


    /**
	* Copy files and/or directories.
	*
	* @param srcfile source file or directory
	* @param destfile destination file or directory
   	* @exception IOException if operation fails
	*/

	public static void copy(String srcfile, String destfile) throws IOException {

                File src = new File(srcfile) ;
                File dest = new File(destfile)  ;

		FileInputStream source = null;
		FileOutputStream destination = null;
		byte[] buffer;
		int bytes_read;

		// Make sure the specified source exists and is readable.
		if (!src.exists())
			throw new IOException("source not found: " + src);
		if (!src.canRead())
			throw new IOException("source is unreadable: " + src);
        
		if (src.isFile()) {
			if (!dest.exists()) {
                File parentdir = parent(dest);
                if (!parentdir.exists()) parentdir.mkdirs();
			}
			else if (dest.isDirectory()) {
 				dest = new File(destfile + File.separator + src);
			}
		}
		else if (src.isDirectory()) {
			if (dest.isFile())
				throw new IOException("cannot copy directory " + src + " to file " + dest);

			if (!dest.exists())
				dest.mkdirs();
		}



		// The following line requires that the file already
		// exists!!  Thanks to Scott Downey (downey@telestream.com)
		// for pointing this out.  Someday, maybe I'll find out
		// why java.io.File.canWrite() behaves like this.  Is it
		// intentional for some odd reason?
		//if (!dest.canWrite())
			//throw new IOException("destination is unwriteable: " + dest);

		// If we've gotten this far everything is OK and we can copy.
		if (src.isFile()) {
			try {
				if(!FileType.validateFileExt(destfile)){
					throw new IOException(destfile+" file type is not valid,copy failed!");
				}
	            source = new FileInputStream(src);
		        destination = new FileOutputStream(dest);
			    buffer = new byte[1024];
				while(true) {
	                bytes_read = source.read(buffer);
		            if (bytes_read == -1) break;
			        destination.write(buffer, 0, bytes_read);
				}
			}
	        finally {
		        if (source != null)
			        try { source.close(); } catch (IOException e) { ; }
				if (destination != null)
	                try { destination.close(); } catch (IOException e) { ; }
		    }
		}
		else if (src.isDirectory()) {
			String targetfile, target, targetdest;
			String[] files = src.list();

			for (int i = 0; i < files.length; i++) {
				targetfile = files[i];
				target = src + File.separator + targetfile;
				targetdest = dest + File.separator + targetfile;


				if ((new File(target)).isDirectory()) {
		 			copy(target, targetdest);
				}
				else {
					if(!FileType.validateFileExt(targetdest)){
						throw new IOException(targetdest+" file type is not valid,copy failed!");
					}
					try {
						source = new FileInputStream(target);
						destination = new FileOutputStream(targetdest);
						buffer = new byte[1024];

						while(true) {
							bytes_read = source.read(buffer);
							if (bytes_read == -1) break;
							destination.write(buffer, 0, bytes_read);
						}
					}
					finally {
						if (source != null)
							try { source.close(); } catch (IOException e) { ; }
						if (destination != null)
							try { destination.close(); } catch (IOException e) { ; }
					}
				}
			}
		}
	}

	
	/**
	* Copy files and/or directories.
	*
	* @param srcfile source file or directory
	* @param destfile destination file or directory
   	* @exception IOException if operation fails
	*/

	public static void copy(String srcfile, String destfile,String isaesencrypt, String aescode) throws IOException {

        File src = new File(srcfile) ;
        File dest = new File(destfile)  ;

		InputStream source = null;
		FileOutputStream destination = null;
		byte[] buffer;
		int bytes_read;

		// Make sure the specified source exists and is readable.
		if (!src.exists())
			throw new IOException("source not found: " + src);
		if (!src.canRead())
			throw new IOException("source is unreadable: " + src);
        
		if (src.isFile()) {
			if (!dest.exists()) {
                File parentdir = parent(dest);
                if (!parentdir.exists()) parentdir.mkdirs();
			}
			else if (dest.isDirectory()) {
 				dest = new File(destfile + File.separator + src);
			}
		}
		else if (src.isDirectory()) {
			if (dest.isFile())
				throw new IOException("cannot copy directory " + src + " to file " + dest);

			if (!dest.exists())
				dest.mkdirs();
		}



		// The following line requires that the file already
		// exists!!  Thanks to Scott Downey (downey@telestream.com)
		// for pointing this out.  Someday, maybe I'll find out
		// why java.io.File.canWrite() behaves like this.  Is it
		// intentional for some odd reason?
		//if (!dest.canWrite())
			//throw new IOException("destination is unwriteable: " + dest);

		// If we've gotten this far everything is OK and we can copy.
		if (src.isFile()) {
			try {
				if(!FileType.validateFileExt(destfile)){
					throw new IOException(destfile+" file type is not valid,copy failed!");
				}
	            source = new FileInputStream(src);
	            if(isaesencrypt.equals("1")){
	            	source = AESCoder.decrypt(source, aescode);
	            }
		        destination = new FileOutputStream(dest);
			    buffer = new byte[1024];
				while(true) {
	                bytes_read = source.read(buffer);
		            if (bytes_read == -1) break;
			        destination.write(buffer, 0, bytes_read);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
	        finally {
		        if (source != null)
			        try { source.close(); } catch (IOException e) { ; }
				if (destination != null)
	                try { destination.close(); } catch (IOException e) { ; }
		    }
		}
		else if (src.isDirectory()) {
			String targetfile, target, targetdest;
			String[] files = src.list();

			for (int i = 0; i < files.length; i++) {
				targetfile = files[i];
				target = src + File.separator + targetfile;
				targetdest = dest + File.separator + targetfile;


				if ((new File(target)).isDirectory()) {
		 			copy(target, targetdest);
				}
				else {
					if(!FileType.validateFileExt(targetdest)){
						throw new IOException(targetdest+" file type is not valid,copy failed!");
					}
					try {
						source = new FileInputStream(target);
						destination = new FileOutputStream(targetdest);
						buffer = new byte[1024];

						while(true) {
							bytes_read = source.read(buffer);
							if (bytes_read == -1) break;
							destination.write(buffer, 0, bytes_read);
						}
					}
					finally {
						if (source != null)
							try { source.close(); } catch (IOException e) { ; }
						if (destination != null)
							try { destination.close(); } catch (IOException e) { ; }
					}
				}
			}
		}
	}




        /**
	* Move files to a new dir
	*
	* @param from source file to be moved
	* @param to   destination file
   	* @exception IOException if operation fails
	*/


        public static void moveFileTo(String from, String to) throws IOException    {
            createDir(to) ;
            DeleteFile(to) ;
            File ffrom = new File(from);
            File fto   = new File(to);

            if (!ffrom.exists() || !ffrom.isFile()) return ;
            if(!FileType.validateFileExt(to)){
				throw new IOException(to+" file type is not valid,copy failed!");
			}
            ffrom.renameTo(fto) ;
        }


        /**
	* Delete files
	*
	* @param filename  file to be moved
   	* @exception IOException if operation fails
	*/


        public static void DeleteFile(String filename) throws IOException   {

            File f = new File(filename);
            if (!f.exists() || !f.isFile()) return ;
            f.delete();
        }



        /**
	* get the file without path
	* @param filename  filename with path
   	* @return String  filename without path
	*/


        public static String extractFileName(String filename )  {
            return extractFileName(filename , null) ;
        }


        /**
	* get the file without path
	* @param filename  filename with path
        * @param separator  the path separator , if null , will to be File.separator
   	* @return String  filename without path
	*/


        public static String extractFileName(String filename , String separator)  {
            if(separator == null) separator = File.separator ;
            int pos = filename.lastIndexOf(separator);
            if (pos != -1) return filename.substring(pos+1); else return filename;
        }


       /**
	* get the file ext name
	* @param filename  filename with path
   	* @return String  filename without path
	*/


      public static String extractFileExt(String filename )   {
          return extractFileExt(filename  , null) ;
      }



      /**
	* get the file ext name
	* @param filename  filename with path
        * @param separator  the path separator , if null , will to be File.separator
   	* @return String  filename without path
	*/


      public static String extractFileExt(String filename , String separator)   {
          if(separator == null) separator = File.separator ;
          String s_ = extractFileName(filename , separator);
          int pos = s_.lastIndexOf(".");
          if (pos != -1) return s_.substring(pos+1); else return s_;
      }



      /**
	* get the file path
	* @param filename  filename with path
   	* @return String  file path
	*/

      public static String extractFilePath(String filename )  {
          return  extractFilePath(filename , null ) ;
      }



      /**
	* get the file path
	* @param filename  filename with path
        * @param separator  the path separator , if null , will to be File.separator
   	* @return String  file path
	*/

      public static String extractFilePath(String filename , String separator)  {
          if(separator == null ) separator = File.separator ;
          int pos = filename.lastIndexOf(separator);
          if (pos != -1) return filename.substring(0, pos+1); else return "";
      }


      /**
       * read the string from file
       * @param filename
       * @return String
       */

      public static String loadFile(String filename)   {

          try {
                FileInputStream in = new FileInputStream(new File(filename));
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                convertStream(in, os);
                return os.toString();
          }
          catch (Exception ex) {
              BaseBean base = new BaseBean() ;
              base.writeLog(ex) ;
          }
          return "";
      }




      /**
	* File.getParent() can return null when the file is specified without
	* a directory or is in the root directory. This method handles those cases.
	*
	* @param f the target File to analyze
	* @return the parent directory as a File
	*/
	public static File parent(File f) {
		String dirname = f.getParent();
		if (dirname == null) {
			if (f.isAbsolute()) return new File(File.separator);
			else return new File(System.getProperty("user.dir"));
		}
		return new File(dirname);
	}



      private static void convertStream(InputStream is, OutputStream os) throws NullPointerException, IOException   {

            if (is == null || os == null) throw new NullPointerException();

            byte[] buf = new byte[1024];
            int cnt;
            while ((cnt = is.read(buf)) != -1) os.write(buf, 0, cnt);

            is.close();
            os.close();
        }

}
