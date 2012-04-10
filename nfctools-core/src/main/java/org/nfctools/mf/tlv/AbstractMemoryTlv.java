package org.nfctools.mf.tlv;

import org.nfctools.mf.MfUtils;

public class AbstractMemoryTlv extends Tlv {

	protected int pageAddress;
	protected int byteOffset;
	protected int size;
	protected int bytesPerPage;

	public AbstractMemoryTlv() {
	}

	public AbstractMemoryTlv(byte[] bytes) {
		pageAddress = MfUtils.getMostSignificantNibble(bytes[0]);
		byteOffset = MfUtils.getLeastSignificantNibble(bytes[0]);
		size = bytes[1];
		bytesPerPage = MfUtils.getLeastSignificantNibble(bytes[2]);
	}

	public byte[] toBytes() {
		byte[] bytes = new byte[3];
		bytes[0] = MfUtils.encodeNibbles(pageAddress, byteOffset);
		bytes[1] = (byte)size;
		bytes[2] = MfUtils.encodeNibbles(0, bytesPerPage);
		return bytes;
	}

	public int getPosition() {
		return (int)Math.round(pageAddress * (int)Math.pow(2, bytesPerPage) + byteOffset);
	}

	public int getPageAddress() {
		return pageAddress;
	}

	public void setPageAddress(int pageAddress) {
		this.pageAddress = pageAddress;
	}

	public int getByteOffset() {
		return byteOffset;
	}

	public void setByteOffset(int byteOffset) {
		this.byteOffset = byteOffset;
	}

	public int getBytesPerPage() {
		return bytesPerPage;
	}

	public void setBytesPerPage(int bytesPerPage) {
		this.bytesPerPage = bytesPerPage;
	}

	public int getSize() {
		if (size == 0)
			return 256;
		else
			return size;
	}

	public void setSize(int size) {
		if (size == 256)
			size = 0;
		else
			this.size = size;
	}

}
