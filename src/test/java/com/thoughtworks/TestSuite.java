package com.thoughtworks;
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

import com.thoughtworks.cell.CellFactoryTest;
import com.thoughtworks.cell.EmptyTest;
import com.thoughtworks.cell.HotelTest;
import com.thoughtworks.cell.JailTest;
import com.thoughtworks.board.GameBoardTest;
import com.thoughtworks.game.BusinessGameTest;
import com.thoughtworks.input.PropertyFileReaderTest;
import com.thoughtworks.output.ResultsPrinterTest;
import com.thoughtworks.player.PlayerComparatorTest;
import com.thoughtworks.player.PlayerTest;
import com.thoughtworks.settings.SettingsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by soorajpottekat on 12/4/2017.
 */
@RunWith(Suite.class)

@SuiteClasses({
        GameBoardTest.class,
        PlayerTest.class,
        CellFactoryTest.class,
        EmptyTest.class,
        HotelTest.class,
        JailTest.class,
        SettingsTest.class,
        PropertyFileReaderTest.class,
        ResultsPrinterTest.class,
        PlayerComparatorTest.class,
        BusinessGameTest.class
})
public class TestSuite
{
}
