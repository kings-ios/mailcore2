package com.libmailcore;

public class Operation extends NativeObject {
    /** Cancel the operation. */
    public native void cancel();
    /** Returns whether the operation has been cancelled. */
    public native boolean isCancelled();
    
    /** Starts the operation. Calls the aCallback.finished() when the operation is finished.
        @see OperationCallback.finished() */
    public void start(OperationCallback aCallback)
    {
        callback = aCallback;
        nativeStart();
    }
    
    private native void nativeStart();
    
    protected void callCallback()
    {
        if (callback != null) {
            callback.succeeded();
        }
    }
    
    protected OperationCallback callback;
}
