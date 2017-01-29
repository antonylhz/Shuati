package com.antonylhz.shuati.ood.excel;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by antonylhz on 3/3/16.
 */
public class ExcelTest {

    @Test
    public void testGetAlphabeticalId() throws Exception {
        Assert.assertEquals("AA" , Excel.getAlphabeticalColumn(27));
        Assert.assertEquals("YZ" , Excel.getAlphabeticalColumn(676));
    }
}