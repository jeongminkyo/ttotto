package com.landvibe.ttotto.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;
import net.logstash.logback.fieldnames.LogstashFieldNames;

import java.io.IOException;
import java.util.Map;

public class RequestLogProvider extends AbstractFieldJsonProvider<ILoggingEvent> implements FieldNamesAware<LogstashFieldNames> {

	@Override
	public void writeTo(JsonGenerator generator, ILoggingEvent iLoggingEvent) throws IOException {
		Map<String, String> mdcProperties = iLoggingEvent.getMDCPropertyMap();

		String requestInfos = mdcProperties.get("request");
		if (requestInfos == null) return;

		Map<String, Object> requestInfoMap = Map.of(
			"request", new ObjectMapper().readTree(requestInfos)
		);

		JsonWritingUtils.writeMapEntries(generator, requestInfoMap);
		if (this.getFieldName() != null) {
			generator.writeEndObject();
		}
	}

	@Override
	public void setFieldNames(LogstashFieldNames fieldNames) {
		this.setFieldName(fieldNames.getMdc());
	}
}
