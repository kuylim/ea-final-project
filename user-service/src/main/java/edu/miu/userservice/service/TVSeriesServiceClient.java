package edu.miu.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@FeignClient(name = "TVSERIES-SERVICE")
public interface TVSeriesServiceClient {
}
