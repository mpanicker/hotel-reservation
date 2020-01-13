package com.techpro.api.hotelreservation.db;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.techpro.api.hotelreservation.domain.Reservation;
import org.codehaus.jackson.map.util.ISO8601Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by manoj on 1/12/2020.
 */
@Component
public class DynamoDBUtil {
    private final static Logger log = LoggerFactory.getLogger(DynamoDBUtil.class);

    @Autowired
    DynamoDBMapper dynamoDBMapper;

   /* public static DynamoDBMapper getDynamoDBMapper(String region) {

        return new DynamoDBMapper(getAmazonDynamoDBClient(region));
    }

    private static AmazonDynamoDB getAmazonDynamoDBClient(String region) {

        return AmazonDynamoDBClientBuilder.standard().withCredentials(awsCredentialsProvider()).withRegion(region)
                .build();
    }

    private static AWSCredentialsProvider awsCredentialsProvider() {

        return new DefaultAWSCredentialsProviderChain();
    }*/

    public Reservation saveReservation(Reservation reservation, String region) {

        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .build();


        dynamoDBMapper.save(reservation);
        return dynamoDBMapper.load(reservation);

    }

   /* public static void addEntryToSyncTable(List<TagMetadataV2> tags, String region, String syncTableName, String action, MetadataSyncMappingProperties msmp) {
        Date currentDate = new Date();
        String isoDateStr = ISO8601Utils.format(currentDate);

        ArrayList<TagMetadataSync> tagMetadataSyncList = new ArrayList();
        for(TagMetadataV2 tagMetadataV2: tags) {
            TagMetadataSync tagMetadataSync = new TagMetadataSync();

            tagMetadataSync.setTagId(tagMetadataV2.getTagId());
            tagMetadataSync.setActionType(action);
            tagMetadataSync.setCreatedDay(isoDateStr.substring(0, 10));
            tagMetadataSync.setSystemName(tagMetadataV2.getSystemName());

            Map<String, String> metadataElement = tagMetadataV2.getMetadataElement();
            tagMetadataSync.setMetadataElement(metadataElement);

            tagMetadataSync.setTimestampCreated(isoDateStr);

            String qualifiedName = TagMetadataUtil.getQualifiedNameWithMappingInfo(tagMetadataV2, msmp.getqualifiedNameOrder(), msmp.getqualifiedNameConnector(), msmp.getqualifiedNamePrefix());
            tagMetadataSync.setQualifiedName(qualifiedName);

            tagMetadataSync.setTimestampSynchronized(MvGeneralConstant.MVSYNCTIMESTAMPNOTSYNCED);

            tagMetadataSyncList.add(tagMetadataSync);
        }

        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(syncTableName))
                .withBatchWriteRetryStrategy(new DynamoDBMapperConfig.DefaultBatchWriteRetryStrategy())
                .build();

        ArrayList<TagMetadata> deletePlaceHolder = new ArrayList();
        List<DynamoDBMapper.FailedBatch> failedBatches = getDynamoDBMapper(region).batchWrite(tagMetadataSyncList, deletePlaceHolder, config);
    }*/
}
