/* *************************************************************************
 *
 *  TMPotter - Bi-text Aligner/TMX Editor
 *
 *  Copyright (C) 2015 Hiroshi Miura
 *
 *  Part of this come from OmegaT.
 *
 *  Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
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

package org.tmpotter.segmentation;

import org.tmpotter.util.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * A class representing the language rules and their mapping to the segmentation
 * rules for each particular language.
 * 
 * @author Maxym Mykhalchuk
 */
@SuppressWarnings("serial")
public class MapRule implements Serializable, Cloneable {

  /**
   * creates a new empty MapRule.
   */
  public MapRule() {
  }

  /**
   * creates an initialized MapRule.
   */
  public MapRule(String language, String pattern, List<Rule> rules) {
    this.setLanguage(language);
    this.setPattern(pattern);
    this.setRules(rules);
  }

  /**
   * Language Name
   */
  private String languageCode;

  /**
   * Returns Language Name (to display it in a dialog).
   */
  public String getLanguage() {
    String res = LanguageCodes.getLanguageName(languageCode);
    return StringUtil.isEmpty(res) ? languageCode : res;
  }

  /**
   * Sets Language Name
   */
  public void setLanguage(String language) {
    this.languageCode = language;
  }

  /**
   * Returns Language Code for programmatic usage.
   */
  public String getLanguageCode() {
    return languageCode;
  }

  /**
   * Pattern for the language/country ISO code (of a form LL-CC).
   */
  private Pattern pattern;

  /**
   * Returns Pattern for the language/country ISO code (of a form LL-CC).
   */
  public String getPattern() {
    if (pattern != null) {
      return pattern.pattern();
    } else {
      return null;
    }
  }

  /**
   * Returns Compiled Pattern for the language/country ISO code (of a form
   * LL-CC).
   */
  public Pattern getCompiledPattern() {
    return pattern;
  }

  /**
   * Sets Pattern for the language/country ISO code (of a form LL-CC).
   */
  public void setPattern(String pattern) throws PatternSyntaxException {
        // Fix for bug [1643500]
    // language code in segmentation rule is case sensitive
    // Correction contributed by Tiago Saboga.
    this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
  }

  public MapRule clone() {
    MapRule result;
    try {
      result = (MapRule)super.clone();
    } catch (CloneNotSupportedException ce) {
      throw new RuntimeException();
    }
    result.languageCode = languageCode;
    result.pattern = pattern;
    result.rules = new ArrayList<Rule>(rules.size());
    for (Rule rule : rules) {
      result.rules.add(rule.clone());
    }
    return result;
  }

  /**
   * List of rules (of class {@link Rule}) for the language
   */
  private List<Rule> rules;

  /**
   * Returns List of rules (of class {@link Rule}) for the language
   */
  public List<Rule> getRules() {
    return rules;
  }

  /**
   * Sets List of rules (of class {@link Rule}) for the language
   */
  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }

  /**
   * Indicates whether some other MapRule is "equal to" this one.
   */
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof MapRule)) {
      return false;
    }
    MapRule that = (MapRule) obj;
    return this.getPattern().equals(that.getPattern())
            && this.getLanguage().equals(that.getLanguage())
            && this.getRules().equals(that.getRules());
  }

  /**
   * Returns a hash code value for the object.
   */
  public int hashCode() {
    return this.getPattern().hashCode() + this.getLanguage().hashCode() + this.getRules().hashCode();
  }

  /**
   * Returns a string representation of the MapRule for debugging purposes.
   */
  public String toString() {
    return getLanguage() + " (" + getPattern() + ") " + getRules().toString();
  }
}
