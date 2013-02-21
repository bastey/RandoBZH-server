package com.bastey.randofr.reader;

/**
 * @author BASTEY
 */
public class ArretBatchException
    extends RuntimeException
{
    private static final long serialVersionUID = -951033887572914555L;

    public ArretBatchException()
    {

    }

    public ArretBatchException( String message )
    {
        super( message );
    }

    public ArretBatchException( String message, Throwable e )
    {
        super( message, e );
    }

}
