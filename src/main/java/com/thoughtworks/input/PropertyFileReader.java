package com.thoughtworks.input;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Sooraj.Pottekat on 12/3/2017.
 *
 * @author Sooraj Pottekat
 */
public class PropertyFileReader
{
    private final String filePath;

    public PropertyFileReader(String filePath)
    {
        this.filePath = filePath;
    }

    public Map<Object,Object> load()
    {
        Properties prop = new Properties();
        try
        {
            prop.load(new FileInputStream(filePath));
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("Invalid file path IO Exception occurred Path : " + filePath );
        }
        return prop;
    }
}
