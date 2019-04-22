package swust.yang.exception;

public class FileNotDirectoryException extends Exception {
       /**
	 * 
	 */
	private static final long serialVersionUID = 5454785846922103189L;

	public FileNotDirectoryException() {
    	super();
    }
       
    public FileNotDirectoryException(String msg) {
    	super(msg);
    }
       
       
}
