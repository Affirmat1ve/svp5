

import org.junit.*;

import java.io.FileWriter;

public class ResourcePoolTest {

    @Test
    public void testCreatePool() {
        int size = 2;
        ResourcePool<Thread> threadPool = new ResourcePool<>(size, new ThreadFactory());
        Assert.assertEquals(2, threadPool.getPoolSize());
        size = 5;
        ResourcePool<FileWriter> filePool = new ResourcePool<>(size, new FileFactory());
        Assert.assertEquals(5, filePool.getPoolSize());
    }

    @Test(expected = IllegalStateException.class)
    public void throwsExceptionAcquirePoolIsTerminated() {
        int size = 2;
        ResourcePool<Thread> threadPool = new ResourcePool<>(size, new ThreadFactory());
        threadPool.shutdown();
        threadPool.getObject();
    }




}