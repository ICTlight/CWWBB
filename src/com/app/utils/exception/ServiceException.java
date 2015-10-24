package com.app.utils.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ServiceException extends RuntimeException
{
	
  private static final long serialVersionUID = 1269400238371242060L;
  private Throwable paramThrowable = null;

  public ServiceException()
  {
  }

  public ServiceException(String paramString)
  {
    super(paramString);
  }

  public ServiceException(Throwable paramThrowable)
  {
    this.paramThrowable = paramThrowable;
  }

  public ServiceException(String paramString, Throwable paramThrowable)
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