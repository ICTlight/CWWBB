package com.app.utils.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DaoException extends RuntimeException
{
  
  private static final long serialVersionUID = -8132783210548961444L;
  private Throwable paramThrowable = null;

  public DaoException()
  {
  }

  public DaoException(String paramString)
  {
    super(paramString);
  }

  public DaoException(Throwable paramThrowable)
  {
    this.paramThrowable = paramThrowable;
  }

  public DaoException(String paramString, Throwable paramThrowable)
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