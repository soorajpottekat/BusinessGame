package com.thoughtworks.settings;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Sooraj.Pottekat on 12/3/2017.
 *
 * @author Sooraj Pottekat
 */
public class Settings
{
    private final Map<Object, Object> input;
    private static final String CELLS = "cells";
    private static final String ROLLS = "rolls";
    private static final String NUMBER_OF_PLAYERS = "numberOfPlayers";
    public Settings(Map<Object, Object> input)
    {
        this.input = input;
    }

    public List<String> getCells()
    {
        String list = (String) input.get(CELLS);
        if (list == null)
            return new ArrayList<String>();
        return splitCells(list);
    }

    private List<String> splitCells(String list)
    {
        ArrayList<String> cells = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(list, ",");
        while (tokenizer.hasMoreTokens())
            cells.add(tokenizer.nextToken());
        return cells;
    }

    public List<Integer> getRolls()
    {
        String list = (String) input.get(ROLLS);
        if (list == null)
            return new ArrayList<Integer>();
        return splitRolls(list);
    }
    private List<Integer> splitRolls(String list)
    {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        StringTokenizer tokenizer = new StringTokenizer(list, ",");
        while (tokenizer.hasMoreTokens())
            rolls.add(Integer.parseInt(tokenizer.nextToken()));
        return rolls;
    }

    public Integer getNumberOfPlayers()
    {
        String numberOfPlayers = (String) input.get(NUMBER_OF_PLAYERS);
        if (null == numberOfPlayers)
            return 0;
        return Integer.parseInt(numberOfPlayers);

    }
}
