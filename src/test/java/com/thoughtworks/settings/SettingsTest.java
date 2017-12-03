package com.thoughtworks.settings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
 * Created by Sooraj.Pottekat on 12/3/2017.
 *
 * @author Sooraj Pottekat
 */
public class SettingsTest
{
    @Test
    public void getEmptyInputCells() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        Settings settings = new Settings(input);
        List<String> result = settings.getCells();
        assertEquals(new ArrayList<String>(),result);
    }
    @Test
    public void getSingleInputCell() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        input.put("cells","E");
        Settings settings = new Settings(input);
        List<String> result = settings.getCells();
        assertEquals(Arrays.asList("E"),result);
    }
    @Test
    public void getMultipleInputCell() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        input.put("cells","E,T,H,J");
        Settings settings = new Settings(input);
        List<String> result = settings.getCells();
        assertEquals(Arrays.asList("E","T","H","J"),result);
    }

    @Test
    public void emptyInputRolls() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        Settings settings = new Settings(input);
        List<Integer> result = settings.getRolls();
        assertEquals(new ArrayList<String>(),result);
    }
    @Test
    public void getSingleInputRoll() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        input.put("rolls","5");
        Settings settings = new Settings(input);
        List<Integer> result = settings.getRolls();
        assertEquals(Arrays.asList(5),result);
    }
    @Test
    public void getMultipleInputRolls() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        input.put("rolls","5,6,12,2");
        Settings settings = new Settings(input);
        List<Integer> result = settings.getRolls();
        assertEquals(Arrays.asList(5,6,12,2),result);
    }

    @Test
    public void numberOfPlayersNotSet() throws Exception
    {
        HashMap<Object, Object> input = new HashMap<Object,Object>();
        Settings settings = new Settings(input);
        Integer numberOfPlayers = settings.getNumberOfPlayers();
        assertEquals(new Integer(0),numberOfPlayers);
    }
     @Test
     public void getNumberOfPlayer() throws Exception
     {
         HashMap<Object, Object> input = new HashMap<Object,Object>();
         input.put("numberOfPlayers","5");
         Settings settings = new Settings(input);
         Integer numberOfPlayers = settings.getNumberOfPlayers();
         assertEquals(new Integer(5),numberOfPlayers);
     }

}