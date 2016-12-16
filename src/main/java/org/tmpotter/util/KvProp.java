/* ************************************************************************
 *
 *  TMPotter - Bi-text Aligner/TMX Editor.
 *
 *  Copyright (C) 2005-2009 Raymond: Martin 
 *            (C) 2015 Hiroshi Miura
 *
 *  Copyright (C) 2014 Alex Buloichik 
 *
 *  This file is part of TMPotter.
 *
 *  TMPotter is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TMPotter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with TMPotter.  If not, see http://www.gnu.org/licenses/.
 *
 * *************************************************************************/

package org.tmpotter.util;


/**
 * Class for store key-value pair.
 *
 * @author Alex Buloichik (alex73mail@gmail.com)
 */
public class KvProp {

    private final String type;
    private final String value;

	/**
	 * Constructor with kv.
     * @param key key.
     * @param value value.
	 */
	public KvProp(String key, String value) {
        this.type = key;
        this.value = value;
    }

	/**
	 * Get key.
     * @return key.
	 */
	public String getType() {
        return type;
    }

	/**
     * Get value.
     * @return value.
	 */
	public String getValue() {
        return value;
    }
}
