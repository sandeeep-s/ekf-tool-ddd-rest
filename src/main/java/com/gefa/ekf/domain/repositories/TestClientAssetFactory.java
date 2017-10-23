package com.gefa.ekf.domain.repositories;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.gefa.ekf.client.domain.ClientAsset;
import com.gefa.ekf.domain.Asset;

public class TestClientAssetFactory {

	public ClientAsset createAsset() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_TO_GEFA);

		ClientAsset asset = new ClientAsset();

		int random = ThreadLocalRandom.current().nextInt(10000, 30000);

		asset.setGevisNumber(101010L);
		asset.setBusinessType("new-asset");
		asset.setSerialNumber("SerialNo-" + random);
		asset.setManufacturerTitle("Atlas");
		asset.setAssetName("JMSTEST-" + random);
		asset.setRequestedDisbursementDate(getValidDisbursementDate());
		asset.setInternalRefNo("");
		asset.setConstructionYear(2017);
		asset.setDisbursementParty("invoicing-party");
		asset.setVatIncludedInDisbursment(true);
		asset.setPaymentProofAvailable(false);
		asset.setPaymentProofDocument(null);
		asset.setInvoiceDate(new Date());
		asset.setInvoiceNumber("INVOICE-" + random);
		asset.setInvoiceDocument(null);
		asset.setVrdAvailable(false);
		asset.setRegistrationNumber(null);
		asset.setRegisteredTo(null);
		asset.setVehicleRegistrationDocument(null);
		asset.setNetPrice(new BigDecimal(10000.0));
		asset.setCommentsToGEFA("test dealer comments");
		asset.setAssetComments("asset comments");

		return asset;

	}

	public Date getValidDisbursementDate() {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int offset = (SATURDAY == dayOfWeek) ? 2 : (SUNDAY == dayOfWeek) ? 1 : 0;
		cal.add(Calendar.DAY_OF_MONTH, offset);
		return cal.getTime();

	}

	public static final int SATURDAY = 7;

	public static final int SUNDAY = 1;

	public static final String DATE_FORMAT_TO_GEFA = "yyyy-MM-dd'T'HH:mm:ss.SS";

}
