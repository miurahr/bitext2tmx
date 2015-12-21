/*
#######################################################################
#
#  bitext2tmx - Bitext Aligner/TMX Editor
#
#  Copyright (C) 2005-2006 Susana Santos Antón
#            (C) 2006-2009 Raymond: Martin et al
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
#
#######################################################################
*/

package bitext2tmx.engine;


/**
 *  Action when segument changing.
 * 
 */
public class SegmentChanges {
  int kind;
  int pos;
  boolean source;
  String phrase;
  int indexLine;
  int [] numEliminada;


  /**
   * Constructor.
   */
  public SegmentChanges() {
    kind        = 0;
    pos         = 0;
    source      = false;
    phrase       = "";
    indexLine = -1;
  }

  /**
   * Constructor.
   * 
   * @param kind tipo
   * @param position  pos
   * @param source fuente
   * @param phrase frase
   * @param index ident line
   */
  public SegmentChanges( int kind, int position, boolean source, 
      String phrase, int index )  {
    this.kind        = kind;
    this.pos         = position;
    this.source      = source;
    this.phrase      = phrase;
    this.indexLine   = index;
  }

  /**
   * Accessor for kind.
   * 
   * @return kind
   */
  public int     getKind()         {
    return ( kind );
  }
  
  /**
   * Accessor for position.
   * 
   * @return position
   */
  public int     getPosition()          {
    return  ( pos );
  }
  
  /**
   * Accessor for frase.
   * 
   * @return frase
   */
  public String  getFrase()        {
    return ( phrase );
  }

  /**
   * Accessor for ident line.
   * 
   * @return ident
   */
  public int     getIdent_linea()  {
    return ( indexLine );
  }

  /**
   * Accessor for source/translation indicator.
   * 
   * @return source
   */
  public boolean getSource()       {
    return ( source );
  }
  
  /**
   * Accessor for num eliminada.
   * 
   * @return numEliminada
   */
  public int[]   getNumEliminada() {
    return ( numEliminada );
  }

  /**
   * Accessor for TAM.
   * 
   * @return length of numEliminada
   */
  public int getTam() {
    int tam = numEliminada.length;

    return ( tam );
  }

  /**
   * Setter for Tipo.
   * 
   * @param ktipo to be set
   */
  public void setTipo( int ktipo )         {
    kind   = ktipo;
  }
  
  /**
   * Setter for position.
   * 
   * @param kpos to set
   */
  public void setPos( int kpos )           {
    pos    = kpos;
  }
  
  /**
   * Setter for fuente.
   * 
   * @param source to set boolean
   */
  public void setSource( boolean source ) {
    this.source = source;
  }
  
  /**
   * Setter for frase.
   * 
   * @param kfrase string to set
   */
  public void setFrase( String kfrase )    {
    phrase  = kfrase;
  }

  /**
   * Setter for line ident.
   * 
   * @param index to set
   */
  public void setIdent_linea( int index ) {
    indexLine = index;
  }

  /**
   * Setter for num of Eliminada.
   * 
   * @param keliminadas eliminada
   * @param tam number of array
   */
  public void setNumEliminada( int[] keliminadas, int tam ) {
    numEliminada = new int[tam];
    for ( int cont = 0; cont < tam; cont++ ) {
      numEliminada[cont] = keliminadas[cont];
    }
  }
}