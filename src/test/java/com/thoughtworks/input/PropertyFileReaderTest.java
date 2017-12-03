package com.thoughtworks.input;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/*
 * Copyright (c) Multichoice Technical Operations. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Multichoice Technical Operations. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Multichoice Technical Operations.
 *
 * MULTICHOICE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. MULTICHOICE
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * Created by Sooraj.Pottekat on 12/3/2017.
 *
 * @author Sooraj Pottekat
 */
public class PropertyFileReaderTest
{
    @Test(expected = IllegalArgumentException.class)
    public void invalidFilePath() throws Exception
    {
        String filePath = "invalidPath";
        PropertyFileReader propertyFileReader = new PropertyFileReader(filePath);
        Map<Object, Object> properties = propertyFileReader.load();
    }

    @Test
    public void validPathOneProperty() throws Exception
    {
        String filePath = "./src/test/java/resources/testInput.properties";
        PropertyFileReader propertyFileReader = new PropertyFileReader(filePath);
        Map<Object, Object> properties = propertyFileReader.load();
        assertEquals(properties.get("prop1"),"FirstProperty");
        assertEquals(properties.get("prop2"),"SecondProperty");
        assertEquals(properties.get("prop3"),"ThirdProperty");
    }
}