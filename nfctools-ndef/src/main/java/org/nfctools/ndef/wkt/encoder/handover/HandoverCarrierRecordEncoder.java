/**
 * Copyright 2011 Adrian Stabiszewski, as@nfctools.org
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

package org.nfctools.ndef.wkt.encoder.handover;

import java.io.ByteArrayOutputStream;

import org.nfctools.ndef.NdefConstants;
import org.nfctools.ndef.NdefMessageEncoder;
import org.nfctools.ndef.NdefRecord;
import org.nfctools.ndef.Record;
import org.nfctools.ndef.ext.ExternalTypeRecord;
import org.nfctools.ndef.mime.MimeRecord;
import org.nfctools.ndef.wkt.encoder.RecordEncoder;
import org.nfctools.ndef.wkt.records.AbstractWellKnownRecord;
import org.nfctools.ndef.wkt.records.handover.HandoverCarrierRecord;
import org.nfctools.ndef.wkt.records.handover.HandoverCarrierRecord.CarrierTypeFormat;

/**
 * 
 * @author Thomas Rorvik Skjolberg (skjolber@gmail.com)
 *
 */

public class HandoverCarrierRecordEncoder implements RecordEncoder {

	@Override
	public boolean canEncode(Record record) {
		return record instanceof HandoverCarrierRecord;
	}

	@Override
	public NdefRecord encodeRecord(Record record, NdefMessageEncoder messageEncoder) {
		
		HandoverCarrierRecord handoverCarrierRecord = (HandoverCarrierRecord)record;
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		CarrierTypeFormat carrierTypeFormat = handoverCarrierRecord.getCarrierTypeFormat();
		if(carrierTypeFormat == null) {
			throw new IllegalArgumentException("Expected carrier type format");
		}
		bout.write(carrierTypeFormat.getValue() & 0x7);
		
		Object carrierType = handoverCarrierRecord.getCarrierType();
		
		byte[] encoded;
		
		switch(carrierTypeFormat) {
			case WellKnown : {
				// NFC Forum well-known type [NFC RTD]
				if(carrierType instanceof AbstractWellKnownRecord) {
					AbstractWellKnownRecord abstractWellKnownRecord = (AbstractWellKnownRecord)carrierType;
					
					encoded = messageEncoder.encodeSingle(abstractWellKnownRecord);
					
					break;
				} else {
					throw new IllegalArgumentException();
				}
			}
			case Media : {
				// Media-type as defined in RFC 2046 [RFC 2046]
				String string = (String)carrierType;
				
				encoded = string.getBytes(NdefConstants.DEFAULT_CHARSET);
				
				break;
			}
			case AbsoluteURI : {
				// Absolute URI as defined in RFC 3986 [RFC 3986]
				String string = (String)carrierType;
				
				encoded = string.getBytes(NdefConstants.DEFAULT_CHARSET);
				
				break;
			}
			case External : {
				// NFC Forum external type [NFC RTD]
				if(carrierType instanceof ExternalTypeRecord) {
					ExternalTypeRecord externalTypeRecord = (ExternalTypeRecord)carrierType;
					
					encoded = messageEncoder.encodeSingle(externalTypeRecord);
									
					break;
				} else {
					throw new IllegalArgumentException();
				}
			}
			default: {
				throw new RuntimeException();
			}
		}
		
		if(encoded.length > 255) {
			throw new IllegalArgumentException("Carrier type 255 byte limit exceeded.");
		}
		bout.write(encoded.length);
		bout.write(encoded, 0, encoded.length);
		
		if(handoverCarrierRecord.hasCarrierData()) {
			bout.write(handoverCarrierRecord.getCarrierData(), 0, handoverCarrierRecord.getCarrierDataSize());
		}
		
		return new NdefRecord(NdefConstants.TNF_WELL_KNOWN, HandoverCarrierRecord.TYPE, record.getId(), bout.toByteArray());
	}

}