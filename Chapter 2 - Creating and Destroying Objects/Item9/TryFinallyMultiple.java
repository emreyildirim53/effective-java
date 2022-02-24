package Item9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryFinallyMultiple
{

    private static final int BUFFER_SIZE = 15;

    // try-finally is ugly when used with more than one resource!
    static void copy(String src, String dst) throws IOException
    {
        InputStream in = new FileInputStream(src);
        try
        {
            OutputStream out = new FileOutputStream(dst);
            try
            {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) out.write(buf, 0, n);
            }
            finally
            {
                out.close();
            }
        }
        finally
        {
            in.close();
        }
    }
}