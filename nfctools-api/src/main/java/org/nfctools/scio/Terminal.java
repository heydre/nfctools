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
package org.nfctools.scio;

import java.io.IOException;

import javax.smartcardio.CardTerminal;

import org.nfctools.io.NfcDevice;
import org.nfctools.ndef.NdefListener;
import org.nfctools.nfcip.NFCIPConnectionListener;

public interface Terminal extends NfcDevice {

	boolean canHandle(String terminalName);

	String getTerminalName();

	void initInitiatorDep() throws IOException;

	void initTargetDep() throws IOException;

	void setCardTerminal(CardTerminal cardTerminal);

	CardTerminal getCardTerminal();

	void setStatusListener(TerminalStatusListener statusListener);

	void setNfcipConnectionListener(NFCIPConnectionListener nfcipConnectionListener);

	void setNdefListener(NdefListener ndefListener);
}
