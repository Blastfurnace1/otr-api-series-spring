
package com.blastfurnace.otr.series;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.blastfurnace.otr.AppConfigTest;
import com.blastfurnace.otr.data.series.service.model.SeriesDataWrapper;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for Series Services
 *
 * @author Jim Blackson
 */
public class SeriesAPIRestTests extends AppConfigTest {

	private static final Logger log = LoggerFactory.getLogger(SeriesAPIRestTests.class); 
	
	@Test
	public void WhenSendingGetRequestToControllerReponseObject() throws Exception {
		log.info("Series API Rest Tests - Start");
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.getTestRestTemplate().getForEntity(
				"http://localhost:" + this.getPort() + "/rest/series/get/1", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		HttpHeaders httpHeaders = this.getTestRestTemplate()
				  .headForHeaders("http://localhost:" + this.getPort() + "/rest/series/get/1");
		
		assertTrue(httpHeaders.getContentType()
				  .includes(MediaType.APPLICATION_JSON));
		
		SeriesDataWrapper series = this.getTestRestTemplate().getForObject(
				"http://localhost:" + this.getPort() + "/rest/series/get/1", SeriesDataWrapper.class);

		log.info("Series API Rest Tests - End");
	}
	
}
