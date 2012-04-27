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

/**
 * This class represents the NFC Forum Well-known Type "NFC URI Record Type".
 */
public class UriRecord extends WellKnownRecord {

	public static final Charset DEFAULT_URI_CHARSET = Charset.forName("UTF-8");

	/**
	 * No URI Prefix.
	 */
	public static final String PREFIX_0x00 = "";

	/**
	 * http://www.
	 */
	public static final String PREFIX_0x01 = "http://www.";

	/**
	 * https://www.
	 */
	public static final String PREFIX_0x02 = "https://www.";

	/**
	 * http://
	 */
	public static final String PREFIX_0x03 = "http://";

	/**
	 * https://
	 */
	public static final String PREFIX_0x04 = "https://";

	/**
	 * tel:
	 */
	public static final String PREFIX_0x05 = "tel:";

	/**
	 * mailto:
	 */
	public static final String PREFIX_0x06 = "mailto:";

	/**
	 * ftp://anonymous:anonymous@
	 */
	public static final String PREFIX_0x07 = "ftp://anonymous:anonymous@";

	/**
	 * ftp://ftp.
	 */
	public static final String PREFIX_0x08 = "ftp://ftp.";

	/**
	 * ftps://
	 */
	public static final String PREFIX_0x09 = "ftps://";

	/**
	 * sftp://
	 */
	public static final String PREFIX_0x0A = "sftp://";

	/**
	 * smb://
	 */
	public static final String PREFIX_0x0B = "smb://";

	/**
	 * nfs://
	 */
	public static final String PREFIX_0x0C = "nfs://";

	/**
	 * ftp://
	 */
	public static final String PREFIX_0x0D = "ftp://";

	/**
	 * dav://
	 */
	public static final String PREFIX_0x0E = "dav://";

	/**
	 * news:
	 */
	public static final String PREFIX_0x0F = "news:";

	/**
	 * telnet://
	 */
	public static final String PREFIX_0x10 = "telnet://";

	/**
	 * imap:
	 */
	public static final String PREFIX_0x11 = "imap:";

	/**
	 * rtsp://
	 */
	public static final String PREFIX_0x12 = "rtsp://";

	/**
	 * urn:
	 */
	public static final String PREFIX_0x13 = "urn:";

	/**
	 * pop:
	 */
	public static final String PREFIX_0x14 = "pop:";

	/**
	 * sip:
	 */
	public static final String PREFIX_0x15 = "sip:";

	/**
	 * sips:
	 */
	public static final String PREFIX_0x16 = "sips:";

	/**
	 * tftp:
	 */
	public static final String PREFIX_0x17 = "tftp:";

	/**
	 * btspp://
	 */
	public static final String PREFIX_0x18 = "btspp://";

	/**
	 * btl2cap://
	 */
	public static final String PREFIX_0x19 = "btl2cap://";

	/**
	 * btgoep://
	 */
	public static final String PREFIX_0x1A = "btgoep://";

	/**
	 * tcpobex://
	 */
	public static final String PREFIX_0x1B = "tcpobex://";

	/**
	 * irdaobex://
	 */
	public static final String PREFIX_0x1C = "tirdaobex://";

	/**
	 * file://
	 */
	public static final String PREFIX_0x1D = "file://";

	/**
	 * urn:epc:id:
	 */
	public static final String PREFIX_0x1E = "urn:epc:id:";

	/**
	 * urn:epc:tag:
	 */
	public static final String PREFIX_0x1F = "urn:epc:tag:";

	/**
	 * urn:epc:pat:
	 */
	public static final String PREFIX_0x20 = "urn:epc:pat:";

	/**
	 * urn:epc:raw:
	 */
	public static final String PREFIX_0x21 = "urn:epc:raw:";

	/**
	 * urn:epc:
	 */
	public static final String PREFIX_0x22 = "urn:epc:";

	/**
	 * urn:nfc:
	 */
	public static final String PREFIX_0x23 = "urn:nfc:";

	/**
	 * Possible URI-Prefixes as they are defined in the official technical
	 * specifications of the URI Record Type chapter 3.2.2.
	 */
	public static final String[] abbreviableUris = { "", "http://www.", "https://www.", "http://", "https://", "tel:", "mailto:", "ftp://anonymous:anonymous@", "ftp://ftp.", "ftps://", "sftp://", "smb://", "nfs://", "ftp://", "dav://", "news:", "telnet://", "imap:", "rtsp://", "urn:", "pop:",
			"sip:", "sips:", "tftp:", "btspp://", "btl2cap://", "btgoep://", "tcpobex://", "irdaobex://", "file://", "urn:epc:id:", "urn:epc:tag:", "urn:epc:pat:", "urn:epc:raw:", "urn:epc:", "urn:nfc:" };

	private String uri;

	private String prefix;

	/**
	 * Creates a new URI record with an absolute URI.
	 * 
	 * @param uri
	 *            The complete URI as a string.
	 */
	public UriRecord(String uri) {
		this("", uri);
	}

	/**
	 * Creates a new URI record with a prefix.
	 * 
	 * @param prefix
	 *            The URI prefix.
	 * @param uri
	 *            The rest of the URI.
	 */
	public UriRecord(String prefix, String uri) {
		this.prefix = prefix;
		this.uri = prefix + uri;
	}

	/**
	 * Default URI record constructor.
	 */
	public UriRecord() {
	}

	/**
	 * Returns the URI.
	 * 
	 * @return The URI as a string.
	 */
	public String getUri() {
		return this.uri;
	}

	/**
	 * Returns the URI prefix.
	 * 
	 * @return The prefix of the URI as a string.
	 */
	public String getPrefix() {
		return this.prefix;
	}

	/**
	 * Sets the URI.
	 * 
	 * @param uri
	 *            The complete URI.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Sets the prefix of the URI.
	 * 
	 * @param prefix
	 *            The prefix. You can use the public constants of this class.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Returns the complete URI in a human readable form.
	 */
	@Override
	public String toString() {
		return "Uri: [" + uri + "]";
	}

	/**
	 * Method checks if an URI already has been set. Note, the method does not
	 * check, if the URI is correct formatted and will also return true in this
	 * case.
	 * 
	 * @return True if an arbitrary URI has been set and false otherwise.
	 */
	public boolean hasUri() {
		return uri != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		UriRecord other = (UriRecord) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
