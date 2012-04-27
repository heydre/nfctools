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
 * "The Recommended Action Record".
 * <p>
 * This record is local record type of the smart poster record type and defines
 * the recommended action for the accepting NFC device.
 */
public class ActionRecord extends WellKnownRecord {

	private Action action;

	/**
	 * Creates a new action record.
	 * <p>
	 * Currently there are three possible actions.<br>
	 * Action.DEFAULT_ACTION - performs a typical action<br>
	 * Action.SAVE_FOR_LATER - URI shall be saved for later use<br>
	 * Action.OPEN_FOR_EDITING - URI shall be opened for further editing
	 * 
	 * @param action
	 *            The recommended action.
	 */
	public ActionRecord(Action action) {
		this.action = action;
	}

	/**
	 * Default action record constructor.
	 */
	public ActionRecord() {
	}

	/**
	 * Returns the action as an instance of Action.
	 * 
	 * @return The recommended action.
	 */
	public Action getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "Action: " + action;
	}

	/**
	 * Sets the action of this record.
	 * <p>
	 * Currently there are three possible actions.<br>
	 * Action.DEFAULT_ACTION - performs a typical action<br>
	 * Action.SAVE_FOR_LATER - URI shall be saved for later use<br>
	 * Action.OPEN_FOR_EDITING - URI shall be opened for further editing
	 * 
	 * @param action
	 *            The recommended action.
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * Method checks if an action has been set (is not null).
	 * 
	 * @return True if there is an action and false otherwise.
	 */
	public boolean hasAction() {
		return action != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
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
		ActionRecord other = (ActionRecord) obj;
		if (action != other.action)
			return false;
		return true;
	}

}
