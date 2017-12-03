package com.thoughtworks.cell;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class CellFactoryTest
{
    @Test
    public void createCellsWithNullInput() throws Exception
    {
        ArrayList<Cell> expected = new ArrayList<Cell>();
        List<Cell> actual = new CellFactory().createCells(null);
        assertEquals(expected,actual);
    }

    @Test
    public void createCellsWithEmptyInput() throws Exception
    {
        ArrayList<Cell> expected = new ArrayList<Cell>();
        List<Cell> actual = new CellFactory().createCells(new ArrayList<String>());
        assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void invalidInput() throws Exception
    {
        new CellFactory().createCells(Arrays.asList("K"));
    }

    @Test
    public void oneEmptyCellInput() throws Exception
    {
        List<Cell> actual = new CellFactory().createCells(Arrays.asList("E"));
        assertTrue(actual.get(0) instanceof Empty);
    }
    @Test
    public void oneTreasureCellInput() throws Exception
    {
        List<Cell> actual = new CellFactory().createCells(Arrays.asList("T"));
        assertTrue(actual.get(0) instanceof Treasure);
    }
    @Test
    public void oneJailCellInput() throws Exception
    {
        List<Cell> actual = new CellFactory().createCells(Arrays.asList("J"));
        assertTrue(actual.get(0) instanceof Jail);
    }
    @Test
    public void oneHotelInput() throws Exception
    {
        List<Cell> actual = new CellFactory().createCells(Arrays.asList("H"));
        assertTrue(actual.get(0) instanceof Hotel);
    }

    @Test
    public void mixedInputsTest() throws Exception
    {
        List<Cell> actual = new CellFactory().createCells(Arrays.asList("H","T","J","E"));
        assertTrue(actual.get(0) instanceof Hotel);
        assertTrue(actual.get(1) instanceof Treasure);
        assertTrue(actual.get(2) instanceof Jail);
        assertTrue(actual.get(3) instanceof Empty);
    }

}