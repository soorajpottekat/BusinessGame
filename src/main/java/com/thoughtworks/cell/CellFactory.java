package com.thoughtworks.cell;
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

/**
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class CellFactory
{
    public List<Cell> createCells(List<String> inputs)
    {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        if (inputs == null)
            return cells;
        for (String input : inputs)
            cells.add(createOneCell(input));
        return cells;
    }

    private Cell createOneCell(String input)
    {
        if("E".equals(input))
            return new Empty();
        else if("T".equals(input))
            return new Treasure();
        else if("J".equals(input))
            return new Jail();
        else if("H".equals(input))
            return new Hotel();
        else
            throw new IllegalArgumentException("Invalid input to create cells : " + input);
    }
}
