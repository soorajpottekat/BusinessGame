package com.thoughtworks.game;
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
 * Created by Sooraj.Pottekat on 11/28/2017.
 *
 * @author Sooraj Pottekat
 */
public class BusinessGame
{
    private static ArrayList<String> board;
    public static void setBoard(ArrayList<String> board)
    {
        BusinessGame.board = board;
    }

    public String roll(int value)
    {
        if(value < 2 || value > 12)
            throw new IllegalArgumentException("The value should be with in range 2-12");
        return board.get((value - 1) % board.size());
    }
}