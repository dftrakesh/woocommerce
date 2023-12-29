package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Environment {
    private String storeId;
    private String homeUrl;
    private String siteUrl;
    private String version;
    private String logDirectory;
    private Boolean logDirectoryWritable;
    private String wpVersion;
    private Boolean wpMultisite;
    private Long wpMemoryLimit;
    private Boolean wpDebugMode;
    private Boolean wpCron;
    private String language;
    private String serverInfo;
    private String phpVersion;
    private Long phpPostMaxSize;
    private Long phpMaxExecutionTime;
    private Long phpMaxInputVars;
    private String curlVersion;
    private Boolean suhosinInstalled;
    private Long maxUploadSize;
    private String mysqlVersion;
    private String mysqlVersionString;
    private String defaultTimezone;
    private Boolean fsockopenOrCurlEnabled;
    private Boolean soapclientEnabled;
    private Boolean domdocumentEnabled;
    private Boolean gzipEnabled;
    private Boolean mbstringEnabled;
    private Boolean remotePostSuccessful;
    private Long remotePostResponse;
    private Boolean remoteGetSuccessful;
    private Long remoteGetResponse;
    private String externalObjectCache;
}