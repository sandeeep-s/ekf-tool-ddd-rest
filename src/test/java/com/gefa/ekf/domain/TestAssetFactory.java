package com.gefa.ekf.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.gefa.ekf.domain.Asset.Builder;
import com.gefa.ekf.domain.repositories.TestBusinessTypeRepository;
import com.gefa.ekf.domain.repositories.TestDealerRepository;
import com.gefa.ekf.domain.repositories.TestManufacturerRepository;

public class TestAssetFactory {

	public Asset createAsset() {
		int random = ThreadLocalRandom.current().nextInt(10000, 30000);

		Builder assetBuilder = new Asset.Builder(new TestDealerRepository(), new TestManufacturerRepository(),
				new TestBusinessTypeRepository());
		assetBuilder.gevisNumber(101010L);
		assetBuilder.businessType("new-asset");
		assetBuilder.serialNumber("SerialNo-" + random);
		assetBuilder.manufacturer("Atlas");
		assetBuilder.assetName("JMSTEST-" + random);
		assetBuilder.requestedDisbursementDate(getValidDisbursementDate());
		assetBuilder.internalRefNo("");
		assetBuilder.constructionYear(2017);
		assetBuilder.disbursementParty("invoicing-party");
		assetBuilder.vatIncludedInDisbursment(true);
		assetBuilder.paymentProofAvailable(false);
		assetBuilder.paymentProofDocument(null);
		assetBuilder.invoice("INVOICE-" + random, new Date(), null);
		assetBuilder.vrdAvailable(false);
		assetBuilder.vrd(null, null, null);
		assetBuilder.netPrice(new BigDecimal(10000.0));
		assetBuilder.commentsToGEFA("test dealer comments");
		assetBuilder.assetComments("asset comments");

		return assetBuilder.build();
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
