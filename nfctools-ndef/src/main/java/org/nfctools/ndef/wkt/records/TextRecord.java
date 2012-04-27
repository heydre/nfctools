/**
 * Copyright 2011-2012 Adrian Stabiszewski, as@nfctools.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nfctools.ndef.wkt.records;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * This class represents the NFC Forum Well-known Type "NFC Text Record Type".
 */
public class TextRecord extends WellKnownRecord {

	public static final byte LANGUAGE_CODE_MASK = 0x1F;

	/**
	 * Indicates the UTF-8 encoding scheme of the containing text.
	 */
	public static final Charset UTF8 = Charset.forName("UTF-8");

	/**
	 * Indicates the UTF-16 encoding scheme of the containing text.
	 */
	public static final Charset UTF16 = Charset.forName("UTF-16BE");

	private String text;
	private Charset encoding;
	private Locale locale;

	/**
	 * Creates a new text record.
	 * <p>
	 * The encoding-scheme of the text will be UTF-8. The language code depends
	 * on the host environment. If you want another encoding-scheme and/or
	 * language code use another constructor.
	 * 
	 * @param text
	 *            The text of this record.
	 */
	public TextRecord(String text) {
		this(text, UTF8, Locale.getDefault());
	}

	/**
	 * Creates a new text record.
	 * <p>
	 * The encoding-scheme of the text will be UTF-8. If you want another
	 * encoding scheme use another constructor.
	 * 
	 * @param text
	 *            The text of this record.
	 * @param locale
	 *            The ISO/IANA language code of the text in this record.
	 *            Examples: "en_US", "de".
	 */
	public TextRecord(String text, Locale locale) {
		this(text, UTF8, locale);
	}

	/**
	 * Creates a new text record.
	 * 
	 * @param text
	 *            The text of this record.
	 * @param encoding
	 *            The character-encoding scheme, the text should have. This
	 *            value has to be either UTF-8 or UTF-16. You can make use of
	 *            public constants of this class.
	 * @param locale
	 *            The ISO/IANA language code of the text in this record.
	 *            Examples: "en_US", "de".
	 * @throws IllegalArgumentException
	 *             If encoding is neither UTF-8 or UTF-16.
	 */
	public TextRecord(String text, Charset encoding, Locale locale) {
		this.encoding = encoding;
		this.text = text;
		this.locale = locale;
		if (!encoding.equals(UTF8) && !encoding.equals(UTF16))
			throw new IllegalArgumentException("unsupported encoding. only utf8 and utf16 are allowed.");
	}

	/**
	 * Default text record constructor.
	 */
	public TextRecord() {
	}

	/**
	 * Returns the containing text.
	 * 
	 * @return The containing text as a String.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the ISO/IANA language code of this text record.
	 * 
	 * @return The language code.
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Returns the character-encoding scheme of this text record.
	 * 
	 * @return The encoding scheme as an instance of Charset.
	 */
	public Charset getEncoding() {
		return encoding;
	}

	/**
	 * Returns the containing text, the key (if present) and the language code
	 * of this record in a human readable form.
	 * 
	 * @return The text, the key and the language code as a String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: [");

		if (hasKey())
			sb.append("Key/Id: ").append(getKey()).append(", ");

		sb.append("Text: ").append(text).append(", ");
		sb.append("Locale: " + locale.getLanguage()).append(locale.getCountry() == null || locale.getCountry().length() == 0 ? "" : ("-" + locale.getCountry()));

		sb.append("]");
		return sb.toString();
	}

	/**
	 * Sets the text of this record.
	 * 
	 * @param text
	 *            The text of this record.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the character-encoding scheme of the text. This value has to be
	 * either UTF-8 or UTF-16. You can make use of the public constants of this
	 * class.
	 * 
	 * @param encoding
	 *            The encoding scheme.
	 * @throws IllegalArgumentException
	 *             If encoding is neither UTF8 or UTF16.
	 */
	public void setEncoding(Charset encoding) {
		if (!encoding.equals(UTF8) && !encoding.equals(UTF16))
			throw new IllegalArgumentException("unsupported encoding. only utf8 and utf16 are allowed.");

		this.encoding = encoding;
	}

	/**
	 * Defines the ISO/IANA language code of the text in this record. Examples:
	 * "en_US", "de".
	 * 
	 * @param locale
	 *            The language code.
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * Method checks if text is not null.
	 * 
	 * @return Returns true if there is already text and false otherwise.
	 */
	public boolean hasText() {
		return text != null;
	}

	/**
	 * Method checks if Locale is not null.
	 * 
	 * @return Returns true if there is a Locale defined and false otherwise.
	 */
	public boolean hasLocale() {
		return locale != null;
	}

	/**
	 * Method checks if encoding is not null.
	 * 
	 * @return Returns true if there is a encoding defined and false otherwise.
	 */
	public boolean hasEncoding() {
		return encoding != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextRecord other = (TextRecord) obj;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}
