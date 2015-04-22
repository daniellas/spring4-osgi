package org.springframework.osgi.util.internal;

import org.junit.Assert;
import org.junit.Test;

public class ClassUtilsTest {
    
    @Test
    public void concurentLibShoulBeAvailable() {
        Assert.assertTrue(ClassUtils.concurrentLibAvailable());
    }
}
