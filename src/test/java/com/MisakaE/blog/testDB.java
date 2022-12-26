package com.MisakaE.blog;

import com.misakaE.blog.util.DBUtil;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.junit.Test;

public class testDB {
    @Test
    public void testDB(){
        System.out.println((DBUtil.getConnection()));
    }
}
