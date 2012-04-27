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

/**
 * This class represents the NFC Forum Well-known Type
 * "Smart Poster Record Type".
 */
public class SmartPosterRecord extends WellKnownRecord {

	private TextRecord title;
	private UriRecord uri;
	private ActionRecord action;

	/**
	 * Creates a new smart poster record.
	 * 
	 * @param title
	 *            The title of the smart poster.
	 * @param uri
	 *            The URI.
	 * @param action
	 *            The action.
	 */
	public SmartPosterRecord(TextRecord title, UriRecord uri, ActionRecord action) {
		this.title = title;
		this.uri = uri;
		this.action = action;
	}

	/**
	 * Default smart poster record constructor.
	 */
	public SmartPosterRecord() {
	}

	/**
	 * Returns the title record.
	 * 
	 * @return The title as an instance of a text record.
	 */
	public TextRecord getTitle() {
		return title;
	}

	/**
	 * Sets the title record.
	 * 
	 * @param title
	 *            The title as an instance of a text record.
	 */
	public void setTitle(TextRecord title) {
		this.title = title;
	}

	/**
	 * Returns the URI record.
	 * 
	 * @return The containing URI record.
	 */
	public UriRecord getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * 
	 * @param uri
	 *            The URI record.
	 */
	public void setUri(UriRecord uri) {
		this.uri = uri;
	}

	/**
	 * Returns the action record of this smart poster record.
	 * 
	 * @return The containing action record.
	 */
	public ActionRecord getAction() {
		return action;
	}

	/**
	 * Sets the action record of this smart poster record. This record defines
	 * the recommended action for the accepting NFC device.
	 * <p>
	 * Currently there are three possible actions.<br>
	 * Action.DEFAULT_ACTION - performs a typical action<br>
	 * Action.SAVE_FOR_LATER - URI shall be saved for later use<br>
	 * Action.OPEN_FOR_EDITING - URI shall be opened for further editing
	 * 
	 * @param action
	 *            The action record.
	 */
	public void setAction(ActionRecord action) {
		this.action = action;
	}

	/**
	 * Returns the title, the URI and the action of this smart poster record in
	 * a human readable form.
	 * 
	 * @return The title, URI and the action as a String.
	 */
	@Override
	public String toString() {
		return "SmartPoster: [" + getTitle() + ", " + getUri() + ", " + getAction() + "]";
	}

	/**
	 * Method checks if this smart poster record has a title.
	 * 
	 * @return Returns true if there is a title and false otherwise.
	 */
	public boolean hasTitle() {
		return title != null;
	}

	/**
	 * Method checks if this smart poster record has an URI.
	 * 
	 * @return Returns true if there is an URI and false otherwise.
	 */
	public boolean hasUri() {
		return uri != null;
	}

	/**
	 * Method checks if this smart poster record has an action.
	 * 
	 * @return Returns true if there is an action and false otherwise.
	 */
	public boolean hasAction() {
		return action != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		SmartPosterRecord other = (SmartPosterRecord) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
