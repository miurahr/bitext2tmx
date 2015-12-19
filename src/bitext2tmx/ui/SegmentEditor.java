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


package bitext2tmx.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;


/**
 *   Segment editor
 *
 */
@SuppressWarnings("serial")
final class SegmentEditor extends DockablePanel {
  final private JTextPane textPane =  new JTextPane();
  final private MainWindow windowMain;

  public SegmentEditor( final MainWindow windowMain )
  {
    super( "SegmentEditor", "SegmentEditor", false );

    this.windowMain = windowMain;

    getDockKey().setName( "Segment Editor" );
    getDockKey().setTooltip( "Segment Editor" );
    getDockKey().setCloseEnabled(false);
    getDockKey().setAutoHideEnabled(false);
    getDockKey().setMaximizeEnabled(false);
    getDockKey().setFloatEnabled(false);
    getDockKey().setResizeWeight( 1.0f );  // takes all resizing
    //getDockKey().setIcon( Icons.getIcon( "icon-small.png" ) );

    textPane.addKeyListener( new KeyAdapter() {
      @Override
      final public void keyReleased( final KeyEvent e ) { 
          onKeyReleased();
      }
    });

    textPane.addMouseListener( new MouseAdapter() {
      @Override
      final public void mouseClicked( final MouseEvent e ) {
        onClicked();
      }
    });

    setLayout( new GridBagLayout() );

    final GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridheight = 1;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.ipadx = 10;
    gbc.ipady = 10;
    gbc.insets = new Insets( 1, 1, 1, 1 );
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;

    final JScrollPane scpn = new JScrollPane( textPane );
    add( scpn, gbc );
  }

  final public String getText() { return( textPane.getText() ); }

  final public void setText( final String strText )
  {
    textPane.setText( strText );
    textPane.setCaretPosition( 0 );
  }

  //final public void setFonts( final Font f ) { _tpn.setFont( f ); }

  final public void setEditorFont( final Font f )
  {
    if( textPane != null ) textPane.setFont( f );
    else System.out.println( " _ed _tpn does not exist yet!" );
  }

  final public void reset() { textPane.setText( "" ); }

  final public int getSelectionStart() { return( textPane.getSelectionStart() ); }

  private void onKeyReleased()
  { windowMain.setTextAreaPosition( textPane.getSelectionStart() ); }

  private void onClicked()
  { windowMain.setTextAreaPosition( textPane.getSelectionStart() ); }

}// SegmentEditor{}


