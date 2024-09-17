package edu.grinnell.csc207.blocks;

import java.io.PrintWriter;

/**
 * A text block surrounded by a single letter.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class Surrounded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box.
   */
  AsciiBlock contents;

  /**
   * The character we put around the box.
   */
  String boxChar;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents
   *   The contents of the block.
   *
   * @param surroundChar
   *   The character that we use to surround the block.
   */
  public Surrounded(AsciiBlock blockContents, char surroundChar) {
    this.contents = blockContents;
    this.boxChar = Character.toString(surroundChar);
  } // Boxed(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   If the row is invalid.
   */
  public String row(int i) throws Exception {

    String row;
    
    if (i == 0){
      row = this.boxChar.repeat(this.contents.width() + 2);
    } else if (i < this.contents.height() - 1){
       row = this.boxChar.concat(this.contents.row(this.contents.height() - i + 1). concat(this.boxChar)); 
    } else {
      row = this.boxChar.repeat(this.contents.width() + 2);
    }

    return row;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.contents.height() + 2;  
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the numbrer of columns
   */
  public int width() {
    return this.contents.width() + 2;
  } // width()
} // class Surrounded
