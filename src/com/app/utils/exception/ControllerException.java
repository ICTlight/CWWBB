package com.app.utils.exception;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ControllerException extends Exception {

	private static final long serialVersionUID = -2038697377290762562L;
	private Throwable paramThrowable = null;

	  public ControllerException()
	  {
	  }

	  public ControllerException(String paramString)
	  {
	    super(paramString);
	  }

	  public ControllerException(Throwable paramThrowable)
	  {
	    this.paramThrowable = paramThrowable;
	  }

	  public ControllerException(String paramString, Throwable paramThrowable)
	  {
	    super(paramString);
	    this.paramThrowable = paramThrowable;
	  }

	  public void printStackTrace()
	  {
	    super.printStackTrace();
	    if (this.paramThrowable != null)
	      this.paramThrowable.printStackTrace();
	  }

	  public void printStackTrace(PrintStream paramPrintStream)
	  {
	    super.printStackTrace(paramPrintStream);
	    if (this.paramThrowable != null)
	      this.paramThrowable.printStackTrace(paramPrintStream);
	  }

	  public void printStackTrace(PrintWriter paramPrintWriter)
	  {
	    super.printStackTrace(paramPrintWriter);
	    if (this.paramThrowable != null)
	      this.paramThrowable.printStackTrace(paramPrintWriter);
	  }


}




