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

/**
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class CellFactory
{
    public ArrayList<Cell> createCells(String[] inputs)
    {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        if (inputs == null)
            return cells;
        for (int i = 0; i < inputs.length; i++)
        {
            createOneCell(inputs[i], cells);
        }
        return cells;
    }

    private void createOneCell(String input, ArrayList<Cell> cells)
    {
        if("E".equals(input))
            cells.add(new Empty());
        else if("T".equals(input))
            cells.add(new Treasure());
        else if("J".equals(input))
            cells.add(new Jail());
        else if("H".equals(input))
            cells.add(new Hotel());
        else
            throw new IllegalArgumentException("Invalid input to create cells : " + input);
    }
}
